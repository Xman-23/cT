package Chapter_Six_Brute_Force_Search;

import java.util.*;

public class ExpressionMaximizerRecursive {


    public static void main(String[] args) {
    	/*
    		expression 문자열이 "100 - 200 * 300 - 500 + 20"처럼 공백이 포함되어 있습니다.
			이 상태에서 split() 메서드를 통해 " 200" 같은 문자열이 생성되고, 
			이를 Long.parseLong() 하려다 예외가 발생한 것입니다. 
			Long.parseLong()은 숫자 문자열만 처리할 수 있으며 " 200"처럼 공백이 포함되면 오류가 납니다.
    	 */
    	ExpressionMaximizerRecursiveSolution.expression("100-200*300-500+20".replace(" ", ""));
    }
}
//삼성 노트에 작성한 재귀 상황 참조
class ExpressionMaximizerRecursiveSolution {

	ExpressionMaximizerRecursiveSolution() {
		super();
	}

	static char[] opArray = new char[] {'*', '+', '-'};
	static long max = 0;

	public static void expression(String expression) {
		List<Character> opList = new ArrayList<>();
		//100-200*300-500+20
		for(char op : opArray) {
			//연산자가 있는지 String.indexOf != -1 로 체크
			//있으면 연산자의 인덱스 위치를 반환 
			//없으면 '-1'을 반환
			if(expression.indexOf(op) != -1) {
				//연산자가 있다면은 List에 추가(연산자가 *중복* 되어도 '연산자 하나만' 저장)
				opList.add(op);
			}
		}
		//'List'에 연산자를 추가하여 사이즈가 채워졌으면, List.size()를 기반으로 중복방지를 위한, boolean 선언
		boolean[] visited = new boolean[opList.size()];
		//연산자가 들어갈 또 다른 List 생성
		List<Character> orderList = new ArrayList<>();
		//순열을 위한 메소드로 던짐
		permute(opList, visited, orderList,  expression);

		System.out.println(max);

	}

	public static void permute(List<Character> opList, boolean[] visited, List<Character> orderList,String expression) {
		if(opList.size() == orderList.size()) {
			long value = ev(expression,orderList);
			max = Math.max(Math.abs(value), max);
			return; //재귀 종료
		}
		//opList = '+'(0), '-'(1), '*'(2)
		for(int i=0; i< opList.size(); i++) {
			if(!visited[i]) {
				visited[i] = true; //중복방지를 위한 visited;
				orderList.add(opList.get(i));
				permute(opList,visited,orderList,expression);
				orderList.remove(orderList.size()-1); // orderList의 마지막 인덱스(orderList.size()-1)를 'remove'제거;
				visited[i] = false; // 순열을 위해서 마지막 인덱스를 지우고,새로운 부호 추가 ex) (+-*) -> (+*-) 
			}
		}
	}
	public static long ev(String expression, List<Character> orderList) {

		if(orderList == null || orderList.isEmpty()) {
			return Long.parseLong(expression);
		}

		char op = orderList.get(0);
		List<String> stringList = split(expression,op);
		List<Long> result = new ArrayList<>();

		for(String part : stringList) {
			//list => '+', '-', '*';
			//list.subList(1,orderList.size()) => '-', '*';
			result.add(ev(part,orderList.subList(1, orderList.size())));
		}

		long res = result.get(0);

		for(int i=1; i<result.size();i++) {
			res = cal(res,result.get(i),op);
		}
		// 여기서 -6040이 +60400으로 되어서 마지막('+')연산자에서 'cal메소드'에 의히여 20을 더하여 6420
		return res; 
	}

	public static List<String> split(String expression, char op) {
		List<String> list = new ArrayList<>();
		int start = 0;

		for(int i=0; i<expression.length();i++) {
			if(expression.charAt(i) == op) {
				list.add(expression.substring(start,i));//부호 전 까지의 '문자열'을 'list'를 추가 
				start = i+1; //부호 다음 인덱스를 기준으로,substring 하기 위해서, 'i(부호인덱스)+1' 처리 
			}
		}
		list.add(expression.substring(start)); //'for문'에서 부호 인덱스 기준으로 substring 후, 나머지 문자열 'list'추가

		return list;
	}
	public static long cal (long a, long b, char op) {
		if(op == '+') {
			return a+b;
		}
		if(op == '-') {
			return a-b;
		}
		return a*b;
	}
}
