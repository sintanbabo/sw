package baejoon;

import java.util.*;

class Edge {
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
}

public class p1197 {
    static class Compare implements Comparator<Edge> {
        public int compare(Edge one, Edge two) {
            return Integer.compare(one.cost, two.cost);
        }
    }
    public static void disjoint_union(int [] p, int x, int y) {
        x = find(p, x);
        y = find(p, y);
        p[x] = y;
    }
    public static int find(int[] p, int x) {
        if (x == p[x]) {
            return x;
        } else {
            return (p[x] = find(p, p[x]));
        }
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[] p = new int[n+1];
        for (int i=0; i<=n; i++) {
            p[i] = i;
        }
        ArrayList<Edge> a = new ArrayList<Edge>();
        for (int i=0; i<m; i++) {
            a.add(new Edge(sc.nextInt(), sc.nextInt(), sc.nextInt()));
        }
        Collections.sort(a, new Compare());
        int ans = 0;
        for (Edge e : a) {
            int x = find(p, e.start);
            int y = find(p, e.end);
            if (x != y) {
                disjoint_union(p, e.start, e.end);
                ans += e.cost;
            }
        }
        System.out.println(ans);
    }
}

