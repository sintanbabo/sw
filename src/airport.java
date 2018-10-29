import java.util.Scanner;

public class airport {
	
	public static int h = 0, w = 0, max_value = 0;
	public static int T, K, N, a[][];

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int test_case;
		
		
		T = sc.nextInt();        
		for(test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			K = sc.nextInt();
			a = new int[N][N];
			
			for(int i=0; i<N; i++) {
				for (int j=0; j<N; j++) {
					a[i][j] = sc.nextInt();
				}
			}
			
			for(int i=0; i<N; i++) {				
				for (int j=0; j<N; j++) {
					h = w = max_value = 0;
					move(i,j,a[i][j]);
					max_value = Math.max(max_value, h*w);
				}
			}
			
			System.out.println(max_value);
		}
	}
	
	public static void move(int x, int y, int start_value) {
		boolean l = false, r = false, lr = false;
		
		if (x == N-1 && y == N-1) {
			return ;
		}
		
		if (h == 0 && w == 0) {
			if ( x+1 < N && y+1 < N && (Math.abs(start_value - a[x+1][y+1]) <= K ) &&
	           ( y+1 < N && (Math.abs(start_value - a[x][y+1]) <= K )) &&
	           ( x+1 < N && (Math.abs(start_value - a[x+1][y]) <= K ) ) ) {
				h++;
				w++;
				move(x,y+1, start_value);
				move(x+1,y, start_value);
				move(x+1,y+1, start_value);
			}
		}
		else {
			if ( x+1 < N && y+1 < N && (Math.abs(start_value - a[x+1][y+1]) <= K ) &&
					( y+1 < N && (Math.abs(start_value - a[x][y+1]) <= K ))  ) {
				w++;
				move(x,y+1, start_value);
			}
			if (x+1 < N && y+1 < N && (Math.abs(start_value - a[x+1][y+1]) <= K ) &&
					( x+1 < N && (Math.abs(start_value - a[x+1][y]) <= K ) ) ) {
				h++;
				move(x+1,y, start_value);
			}
		}
	}

}
