package adv;

import java.util.Scanner;

public class city_connect {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int road_count = 0;
		int city_count = 0;
		int road[][];
		int connecting_group[];
		
		for (int t=1; t<=T; t++) {
			city_count = sc.nextInt();					// ���� ����
			road_count = sc.nextInt();					// �� ����
			road = new int[road_count][3];				// ���� ���� 
			connecting_group = new int[city_count];		// ����� ���θ� ������ ����
			
			// connection_group �ʱ�ȭ
			for (int i=0; i<city_count; i++) connecting_group[i] = 0;
			
			// �Է°� ����
			for(int i=0; i<road_count; i++) {
				road[i][0] = sc.nextInt();		// ���� ����
				road[i][1] = sc.nextInt();		// �� ����
				road[i][2] = 1;					// ��뿩�� (0 : �߸� ����, 1:���� ����)
			}
			
			// ���� �ڸ��� (1�����ú��� city_count�����ñ��� �ڸ���)
			for(int i=1; i<=city_count; i++) {
				
				// ���� ���ֱ�
				// (���� ���� �Ǵ� ���� ���ð� ���� ���ÿ� ���Ǹ� �濡�� ��������� ǥ���Ѵ�.)
				if (road[i][0] == i || road[i][1] == i) {
					road[i][2] = 0;
				}
				
				// ���� ���ø� �����ϰ� ��� ����Ǵ��� Ȯ��
				// 	������ ������ŭ �ݺ��ؼ� Ȯ���Ѵ�.
				for(int j=0; j<road_count; j++) {
					
				}
			}
		}

	}

}
