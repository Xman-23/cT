package codingTest0426;

import java.util.*;
import java.time.*;
import java.time.format.*;
import java.math.*;
import java.lang.*;
import java.io.*;

public class CodingTest_20 {
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
		String[] returnValue = CodingTest_20.getValue(logs);
		String stringOne = returnValue[0];
		String stringTwo = returnValue[1];
		
		System.out.println("가장 오래 접속한 사람" + stringOne);
		System.out.println("가장 최근 접속한 사람" + stringTwo);
		
	}

	public static String[] getValue(String[] logs) {

		String returnValue_One = "";
		String returnValue_Two = "";
		LocalDateTime minLog = LocalDateTime.MAX; //2999-12-31 첫비교 와 저장을 위한 변수
		LocalDateTime maxLog = LocalDateTime.MIN; //1999-12-31
		Map<String,LocalDateTime> map = new HashMap<String,LocalDateTime>();
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");

		for(int i=0; i<logs.length; i++) {
			String[] stringSplit = logs[i].split(",");
			String userID = stringSplit[0];
			String stringLogTime = stringSplit[1];
			LocalDateTime logTime = LocalDateTime.parse(stringLogTime,dateTimeFormatter);

			if(map.containsKey(userID)) {
				if(logTime.isAfter(map.get(userID))) {
					map.put(userID, logTime);
				}
			}else {
				map.put(userID, logTime);
			}
		}

		System.out.println("map = " + map);

		Set<String> set = map.keySet(); //map 의 키 값을 Set 클래스로 반환 key = userID
		Iterator<String> iterator = set.iterator();

		for(String userID : map.keySet()) {
			String returnuserID = userID;
			LocalDateTime logTime = map.get(returnuserID);
	
			if(logTime.isBefore(minLog)) {
				returnValue_One = returnuserID;
				minLog = logTime;
			}
			if(logTime.isAfter(maxLog)) {
				returnValue_Two = returnuserID;
				minLog = logTime;
			}

		}
		
		for(String userID : map.keySet()) {
			System.out.println("여기 들어오나요??");
			String returnuserID = userID;
			System.out.println(returnuserID);
			LocalDateTime logTime = map.get(returnuserID);
			System.out.println(logTime);
			if(logTime.isAfter(maxLog)) {
				returnValue_Two = returnuserID;
				minLog = logTime;
			}

		}

		System.out.println("returnValue_One = " + returnValue_One);
		System.out.println("returnValue_Two = " + returnValue_Two);
		String[] returnValue = {returnValue_One, returnValue_Two};
		
		return returnValue;
	}
}
