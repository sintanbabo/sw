package baejoon;

import java.util.Scanner;

public class p2011 {
	static long c = 1000000;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		int a[] = new int[input.length()+1];
		long d[] = new long[input.length()+1];
		boolean isZero = false;
		
		// �Է°��� char �迭�� ��ȯ
		a[0] = 0;
		for(int i=0; i<input.length(); i++) {
			a[i+1] = input.charAt(i)-'0';
		}
		
		// �Է°��� ���ؼ� ��쿡 �� ���
		d[0] = 1;
		d[1] = 1;
		
		if (a[1] == 0)
		{
			isZero = true;
		}
		else {
			for(int i=2; i<a.length; i++) {
				
				if (a[i] > 0){
					d[i] = (d[i-1]) % c;
				}
				
				int temp = a[i-1]*10 + a[i];
				
				if (temp >= 10 && temp <= 26)
					d[i] = (d[i] + d[i-2]) % c;
			}
		}
		
		if (isZero) System.out.println(0);
		else System.out.println(d[input.length()]);
	}
}
