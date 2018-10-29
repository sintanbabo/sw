package ad;
import java.util.*;

public class ad_두수로만들수있는수 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n1 = sc.nextInt();
		int n2 = sc.nextInt();
		int cnt = sc.nextInt();
		int[] d = new int[cnt+1];
		
		Arrays.fill(d, Integer.MAX_VALUE);
		
		d[0] = 1;
		if (n1 < n2) { 
			d[1] = n1;
		}
		else {
			d[1] = n2;
		}
		
		for(int i=2; i<=cnt; i++) {
			for(int j=0; j<i; j++) {
				if (d[i] > d[j] * n1) {
					d[i] = d[j] * n1;
				}
			}
			for(int h=1; h<i; h++) {
				if (d[i] > d[h] * n2) {
					d[i] = d[h] * n2;
				}
			}
		}
		
		System.out.println(d[cnt]);
	}
}
