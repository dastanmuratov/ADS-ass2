import java.util.Set;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;

public class MyDijkstraSearch<T> extends MySearch<T> {
    private Set<Vertex<T>> unsettledNodes;
    private Map<Vertex<T>, Double> distances;
    private MyWeughtedGraph<T> graph;

    public MyDijkstraSearch(MyWeughtedGraph<T> graph, Vertex<T> source) {
        super(source);
        unsettledNodes = new HashSet<>();
        distances = new HashMap<>();
        this.graph = graph;
        dijkstra();
    }

    public void dijkstra() {
            Vertex<T> vertex = getVertexWithMinimumWeight(unsettledNodes);
            marked.add((Vertex<T>) vertex);
            unsettledNodes.remove(vertex);

            for (Vertex<T> target : graph.adjacencyList(vertex)) {
                double distance = getShortestDistance(vertex) + getDistance(vertex, target);

                if (getShortestDistance(target) > distance) {
                    distances.put(target, distance);
                    edgeTo.put(target, vertex);
                    unsettledNodes.add(target);
                }
            }
    }

    private double getDistance(Vertex<T> node, Vertex<T> target) {
        return node.getWeight(target);
    }

    private Vertex<T> getVertexWithMinimumWeight(Set<Vertex<T>> vertices) {
        Vertex<T> minimum = null;
        for (Vertex<T> vertex : vertices) {
            if (minimum == null) minimum = vertex;
            else {
                if (getShortestDistance(vertex) < getShortestDistance(minimum)) minimum = vertex;
            }
        }
        return minimum;
    }
    private double getShortestDistance(Vertex<T> destination) {
        Double distance = distances.get(destination);
        return (distance == null ? Double.MAX_VALUE : distance);
    }
}