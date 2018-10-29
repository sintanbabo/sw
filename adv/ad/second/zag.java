package ad.second;

import java.util.ArrayList;
//import java.io.FileInputStream;
import java.util.Scanner;
import java.util.Stack;

public class zag 
{
	static int ROW;
	static int COL;
	static int stX;
	static int stY;	
	
	private int m_SrcArray[][];
	private int m_nRow;
	private int m_nCol;
	private int m_nStartX;
	private int m_nStartY;
	private int m_lastSec;
	private int m_remainSec;
	
	private Stack<ZagPoint> zagStack;
	
	public static void main(String []args) throws Exception
	{
		//System.setIn(new FileInputStream("res/sample_input.txt"));
		Scanner sc = new Scanner(System.in);
		char srcArray[][] = null;
		COL = sc.nextInt();
		ROW = sc.nextInt();	
		
		//CHAR 배열로 입력 처리
		srcArray = new char[ROW][];
		for (int i = 0; i < ROW; i++)
		{			
			String tp = sc.next();
			srcArray[i] = tp.toCharArray(); 
		}
		stX = sc.nextInt();
		stY = sc.nextInt();
		
		//INT 배열로 변환
		int nSrcArray[][] = new int[ROW][COL];		
		for (int i = 0; i < ROW; i++)
		{
			for (int j = 0; j < COL; j++)
			{
				int tp = Integer.parseInt(srcArray[i][j]+"");	
				nSrcArray[i][j] = tp;
			}
		}
	
		zag test = new zag(nSrcArray, ROW, COL, stY-1, stX-1);
		test.killStart();
		
		
		ArrayList<ZagPoint> al = new ArrayList<ZagPoint>();
	}
	
	public zag()
	{		
		this.m_SrcArray = new int[2][2];
		this.m_nRow = 0;
		this.m_nCol = 0;
		this.m_nStartX = 0;
		this.m_nStartY = 0;
		zagStack = new Stack<ZagPoint>();
	}
	
	public zag(int [][]src, int row, int col, int stX, int stY)
	{
		this.m_SrcArray = src;
		this.m_nRow = row;
		this.m_nCol = col;
		this.m_nStartX = stX;
		this.m_nStartY = stY;
		//시작점 설정
		m_SrcArray[stX][stY] = 3;		
		zagStack = new Stack<ZagPoint>();
	}
	
	public void killStart() throws Exception
	{
		ZagPoint tp = null;
		//초기값
		makePrxNode(m_nStartX, m_nStartY, 3);
		//시간계산
		while (zagStack.iterator().hasNext())
		{
			tp = zagStack.pop();
			makePrxNode(tp.getX(), tp.getY(), tp.getWeight());
		}	
		
		//결과 출력
		for (int i = 0; i < m_nRow; i++)
		{
			for (int j = 0; j < m_nCol; j++)
			{	
				if (m_SrcArray[i][j] == 1)
				{
					m_remainSec = m_remainSec + m_SrcArray[i][j];
				}			
				
				//System.out.print(m_SrcArray[i][j] + " ") ;
				//if (j == m_nCol -1)
				//{
				//	System.out.println("") ;
				//}
				
			}
		}		
		m_lastSec = m_lastSec - 1;	
		System.out.println(m_lastSec);
		System.out.println(m_remainSec);		
	}	
	
	//입력된 포인트의 인접 4방향에서 0이 아니고 Marking이 안된(1인) 노드를 찾아 Stack에 PUSH
	public void makePrxNode(int x, int y, int w) throws Exception
	{
		//북쪽
		int x1 = 0;
		int y1 = 0;
		//동쪽
		int x2 = 0;
		int y2 = 0;
		//남쪽
		int x3 = 0;
		int y3 = 0;
		//서쪽
		int x4 = 0;
		int y4 = 0;
		
		x1 = x;
		y1 = y-1;		
		x2 = x+1;
		y2 = y;		
		x3 = x;
		y3 = y+1;		
		x4 = x-1;
		y4 = y;
		
		if (m_lastSec < (w+1))
		{
			m_lastSec = w+1;
		}
		
		if (x1 >= 0 && y1 >= 0 && getWeight(x1, y1) == 1)
		{
			setWeight(x1, y1, w+1);
			zagStack.push(new ZagPoint(x1, y1, w+1));
		}
		
		if (x2 >= 0 && y2 >= 0 && getWeight(x2, y2) == 1)
		{		
			setWeight(x2, y2, w+1);
			zagStack.push(new ZagPoint(x2, y2, w+1));
		}
		
		if (x3 >= 0 && y3 >= 0 && getWeight(x3, y3) == 1)
		{		
			setWeight(x3, y3, w+1);
			zagStack.push(new ZagPoint(x3, y3, w+1));
		}
		
		if (x4 >= 0 && y4 >= 0 && getWeight(x4, y4) == 1)
		{		
			setWeight(x4, y4, w+1);
			zagStack.push(new ZagPoint(x4, y4, w+1));
		}
	}
	
	public int getWeight(int x, int y) throws Exception
	{	
		if (x < 0 || y < 0 || x >= m_nRow || y >= m_nCol)
		{
			return 0;
		}
		
		return Integer.parseInt(m_SrcArray[x][y]+"");
	}
	
	public void setWeight(int x, int y, int w) throws Exception
	{
		if (x < 0 || y < 0 || x > m_nRow || y > m_nCol)
		{
			return;
		}
		
		m_SrcArray[x][y] = w;
	}
}

class ZagPoint
{
	public int m_nX;
	public int m_nY;
	public int m_nWeight;
	
	public ZagPoint()
	{
		m_nX = 0;
		m_nY = 0;
		m_nWeight = 0;
	}
	
	public ZagPoint(int x, int y, int w)
	{
		m_nX = x;
		m_nY = y;
		m_nWeight = w;
	}
	
	public int getX()
	{
		return m_nX;
	}
	
	public void setX(int x)
	{
		m_nX = x;
	}
	
	public int getY()
	{
		return m_nY;
	}
	
	public void setY(int y)
	{
		m_nY = y;
	}
	
	public int getWeight()
	{
		return m_nWeight;	
	}
	
	public void setWeight(int w)
	{
		m_nWeight = w;	
	}
}