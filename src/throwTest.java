
public class throwTest {

	public static void main(String[] args) throws Exception{
		System.out.println("before");

		if (1 == 1)
			throw new Exception("bb");
		
		System.out.println("after");
	}
}
