package ad;

import java.util.Scanner;
import java.util.Set;
import java.util.TreeSet;

public class savezone1 {
	static int di[] = {-1, 1, 0, 0};
	static int dj[] = {0, 0, 1, -1};
	
	public static int N;
	public static int zone[][];
	public static int zone_copy[][];
	public static int visited[][];
	public static int max_result = 0;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		zone = new int[N+1][N+1];
		zone_copy = new int[N+1][N+1];
		visited = new int[N+1][N+1];
		Set<Integer> value = new TreeSet<Integer>();
		int min=100, max=1;
		int res=0;
		
		// ��ǥ�� �Է¹ް� �Է¹��� ���� �����Ѵ�.
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				zone[i][j] = sc.nextInt();
				value.add(zone[i][j]);
			}
		}
		
		// �ּҼ����� �ִ������ �ݺ��ϸ鼭 ���� ���� ���� -1�� �ٲ۴�.
		for (int z : value) {
			res = 0;
			for(int i=0; i<=N; i++) for (int j=0; j<=N; j++) visited[i][j] = -1;
			
			// ���� ��� ���� 0���� ǥ���ϰ� ���� ����� ���� ���� 1�� ǥ���Ѵ�.
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if (zone[i][j] <= z) zone_copy[i][j] = 0;
					else zone_copy[i][j] = 1;
				}
			}
			
			// �������� ���� ���ϱ�
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if (zone_copy[i][j] == 1 && visited[i][j] == -1) {
						res++;
						checkSaveZone(i,j);
						
					}
					if (max_result <= res) {
						max_result = res;
					}
				}
			}
		}
		
		// ��� ����ϱ�
		System.out.println(max_result);
	}
	
	public static void checkSaveZone(int I, int J) {
		
		// ���� ��ǥ�� �湮�Ǿ��ٰ� ǥ���ϱ�
		visited[I][J] = 1;
		
		for (int i=0; i<4; i++) {
			int ni = I + di[i];
			int nj = J + dj[i];
			if (ni<0 || ni>=N || nj<0 || nj>=N) continue;
			if (zone_copy[ni][nj] != 0 && visited[ni][nj] == -1) {
				checkSaveZone(ni, nj);
			}
		}
	}

}
