package adv;

import java.lang.reflect.Array;
import java.util.Scanner;

public class zigzag {
	public static void main(String args[]) throws Exception	{
		/* �Ʒ� �޼ҵ� ȣ���� ������ ǥ���Է�(Ű����) ��� input.txt ���Ϸ� ���� �о���ڴٴ� �ǹ��� �ڵ��Դϴ�.
		   ���� ������ PC ���� �׽�Ʈ �� ����, �Է°��� input.txt�� ������ �� �� �ڵ带 ù �κп� ����ϸ�,
		   ǥ���Է� ��� input.txt ���Ϸ� ���� �Է°��� �о� �� �� �ֽ��ϴ�.
		   ����, ���� PC���� �Ʒ� �޼ҵ带 ������� �ʰ� ǥ���Է��� ����Ͽ� �׽�Ʈ�ϼŵ� �����մϴ�.
		   ��, Codeground �ý��ۿ��� "�����ϱ�" �� ������ �ݵ�� �� �޼ҵ带 ����ų� �ּ�(//) ó�� �ϼž� �մϴ�. */
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
		int x = 0; //x��ǥ
		int y = 0; //y��ǥ
		
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
