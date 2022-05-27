import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
public class MyWeughtedGraph<T> {
    private final boolean undirected;
    private final Map<Vertex, List<Edge<Vertex>>> map = new HashMap<>();
    public MyWeughtedGraph() {
        this.undirected = true;
    }

    public MyWeughtedGraph(boolean undirected) {
        this.undirected = undirected;

    }
    public void addVertex(Vertex<T> source) {
        map.put(source, new LinkedList<>());
    }
    public int getVerticesCount() {
        return map.size();
    }

    public int getEdgesCount() {
        int count = 0;
        for (Vertex<T> vertex : map) {
            int degree = vertex.degreeOfVertex();
            count += degree;
        }

    public void addEdge(Vertex<T> source, Vertex<T> dest, double weight) {
        if(hasVertex(source)) addVertex(source);
        if(hasVertex(dest))addVertex(dest);
        if (hasEdge(source, dest)
                || source.equals(dest))
            return;
        source.add(new MyEdge<>(source, dest, weight));
    }
        if(undirected) return count / 2;
        return count;
    }
    public boolean hasVertex(Vertex<T> v) {
        return map.containsKey(v);
    }

    public boolean hasEdge(Vertex<T> source, Vertex<T> dest) {
        return hasVertex(source) && source.hasAdjacentVertex(dest);
    }
    public Set<Vertex<T>> adjacencyList(Vertex<T> vertex) {
        return hasVertex(vertex) ? null : vertex.getAdjacentVertices();
    }
