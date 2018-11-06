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
public class p20170417_인형정리_dp1 {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int C = sc.nextInt();
		int a[] = new int[N+1];
		int b[][] = new int[C+1][N+1];
		
		for(int i=1; i<=N; i++) {
			a[i] = sc.nextInt();
			for(int j=1; j<=C; j++) {
				if (j == a[i]) {
					b[j][i] = b[j][i-1] + 1;
				}
				else {
					b[j][i] = b[j][i-1];
				}
			}
		}
		
		int M = sc.nextInt();
		
		for(int i=0; i<M; i++) {
			int s = sc.nextInt();
			int e = sc.nextInt();
			
			int max = 0;
			int max_color = 0;
			for(int j=1; j<=C; j++) {
				int temp = b[j][e] - b[j][s-1];
				if (temp > (e-s+1)/2 && max < temp) {
					max = temp;
					max_color = j;
				}
			}
			if (max == 0) System.out.println("no");
			else System.out.println("yes " + max_color);
		}
	}
}
