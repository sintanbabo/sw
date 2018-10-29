package im;

import java.util.Scanner;

public class cal {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int a[] = {0,1,2,3,4,5,6,7,8};
		int b[] = {0,0,0,1,2,3,4,5,6};
		int c[] = new int[100];
		
		int a_index = a.length;
		int b_index = b.length;
		int c_index = 0;
		int round = 0;
		int d = 0;
		while(a_index < 0 && b_index < 0) 
		{
			a_index--; b_index--;
			d = a[a_index] + b[b_index] + round;
			if (d > 10) {
				d = d - 10;
				round = 1;
			}
			c[c_index] = d;
			c_index++;
		}
		
		for(int i=0; i<c_index; i++) 
		{
			
		}
	}
}
