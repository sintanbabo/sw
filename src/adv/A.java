package adv;

public class A {

	static int i=0;
	
	static void A() {
		System.out.println(i); 
		if (i==100000000) {
			return;
		}
		i = i+1;
		A();
		System.out.println("end : " + i);
	}
	public static void main(String[] args) {
		A();
		System.out.println(i); 
	}
}