package baejoon;

import java.util.Scanner;

public class p13909 {

	public static int primeCount(int n) {
		int count = 1;
		int current = 2;
		for(current=2; current*current<n; current++) {
			if (n%current == 0)
				count++;
		}
		count *= 2;
		
		if (current*current == n) count++;
		
		return count;
	}
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int n = sc.nextInt();

		int d = 1;
		for(int i=2; i<=n; i++) {
			int temp = primeCount(i);			
			
			if (temp%2 == 0) {
				d = d;
			}
			else {
				d = d+1;
			}
		}
		
		System.out.println(d);
	}

}
