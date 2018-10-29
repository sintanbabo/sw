package baejoon;

import java.util.*;

class p1217 implements Comparable<p1217>{
	int a;
	int b;
	
	public int compareTo(p1217 target) {
		if (this.b > target.b) {
			return 1;
		} else if (this.b < target.b) {
			return -1;
		}
		return 0;
	}
}

public class p1217_2 {

	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for(int t=1; t<=T; t++) {
			int n = sc.nextInt();
			int k = sc.nextInt();
			int[] a = new int[n+1];
			int[] b = new int[n+1];
			PriorityQueue<p1217> selected = new PriorityQueue<p1217>(Collections.reverseOrder());
			PriorityQueue<p1217> not_selected = new PriorityQueue<p1217>();
			
			// 입력값 받기
			for(int i=1; i<=n; i++) {
				p1217 temp = new p1217();
				temp.a = sc.nextInt();
				temp.b = sc.nextInt();
				not_selected.offer(temp);
			}
			
			double result = 0.0;
			int f=0, w=0;
			for(int i=1; i<=n; i++) {
				
				p1217 temp = not_selected.poll();
				
				if (k > 0) {
					selected.offer(temp);
					not_selected.remove(i);
					f += temp.a;
					w += temp.b;
					result = (double)f / (double)w;
					k--;
				}
				else {
					p1217 select = selected.poll();
					f -= select.a;
					w -= select.b;
					p1217 not = not_selected.poll();
					f += not.a;
					w += not.b;
					double r = (double) f / (double) w;
					
					if (result < r) {
						selected.offer(not);
						not_selected.offer(select);
						result = r;
					}
					else {
						f -= not.a;
						w -= not.b;
						f += select.a;
						w += select.b;
						selected.offer(select);
						not_selected.offer(not);
					}
				}
			}
			
			System.out.println("#" + t + " " + String.format("%.3f", result));
		}
	}
}
