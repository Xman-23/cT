package Chapter_Five_Recursive;

public class Recursive {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int n = 2;
		int m = 3;
		int result = 1;
		for(int i=0 ; i<m; i++) {
			result = result * n;
			//0 = 2^1 = result * n (1*2);
			//1 = 2^2 = result * n (2*2);
			//2 = 2^3 = result * n (4*2);
		}
		System.out.println(n);
	}

}
