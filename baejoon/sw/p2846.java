package sw;

import java.util.Scanner;

public class p2846 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int input[] = new int[t];
		int result[] = new int[t];
		
		// �Է°� �ޱ�
		for(int i=0; i<input.length; i++) {
			input[i] = sc.nextInt();
		}
		
		// ����ϱ� (�ڽŰ� �ٷ� �ڽ��� �ո� ����)
		result[0] = 0;
		for(int i=0; i<input.length-1; i++) {
			if(input[i] < input[i+1]) {
				result[i+1] = input[i+1] - input[i];
			}
			else {
				result[i+1] = 0;
			}
		}
		
		// ���� ū ���� ã�´�.
		int max = 0;
		for(int i=0; i<input.length; i++) {
			if (result[i] > max) max = result[i];
		}
		
		System.out.println(max+"");
	}
}
