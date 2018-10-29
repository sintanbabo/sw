package ad;

import java.util.Scanner;

public class NQueen {

	public static int nResult = 0;
	public static int N = 0;
	public static int[][] chess;
	public static int Qcnt = 0;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		N = sc.nextInt();

		for (int i = 0; i < N; i++) {
			chess = new int[N][N];
			Qcnt = 0;
			queens(0, i);
		}

		System.out.println(nResult);
	}

	public static void queens(int x, int y) {
		boolean isPass = true;

		// 마지막 좌표까지 갔다면 성공
		if (Qcnt == N ) {
			nResult++;
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(chess[i][j] + " ");				
				}
				System.out.println();
			}
			System.out.println("\n");
			Qcnt = 0;
			return;
		}
		else if(x >= N || y >= N) {
			return ;
		}

		// chess 판에 현재 좌표에 Queen이 있다고 표시하기 (1)
		if (chess[x][y] == 0) {
			chess[x][y] = 1;
			Qcnt++;
			
			// chess 판에 현재 좌표에 의해 놓일 수 없는 곳 표시하기(2)
			// 상
			if (isPass) {
				for (int i = x - 1; i >= 0; i--) {
					if (chess[i][y] == 0) {
						chess[i][y] = 2;
					}
				}
			}

			// 하
			if (isPass) {
				for (int i = x + 1; i < N; i++) {
					if (chess[i][y] == 0) {
						chess[i][y] = 2;
					} 
				}
			}

			// 좌
			if (isPass) {
				for (int i = y - 1; i >= 0; i--) {
					if (chess[x][i] == 0) {
						chess[x][i] = 2;
					} 
				}
			}

			// 우
			if (isPass) {
				for (int i = y + 1; i < N; i++) {
					if (chess[x][i] == 0) {
						chess[x][i] = 2;
					} 
				}
			}

			// 상좌
			if (isPass) {
				for (int i = 0; i < N; i++) {
					if (x-i >= 0 && y-i >=0) {
						if (chess[x-i][y-i] == 0) {
							chess[x-i][y-i] =2;
						}
					}
					else {
						break;
					}
				}
			}

			// 상우
			if (isPass) {
				for (int i = 0; i < N; i++) {
					if (x-i >= 0 && y+i < N) {
						if (chess[x-i][y+i] == 0) {
							chess[x-i][y+i] =2;
						}
					}
					else {
						break;
					}
				}
			}

			// 하좌
			if (isPass) {
				for (int i = 0; i < N; i++) {
					if (x+i < N && y-i >=0) {
						if (chess[x+i][y-i] == 0) {
							chess[x+i][y-i] =2;
						}
					}
					else {
						break;
					}
				}
			}

			// 하우
			if (isPass) {
				for (int i = 0; i < N; i++) {
					if (x+i < N && y+i < N) {
						if (chess[x+i][y+i] == 0) {
							chess[x+i][y+i] =2;
						}
					}
					else {
						break;
					}
				}
			}
			
			// 다음으로 이동
			if (isPass) {
				for (int j = 0; j < N; j++)
					if (j != y)
						queens(x + 1, j);
			}
		}
	}
}
