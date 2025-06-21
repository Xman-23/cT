package codingTest0426;

import java.util.*;
import java.time.*;
import java.time.format.*;
import java.math.*;
import java.lang.*;
import java.io.*;

public class CodingTest_21 {
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
		String[] returnValue = CodingTest_21.getValue(logs);
		String stringOne = returnValue[0];
		String stringTwo = returnValue[1];
		
		System.out.println("가장 오래 접속한 사람 =" + stringOne);
		System.out.println("가장 최근 접속한 사람 =" + stringTwo);
		
	}

	public static String[] getValue(String[] logs) {

		String returnValue_One = "";
		String returnValue_Two = "";
		LocalDateTime minLog = LocalDateTime.MIN; //1999-12-31 첫비교 와 가장 최근 로그인한 사람 
		LocalDateTime maxLog = LocalDateTime.MAX; //1999-12-31 가장 오래 접속되어있는 사람.
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
		
		Set<Map.Entry<String, LocalDateTime>> entrySet = map.entrySet();
		Map.Entry<String, LocalDateTime> entry = entrySet.iterator().next();
		System.out.println("entry = " + entry);
		
		for(Map.Entry<String, LocalDateTime> entryMap : map.entrySet()) {
			String userID= entryMap.getKey(); // userID
			LocalDateTime logTimeCompare = entryMap.getValue(); // logTime
			//가장 최근에 접속한 사람 찾기
			if(logTimeCompare.isAfter(minLog)) {
				returnValue_One = userID;
				minLog = logTimeCompare;
			}else if(logTimeCompare.isEqual(minLog)) {
				if(returnValue_One.compareTo(userID) > 0) {
					returnValue_One =userID;
				}
			}
			//가장 오래 접속한 사람 찾기
			if(logTimeCompare.isBefore(maxLog)) {
				returnValue_Two = userID;
				maxLog = logTimeCompare;
			}else if(logTimeCompare.isEqual(maxLog)) {
				if(returnValue_Two.compareTo(userID) > 0) {
					returnValue_Two = userID;
				}
			}
		}

		String[] returnValue = {returnValue_One, returnValue_Two};
		
		return returnValue;
	}
}
