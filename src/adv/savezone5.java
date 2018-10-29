package adv;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.TreeSet;

public class savezone5 {
	
	static int Answer ;
	static int N ;	
	static int[][] map ;
	static int[][] visited ;
	static int MaxCnt = 0; 
	static int Cnt;
	static TreeSet ts = new TreeSet();	
	static int[] di = { -1, 0, 1, 0 };
	static int[] dj = { 0, 1, 0, -1 };
	static int myCnt=0;
	static Queue<Data> q = new LinkedList<Data>();
		
 
	public static class Data{
		int x , y ;
		
		public Data(int x, int y  ){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws FileNotFoundException{
		
		//System.setIn( new FileInputStream("D:\\dev\\workspace\\JavaTest\\src\\adtest\\안전영역2.txt"));	
		Scanner sc = new Scanner(System.in);
				
		int T = sc.nextInt();
		
		
		for(int Testcase=0; Testcase < T; Testcase++){			
			
			N = sc.nextInt();
			
			MaxCnt=0;
			map = new int[N][N];
			visited = new int[N][N];
			
			for (int i = 0 ; i < N  ; i++) 
			{
				for (int j = 0 ; j < N ; j++)
				{
					map[i][j] = sc.nextInt();
					ts.add(map[i][j]);
				}			
			}			

			Iterator iter = ts.iterator();
			while(iter.hasNext()){
				int temp = (Integer) iter.next();
				System.out.println(temp);
				// 침수값 -1로 변경		
				for (int i = 0 ; i < N  ; i++) 
				{
					for (int j = 0 ; j < N ; j++)
					{
						if( map[i][j] == temp ){
							 map[i][j] = -1;
						}
						visited[i][j] = 0;
					}			
				}
				
				for (int i = 0 ; i < N  ; i++) 
				{
					for (int j = 0 ; j < N ; j++)
					{
						System.out.print(map[i][j] + " ");
					}			
					System.out.println();
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
   		
		for (int i = 0 ; i < N  ; i++) 
		{
			for (int j = 0 ; j < N ; j++)
			{				
				if( map[i][j] > -1 && visited [i][j] == 0 ){
					BFS(i,j);
					Cnt++;
				}				
			}			
		}
   	}
   	
   	
   	public static void BFS(int i, int j){ 
   		
   		q.add(new Data(i,j));		
   		
        while(!q.isEmpty()){
             Data t =	q.poll();
             if( map[t.x][t.y] > 0 && visited[t.x][t.y]  == 0 ){
                visited[t.x][t.y] = 1;
             
                System.out.println("visited : " + t.x + " " + t.y);
		   		for(int a=0; a<4; a++){   			
		   			int ii = t.x + di[a];
		   			int jj = t.y + dj[a];
		   			
		   			if( ii<0 || jj<0 || ii>=N || jj>=N ) continue;
		   			if( map[ii][jj] > 0 && visited[ii][jj]  == 0 ){
		   				q.add(new Data(ii, jj));
		   				
		   			}   			
	   		    }
             }
        }
   	
   	}
	
}
