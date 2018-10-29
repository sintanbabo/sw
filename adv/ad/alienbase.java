package ad;

import java.util.Scanner;

public class alienbase {

	static int visited[] = new int[15];
	static int input[][] = new int[15][15];
	static int index = 0;
	static int N;
	static int answer;
	static int temp;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		
		for (int t=1; t<=T; t++) {
			N = sc.nextInt();
			
			// �Է°� ����
			for (int i = 0; i < N; i++) {
				visited[i] = 0;
				for (int j = 0; j < N; j++) {
					input[i][j] = sc.nextInt();
				}
			}
			temp = 0;
			answer = Integer.MAX_VALUE;
			dfs(0);
			System.out.println("#" + t + " " + answer);
		}
	}
	
	public static void dfs(int d) {
	
		if (d >= N) {
			if (answer >= temp) {
				answer = temp;
			}
			return ;
		}
		
		// Ž�� ����
		for (int i=0; i<N; i++) {
			if (visited[i] == 0) {
				temp += input[d][i];
				
				// �߰����� ���� �ּҰ��� �Ѿ�� Ž���� �����Ѵ�.
				if (temp > answer) {
					temp -= input[d][i];
					continue;
				}
				
				// �湮 ���� ����
				visited[i] = 1;
				
				// ���� Ž�� ����
				dfs(d+1);
				visited[i] = 0;
				temp -= input[d][i];
			}
		}
	}
}
