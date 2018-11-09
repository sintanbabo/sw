import java.math.BigInteger;
import java.util.Scanner;

/*
1
3 4 2
2 2
2 3

1
4 5 2
2 2
3 3

1
100 100 3
15 16
16 15
99 88

2
3 4 2
2 2
2 3
100 100 3
15 16
16 15
99 88

 */

public class ChessOnLoad {

	public static int nResult;
	public static int N,M,K;
	public static BigInteger [][] result;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int i = 0; i < T; i++) {
			nResult = 0;
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			
			// result �����
			result = new BigInteger[N][M];
			for (int x=0; x<N; x++) {
				for (int y=0; y<M; y++) {
					result[x][y] = BigInteger.valueOf(-1);
				}
			}
						
			// ���� �����
			for(int j=0;j<K;j++) {
				int x = 0, y = 0;
				x = sc.nextInt();
				y = sc.nextInt();
				result[x-1][y-1] = BigInteger.valueOf(0);
			}
			
			result[0][0] = BigInteger.valueOf(1);
			// ù ���� ���ο� 1�� ä���
			for (int z=1; z<N; z++) {
				if (result[z-1][0] == BigInteger.valueOf(0)) result[z][0] = BigInteger.valueOf(0);
				else if (result[z][0] == BigInteger.valueOf(-1)) result[z][0] = BigInteger.valueOf(1);
			}
			// ù ��° ���ο� 1�� ä���
			for (int z=1; z<M; z++) {
				if (result[0][z-1] == BigInteger.valueOf(0)) result[0][z] = BigInteger.valueOf(0);
				else if (result[0][z] == BigInteger.valueOf(-1)) result[0][z] = BigInteger.valueOf(1);
			}
			
			// ������ ����ϱ�
			for (int x=1; x<N; x++) {
				for (int y=1; y<M; y++) {
					if (result[x][y] == BigInteger.valueOf(-1))
						result[x][y] = result[x-1][y].add(result[x][y-1]);
				}
			}			
			
			System.out.println("Case #" + (i+1));
			System.out.println(result[N-1][M-1].remainder(BigInteger.valueOf(1000000007)));
			
		}
	}

}
