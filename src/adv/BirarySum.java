package adv;

import java.util.Scanner;

public class BirarySum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Scanner sc = new Scanner(System.in);
		
		
		String First  = sc.next();
		String Second = sc.next();
		
		String sFirst  = First;
		String sSecond = Second;
		
		int iLength;
		
		if(First.length() > Second.length()){
			for(int i=0; i < First.length()-Second.length(); i++){
				sSecond = "0" + sSecond;
			}
		}else if(Second.length() > First.length()){
			for(int i=0; i < Second.length() - First.length(); i++){
				sFirst = "0" + sFirst;
			}			
		}
		
		String sRetuen = "";
		char[] cFirst  = sFirst.toCharArray();
		char[] cSecond = sSecond.toCharArray();
		
		int  a = 0;
		char b = '0'; //올림을 위한 자리수
		
		
		for(int i=sFirst.length()-1; i >= 0; i--){
			
			//System.out.println("cFirst[i] = " + cFirst[i] + "  cSecond[i] = " + cSecond[i]+ "  b = " + b);
			a = (cFirst[i]-'0') +  (cSecond[i]-'0')  +  (b-'0');
			if(a > 1){
				b = '1';
				if(a == 2)	a = 0;
				else        a = 1;
			}
			else {
				b = '0';
			}
			
			sRetuen = a + sRetuen;
			if(i == 0 && b == '1') sRetuen = b + sRetuen; 
		}
		
		
		
		if(sRetuen.indexOf("1") >= 0)	System.out.println(sRetuen);
		else 							System.out.println("0");
		//System.out.println(sFirst);
		//System.out.println(sSecond);
	}

}
