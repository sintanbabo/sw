package pro.graph;

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
public class roadmaker_prim {
	static int N;			// 마을 개수
	static int M;			// 포장 도로 개수
	static int T;			// Test Case
	static int road[][];	// 도로
	static int road_value[];// 연결 비용
	static int min, max;	// 연결 비용
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		// 입력값 받기 및 초기화
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();		
			M = sc.nextInt();
			road = new int[M+1][3];
			road_value = new int[M+1];
			for(int i=1; i<M+1; i++) {
				road[i][0] = sc.nextInt();
				road[i][1] = sc.nextInt();
				road[i][2] = sc.nextInt();
				road_value[i] = -1;
			}
					
			// 탐색 시작
			prim(1,N-1);
			
			// 최대 최소값 구하기
			int temp = 0, temp1 = 0;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			for(int i=1; i<M+1; i++) {
				if (min > road_value[i] && road_value[i] > 0) min = road_value[i];
				if (max < road_value[i] && road_value[i] > 0) max = road_value[i];
			}
			
			// 결과값 출력
			for(int a : road_value) {
				System.out.print(a + " ");
			}
			System.out.println();
			
			System.out.println("#" + t + " : " + (max-min));
		}
	}
	
	static void prim(int start, int m) {
		int min_point = 0;
		int prim_min = 0;
		
		min_point = start;
		
		while (m >= 0) {
			
			// 연결되었음을 표시
			road_value[min_point] = prim_min;
			
			// S 집합들 중에서 S 외부와 연결된 값 들 중에서 최소비용을 찾는다.
			prim_min = Integer.MAX_VALUE;
			for(int i=1; i<M+1; i++) {
				if (road_value[road[i][0]] >= 0 && road_value[road[i][1]] < 0) {
					if (road[i][2] < prim_min) {
						min_point = road[i][1];
						prim_min = road[i][2];
					}
				}
			}

			// 하나의 연결선이 연결됨을 표시
			m = m-1;
		}		
	}
}
