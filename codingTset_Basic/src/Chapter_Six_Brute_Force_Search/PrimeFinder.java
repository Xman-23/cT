package Chapter_Six_Brute_Force_Search;

import java.util.*;


public class PrimeFinder {

	public static void main(String[] args) {

		PrimeFinderSolution primeFinderSolution = new PrimeFinderSolution();
		int count = primeFinderSolution.primeFinderSolution("17");
		System.out.println(count);
	}

}

class PrimeFinderSolution {

	PrimeFinderSolution() {
		super();
	}
	Set<Integer> set = new HashSet<>();
	boolean[] visited ; //'dfs' 에 사용할 중복방지용 boolean 변수
	//string = "17" => length = 2;
	public int primeFinderSolution(String numbers) {
		visited = new boolean[numbers.length()];
		dfs("",numbers);

		int counter = 0;
		for(int number : set) {
			if(isPrime(number)) {
				counter++;
			}
		}

		return counter;
	}

	public void dfs(String current, String numbers) {
		if(!current.equals("")) {
			set.add(Integer.parseInt(current));
			System.out.println(set);
		}
		for(int i=0; i<numbers.length();i++) {
			//index =0은 무조건 방문한곳이 아니므로, '분기'문을 탄다
			if(!visited[i]) {
				visited[i] = true;
				dfs(current+numbers.charAt(i),numbers);
				visited[i] = false;
			}
		}
	}
	//number = 1,17,7,71
	public boolean isPrime(int number) {
		if(number < 2) {
			return false;
		}

		for(int i=2; i<=Math.sqrt(number); i++) {
			if(number % i == 0) {
				return false;
			}
		}
		return true;
	}
}
