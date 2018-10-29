package adv;

import java.util.Scanner;

public class triangle {
	public static void main(String args[]) throws Exception	{
		//파스칼 삼각형
		Scanner sc = new Scanner(System.in);  
		int N = sc.nextInt(); // 높이
		int M = sc.nextInt(); // 출력형태
		 
		int[][] pascal = new int[N][N];
		 
		for (int i = 0; i < N; ++i) {
			for (int j = 0; j <= i; ++j) {
				if (j == 0 || j == i) {
					pascal[i][j] = 1;
				} else {
					pascal[i][j] = pascal[i - 1][j - 1] + pascal[i - 1][j];
				}
			}
		}
		    
	
		//출력형태
		if (M == 1) {
			/*
			1 
			1 1 
			1 2 1 
			1 3 3 1 
			1 4 6 4 1
			*/ 
			for (int i = 0; i < N; ++i)	{
				for (int j = 0; j < N; ++j)	{
					if (pascal[i][j] != 0) {
						System.out.print(pascal[i][j] + " ");
					}
				}
				System.out.println();
			}
		} else if (M == 2) {
			/*
			1 4 6 4 1 
			 1 3 3 1 
			  1 2 1 
			   1 1 
			    1 
			*/
			for (int i = N - 1; i >= 0; --i) {
				for (int j = i; j < N - 1; ++j)	{
					System.out.print(" ");
				}
				for (int j = 0; j < N; ++j)	{
					if (pascal[i][j] != 0) {
						System.out.print(pascal[i][j] + " ");
					}
				}
				System.out.println();
			}
		} else if (M == 3) {
			/*
			1 
			4 1 
			6 3 1 
			4 3 2 1 
			1 1 1 1 1 
			*/
			for (int i = N - 1; i >= 0; --i) {
				for (int j = N - 1; j >= 0; --j) {
					if (pascal[j][i] != 0) {
						System.out.print(pascal[j][i] + " ");
					}
				}
				System.out.println();
			}
		} //end if
	}
}
