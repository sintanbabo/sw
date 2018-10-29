package im;

import java.util.Scanner;

/*
2
3 5
2 7 5 11 1
5 1 14 0 2
3 9 8 12 4
3 3
1 1 1
2 2 2
3 3 3

 */
public class horror_house {

	public static int room[][];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int x=0,y=0,result=0;
		
		for(int t=1; t<=T; t++) {
			x = y = result = 0;
			x = sc.nextInt();
			y = sc.nextInt();
			room = new int[x][y];
			
			// 2차원 배열에 공포 지수 저장하기
			for (int i=0; i<x; i++) {
				for (int j=0; j<y; j++) {
					room[i][j] = sc.nextInt();
				}
			}
			
			result = Math.min(returnMinValue(x-1,y-2), returnMinValue(x-2,y-1)) + room[x-1][y-1];
			
			System.out.println("#" + t + " " + result);
		}
	}
	
	public static int returnMinValue(int x, int y) {
		if (x == 0 && y == 0) {
			return room[0][0];
		}
		else if (y-1<0 && x-1 >= 0) {
			return returnMinValue(x-1,y) + room[x][y];
		}
		else if (x-1<0 && y-1 >= 0) {
			return returnMinValue(x,y-1) + room[x][y];
		}
		else {
			return Math.min(returnMinValue(x,y-1), returnMinValue(x-1,y)) + room[x][y];
		}
	}

}
