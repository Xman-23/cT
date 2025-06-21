package middleHigh;

import java.util.*;
import java.time.*;
import java.time.format.*;
import java.lang.*;
import java.math.*;
import java.io.*;

public class CodingTest_23 {
	public static void main (String[] args) {
		String[] logs = {
				"kim,2023-05-20 09:00:00",
			    "lee,2023-05-21 09:00:00",
			    "park,2023-05-20 08:00:00",
			    "kim,2023-06-01 15:00:00",
			    "choi,2023-06-01 15:00:00",
			    "lee,2023-06-01 15:00:00",
			    "han,2022-12-31 23:59:59"
		};
		System.out.println(getMaxCounterUserID(logs));
		System.out.println(getMinCounterUserID(logs));
		System.out.println(getMaxAndMinCounterUserID(logs)[0] + getMaxAndMinCounterUserID(logs)[1]);
		
	}
	
	public static String getMaxCounterUserID(String[] logs) {
	
		if(logs.length == 0 || logs == null) {
			return "-1";
		}
		Map<String,Integer> map = new HashMap<String,Integer>();
		String returnUserID = "";
		Integer minCount = Integer.MIN_VALUE; //-22억 자주 로그인한 사람 찾기 위한 변수				

		for(int i=0; i<logs.length; i++) {
			String[] stringSplit = logs[i].split(",");
			String userID =stringSplit[0];
			
			if(map.containsKey(userID)) {
				map.put(userID, map.get(userID)+1);
			}else {
				map.put(userID, 1);
			}
		}

		System.out.println("Map = " + map);

		for(Map.Entry<String,Integer> entryMap  : map.entrySet()) {
			String userID = entryMap.getKey();
			Integer loginCounter = entryMap.getValue();

			if(loginCounter > minCount) {
				returnUserID = userID;
				minCount = loginCounter;
			}else if(loginCounter==minCount) {
				if(returnUserID.compareTo(userID) > 0) {
					returnUserID= userID;
				}
			}
		}
		return returnUserID;
	}
	
	public static String getMinCounterUserID(String[] logs) {

		if(logs.length == 0 || logs == null) {
			return "-1";
		}

		Map<String,Integer> map = new HashMap<String,Integer>();
		String returnUserID = "";
		Integer maxCounterLogin = Integer.MAX_VALUE; // 22억 가장 접속이 적은 사람 찾기

		for(int i=0; i < logs.length; i++) {
			String[] stringSplit = logs[i].split(",");
			String   userID = stringSplit[0];
	
			if(map.containsKey(userID)) {
				map.put(userID, map.get(userID)+1);
			}else {
				map.put(userID, 1);
			}
		}
		System.out.println("Map = " + map);

		for(Map.Entry<String,Integer> entryMap : map.entrySet()) {
			String userID = entryMap.getKey();
			Integer loginCounter = entryMap.getValue();

			if(loginCounter < maxCounterLogin) {
				maxCounterLogin = loginCounter;
				returnUserID = userID;
			}else if(loginCounter == maxCounterLogin) { // Class 는 isEqual 사용 (클래스 사용) , Integer,Double 은 == 숫자 취급
				if(returnUserID.compareTo(userID)>0) {
					returnUserID = userID;
				}
			}
		}

		return returnUserID;
	}

	public static String[] getMaxAndMinCounterUserID(String[] logs) {

		if(logs.length == 0 || logs == null){
			return null;
		}
		
		Map<String,Integer> map = new HashMap<String,Integer>();
		String returnMaxUserID = "";
		String returnMinUserID = "";
		Integer minLoginCounter = Integer.MIN_VALUE;
		Integer maxLoginCounter = Integer.MAX_VALUE;

		for(int i=0; i<logs.length; i++) {
			String[] stringSplit =  logs[i].split(",");
			String   userID = stringSplit[0];

			if(map.containsKey(userID)) {
				map.put(userID, map.get(userID)+1);
			}else {
				map.put(userID, 1);
			}
		}

		System.out.println("Map = " + map);
		
		for(Map.Entry<String,Integer> entryMap : map.entrySet()) {
			String userID = entryMap.getKey();
			Integer loginCount = entryMap.getValue();
			//가장 접속 많이 한 사람 찾기
			if(loginCount > minLoginCounter) {
				minLoginCounter = loginCount;
				returnMaxUserID = userID;
			}else if(loginCount == minLoginCounter) {
				if(returnMaxUserID.compareTo(userID) > 0) {
					returnMaxUserID = userID;
				}
			}
			//가장 접속이 적은 사람 찾기
			if(loginCount < maxLoginCounter) {
				maxLoginCounter = loginCount;
				returnMinUserID = userID;
			}else if(loginCount == minLoginCounter) {
				if(returnMinUserID.compareTo(userID) > 0) {
					returnMinUserID = userID;
				}
			}
		}
		
		String[] returnArray = {returnMaxUserID, returnMinUserID};
		
		return returnArray;
	}
}
