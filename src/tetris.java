import java.util.Scanner;

public class tetris {
	public static void main(String args[]) throws Exception	{
		Scanner sc = new Scanner(System.in);
		
		int a[][] = new int[10][10];
		int result[] = new int[10];
		int index[] = new int[10];
		
		for(int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				a[i][j] = sc.nextInt();
			}
		}
		
		for(int j=0; j<10; j++) {
			for (int i=9; i>=0; i--) {
				if (a[i][j] == 1) {
					if (j+1 > 10 && a[i][j+1] == 1) {
						result[j] = result[j] + 1;
						result[j+1] = result[j];
						index[j+1] = i;
					}
					else {
						result[j] = result[j] + 1;
					}
				}
			}
		}
		
		for(int i=0; i<10; i++) {
			for (int j=0; j<10; j++) {
				System.out.print(a[i][j] + " ");
			}
			System.out.println();
		}
	}
}
