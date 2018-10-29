package pro.graph;

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
public class ad_도시를연결하는도로2 {

	// kruskal 이론으로 node가 서로 같은 그룹에 속하는지 찾는다.
	// kruskal의 시작 점은 node가 연결되었던 지점들로 부터 시작한다.
	static boolean ok(int[][] road, int v, int e, int node) {
		boolean ans = true;
		int[] groups = new int[v+1];
		
		// kruskal 알고리즘으로 그룹별로 값을 매핑
		groups[node] = 10000000;
		int group_cnt = 0;
		for(int start=1; start<=v; start++) {
			for(int end=1; end<=v; end++) {
				if (road[start][end] == 1 && start != node && end != node) {
					if (groups[start] == 0 && groups[end] == 0) {	// 둘다 그룹에 없는 경우
						group_cnt++;
						groups[start] = group_cnt;
						groups[end] = group_cnt;
					}
					else if (groups[start] > 0 && groups[end] == 0) { // 시작점만 그룹에 있을 경우 시작그룹 값을 끝그룹에 복사
						groups[end] = groups[start];
					}
					else if (groups[start] == 0 && groups[end] > 0) { // 끝점만 그룹에 있을 경우 끝그룹을 시작그룹에 복사
						groups[start] = groups[end];
					}
					else if (groups[start] != groups[end]) {			// 시작점의 그룹과 끝점 그룹이 다른 경우, 시작점의 그룹으로 끝점 그룹값을 대체
						for(int i=1; i<=v; i++) {
							if (groups[i] == groups[end]) {
								groups[i] = groups[start];
							}
						}
					}
				}
			}
		}
		
		// 모든 그룹의 값이 동일하면 false, 값이 동일하지 않으면 true
		Set<Integer> set = new HashSet<Integer>();
		for(int i=1; i<=v; i++) {
			if (groups[i] != 10000000) 
				set.add(groups[i]);
		}
		if (set.size() > 1) return true;
		else return false;
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
