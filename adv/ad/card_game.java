package ad;
import java.util.Arrays;
import java.util.Scanner;

/*
3
3 2 5
2 4 1

4
1 2 3 4
4 1 2 3

5
3 2 4 3 4
3 5 5 2 2

6
1 5 6 4 3 8
9 7 4 5 2 1

 */
public class card_game {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		
		int left[];
		int right[];
		int temp = 0, result = 0;
		
		int card_count = sc.nextInt();
		left  = new int[card_count];
		right  = new int[card_count];
		
		// 왼쪽값 받기
		for (int i=0; i<card_count; i++) {
			left[i] = sc.nextInt();
		}
		
		// 오른쪽값 받기
		for (int j=0; j<card_count; j++) {
			right[j] = sc.nextInt();
		}
		
		// 왼쪽의 가장 큰 수를 찾는다.
		Arrays.sort(left);
		temp = left[card_count-1];
		
		// 왼쪽의 가장 큰 수보다 작은 오른쪽 카드를 찾아서 더한다.
		for (int i=0; i<card_count; i++) {
			if (temp > right[i]) {
				result += right[i];
			}
		}
		
		// 결과 출력 
		System.out.println(result);
	}

}
