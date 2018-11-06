package adv.BFS;

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
public class ad_도시를연결하는도로{

	// node�� �߶��� �� �ٷ� node�� ����� �༮���� ���� ����Ǵ��� Ȯ���Ѵ�.
	// 1 -- 2 -- 3 ���� 2�� �߶��� ���, 1�� 3�� ����Ǵ��� Ȯ���Ѵ�.
	// Ȯ���ϴ� ����� bfs�� ����ϵ��� �Ѵ�.
	static boolean ok(int[][] road, int v, int e, int node) {
		boolean ans = true;
		int cnt = 0;
		int start = 0;
		int end = 0;
		Queue<Integer> q = new LinkedList<Integer>();
		boolean [] visited = new boolean[e+1];
		
		Arrays.fill(visited, false);
		
		// node�� ����� ��� node�� ������ Ȯ���Ѵ�.
		visited[node] = true;
		for(int i=1; i<=v; i++) {
			if (road[node][i] == 1 && node != i){
				cnt++;
				if (cnt == 1) start = i;
				else end = i;
			}
		}
		// 1���� ���� ����� ��� �ٽɵ��ð� �� �� ����.
		if (cnt == 1) ans = false;
		else {
			// 2�� �̻��� ���� ����� ��� Ȯ�� (BFS �̿�)
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
			int road[][] = new int[e+1][e+1]; // x --> y, y --> x ��� �����ϱ� ���� 2���� �迭 ���
			
			// ���� ���� �Է�
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
