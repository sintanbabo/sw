package adv;

import java.util.*;

/*
1
8 9
1 2 1 3 3 2 2 4 4 3 3 5 5 6 7 8 8 7
 */
public class ad_사이클찾기 {

	// 그냥 만든 충분히 큰 수
	public static int inf = 10000000;
	
	// 사이클이 시작될 수 있는 node는 하나 이상의 input과 하나 이상의 output이 있어야 한다.
	// 사이클을 찾을 때 노드의 총 개수는 전체 노드의 개수를 넘지 않는다.
	static boolean go(int[][] road, int node, int node_cnt, int node_max, Stack<Integer> s, boolean[] visited)
	{
		if(node_cnt > 0 && visited[node]) { 
			s.push(node);
			return true;
		}
		else {
			visited[node] = true;
			s.push(node);
			for(int i=1; i<=node_max; i++) {
				if (road[node][i] == 1) {
					return go(road,i,++node_cnt,node_max,s,visited);
				}
			}
		}
		
		return false;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Stack<Integer> s = new Stack<Integer>();
		int[] result = new int[100];
		
		for(int t=1; t<=T; t++) {
			Arrays.fill(result, inf);
			
			int n = sc.nextInt();
			int m = sc.nextInt();
			boolean[] visited = new boolean[n+1];
			int [][] road = new int[n+1][n+1];
			
			Arrays.fill(visited, false);
			
			// 입력값 저장
			for(int i=1; i<=m; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				road[from][to] = 1;
			}
			
			// i를 기준으로 사이클인지 확인
			String ans = "";
			int index = 0;
			loop : for(int i=1; i<=n; i++) {
				if(go(road,i,0,n,s,visited)) {
					int cycle_start_node = s.pop();
					while(!s.isEmpty()) {
						int temp = s.pop();
						if (cycle_start_node != temp) {
							result[index++] = temp; 
						}
						else {
							result[index++] = temp;
							break loop;
						}
					}
				}
				else {
					s.clear();
					Arrays.fill(visited,false);
				}
			}
			
			Arrays.sort(result);
			for(int i=0; i<100; i++) {
				if (result[i] != inf) {
					if (i==0) ans = "" + result[i];
					else ans = ans + "," + result[i];
				}
			}
			
			if (ans == "") ans = "0";
			System.out.println(ans);
		}
	}

}
