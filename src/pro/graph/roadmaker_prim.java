package pro.graph;

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
public class roadmaker_prim {
	static int N;			// ���� ����
	static int M;			// ���� ���� ����
	static int T;			// Test Case
	static int road[][];	// ����
	static int road_value[];// ���� ���
	static int min, max;	// ���� ���
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		
		// �Է°� �ޱ� �� �ʱ�ȭ
		for(int t=1; t<=T; t++) {
			N = sc.nextInt();		
			M = sc.nextInt();
			road = new int[M+1][3];
			road_value = new int[M+1];
			for(int i=1; i<M+1; i++) {
				road[i][0] = sc.nextInt();
				road[i][1] = sc.nextInt();
				road[i][2] = sc.nextInt();
				road_value[i] = -1;
			}
					
			// Ž�� ����
			prim(1,N-1);
			
			// �ִ� �ּҰ� ���ϱ�
			int temp = 0, temp1 = 0;
			min = Integer.MAX_VALUE;
			max = Integer.MIN_VALUE;
			for(int i=1; i<M+1; i++) {
				if (min > road_value[i] && road_value[i] > 0) min = road_value[i];
				if (max < road_value[i] && road_value[i] > 0) max = road_value[i];
			}
			
			// ����� ���
			for(int a : road_value) {
				System.out.print(a + " ");
			}
			System.out.println();
			
			System.out.println("#" + t + " : " + (max-min));
		}
	}
	
	static void prim(int start, int m) {
		int min_point = 0;
		int prim_min = 0;
		
		min_point = start;
		
		while (m >= 0) {
			
			// ����Ǿ����� ǥ��
			road_value[min_point] = prim_min;
			
			// S ���յ� �߿��� S �ܺο� ����� �� �� �߿��� �ּҺ���� ã�´�.
			prim_min = Integer.MAX_VALUE;
			for(int i=1; i<M+1; i++) {
				if (road_value[road[i][0]] >= 0 && road_value[road[i][1]] < 0) {
					if (road[i][2] < prim_min) {
						min_point = road[i][1];
						prim_min = road[i][2];
					}
				}
			}

			// �ϳ��� ���ἱ�� ������� ǥ��
			m = m-1;
		}		
	}
}
