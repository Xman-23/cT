package chapter_Two_time_comPlexity;

public class O_N {


	O_N(){
		super();
	}

	public static void main(String[] args) {

	}

	public static boolean oN(int[] arr, int target) {


		for(int i=0; i<arr.length;i++) {
			int number = arr[i];
			if(number == target) {
				return true;
			}
		}

		return false;
	}
	
}
