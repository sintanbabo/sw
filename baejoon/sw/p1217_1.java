package sw;

import java.util.*;

public class p1217_1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] a = new int[n+1];
			int[] b = new int[n+1];
			int[] used = new int[n+1];
			
			// 입력값 받기
			for(int i=1; i<=n; i++) {
				a[i] = sc.nextInt();
				b[i] = sc.nextInt();
			}
			
			// 
			double result = 0.0;
			int f=0, w=0;
			int last_index = 0;
			for(int i=1; i<=k; i++) {
				for(int j=1; j<=n; j++) {
					if (used[j] == 0) {
						f += a[j];
						w += b[j];
						if (result < ((double)f / (double)w)) {
							result = ((double)f / (double)w);
							last_index = j;
						}
						f -= a[j];
						w -= b[j];
					}
				}
				if (last_index > 0) {
					used[last_index] = 1;
					f += a[last_index];
					w += b[last_index];
					last_index = 0;
					if (i != k) result = 0.0;
				}
			}
			System.out.println("#" + t + " " + String.format("%.3f", result));
		}
	}
}
