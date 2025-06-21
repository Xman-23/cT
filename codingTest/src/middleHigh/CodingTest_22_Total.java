package middleHigh;

import java.util.*;
import java.lang.*;
import java.io.*;
import java.time.*;
import java.time.format.*;
import java.math.*;

public class CodingTest_22_Total {
	public static void main(String[] args) {
		String[] logs = {
				"kim,2023-05-20 09:00:00",
			    "lee,2023-05-21 09:00:00",
			    "park,2023-05-20 08:00:00",
			    "kim,2023-06-01 15:00:00",
			    "choi,2023-06-01 15:00:00",
			    "lee,2023-06-01 15:00:00",
			    "han,2022-12-31 23:59:59"
		};

		int[] numbers1 = {3, 1, 2, 5, 2, 1}; // 123
		int[] numbers2 = {7, 7, 7};
		int[] numbers3 = {0, -1, -3, 2, 2};

		String[] returnValue = Method.getLatestAndOldUserID(logs);
		System.out.println("가장 최근에 접속한 사람 =" + returnValue[0]);
		System.out.println("가장 오래 접속한 사람 =" + returnValue[1]);
		System.out.println("가장 최근에 접속한 사람 = " + Method.getLatestUserID(logs));
		System.out.println("가장 오래 접속한 사람 =" + Method.getOldUserID(logs));
		System.out.println("세번쨰 큰 정수 찾기  = " + Method.getThreeMaxValueTreeSet(numbers1,3));
		System.out.println("세번째 작은 정수 찾기 = " + Method.getThreeMinValueTreeSet(numbers1,2));
	}
}

class Method {
	
	Method() {
		super();
	}
	//k번째로 큰 정수를 찾으시오
	public static int getThreeMaxValueTreeSet(int[] numbers,int k) {
		//배열 Validation
		if(numbers.length == 0 || numbers == null) {
			return -1;
		}

		Set<Integer> set = new TreeSet<Integer>();
		int returnNumber = 0;
		for(int i=0; i<numbers.length; i++) {
			int num = numbers[i];
			//양수만 비교
			if(num > 0) {
				set.add(num);
			}
		}
		//set의 사이즈가 'k'보다 작을경우 k번째 자리의 값을 가져올 수 가 없다.
		if(set.size() < k) {
			return -1;
		//적어도 set의 사이즈가 'k'와 같을경우에는 k번째 자리의 가져올 수 있음
		}else if(set.size() >=k) {
			Iterator<Integer> iterator = set.iterator();
			//k번째 자리까지 오기 위해 'i<k'를 조건문으로 명시 왜 ?? k가 3이면 컴퓨터 인덱스는 0부터 시작하여 2까지 오기때문
			for(int i=0; i<k; i++) {
				//k번째 자리 바로 앞까지 iterator.next() 메서드를 사용하여 인덱스 이동
				if(i<k-1) {
					iterator.next();
				//i가 k보다 작은 즉 k번째자리(index = k-1) 까지 왔을경우에, iterator.next()를 사용하여 그 자리의 값을 returnNumber(반환값)에 대입
				}else if(i<k) {
					returnNumber = iterator.next();
				}
			}	
		}

		return returnNumber;
	}
	//k번째 작은 정수 찾기
	public static int getThreeMinValueTreeSet(int[] numbers,int k) {
		
		if(numbers.length == 0 || numbers == null) {
			return -1;
		}

		Set<Integer> set = new TreeSet<Integer>(Comparator.reverseOrder());
		int returnNumber = 0;

		for(int num : numbers) {
			if(num > 0) {
				set.add(num);
			}
		}
		//set의 사이즈가 'k'보다 작은경우 k(index=k-1)자리의 작은 정수를 가져올 수 없다
		if(set.size() < k) {
			return -1;
		//적어도 set의 사이즈가 k와 같으면 k(index=k-1)자리의 작은정수를 가져올 수 있음
		}else if(set.size() >= k) {
			Iterator<Integer> iterator = set.iterator();
			//k번째 자리까지 오기 위해 'i<k'를 조건문으로 명시 왜 ?? k가 3이면 컴퓨터 인덱스는 0부터 시작하여 2까지 오기때문
			for(int i=0; i<k;i++) {
				//k번째 자리 바로 앞까지 next를 돌림
				if(i<k-1) {
					iterator.next();
					//k번째 자리의 값을 return값에 담음
				}else if(i<k) {
					returnNumber = iterator.next();
				}
			}
		}

		return returnNumber;
	}
	
