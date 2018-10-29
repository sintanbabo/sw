package ad;

import java.util.Scanner;

public class BusTransfer {

	static int M, N, bus_count, bus[][], result, start[], end[], temp, bus_use[], current_bus;
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		M = sc.nextInt();
		N = sc.nextInt();
		bus_count = sc.nextInt();
		bus = new int[bus_count][6];
		bus_use = new int[bus_count];
		current_bus = temp = result = -1;
		start = new int[2];
		end = new int[2];
	
		// 입력값 받기
		for(int i=0; i<bus_count; i++) {
			bus[i][0] = sc.nextInt(); // bus id
			bus[i][1] = sc.nextInt(); // bus start x
			bus[i][2] = sc.nextInt(); // bus start y
			bus[i][3] = sc.nextInt(); // bus end x
			bus[i][4] = sc.nextInt(); // bus end y
			if (bus[i][1] == bus[i][3])
				bus[i][5] = 'H';
			else
				bus[i][5] = 'W';
			bus_use[i] = 0;
		}
		
		start[0] = sc.nextInt();
		start[1] = sc.nextInt();
		
		end[0] = sc.nextInt();
		end[1] = sc.nextInt();
		
		for (int i=0; i<bus_count; i++) {
			if (bus[i][0] <= start[0] && bus[i][3] >= start[0] && bus[i][2] <= start[1] && bus[i][4] >= start[1]) {
				current_bus = bus[i][0];
				temp=1;
				bus_move(i, start[0],start[1],end[0],end[1]);
			}
		}
						
		System.out.println(result);
	}

	static void bus_move(int bus_index, int sx, int sy, int ex, int ey) {
		if (sx == ex && sy == ey) {
			if (temp < result) result = temp;
			return ;
		}
		
		// 현재 버스의 경로를 처음부터 끝까지 따라간다.
		// 중간에 다른 버스 경로를 만난다면, 다른 버스 경로로 bus_move
		for (int i=sx; i<bus[bus_index][3]; i++) {
			for (int j=sy; j<bus[bus_index][4]; j++) {
				
			}
		}
	}
}
