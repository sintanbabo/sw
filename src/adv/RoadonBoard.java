package adv;

import java.util.Scanner;

public class RoadonBoard {

	static int N;         // ���� ����
	static int board[][]; // ����
	static int road[][];  // ���� ��� ���� (��� :1 , ����� : 0)
	static int dx[] = {-1,-1,-1,0,1,1, 1, 0};
	static int dj[] = {-1, 0, 1,1,1,0,-1,-1};
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// �ִ� ���� ���� �����Ѵ�.
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			// ���� ũ�� �Ҵ�
			N = sc.nextInt();
			board = new int[N][N];
			road = new int[N][N];
			
			// �ʱ�ȭ
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					board[i][j] = 0;
					road[i][j] = 0;
				}
			}
			
			// ���� �Է� �ޱ�
			for(int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					board[i][j] = sc.nextInt();
				}
			}
		
			// dfs ����
			System.out.println("#" + t + " ");
			dfs(t, 0,0);			
		}
	}

	public static void dfs(int t, int x, int y) {

		// ���� ��ǥ�� ���� ������ �Ǹ� ������ ��� �·Ḧ ����Ѵ�.
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
		
		// ���� ��ǥ�� 0 �̸� �ֺ� 8���� ��ǥ�� Ȯ���ؼ� Ž���Ѵ�.
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
