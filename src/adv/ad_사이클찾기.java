package adv;

import java.util.*;

/*
1
8 9
1 2 1 3 3 2 2 4 4 3 3 5 5 6 7 8 8 7
 */
public class ad_사이클찾기{

	// �׳� ���� ����� ū ��
	public static int inf = 10000000;
	
	// ����Ŭ�� ���۵� �� �ִ� node�� �ϳ� �̻��� input�� �ϳ� �̻��� output�� �־�� �Ѵ�.
	// ����Ŭ�� ã�� �� ����� �� ������ ��ü ����� ������ ���� �ʴ´�.
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
			
			// �Է°� ����
			for(int i=1; i<=m; i++) {
				int from = sc.nextInt();
				int to = sc.nextInt();
				
				road[from][to] = 1;
			}
			
			// i�� �������� ����Ŭ���� Ȯ��
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
