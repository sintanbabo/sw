package sw;
import java.util.*;

// �ؾ �Ǹ��ϱ�
public class p11052 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();
		int[] p = new int[n+1];
		int[] d = new int[n+1];
		
		// �Է°� �ޱ�
		for(int i=1; i<=n; i++) {
			p[i] = sc.nextInt();
		}
		
		// d[i] = max(loop(1<=j<=i)(p[i] + d[i-j]))
		for(int i=1; i<=n; i++) {
			for(int j=1; j<=i; j++) {
				if (d[i] < p[i] + d[i-j]) {
					d[i] = p[i] + d[i-j];
				}
			}
		}
		System.out.println(d[n]);
	}
}
