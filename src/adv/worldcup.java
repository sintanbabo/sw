package adv;

import java.util.Scanner;

/*
5 0 0 3 0 2 2 0 3 0 0 5 4 0 1 1 0 4
4 1 0 3 0 2 4 1 0 1 1 3 0 0 5 1 1 3
5 0 0 4 0 1 2 2 1 2 0 3 1 0 4 0 0 5
5 0 0 3 1 1 2 1 2 2 0 3 0 0 5 1 0 4

 */
public class worldcup {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		// ���� ����
		int country[][] = new int[6][3];
		int win=0, same=0, lose=0, result = 0, same_cnt = 0;
		
		for (int j=0; j<4; j++) {
			
			win=0; same=0; lose=0; result = 0; same_cnt = 0;
			
			// 6�� ���� ���ھ� ����
			for(int i=0; i<6; i++) {
				win += country[i][0] = sc.nextInt();
				same += country[i][1] = sc.nextInt();
				lose += country[i][2] = sc.nextInt();
				if (country[i][1] > 0) same_cnt++;
			}
			
			// ������ ���
			// 1. �°� ���� ���� ����
			// 2. ���� ���� ¦���̾�� �Ѵ�. ���� ������ ¦����� �Ѵ�.
			if ( win == lose && ((same%2) == 0) && ((same_cnt%2) == 0)) 
				result = 1;
			else
				result = 0;
			
			System.out.print(result + " ");
		}
		
	}
}
