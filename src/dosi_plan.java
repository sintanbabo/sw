import java.util.Scanner;
import java.io.FileInputStream;

/*
 ����ϴ�Ŭ��������Solution �̾���ϹǷ�, ������Solution.java ��
 ����Ұ��������մϴ�.
 */
class dosi_plan {
	static int N;
	static int AnswerN = 0;

	public static void main(String args[]) throws Exception {
		
		Scanner sc = new Scanner(System.in);

		for (int test_case = 1; test_case <= 5; test_case++) {
			AnswerN = 0; // AnswerN �ʱ�ȭ�����ػ����߰��ѱ���.
			/*
			 * ���׽�Ʈ���̽���ǥ���Է¿����о�ɴϴ�.
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
							
							// ��
							for (int k = 1; i - k >= 0; k++) {
								if (map[i - k][j] == 'B') {
									AnswerN++;
								}
							}
							// �Ʒ�
							for (int k = 1; i + k < N; k++) {
								if (map[i + k][j] == 'B') {
									AnswerN++;
								}
							}
							// ��
							for (int k = 1; j - k >= 0; k++) {
								if (map[i][j - k] == 'B') {
									AnswerN++;
								}
							}
							// ��
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
