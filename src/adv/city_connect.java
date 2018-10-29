package adv;

import java.util.Scanner;

public class city_connect {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int road_count = 0;
		int city_count = 0;
		int road[][];
		int connecting_group[];
		
		for (int t=1; t<=T; t++) {
			city_count = sc.nextInt();					// 도시 개수
			road_count = sc.nextInt();					// 길 개수
			road = new int[road_count][3];				// 도로 정보 
			connecting_group = new int[city_count];		// 연결된 도로를 저장할 변수
			
			// connection_group 초기화
			for (int i=0; i<city_count; i++) connecting_group[i] = 0;
			
			// 입력값 저장
			for(int i=0; i<road_count; i++) {
				road[i][0] = sc.nextInt();		// 시작 도시
				road[i][1] = sc.nextInt();		// 끝 도시
				road[i][2] = 1;					// 사용여부 (0 : 잘린 도로, 1:사용된 도로)
			}
			
			// 도시 자르기 (1번도시부터 city_count번도시까지 자른다)
			for(int i=1; i<=city_count; i++) {
				
				// 도시 없애기
				// (시작 도시 또는 종료 도시가 없앨 도시에 대당되면 길에서 사라졌음을 표시한다.)
				if (road[i][0] == i || road[i][1] == i) {
					road[i][2] = 0;
				}
				
				// 없앤 도시를 제외하고 모두 연결되는지 확인
				// 	도로의 개수만큼 반복해서 확인한다.
				for(int j=0; j<road_count; j++) {
					
				}
			}
		}

	}

}
