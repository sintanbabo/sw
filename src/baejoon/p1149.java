package baejoon;

import java.util.*;

public class p1149 {
	static int go(int[][]a, int n, int[][] d) {
		if (n == 0) return 0;
		
		if (d[n][1] > 0 && d[n][2] > 0 && d[n][3] > 0) {
			return Math.min(Math.min(d[n][1], d[n][2]),d[n][3]); 
		}
		
		// »¡°­
		d[n][1] = Math.min(d[n-1][2]+a[1][n],d[n-1][3]+a[1][n]);
		
		// ÃÊ·Ï
		d[n][2] = Math.min(d[n-1][1]+a[2][n],d[n-1][3]+a[2][n]);
		
		// ÆÄ¶û
		d[n][3] = Math.min(d[n-1][1]+a[3][n],d[n-1][2]+a[3][n]);
		
		return Math.min(Math.min(d[n][1], d[n][2]),d[n][3]);
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		
		int [][] a = new int [n+1][4];		// 1:»¡, 2:ÃÊ, 3:ÆÄ
		int [][] d = new int[n+1][4];
		
		// ÀÔ·Â°ª ¹Ş±â
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=n; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		System.out.println(go(a,n,d));
	}
}
