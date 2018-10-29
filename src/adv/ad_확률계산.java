package adv;

import java.util.*;

/*
2
6 10 40
1 2 0.3 1 3 0.7 2 4 1 3 3 0.2 3 4 0.8 4 4 0.1 4 5 0.9 5 6 1 6 6 0.5 6 5 0.5
6 8 50
1 2 0.3 1 3 0.7 2 4 1 3 3 0.2 3 4 0.8 4 4 0.1 4 5 0.9 5 6 1

 */
class Node {
	int from;
	int to;
	float percent;
	boolean used;
}

public class ad_확률계산 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc=1; tc<=TC; tc++) {
			int n = sc.nextInt();
			int e = sc.nextInt();
			int t = sc.nextInt();
			Node[] node = new Node[e+1];
			float[][] total_percent = new float[n+1][1000];
			boolean[] used = new boolean[e+1];
			
			// 입력값 받기
			for(int i=1; i<=e; i++) {
				node[i] = new Node();
				node[i].from = sc.nextInt();
				node[i].to = sc.nextInt();
				node[i].percent = sc.nextFloat();
				node[i].used = false;
			}
			
			// 시작위치 지정
			int finish = 1;
			total_percent[1][0] = 1;
			
			// t(시간)만큼 반복해서 이동하기
			for(int i=0; i<t/10; i++) {
				float max_percent = Float.MIN_VALUE;
				for(int j=1; j<=e; j++) {
					int from = node[j].from;
					int to = node[j].to;
					float p = node[j].percent;
					boolean u = node[j].used;
					
					if (total_percent[from][i] > 0 && u == false) {
						total_percent[to][i+1] += total_percent[from][i] * p;
						float temp = total_percent[to][i+1];
						if(max_percent < temp) {
							max_percent = temp;
							finish = to;
							node[j].used = true;
						}
					}
				}
			}

			System.out.println("#" + tc + " " + finish + " " + total_percent[finish][t/10]);
		}
	}
}
