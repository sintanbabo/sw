import java.util.Scanner;

/*
 * 8 6 10 1 2 1 3 3 1 3 2 3 6 3 8 4 1 4 5 5 4 5 6 6 2 6 3 6 6 6 7 7 3 7 6 1 5 1 7 2 3 2 6
 */
public class testLadder {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int B = sc.nextInt();
		int l_cnt = sc.nextInt();
		int i,j,x,y;
		int[][] L = new int[N][N];
		
		// L 시작, 끝 좌표 저장
		for(i=0; i<l_cnt; i++) {
			x = sc.nextInt();
			y = sc.nextInt();
			
			L[x-1][y-1] = 1;
			
			x = sc.nextInt();
			y = sc.nextInt();
			
			L[x-1][y-1] = 2;
		}
		
		// 폭탄을 시작위치로 거꾸로 올라간다.
		x = N-1;
		y = B-1;
		L[x][y] = 3;
		
		while(true) {
			if (L[x][y] == 3) x -= 1;
			if (L[x][y] == 0) x -= 1;
			if (L[x][y] == 1){
				for(i=y+1; i<N; i++) {
					if(L[x][i] == 2) {
						x -= 1;
						y = i;
						break;
					}
						
				}
			}
			if (L[x][y] == 2){
				for(i=y-1; y>=0; i--) {
					if(L[x][i] == 1) {
						x -= 1;
						y = i;
						break;
					}
						
				}
			}
			
			// 종료시점 확인
			if (x==0) break;
		}
		
		// L 출력
		for(i=0; i<N; i++) {
			for(j=0; j<N; j++) {
				System.out.print(L[i][j]);
			}
			System.out.println();
		}
		
		System.out.println(y+1);
		
	}

}
