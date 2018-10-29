package baejoon;

import java.util.*;

public class p1002 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int n = sc.nextInt();
			int[][] d = new int [n+1][2];
			
			d[0][0] = 1;
			d[0][1] = 0;
			
			if (n>=1) {
				d[1][0] = 0;
				d[1][1] = 1;
			}
			
			for(int i=2; i<=n; i++) {
				d[i][0] = d[i-1][0] + d[i-2][0];
				d[i][1] = d[i-1][1] + d[i-2][1];
			}
			
			System.out.println(d[n][0] + " " + d[n][1]);
		}
	}

}
