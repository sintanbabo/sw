import java.util.Scanner;
import java.io.FileInputStream;

/*
 사용하는클래스명이Solution 이어야하므로, 가급적Solution.java 를
 사용할것을권장합니다.
 */
class dosi_plan {
	static int N;
	static int AnswerN = 0;

	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 5; test_case++) {
			AnswerN = 0; // AnswerN 초기화를위해새로추가한구문.
			/*
			 * 각테스트케이스를표준입력에서읽어옵니다.
			 */
			N = sc.nextInt();
			char[][] map = new char[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					String tmp = sc.next();
					map[i][j] = tmp.charAt(0);
				}
			}
			///////////////////////////////////////////////////////////////////
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (map[i][j] == 'B') {
						
						if (map[i - 1][j] == 'G' || map[i + 1][j] == 'G' ||
						    map[i][j - 1] == 'G' || map[i][j + 1] == 'G') {
							AnswerN += 1;
						} 
												
						else {							
							AnswerN++;
							
							// 위
							for (int k = 1; i - k >= 0; k++) {
								if (map[i - k][j] == 'B') {
									AnswerN++;
								}
							}
							// 아래
							for (int k = 1; i + k < N; k++) {
								if (map[i + k][j] == 'B') {
									AnswerN++;
								}
							}
							// 좌
							for (int k = 1; j - k >= 0; k++) {
								if (map[i][j - k] == 'B') {
									AnswerN++;
								}
							}
							// 우
							for (int k = 1; j + k < N; k++) {
								if (map[i][j + k] == 'B') {
									AnswerN++;
								}
							}							
						}
					}
				}
			}
			/////////////////////////////////////////////////////////////
			System.out.println("#" + test_case + " " + AnswerN);
		}
	}
}
