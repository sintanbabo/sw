package baejoon;

import java.util.Scanner;

public class p13398 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int [] a = new int[n];
		int [] d = new int[n];
		int [] dr = new int[n];
		
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
		}
		
		d[0] = a[0];
		for(int i=1; i<n; i++) {			
			d[i] = Math.max(d[i-1] + a[i], a[i]);
		}
		dr[n-1] = a[n-1];
		for (int i=n-2; i>=0; i--) {
			dr[i] = Math.max(dr[i+1] + a[i], a[i]);
		}
		
		int result = -100001;
		for(int i=0; i<n; i++) {
			if (result < d[i]) {
				result = d[i];
			}
		}
		for(int i=1; i<n-1; i++) {
			if (result < (d[i-1] + dr[i+1])) {
				result = d[i-1] + dr[i+1];
			}
		}

		System.out.println(result);
	}

}
