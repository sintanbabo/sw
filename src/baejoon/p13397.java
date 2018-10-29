package baejoon;

import java.util.Scanner;

public class p13397 {
	
	public static boolean ok(int[] a, int n, int m, int mid) {
		int count = 0;
		int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
		for(int i=0; i<n; i++) {
			if (a[i] < min) min = a[i];
			if (a[i] > max) max = a[i];
			if ((max - min) >= mid) {
				count++;
				i--;
				min = Integer.MAX_VALUE;
				max = Integer.MIN_VALUE;
			}
		}
		return count >= m;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int n = sc.nextInt();
		int m = sc.nextInt();
		int [] a = new int[n];
		int l=1, r=0, mid=0, ans=0;
		for(int i=0; i<n; i++) {
			a[i] = sc.nextInt();
			r += a[i];
		}
		while(l<=r) {
			mid = (l+r)/2;
			
			if (ok(a,n,m,mid)) {
				ans = Math.max(ans, mid);
				l = mid+1;
			}
			else {
				r = mid-1;
			}
		}
		System.out.println(ans);
	}
}
