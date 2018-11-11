package baejoon;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * BOJ#1753 최단경로
 * https://www.acmicpc.net/problem/1753
 *
 */

/*
5 6
1
5 1 1
1 2 2
1 3 3
2 3 4
2 4 5
3 4 6

*/


public class p1753_다익스트라 {

    static final int INF = 5000000;

    public static void main(String[] args) throws IOException {

        int V; // 정점의 개수 <= 20,000
        int E; // 간선의 개수 <= 300,000
        ArrayList<ArrayList<Element>> W = new ArrayList<>();
        int[] dist;
        int startNode;

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());

        V = Integer.parseInt(st.nextToken());
        E = Integer.parseInt(st.nextToken());

        dist = new int[V + 1];

        for (int i = 0; i < V + 1; i++) {

            Arrays.fill(dist, INF);
            W.add(new ArrayList<>());
        }

        startNode = Integer.parseInt(br.readLine());

        for (int i = 0; i < E; i++) {

            st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());

            Element temp = new Element(b,w);
            
            W.get(a).add(temp);
        }

        dijkstra(startNode, V, W, dist);

        for (int i = 1; i < V + 1; i++) {

            bw.write(dist[i] < INF ? dist[i] + "\n" : "INF\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dijkstra(int src, int V, ArrayList<ArrayList<Element>> W, int[] dist) {

        PriorityQueue<Element> pq = new PriorityQueue<>();

        dist[src] = 0;

        pq.add(new Element(src, dist[src]));

        while (!pq.isEmpty()) {

            int cost = pq.peek().dist;
            int here = pq.peek().node;

            pq.poll();

            if (dist[here] < cost) {

                continue;
            }

            for (Element x : W.get(here)) {

                int adjNode = x.node;
                int weight = x.dist;

                if (dist[adjNode] > dist[here] + weight) {

                    dist[adjNode] = dist[here] + weight;
                    pq.add(new Element(adjNode, dist[adjNode]));
                }
            }
        }
    }
}

class Element implements Comparable<Element> {

    int node;
    int dist;

    Element(int node, int dist)
    {
        this.node = node; 
        this.dist = dist;
    }

    @Override
    public int compareTo(Element o) {
        return Integer.compare(this.dist, o.dist);
    }
}