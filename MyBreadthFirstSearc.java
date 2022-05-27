import java.util.LinkedList;
import java.util.Queue;
public class MyBreadthFirstSearch<T> extends MySearch {
    public MyBreadthFirstSearch(MyWeughtedGraph<T> graph, Vertex<T> source) {
        super(source);
        bfs(graph, source);
    }
    private void bfs(MyWeughtedGraph<T> graph, Vertex<T> current) {
        marked.add(current);
        Queue<Vertex<T>> queue = new LinkedList<>();
        queue.add(current);
        while (!queue.isEmpty()) {
            Vertex<T> v = queue.remove();
            for (Vertex<T> vertex : graph.adjacencyList(v)) {
                if (!marked.contains(vertex)) {
                    queue.add(vertex);
                    marked.add(vertex);
                    edgeTo.put(vertex);
                  
                }
            }
        }
    }
}
