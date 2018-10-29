package ad;

import java.util.*;

public class ad_숫자만들기2 {

	static int go(int[] d, int start, int end) {
		if (start == end)
			return 0;
		
		if (end <= 0)
			return 0;
		
		if (d[end]>0) {
			return d[end];
		}
		else {
			d[end] = go(d,start,end-1) + 1;
			
			if (end%2 == 0) {
				int temp = go(d,start,end/2) + 1;
				if (d[end] > temp) d[end] = temp;
			}
			
			if (end%3 == 0) {
				int temp = go(d,start,end/3) + 1;
				if (d[end] > temp) d[end] = temp;
			}
			
			return d[end];
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		int[] d = new int[end+1];
		
		System.out.println(go(d,start,end));
	}
}
