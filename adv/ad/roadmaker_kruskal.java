package ad;

import java.util.Scanner;

/*
1
5
7
1 2 2 
1 3 7
2 3 8
2 4 1
3 4 1
3 5 9
4 5 6
 */
public class roadmaker_kruskal {
	static int N;				// ���� ����
	static int M;				// ���� ���� ����
	static int T;				// Test Case
	static int road[][];		// ����
	static int group_value[];	// ���� �׷�
	static int road_value[];	// ���� ���
	static int min, max;		// ���� ���
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		// �Է°� �ޱ� �� �ʱ�ȭ
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();		
			M = sc.nextInt();
			road = new int[M+1][3];
			group_value = new int[M+1];
			road_value = new int[M+1];
			for(int i=1; i<M+1; i++) {
				road[i][0] = sc.nextInt();
				road[i][1] = sc.nextInt();
				road[i][2] = sc.nextInt();
				group_value[i] = -1;
			}
					
			// Ž�� ����
			kruskal(1,N-1);
			
			// �ִ� �ּҰ� ���ϱ�
			int temp = 0, temp1 = 0;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			for(int i=1; i<M+1; i++) {
				if (min > road_value[i] && road_value[i] > 0) min = road_value[i];
				if (max < road_value[i] && road_value[i] > 0) max = road_value[i];
			}
			
			System.out.println("#" + t + " : " + (max-min));
		}
	}
	
	static void kruskal(int start, int m) {
		int temp0, temp1, temp2;
		
		// �Էµ� ��庰 ���� ����ġ�� �������� �����Ѵ�.
		for (int i=1; i<M+1; i++) {
			for (int j=i+1; j<M+1; j++) {
				if (road[i][2] > road[j][2]) {
					temp0 = road[i][0];
					temp1 = road[i][1];
					temp2 = road[i][2];
					
					road[i][0] = road[j][0];
					road[i][1] = road[j][1];
					road[i][2] = road[j][2];
					
					road[j][0] = temp0;
					road[j][1] = temp1;
					road[j][2] = temp2;
				}
			}
		}
		
		int index = 1;
		int group = 1;
		while (m >= 0) {
			
			// ����ġ�� ���� ���� ��带 �����Ѵ�. (index�� ���� ����� ����ϸ� �ȴ�)
			// (���õ� ��忡 ���ؼ� cycle�� �����Ǹ� �ȵȴ�) 
			if (group_value[road[index][0]] < 0 && group_value[road[index][1]] < 0)
			{	
				// 2���� ��� ��� �׷쿡 �������� ���� ��, 2���� ��带 �̿��ؼ� �ϳ��� �׷��� �����.
				group_value[road[index][0]] = ++group;
				group_value[road[index][1]] = ++group;
				road_value[road[index][1]] = road[index][2];
				index++;
			}
			else if (group_value[road[index][0]] >= 0 && group_value[road[index][1]] < 0)
			{
				// ���� ��常 �׷쿡 ���� ���� ��, ���� ����� �׷찪�� ���� ���� �������ش�.
				group_value[road[index][1]] = group_value[road[index][0]];
				road_value[road[index][1]] = road[index][2];
				index++;
			}
			else if (group_value[road[index][0]] < 0 && group_value[road[index][1]] >= 0)
			{
				// ���� ��常 �׷쿡 ���� ���� ��, ���� ����� �׷찪�� ���� ���� �������ش�.
				group_value[road[index][0]] = group_value[road[index][1]];
				road_value[road[index][1]] = road[index][2];
				index++;
			}
			else if (group_value[road[index][0]] >= 0 && group_value[road[index][1]] >= 0 && group_value[road[index][0]] != group_value[road[index][1]])
			{
				// ���� ���� ���� ����� �׷찪�� �ٸ� ���, ���� ��� �׷��� ���� ��� ���� ��� �׷��� ������ �ٲ۴�.
				int group_temp1, group_temp2;
				
				group_temp1 = group_value[road[index][0]];
				group_temp2 = group_value[road[index][1]];
				
				for (int i=1; i<M+1; i++) {
					if (group_value[i] == group_temp2) {
						group_value[i] = group_temp1;
					}
				}
				
				road_value[road[index][1]] = road[index][2];
				index++;
			}
			else {
				index++;
				continue;
			}
			
			// �ϳ��� ���ἱ�� ������� ǥ��
			m = m-1;
		}		
	}
}
