package adv;

import java.util.*;

/*
4
5
0XXX0
TRXX0
0XLX0
0LXX0
0XXXS
5
0XXX0
TRXX0
0XLX0
0LXXS
0XXX0
10
0RXXXXXXX0
TRXXXLXXR0
0XLXXXXXX0
0LXXXLXRX0
0XXXXXRXX0
0RXXXLXXXS
0XXXXXXXX0
0XXXXRXXX0
0XXXLXXXX0
0XXXXXXXX0
5
0XXX0
TRXX0
0XLX0
0XXRS
0XXX0

 */
public class ad_달기지물자이동{

	public static int go(char[][] a, int[][] d, int n, int x, int y) {
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc=1; tc<=TC; tc++) {
			int n = sc.nextInt();
			char[][] a = new char[n][n];
			int[][]d = new int[n][n];
		
			// �Է°� �ޱ�
			for(int i=0; i<n; i++) {
				a[i] = sc.next().toCharArray();
			}
			
			// ������ ã��
			int x=0,y=0;
			for(int i=0; i<n; i++) {
				if (a[i][0] == 'T') {
					x = i;
					y = 0;
				}
			}
			
			// Ž�� ����
			int ans = go(a,d,n,x,y);
			
			System.out.println(ans);
		}
	}
}
