package chapter_Four_String;

public class TernaryReversal {

	public static void main(String[] args) {
		System.out.println(TernaryReversalSolution.ternaryReversalSolution(45));
	}

}
class TernaryReversalSolution {
	TernaryReversalSolution() {
		super();
	}

	public static Integer ternaryReversalSolution(int s) {
		String string = Integer.toString(s,3);
		String sb = new StringBuilder(string).reverse().toString();
		Integer integer = Integer.valueOf(sb);

		return integer;
	}
}
