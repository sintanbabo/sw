package pro.graph;

import java.util.*;

public class prime {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		long n = sc.nextLong();
		
		int count = 1;
		int current = 2;
		for(current=2; current*current<n; current++) {
			if (n%current == 0)
				count++;
		}
		
		count *= 2;
		
		if (current*current == n) count++;
		
		System.out.println(count);
	}
}
