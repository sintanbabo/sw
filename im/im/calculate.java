package im;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

public class calculate {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Stack<Double> sd = new Stack<Double>();
		List<String> value = new ArrayList<String>();
		Stack<Character> oper = new Stack<Character>();
		String inputValue = sc.next();
		int iLastIndex = 0;
		String temp = "";
		
		// 중위 표기법 ==> 후위 표기법
		total : while(true) {
			char a = inputValue.charAt(iLastIndex);
			if (iLastIndex == (inputValue.length()-1) ) {
				value.add(inputValue.substring(iLastIndex));
				while(true) {
					char b = oper.pop();
					value.add(new Character(b).toString());
					if (oper.empty()) break total;
				}
			}
			
			if (a > '0' && a < '9') {
				temp = temp + a;
				iLastIndex++;
			}
			else {
				if (temp != "") value.add(temp);
				temp = "";

				if (a == '+' || a == '-' || a == '*' || a == '/' || a == '(') {
					oper.push(a);
				}
				else if (a == ')') {
					while (true) {
						char b = oper.pop();
						if (b == '(') break;
						else value.add(new Character(b).toString());
					}
				}
				iLastIndex++;
			}
		}
		System.out.println(value);
		
		// 후위표기법 계산
		Double a=0.0, b=0.0, c=0.0;
		
		for (int i= 0; i<value.size(); i++) {
			String temp1 = value.get(i);
			if ("+".equals(temp1) || "-".equals(temp1) || "*".equals(temp1) || "/".equals(temp1)) {
				b = sd.pop();
				a = sd.pop();
				if ("+".equals(temp1)) c = a + b;
				else if ("-".equals(temp1)) c = a - b;
				else if ("*".equals(temp1)) c = a * b;
				else if ("/".equals(temp1)) c = a / b;
				
				sd.push(c);
			}
			else {
				sd.push(new Double(temp1));
			}
		}
		
		System.out.println(sd.pop());
		System.out.println();
	}
	
	
	/* 1+(2+3-4)+2
	 * 1+2+3+(4+(5+6))-8
	 * (1-3) - (5-6)
	 */

}
