
import java.util.ArrayList;
import java.util.Scanner;

/*
4 40
6
3 4 20
1 2 10
1 3 20
1 4 30
2 3 10
2 4 20
70

6 60					
5
1 2 30
2 5 70
5 6 60
3 4 40
1 6 40
150

4 40
6
1 2 10
1 3 20
1 4 30
2 3 10
2 4 20
3 4 20
70
 */
public class specialDelivery {

	public static void main(String[] args) {
		
		class Box
		{
			int from;
			int to;
			int box;
		}
		
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();	// 마을수
		int C = sc.nextInt();	// 트럭 용량
		int M = sc.nextInt();	// 박스 수
		int index = 0, boxcnt = 0, carindex = 0, deliverycnt = 0;
		Box[] list = new Box[M];
		Box[] car = new Box[M];
		
		for(int i=0; i<M; i++) {
			list[i] = new Box();
			list[i].from = sc.nextInt();
			list[i].to = sc.nextInt();
			list[i].box = sc.nextInt();
		}
		
		index = 1;
		carindex = 0;
		while(index<=N) {
			
			// 트럭에서 빼기
			for(int j = 0; j<carindex; j++) {
				if (car[j].to == index) {
					boxcnt -= car[j].box;
					deliverycnt += car[j].box;
					car[j].from = 0;
					car[j].to = 0;
					car[j].box = 0;
				}
			}
			
			// 트럭에 넣기
			for(int i=0; i<M; i++) {
				if (list[i].from == index && boxcnt < C) {
					if ( (boxcnt + list[i].box) <= C) {
						car[carindex] = new Box();
						car[carindex].from = list[i].from;
						car[carindex].to = list[i].to;
						car[carindex].box = list[i].box;
						boxcnt += list[i].box;
					}
					else {
						car[carindex] = new Box();
						car[carindex].from = list[i].from;
						car[carindex].to = list[i].to;
						car[carindex].box = C-boxcnt;
						boxcnt = C;
					}
					carindex++;
				}
			}
			index++;
		}
		
		System.out.println(deliverycnt);
		
	}
}
