package im;

public class test {
	public static void main(String[] args) {
		//long start = System.currentTimeMillis();
		long temp = 0L;
		
		for(int k=0; k<40; k++) {
			for(int i=0; i<300; i++) {
				for(int j=0; j<26; j++) {
					temp++;
				}	
			}
		}
		//long end = System.currentTimeMillis();
		//System.out.println("time : " + (end-start)/1000);
	}
}
