package adv;

import java.io.FileNotFoundException;
import java.util.Iterator;

import java.util.Scanner;
import java.util.TreeSet;

public class savezone4 {
	
	static int Answer ;
	static int N ;	
	static int[][] map ;
	static int[][] visited ;
	static int MaxCnt = 0; 
	static int Cnt;
	static int[] di = { -1, 1, 0, 0 };
	static int[] dj = { 0, 0, -1, 1 };

	public static void main(String[] args) throws FileNotFoundException{
		
		//System.setIn( new FileInputStream("D:\\dev\\workspace\\JavaTest\\src\\adtest\\temp안전영역.txt"));	
		Scanner sc = new Scanner(System.in);
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		int T = sc.nextInt();
		
		for(int Testcase=0; Testcase < T; Testcase++){			
			
			N = sc.nextInt();
			
			map = new int[N ][N];
			visited = new int[N ][N];
			
			for (int i = 0 ; i < N  ; i++) 
			{
				for (int j = 0 ; j < N ; j++)
				{
					map[i][j] = sc.nextInt();
					ts.add(map[i][j]);
				}			
			}			

			Iterator<Integer> iter = ts.iterator();
			while(iter.hasNext()){
				// 특정값 -1로 변경
				int temp = iter.next();				
				for (int i = 0 ; i < N  ; i++) 
				{
					for (int j = 0 ; j < N ; j++)
					{
						if( map[i][j] == temp ){
							 map[i][j] = -1;
						}
					}			
				}
			
				// count 초기화
				Cnt=0;
				
				// 값 변경한 map 가지고 gogo !
				GOGO();
				
				System.out.println( "Cnt : " + Cnt   );
				
				MaxCnt = Math.max(Cnt, MaxCnt);
			}
			
			
			
			System.out.println("#" + (Testcase + 1) + " " + MaxCnt );
		}
			
	}
	
	// 특정값 이하 바꾼 map 에서 bfs 돌리기
   	public static void GOGO(){  
   		
   		
		// visited 초기화
		for (int i = 0 ; i < N  ; i++) 
		{
			for (int j = 0 ; j < N ; j++)
			{
				visited[i][j] = 0;
			}			
		}
		
		for (int i = 0 ; i < N  ; i++) 
		{
			for (int j = 0 ; j < N ; j++)
			{				
				if( map[i][j] != -1 && visited [i][j] != -1 ){
					BFS(i,j);
					Cnt++;
				}				
			}			
		}
   	}
   	
   	
   	public static void BFS(int i, int j){  
   	
        visited[i][j] = -1;	
   		
   		for(int a=0; a<4; a++){   			
   			int ii = i + di[a];
   			int jj = j + dj[a];
   			
   			if( ii>=0 && jj>=0 && ii<N && jj<N && map[ii][jj] != -1 && visited[ii][jj] != -1){
   				BFS(ii,jj);   			
   			}   			
   		}
   		
   	
   	}
	
}