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

		// ������ ��ǥ���� ���ٸ� ����
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

		// chess �ǿ� ���� ��ǥ�� Queen�� �ִٰ� ǥ���ϱ� (1)
		if (chess[x][y] == 0) {
			chess[x][y] = 1;
			Qcnt++;
			
			// chess �ǿ� ���� ��ǥ�� ���� ���� �� ���� �� ǥ���ϱ�(2)
			// ��
			if (isPass) {
				for (int i = x - 1; i >= 0; i--) {
					if (chess[i][y] == 0) {
						chess[i][y] = 2;
					}
				}
			}

			// ��
			if (isPass) {
				for (int i = x + 1; i < N; i++) {
					if (chess[i][y] == 0) {
						chess[i][y] = 2;
					} 
				}
			}

			// ��
			if (isPass) {
				for (int i = y - 1; i >= 0; i--) {
					if (chess[x][i] == 0) {
						chess[x][i] = 2;
					} 
				}
			}

			// ��
			if (isPass) {
				for (int i = y + 1; i < N; i++) {
					if (chess[x][i] == 0) {
						chess[x][i] = 2;
					} 
				}
			}

			// ����
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

			// ���
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

			// ����
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

			// �Ͽ�
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
			
			// �������� �̵�
			if (isPass) {
				for (int j = 0; j < N; j++)
					if (j != y)
						queens(x + 1, j);
			}
		}
	}
}
