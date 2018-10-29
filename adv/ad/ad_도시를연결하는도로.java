package ad;

import java.util.*;
/*
3
9 10
1 2 2 8 8 6 8 4 4 2 1 5 1 3 5 7 7 3 9 7
5 5
1 2 3 2 4 3 5 4 1 5
5 5
1 5 2 5 3 5 4 5 1 4

 */
public class ad_도시를연결하는도로 {

	// node를 잘랐을 때 바로 node에 연결된 녀석들이 서로 연결되는지 확인한다.
	// 1 -- 2 -- 3 에서 2를 잘랐을 경우, 1과 3이 연결되는지 확인한다.
	// 확인하는 방법은 bfs를 사용하도록 한다.
	static boolean ok(int[][] road, int v, int e, int node) {
		boolean ans = true;
		int cnt = 0;
		int start = 0;
		int end = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		boolean [] visited = new boolean[e+1];
		
		Arrays.fill(visited, false);
		
		// node와 연결된 모든 node의 개수를 확인한다.
		visited[node] = true;
		for(int i=1; i<=v; i++) {
			if (road[node][i] == 1 && node != i){
				cnt++;
				if (cnt == 1) start = i;
				else end = i;
			}
		}
		// 1개의 노드와 연결된 경우 핵심도시가 될 수 없다.
		if (cnt == 1) ans = false;
		else {
			// 2개 이상의 노드와 연결된 경우 확인 (BFS 이용)
			q.add(start);
			while(!q.isEmpty()) {
				int temp = q.remove();
				visited[temp] = true;
				if (temp == end) {
					ans = false;
					break;
				}
				for(int i=1; i<=v; i++) {
					if(road[temp][i] == 1 && i != node && visited[i] == false)
						q.add(i);
				}
			}
		}
		
		return ans;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int v = sc.nextInt();
			int e = sc.nextInt();
			int road[][] = new int[e+1][e+1]; // x --> y, y --> x 모두 저장하기 위해 2차원 배열 사용
			
			// 연결 도로 입력
			for(int i=1; i<=e; i++) {
				int x = sc.nextInt();
				int y = sc.nextInt();
				
				road[x][y] = 1;
				road[y][x] = 1;
			}
			
			String ans = "";
			int result = 0;
			for(int i=1; i<=v; i++) {
				if (ok(road,v,e,i)) {
					result++;
					ans += i + " ";
				}
			}
			System.out.println("#" + t + " " + result + " " + ans);
		}
	}

}
