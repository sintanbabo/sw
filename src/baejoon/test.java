package baejoon;

public class test {
	public static void main(String[] args) {
		int temp = 0;
		for(int i=0; i<100000; i++) {
			for(int j=i; j<100000; j++) {
				temp++;
			}
		}
		System.out.println(temp);
	}
}
