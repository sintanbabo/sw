package ad;

import java.util.*;

class Point1 {
	int number;
	int cnt;
	Point1(int n, int c) {
		this.number = n;
		this.cnt = c;
	}
}

public class ad_숫자만들기 {

	// BFS 알고리즘을 이용해서 최소 회수를 찾는다.
	public static int go(int s, int e) 
	{
		Point1 p = new Point1(s,0);
		Queue<Point1> q = new LinkedList<Point1>();
		
		// 시작점을 넣는다.
		q.add(p);
		
		while(!q.isEmpty()) {
			// 탐색할 좌표를 queue에서 꺼낸다.
			Point1 temp = q.remove();
			
			// 꺼낸 좌표가 end와 같은지 확인한다.
			if (temp.number == e) {
				return temp.cnt;
			}
			
			// 꺼낸 좌표가 아직 end와 같지 않다면, queue에 넣기
			// +1
			Point1 temp1 = new Point1(temp.number+1,temp.cnt+1);
			q.add(temp1);
			
			// *2
			Point1 temp2 = new Point1(temp.number*2,temp.cnt+1);
			q.add(temp2);
			
			// *3
			Point1 temp3 = new Point1(temp.number*3,temp.cnt+1);
			q.add(temp3);
		}
		
		// 여기까지 왔다면 end를 만들 수 없는 것이다.
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		System.out.println(go(start, end));
	}

}
