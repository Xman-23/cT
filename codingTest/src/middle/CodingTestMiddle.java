package middle;

import java.util.*;

public class CodingTestMiddle {
	public static void main(String[] args) {
		//Ct0512.numberCounter();
		//Ct0512.stringReverse();
		//Ct0512.maxNumberAndminNumber();
		//Ct0512.evenAndodd();
		//Ct0512.englishCounter();
		//Ct0512.arrayLeftRightSum();
		Ct0512.isPrime();
	}	
}

class Ct0512 {

	Ct0512() {
		super();
	}

	public static void numberCounter() {

		Scanner scanner = new Scanner(System.in);

		int arrayLength = scanner.nextInt();
		int[] intArray = new int[arrayLength];
		Map<Integer,Integer> map = new HashMap<Integer, Integer>();
		for(int i=0; i<intArray.length; i++) {
			int number =scanner.nextInt();

			if(map.containsKey(number)) {
				map.put(number, map.get(number)+1);
			}else {
				map.put(number, 1);
			}
		}
		//Set<Map.Entry<>>
		for(Map.Entry<Integer,Integer> entrySet : map.entrySet()) {
			int mapNumber = entrySet.getKey();
			int mapCounter = entrySet.getValue();
			System.out.println(mapNumber+": "+ mapCounter);
		}
	}

	public static void stringReverse() {

		Scanner scanner = new Scanner(System.in);

		//String string = new StringBuilder(scanner.nextLine()).reverse().toString();
		String string = scanner.nextLine();
		String returnString = "";
		//Hello : length 5
		// i = 5-1
		for(int i=string.length()-1 ; i>=0;i--) {
			Character ch =  string.charAt(i);
			returnString = returnString + ch; 
		}

		System.out.println(returnString);

	}

	public static void maxNumberAndminNumber() {

		Scanner scanner = new Scanner(System.in);
		Set<Integer> maxSet = new TreeSet<Integer>(Comparator.reverseOrder());
		Set<Integer> minSet = new TreeSet<Integer>();
		int[] intArrayLength = new int[scanner.nextInt()];
		int returnMaxNumber = 0;
		int returnMinNumber = 0;

		for(int i=0; i<intArrayLength.length;i++) {
			intArrayLength[i] = scanner.nextInt();
			maxSet.add(intArrayLength[i]);
			minSet.add(intArrayLength[i]);
		}

		Iterator<Integer> maxIterator = maxSet.iterator();
		Iterator<Integer> minIterator = minSet.iterator();

		returnMaxNumber = maxIterator.next();
		returnMinNumber = minIterator.next();

		System.out.println("Min: "+returnMinNumber);
		System.out.println("Max: "+returnMaxNumber);

	}

	public static void evenAndodd() {

		Scanner scanner = new Scanner(System.in);

		int length = scanner.nextInt();
		int returnEvenCounter = 0;
		int returnOddCounter = 0;
		for(int i=0; i<length;i++) {
			int number = scanner.nextInt();

			if(number <=0) {
				continue;
			}else if(number == 1) {
				returnOddCounter++;
			}else if(number >= 2) {
				if(number % 2 == 0) {
					returnEvenCounter ++;
				}else {
					returnOddCounter++;
				}
			}

		}
		System.out.println("Even: " + returnEvenCounter );
		System.out.println("Odd: " + returnOddCounter );
	}

	public static void englishCounter() {

		Scanner scanner = new Scanner(System.in);

		Map<Character,Integer> map = new HashMap<Character,Integer>();
		String string = scanner.nextLine();

		for(int i=0; i<string.length();i++) {
			char ch = string.charAt(i);

			if(map.containsKey(ch)) {
				map.put(ch, map.get(ch)+1);
			}else {
				map.put(ch, 1);
			}
		}
		for(Map.Entry<Character, Integer> entryMap : map.entrySet()) {
			char returnChar = entryMap.getKey();
			int returnInt =  entryMap.getValue();
	
			System.out.println(returnChar + ": "+returnInt);
		}
	}

	public static void arrayLeftRightSum() {

		Scanner scanner = new Scanner(System.in);

		int[] intArray = new int[scanner.nextInt()];

		for(int i=0; i<intArray.length;i++) {
			intArray[i] = scanner.nextInt();
		}
		
		int leftStart = scanner.nextInt()-1;
		int rightEnd = scanner.nextInt();
		int returnNumber = 0;
		//1,2,3,4,5
		//1,2,3,4,5(사람 기준 순서)
		//2,4 = 사람 기준으로 입력(input)
		//0,1,2,3,4(컴퓨터 기준 순서)
		for(int i = leftStart ; i<rightEnd; i++) {
			returnNumber = returnNumber + intArray[i];
		}
		System.out.println(returnNumber);
	}

	public static void isPrime() {

		Scanner scanner = new Scanner(System.in);

		int length = scanner.nextInt();
		int returnIsPrimeCounter = 0;

		for(int i=0; i<length; i++) {
			boolean isPrime = true; // <-- 이거 개 중요 초기화 안하면은 정확한 답을 가져올 수 없음
										 //그렇기에 for문을 순회할때 꼭 isPrime 을 true로 초기화.
			int num = scanner.nextInt();
			if(num < 2 ) {
				continue;
			}else {
				for(int j=2; j<=Math.sqrt(num); j++) {
					if(num % j == 0) {
						isPrime = false;
						//만약 나눠진 나머지의 값이 0이라면
						//1과 자신을 이외에 다른 숫자로 나눠질 수 있기에 소수가 아니다
						//그러므로 break를 사용한다
						break;
					}
					//이것은 사용할 수 없음 왜? 만약 2,3,4가 오면은 Counter 가 2이지만
					//만약 순서가 바뀌어서 2,4,3이 오면은 마지막 3은 2중 for문을 돌지 않기때문에
					//Counter가 1이 되는 결과가 나오므로 원하는 답이 나올 수 가 없음.
					/*else {
						isPrime = true;
					}*/
				}//2중 For문 탈출(J)
			}//else 문 탈출
			if(isPrime) {
				returnIsPrimeCounter++;
			}//if문 탈출
		}//1중 For문 탈출(I)
	}
}
