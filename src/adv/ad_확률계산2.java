package adv;

import java.util.*;

public class ad_Ȯ�����2 {
	public static void main(String args[]) {
		Scanner sc = new Scanner(System.in);
		
		int TC = sc.nextInt();
		
		for(int tc=1; tc<=TC; tc++) {
			int n = sc.nextInt();
			int e = sc.nextInt();
			int t = sc.nextInt();
			Node[] node = new Node[n+1];
			float[] total_percent = new float[n+1];
			
			// �Է°� �ޱ�
			for(int i=1; i<=e; i++) {
				node[i] = new Node();
				node[i].from = sc.nextInt();
				node[i].to = sc.nextInt();
				node[i].percent = sc.nextFloat();
			}
			
			// ������ġ ����
			int start = 1;
			total_percent[start] = 1;
			
			
		}
	}
}
