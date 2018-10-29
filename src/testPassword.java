import java.util.Scanner;

/*
3
4 11 23 88 21
7 65 0 63 7 19 2 119
9 127 127 127 127 127 127 127 127 127

 */

public class testPassword {

	static long Answer;
	static int N;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case=1; test_case <= T; test_case++) {
			N = sc.nextInt();
			int arr[] = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = sc.nextInt();
			}
			
			//������ ���� �������� �ٲ۴�.
			String a = "";
			for (int i=0; i<N; i++) {
				String s = Integer.toString(arr[i], 2);
				while(s.length()<7) s = "0" + s;
				a += s;
			}
			
			// ����� �������� Long ������ �ٲ۴�.
			Answer = Long.parseLong(a,2);
			
			System.out.println("#"+test_case+" "+Answer);
		}
	}

}
