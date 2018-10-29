package adv;

import java.util.Scanner;

public class RoadonBoard {

	static int N;         // 보드 개수
	static int board[][]; // 보드
	static int road[][];  // 보드 통과 여부 (통과 :1 , 미통과 : 0)
	static int dx[] = {-1,-1,-1,0,1,1, 1, 0};
	static int dj[] = {-1, 0, 1,1,1,0,-1,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// 최대 예제 수를 저장한다.
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			// 변수 크기 할당
			N = sc.nextInt();
			board = new int[N][N];
			road = new int[N][N];
			
			// 초기화
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					board[i][j] = 0;
					road[i][j] = 0;
				}
			}
			
			// 보드 입력 받기
			for(int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
		
			// dfs 시작
			System.out.println("#" + t + " ");
			dfs(t, 0,0);			
		}
	}

	public static void dfs(int t, int x, int y) {

		// 현재 좌표가 종료 조건이 되면 지나온 모든 좌료를 출력한다.
		if (x >= N-1 && y >= N-1) {
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if (road[i][j] == 1) {
						System.out.print((i+1) + " " + (j+1) + ", ");
					}
				}
			}
			System.out.println((x+1) + " " + (y+1));
		}
		
		// 현재 좌표가 0 이면 주변 8개의 좌표를 확인해서 탐색한다.
		if (board[x][y] == 0) {
			road[x][y] = 1;
			for(int i=0; i<8; i++) {
				int ii = x + dx[i];
				int jj = y + dj[i];
				
				if (ii<0 || ii>=N || jj<0 || jj>=N) continue;
				if (board[ii][jj] == 0 && road[ii][jj] == 0) {
					dfs(t,ii,jj);
				}
			}
		}
	}
}

/*
5
0 1 1 1 1
1 0 0 0 1
1 1 1 0 1
1 1 1 0 1
1 1 1 1 0
*/
