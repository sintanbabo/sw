package adv;

import java.lang.reflect.Array;
import java.util.Scanner;

public class zigzag {
	public static void main(String args[]) throws Exception	{
		/* 아래 메소드 호출은 앞으로 표준입력(키보드) 대신 input.txt 파일로 부터 읽어오겠다는 의미의 코드입니다.
		   만약 본인의 PC 에서 테스트 할 때는, 입력값을 input.txt에 저장한 후 이 코드를 첫 부분에 사용하면,
		   표준입력 대신 input.txt 파일로 부터 입력값을 읽어 올 수 있습니다.
		   또한, 본인 PC에서 아래 메소드를 사용하지 않고 표준입력을 사용하여 테스트하셔도 무방합니다.
		   단, Codeground 시스템에서 "제출하기" 할 때에는 반드시 이 메소드를 지우거나 주석(//) 처리 하셔야 합니다. */
		//Scanner sc = new Scanner(new FileInputStream("input.txt"));
        
		Scanner sc = new Scanner(System.in);

		int T;
		int test_case;

		T = sc.nextInt();        
		
		int[][] arr = new int[T][T];

		int lastValue = T * T;
		int value     = 1;
		
		int turnConditionValue = 0;
		for(int w = 1 ; w < T; w++){
			turnConditionValue = turnConditionValue + w;
		}
		
		String turnCondition = "PLUS";
		
		
		String arrow = "A";	
		int x = 0; //x좌표
		int y = 0; //y좌표
		
		for(int z = 0 ; z < lastValue; z++){
			   arr[x][y] = value;
			   //System.out.println("Z : " + z + "++X : " + x + " :: Y : " + y + "::value : " + arr[x][y] + ":: arrow : " + arrow);
			   if(x== T-1 && y== T-1){
				   break;
			   }
			
			   if(z == 0){
				   y = y + 1;
		
			   }else{
				   	if(turnCondition == "PLUS"){
						if(arrow == "A"){
							
							if(y == 0 ){
								arrow = "B";
								x = x + 1;
							}else{
								x = x + 1;
								y = y - 1;
							}
						}else if(arrow == "B"){
							if(x == 0 ){
								arrow = "A";
								y = y + 1;
							}else{
								x = x - 1;
								y = y + 1;
							}
				
						}
				   	}else if(turnCondition == "MINUS"){
						if(arrow == "A"){
							if(x == T - 1 ){
								arrow = "B";
								y = y + 1;
							}else{
								x = x + 1;
								y = y - 1;
							}
						}else if(arrow == "B"){
							if(y == T - 1 ){
								arrow = "A";
								x = x + 1;
							}else{
								x = x - 1;
								y = y + 1;
							}
				
						}
				   		
				   		
				   	}
				   	
				   if(z == turnConditionValue){
					   turnCondition = "MINUS";
				   }
			   }
			   
			   value = value + 1;
			   
			}			
		
		for(int h = 0; h < T; h++){
			
			for(int g = 0; g < T; g++){
				int testValue = arr[g][h];
				System.out.print(testValue + " ");
			}
			System.out.println("");
			
		}
		
	}

	
}
