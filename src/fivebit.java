import java.util.Scanner;

/*
4 
40 60 
999 1000 
10000 10000 
2XXXXXX 2XXXXXXXX

(���)
#1 161 47 
#2 0 0 
#3 10000 10000 
#4 0 0
 */
public class fivebit {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int min=0, max=0, result=0, onecount=0, temp=0, index=0;
		char minStringarray[];
		String minString="0", oneString="0";
		
		
		for (int t = 1; t <= T; t++) {
			// ���� �ʱ�ȭ
			result = 0;
			onecount = 0;
			
			try {
				
				
				// �ּ� �ִ밪 ����
				min = sc.nextInt();
				max = sc.nextInt();			
			
				temp = min;
				
				while( onecount != 5) {
					onecount = 0;

					// �ּҰ��� 2������ ��ȯ�Ͽ� �迭�� ����
					minString = Integer.toBinaryString(temp);

					// 1�� ������ Ȯ��
					for(int i=0; i<minString.length(); i++) {
						if (minString.charAt(i) == '1') onecount++;
					}
					
					temp = temp + 1;
				}
				
				oneString = minString;
				
				if (Integer.parseInt(minString,2) < max) {
				
					// ��� ����
					while (Integer.parseInt(oneString, 2) < max) {
						
						// ���� ���� ����� ����
						temp = Integer.parseInt(oneString,2);
						result += temp;
						
						// �ڸ����� ���ڸ� �� �þ�� �ϴ��� Ȯ��
						if ("11111".equals(oneString.substring(0, 5))) {
							temp = (int) Math.pow(2, oneString.length()) + 15;
							oneString = Integer.toBinaryString(temp);
						}
						else {
							// ������ 0�� �ڸ��� Ȯ��
							index = oneString.length() - oneString.lastIndexOf('0') - 1;
							if (index == 1) {}
							temp += (int) Math.pow(2, index-1);
							oneString = Integer.toBinaryString(temp);
						}
					}
				}
				
				else if (Integer.parseInt(minString,2) == max) {
					result = Integer.parseInt(minString,2);
				}
				
				else if (Integer.parseInt(minString,2) > max) {
					result = 0;
					minString = "0";
				}
				
			}
			catch(Exception e) {
				minString = "0";
				result = 0;
			}
			
			System.out.println("#" + t + " " + result + " " + Integer.parseInt(minString,2));
		}
	}

}
