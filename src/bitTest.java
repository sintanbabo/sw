
public class bitTest {
	public static void main(String[] args) {
		int pos = 5;
		int a = 0;
		String s = "";

		for (int i = 0; i < Integer.numberOfLeadingZeros(pos); i++) s += "0";
		s += Integer.toBinaryString(pos);
		System.out.println(s);
		System.out.println(Integer.toBinaryString(-pos));

        a = pos & -pos;
        pos = pos + a;

        System.out.println(a);
        System.out.println(pos);
	}
}
