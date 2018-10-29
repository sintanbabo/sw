package adv;

import java.util.*;

/*
1
3
10 40 20 30 30 10

 */
public class ad_�ּҿ��� {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int t=1; t<=T; t++) {
			int n = sc.nextInt();
			int total_high = 0;
			int[][] stone = new int[n+1][2];
			boolean[] used = new boolean[n+1];
			Arrays.fill(used, false);
			
			// �Է°� �ޱ�
			for(int i=1; i<=n; i++) {
				stone[i][0] = sc.nextInt();
				total_high += stone[i][0];
				stone[i][1] = sc.nextInt();
			}
			
			// total_high���� 1������ n������ ���� ������ �� �ּ��� ���� ã�´�.
			int index = 0;
			int ans = 0;
			while(total_high > 0) {
				int temp = Integer.MAX_VALUE;
				for(int i=1; i<=n; i++) {
					if (used[i] == false && temp > stone[i][1] * (total_high-stone[i][0]) / 10) {
						temp = stone[i][1] * (total_high-stone[i][0]) / 10;
						index = i;
					}
				}
				used[index] = true;
				ans += temp;
				total_high -= stone[index][0];
			}
			System.out.println("#" + t + " " + ans);
		}
	}
}
