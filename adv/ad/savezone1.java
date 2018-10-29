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
		
		// 좌표를 입력받고 입력받은 수만 저장한다.
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				zone[i][j] = sc.nextInt();
				value.add(zone[i][j]);
			}
		}
		
		// 최소수부터 최대수까지 반복하면서 현재 수의 값을 -1로 바꾼다.
		for (int z : value) {
			res = 0;
			for(int i=0; i<=N; i++) for (int j=0; j<=N; j++) visited[i][j] = -1;
			
			// 물에 잠긴 곳을 0으로 표시하고 물에 잠기지 않은 곳은 1로 표기한다.
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if (zone[i][j] <= z) zone_copy[i][j] = 0;
					else zone_copy[i][j] = 1;
				}
			}
			
			// 안전지대 개수 구하기
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
		
		// 결과 출력하기
		System.out.println(max_result);
	}
	
	public static void checkSaveZone(int I, int J) {
		
		// 현재 좌표가 방문되었다고 표시하기
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
