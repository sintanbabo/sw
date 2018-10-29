package adv;

public class fivebit1 {

	public static void main(String[] args) {
		int AnswerN=0, Answer2 = 0;
		
		for (int i = 30; i <= 1000000000; i++) {

			if (Integer.bitCount(i) == 5) {
				if (Answer2 == 0) {
					Answer2 = i;
				}

				AnswerN += i;

				System.out.println(Integer.lowestOneBit(i));
				i = i + Integer.lowestOneBit(i) - 1;
				// int middle = i & -i;
				// i = i + middle -1; //Integer.lowestOneBit(i) 와 결과 동일함.

			}
		}

	}

}
