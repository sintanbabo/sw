package pro;

public class Edge implements Comparable<Edge>{
    public int start;
    public int end;
    public int cost;

    public Edge() {
        this(0,0,0);
    }

    public Edge(int start, int end, int cost) {
        this.start = start;
        this.end = end;
        this.cost = cost;
    }

	public int compareTo(Edge target) {
		return Integer.compare(this.cost, target.cost);
	}
}
