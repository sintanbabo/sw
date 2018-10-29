
import java.util.Scanner;

/*
4
4 adbc bdca
5 ebdac eadcb
6 ecfabd dfcaeb
8 dgceabhf fhagbcde

 */
public class MaterialSerial {
	
	public static void main(String[] arge) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		
		for (int t=1; t<=T; t++) {
			int N = sc.nextInt();
			char[] from = sc.next().toCharArray();
			char[] to = sc.next().toCharArray();
			
			// factoryR 계산해서 저장하기
			long[] fv = new long[N];
			for(int i=0; i<N; i++) {
				fv[i] = (i+1)*factoryR(i);
			}
			
			// from의 순서 계산하기
			long from_ranking = 0;
			
		}
	}
	
	public static long factoryR(long x) {
		if (x <= 1) return 1;
		else return x*factoryR(x-1);
	}
}