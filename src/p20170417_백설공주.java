import java.util.Arrays;
import java.util.Scanner;

/*
10 3
1 2 1 2 1 2 3 2 3 3
8
1 2
1 3
1 4
1 5
2 5
2 6
6 9
7 10


1 1
1
1
1 1

4 1
1 1 1 1
2
2 3
2 4

 */
public class p20170417_백설공주 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int C = sc.nextInt();
		int a[] = new int[N+1];
		int b[] = new int[N+1];
		
		b[0] = 0;
		for(int i=1; i<=N; i++) {
			a[i] = sc.nextInt();
			b[i] = b[i-1];
			int temp = 1;
			for(int j=1; j<=C; j++) {
				if (j == a[i]) {
					b[i] = temp + b[i];
				}
				temp = temp * 10;
			}
		}
		
		int M = sc.nextInt();
		
		for(int i=0; i<M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			int max = 0;
			int max_color = 0;
			int temp = 0;
			int diff = b[e] - b[s-1];
			char d[] = new Integer(diff).toString().toCharArray();
			for(int j=1; j<=d.length; j++) {
				temp = new Integer(d[j-1])-'0';
				
				if (temp > (e-s+1)/2 && max < temp) {
					max = temp;
					max_color = d.length-j+1;
				}
			}
			if (max == 0) System.out.println("no");
			else System.out.println("yes " + max_color);
		}
	}
}
