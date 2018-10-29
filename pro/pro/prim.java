
package pro;

import java.util.*;

public class prim {

    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        List<Edge>[] a = (List<Edge>[]) new List[n+1];
        for (int i=1; i<=n; i++) {
            a[i] = new ArrayList<Edge>();
        }
        for (int i=0; i<m; i++) {
            int u = sc.nextInt();
            int v = sc.nextInt();
            int c = sc.nextInt();
            a[u].add(new Edge(u,v,c));
            a[v].add(new Edge(v,u,c));
        }
        boolean[] c = new boolean[n+1];
        PriorityQueue<Edge> q = new PriorityQueue<Edge>();
        c[1] = true;
        for (Edge e : a[1]) {
            q.add(e);
        }
        int ans = 0;
        for (int i=0; i<n-1; i++) {
            Edge e = new Edge();
            while (!q.isEmpty()) {
                e = q.poll();
                if (c[e.end] == false) {
                    break;
                }
            }
            c[e.end] = true;
            ans += e.cost;
            for (Edge ee : a[e.end]) {
                q.add(ee);
            }
        }
        System.out.println(ans);
    }
}

