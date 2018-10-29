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
			
			// 입력값 저장
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
		
		// 탐색 시작
		for (int i=0; i<N; i++) {
			if (visited[i] == 0) {
				temp += input[d][i];
				
				// 중간값이 현재 최소값을 넘어가면 탐색을 종료한다.
				if (temp > answer) {
					temp -= input[d][i];
					continue;
				}
				
				// 방문 여부 저장
				visited[i] = 1;
				
				// 다음 탐색 ㄱㄱ
				dfs(d+1);
				visited[i] = 0;
				temp -= input[d][i];
			}
		}
	}
}
