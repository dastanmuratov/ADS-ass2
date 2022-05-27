public class MyEdge<T> {
    private Vertex<T> source;
    private Vertex<T> dest;
    private Double weight;

    public MyEdge(Vertex<T> source, Vertex<T> dest, Double weight) {
        this.source = source;
        this.dest = dest;
        this.weight = weight;
    }

    public MyEdge(Vertex<T> source, Vertex<T> dest) {
        this.source = source;
        this.dest = dest;
    }

    public void setSource(Vertex<T> source) {
        this.source = source;
    }

    public Vertex<T> getSource() {
        return source;
    }
    public Vertex<T> getDest() {
        return dest;

        public void setDest(Vertex<T> dest) {
            this.dest = dest;
        }
    }
    public Double getWeight() {
        return weight;
    }

    public void setWeight(Double weight) {
        this.weight = weight;
    }
