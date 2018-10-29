package ad;

import java.util.Scanner;

/*
1
5
7
1 2 2 
1 3 7
2 3 8
2 4 1
3 4 1
3 5 9
4 5 6
 */
public class roadmaker_kruskal {
	static int N;				// 마을 개수
	static int M;				// 포장 도로 개수
	static int T;				// Test Case
	static int road[][];		// 도로
	static int group_value[];	// 연결 그룹
	static int road_value[];	// 연결 비용
	static int min, max;		// 연결 비용
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		// 입력값 받기 및 초기화
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();		
			M = sc.nextInt();
			road = new int[M+1][3];
			group_value = new int[M+1];
			road_value = new int[M+1];
			for(int i=1; i<M+1; i++) {
				road[i][0] = sc.nextInt();
				road[i][1] = sc.nextInt();
				road[i][2] = sc.nextInt();
				group_value[i] = -1;
			}
					
			// 탐색 시작
			kruskal(1,N-1);
			
			// 최대 최소값 구하기
			int temp = 0, temp1 = 0;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			for(int i=1; i<M+1; i++) {
				if (min > road_value[i] && road_value[i] > 0) min = road_value[i];
				if (max < road_value[i] && road_value[i] > 0) max = road_value[i];
			}
			
			System.out.println("#" + t + " : " + (max-min));
		}
	}
	
	static void kruskal(int start, int m) {
		int temp0, temp1, temp2;
		
		// 입력된 노드별 값을 가중치를 기준으로 정렬한다.
		for (int i=1; i<M+1; i++) {
			for (int j=i+1; j<M+1; j++) {
				if (road[i][2] > road[j][2]) {
					temp0 = road[i][0];
					temp1 = road[i][1];
					temp2 = road[i][2];
					
					road[i][0] = road[j][0];
					road[i][1] = road[j][1];
					road[i][2] = road[j][2];
					
					road[j][0] = temp0;
					road[j][1] = temp1;
					road[j][2] = temp2;
				}
			}
		}
		
		int index = 1;
		int group = 1;
		while (m >= 0) {
			
			// 가중치가 가장 작은 노드를 선택한다. (index가 작은 놈부터 사용하면 된다)
			// (선택된 노드에 의해서 cycle이 형성되면 안된다) 
			if (group_value[road[index][0]] < 0 && group_value[road[index][1]] < 0)
			{	
				// 2개의 노드 모두 그룹에 속해있지 않을 때, 2개의 노드를 이용해서 하나의 그룹을 만든다.
				group_value[road[index][0]] = ++group;
				group_value[road[index][1]] = ++group;
				road_value[road[index][1]] = road[index][2];
				index++;
			}
			else if (group_value[road[index][0]] >= 0 && group_value[road[index][1]] < 0)
			{
				// 시작 노드만 그룹에 속해 있을 때, 시작 노드의 그룹값을 종료 노드로 복사해준다.
				group_value[road[index][1]] = group_value[road[index][0]];
				road_value[road[index][1]] = road[index][2];
				index++;
			}
			else if (group_value[road[index][0]] < 0 && group_value[road[index][1]] >= 0)
			{
				// 종료 노드만 그룹에 속해 있을 때, 종료 노드의 그룹값을 시작 노드로 복사해준다.
				group_value[road[index][0]] = group_value[road[index][1]];
				road_value[road[index][1]] = road[index][2];
				index++;
			}
			else if (group_value[road[index][0]] >= 0 && group_value[road[index][1]] >= 0 && group_value[road[index][0]] != group_value[road[index][1]])
			{
				// 시작 노드와 종료 노드의 그룹값이 다른 경우, 종료 노드 그룹의 값을 모두 시작 노드 그룹의 값으로 바꾼다.
				int group_temp1, group_temp2;
				
				group_temp1 = group_value[road[index][0]];
				group_temp2 = group_value[road[index][1]];
				
				for (int i=1; i<M+1; i++) {
					if (group_value[i] == group_temp2) {
						group_value[i] = group_temp1;
					}
				}
				
				road_value[road[index][1]] = road[index][2];
				index++;
			}
			else {
				index++;
				continue;
			}
			
			// 하나의 연결선이 연결됨을 표시
			m = m-1;
		}		
	}
}
