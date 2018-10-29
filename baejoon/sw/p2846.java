package sw;

import java.util.Scanner;

public class p2846 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int t = sc.nextInt();
		int input[] = new int[t];
		int result[] = new int[t];
		
		// 입력값 받기
		for(int i=0; i<input.length; i++) {
			input[i] = sc.nextInt();
		}
		
		// 계산하기 (자신과 바로 자신의 앞만 본다)
		result[0] = 0;
		for(int i=0; i<input.length-1; i++) {
			if(input[i] < input[i+1]) {
				result[i+1] = input[i+1] - input[i];
			}
			else {
				result[i+1] = 0;
			}
		}
		
		// 가장 큰 값을 찾는다.
		int max = 0;
		for(int i=0; i<input.length; i++) {
			if (result[i] > max) max = result[i];
		}
		
		System.out.println(max+"");
	}
}
