package adv;

import java.util.Scanner;

public class savezone2 {

	static int di[] = {-1, 1, 0, 0};
	static int dj[] = {0, 0, 1, -1};
	static int M[][] = new int[101][101];
	static int Mcopy[][] = new int[101][101];
	static int visited[][] = new int[101][101];
	static int area;
	static int N;
	static int maxArea = 0;
	
	static void dfs(int I, int J) {
		visited[I][J] = 1;
		
		for (int i=0; i<4; i++) {
			int ni = I + di[i];
			int nj = J + dj[i];
			if (ni<1 || ni>N || nj<1 || nj>N) continue;
			if (Mcopy[ni][nj] != 0 && visited[ni][nj] == -1) {
				dfs(ni, nj);
			}
		}
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int maxnum = 0;
		int minnum = 101;
		
		for(int i=1; i<=N; i++) {
			for (int j=1; j<=N; j++) {
				M[i][j] = sc.nextInt();
				if (M[i][j] > maxnum) maxnum = M[i][j];
				if (M[i][j] < minnum) minnum = M[i][j];
			}
		}
		
		for (int k=minnum; k<=maxnum; k++) {
			area = 0;
			for(int i=0; i<101; i++) for (int j=0; j<101; j++) visited[i][j] = -1;
			
			for(int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if (M[i][j] <= k) {
						Mcopy[i][j] = 0;
					}
					else {
						Mcopy[i][j] = 1;
					}
				}
			}
			
			for (int i=1; i<=N; i++) {
				for(int j=1; j<=N; j++) {
					if (Mcopy[i][j] == 1 && visited[i][j] == -1) {
						area++;
						dfs(i,j);
						
						if (area>maxArea) maxArea = area;
					}
				}
			}
		}
		
		System.out.println(maxArea);
	}
}