	public static String getLatestUserID(String[] logs) {

		if(logs.length == 0 || logs == null) {
			return "-1";
		}

		Map<String,LocalDateTime> map = new HashMap<String,LocalDateTime>();
		LocalDateTime minLogTime = LocalDateTime.MIN; // 1999-01-01;
		String returnID = "";

		for(int i=0; i<logs.length; i++) {
			String[] stringSplit = logs[i].split(",");
			String userID = stringSplit[0];
			String stringLogTime = stringSplit[1];
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
	
			LocalDateTime logTime = LocalDateTime.parse(stringLogTime,dateTimeFormatter);

			if(map.containsKey(userID)) {
				if(logTime.isAfter(map.get(userID))) {
					map.put(userID, logTime);
				}
			}else {
				map.put(userID, logTime);
			}
		}

		System.out.println("Map =" + map);

		for(Map.Entry<String,LocalDateTime> entryMap : map.entrySet())
		{
			String userID = entryMap.getKey();
			LocalDateTime logTime = entryMap.getValue();

			if(logTime.isAfter(minLogTime)) {
				minLogTime = logTime;
				returnID = userID;
			}else if(logTime.isEqual(minLogTime)) {
				if(returnID.compareTo(userID) > 0) {
					returnID = userID;
				}
			}
		}

		return returnID;
	}
	
	public static String getOldUserID(String[] logs) {

		if(logs.length == 0 || logs == null) {
			return "-1";
		}

		String returnValue = "";
		Map<String,LocalDateTime> map = new HashMap<String,LocalDateTime>();
		LocalDateTime maxLogTime = LocalDateTime.MAX; //2999-12-31 보다 오래접속

		for(int i=0; i<logs.length; i++) {
			String[] stringSplit = logs[i].split(",");
			String userID = stringSplit[0];
			String stringLogTime = stringSplit[1];
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime logTime = LocalDateTime.parse(stringLogTime,dateTimeFormatter);

			if(map.containsKey(userID)) {
				if(logTime.isAfter(map.get(userID))) {
					map.put(userID, logTime);
				}
			}else {
				//무조건 0번째 인덱스는 map에 put을 실시
				map.put(userID, logTime);
			}
		}

		if(map.size()>0) {
			System.out.println("Map 유효값 체크 = " +  map);

			for(Map.Entry<String,LocalDateTime> entryMap : map.entrySet()) {
				String userID = entryMap.getKey();
				LocalDateTime logTime = entryMap.getValue();
	
				if(logTime.isBefore(maxLogTime)) {
					maxLogTime = logTime;
					returnValue = userID;
				}else if(logTime.isEqual(maxLogTime)) {
					if(returnValue.compareTo(userID) > 0) {
						returnValue = userID;
					}
				}
			}
		}

		return returnValue;
	}
	
	public static String[] getLatestAndOldUserID(String[] logs) {

		System.out.println("값이 잘 오나요?? = " + Arrays.toString(logs));
		Map<String,LocalDateTime> map = new HashMap<String,LocalDateTime>();
		LocalDateTime maxLogTime = LocalDateTime.MAX; // 2999-12-31 , 가장 오래 접속되어 있는 사람 찾기
		LocalDateTime minLogTime = LocalDateTime.MIN; // 1980-01-31 가장 최근에 접속한 사람 찾기
		String oldUserID = ""; // 오래 접속
		String latestUserID = ""; // 최근 접속

		for(int i=0; i<logs.length; i++) {
			String[] stringSplit = logs[i].split(",");
			String userID = stringSplit[0];
			String stringLogTime = stringSplit[1];
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime logTime = LocalDateTime.parse(stringLogTime,dateTimeFormatter);

			if(map.containsKey(userID) ) {
				if(logTime.isAfter(map.get(userID))) {
					map.put(userID, logTime);
				}
			}else {
				map.put(userID, logTime);
			}
		}

		if(map.size() > 0) {
			for(Map.Entry<String,LocalDateTime> entryMap : map.entrySet() ) {
				String userID = entryMap.getKey();
				LocalDateTime logTime = entryMap.getValue();
				//가장 최근에 접속한 사람 찾기
				if(logTime.isAfter(minLogTime)) {
					minLogTime = logTime;
					latestUserID = userID;
				}else if(logTime.isEqual(minLogTime)) {
					if(latestUserID.compareTo(userID) > 0) {
						latestUserID = userID;
					}
				}
				//가장 오래 접속한 사람 찾기
				if(logTime.isBefore(maxLogTime )) {
					maxLogTime = logTime;
					oldUserID = userID;
				}else if(logTime.isEqual(maxLogTime)) {
					if(oldUserID.compareTo(userID) > 0) {
						oldUserID = userID;
					}
				}
			}
		}
		return new String[] {latestUserID, oldUserID};
	}
}
