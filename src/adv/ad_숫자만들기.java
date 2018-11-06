package adv;

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

	// BFS �˰����� �̿��ؼ� �ּ� ȸ���� ã�´�.
	public static int go(int s, int e) 
	{
		Point1 p = new Point1(s,0);
		Queue<Point1> q = new LinkedList<Point1>();
		
		// �������� �ִ´�.
		q.add(p);
		
		while(!q.isEmpty()) {
			// Ž���� ��ǥ�� queue���� ������.
			Point1 temp = q.remove();
			
			// ���� ��ǥ�� end�� ������ Ȯ���Ѵ�.
			if (temp.number == e) {
				return temp.cnt;
			}
			
			// ���� ��ǥ�� ���� end�� ���� �ʴٸ�, queue�� �ֱ�
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
		
		// ������� �Դٸ� end�� ���� �� ���� ���̴�.
		return 0;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int start = sc.nextInt();
		int end = sc.nextInt();
		
		System.out.println(go(start, end));
	}

}
