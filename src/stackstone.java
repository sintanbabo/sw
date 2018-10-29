import java.util.Scanner;

public class stackstone {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		int N = 0;
		int[][] stone;
		int total_height = 0;
		
		for (int i = 0; i < T; i++) {
			N = sc.nextInt();
			stone = new int[N][2];
			total_height = 0;
			
			for(int j=0; j<N; j++) {
				stone[i][0] = sc.nextInt();
				stone[i][1] = sc.nextInt();
				total_height += stone[i][0];
			}
		}
	}
}
