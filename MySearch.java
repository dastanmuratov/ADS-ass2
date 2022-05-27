import java.util.LinkedList;
import java.util.List;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;
import java.util.Map;
public class MySearch<T> {
    protected int count;
    protected Set<Vertex<T>> visited;
    protected Map<Vertex<T>, Vertex<T>> edgeTo;
    protected final Vertex<T> source;

    public MySearch(Vertex<T> source) {
        this.source = source;
        visited = new HashSet<>();
        edgeTo = new HashMap<>();
    }
    public Iterable<Vertex<T>> pathTo(String key) {
        if (!hasPathTo(key)) return null;
        LinkedList<Vertex<T>> ls = new LinkedList<>();
        for (Vertex<T> i = key; i != source; i = edgeTo.get(i)) {
            ls.push(i);
        }
        ls.push(source);

        return ls;
    }
    public int getCount() {
        return count;
    }
    public boolean hasPathTo(String key) {
        return visited.contains(key);
    }

}