import java.util.Scanner;

public class Solution1 {

	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int x=0,y=0;
		
		
		for(int a=1; a<=T; a++) {
			int M = 1;
			
			int N = sc.nextInt();
			int z[][] = new int[N][N];
			char o = 'D';
			
			x = 0; y = 0;
			while(M < N*N) {
				z[x][y] = M;
				M++;
				if (o == 'D') {
					if (y-1 >= 0) { x++; y--;}
					else if (x+1 >= N) { y++; o = 'U';}
					else if (y-1 < 0) { x++; o = 'U';}
				}
				else if (o == 'U') {
					if (x-1 >= 0) { x--; y++;}
					else if (y+1 >= N) { x++; o = 'D';}
					else if (x-1 < 0) { y++; o = 'D';}
				}
			}
			
			for(int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					System.out.print(z[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

}
