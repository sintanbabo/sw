import java.util.Scanner;

public class sortDoll {
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int a[] = new int[N];
		
		for(int i=0; i<N; i++) {
			a[i] = sc.nextInt();
		}
		
		int left = 0;
		int right = M;
		int mid = (left+right)/2;
	}
	
	public static boolean isEnd(int a[], int n, int m)
	{
		int count = 1;
		
		for(int i=0; i<n-1; i++) {
			if (a[i] != a[i+1]) {
				count++;
			}
		}
		
		return (count == m);
	}
}