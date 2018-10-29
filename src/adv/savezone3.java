package adv;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point {
	int x,y;
	Point(int x, int y) {
		this.x = x;
		this.y = y;
	}
}

public class savezone3 {

	static int di[] = {-1, 1, 0, 0};
	static int dj[] = {0, 0, 1, -1};
	static int M[][] = new int[101][101];
	static int Mcopy[][] = new int[101][101];
	static int visited[][] = new int[101][101];
	static int area;
	static int N;
	static int maxArea = 0;
	
	static void bfs(int I, int J, Queue<Point> q) {
		
		Point c = new Point(I,J);
		Point p;
		
		// ���� ��ǥ�� �Է��Ѵ�.
		q.add(c);
		
		// Queue�� ���� ���� ���� ������ �ݺ��Ѵ�.
		while(!q.isEmpty()) {
			// Queue���� �ϳ��� ������.
			p = q.poll();
			
			// ���� ��ǥ�� �湮���� �ʾҰ� ���̰� �ִٸ�, �湮�ϰ� ���� ��ǥ�� �ֺ� ���� �ִ´�.
			if (Mcopy[p.x][p.y] == 1 && visited[p.x][p.y] == -1) {
				visited[p.x][p.y] = 1;
				
				for(int i=0; i<4; i++) {
					int x = p.x + di[i];
					int y = p.y + dj[i];
					
					if (x<0 || x>N || y<0 || y>N) continue;
					if (Mcopy[x][y] !=0 && visited[x][y] == -1) {
						Point e = new Point(x,y);
						q.add(e);
					}
				}
			}
		}
		
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int maxnum = 0;
		int minnum = 101;
		Queue q = new LinkedList<Integer>();
		
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
						bfs(i,j,q);
						
						if (area>maxArea) maxArea = area;
					}
				}
			}
		}
		
		System.out.println(maxArea);
	}
}
