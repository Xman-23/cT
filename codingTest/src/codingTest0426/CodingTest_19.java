package codingTest0426;

import java.util.*; 
import java.lang.*;
import java.time.*;
import java.time.format.*;
import java.math.*;
import java.io.*;



public class CodingTest_19 {
	public static void main(String[] args) {
		String[] stringArray = {
	            "kim,2023-05-20 09:00:00",
	            "lee,2023-05-21 09:00:00",
	            "park,2023-05-20 09:00:00",
	            "choi,2023-05-22 10:30:00",
	            "kim,2024-04-20 10:00:00"
		};
		System.out.println(getUserID(stringArray));
	}

	public static String getUserID(String[] stringArray) {

		System.out.println("getUserID 메서드 도입부 = " + Arrays.toString(stringArray));

		String returnUserID = "";
		Map<String,LocalDateTime> map = new HashMap<String,LocalDateTime>();
		LocalDateTime localDateTime = LocalDateTime.MAX; // 2999-12-31 처음 비교
		DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		 

		for(int i=0; i<stringArray.length;i++) {
			String[] stringSplit = stringArray[i].split(",");
			String userID = stringSplit[0];
			String logTime = stringSplit[1];
			LocalDateTime localDateTimeFormat = LocalDateTime.parse(logTime, dateTimeFormatter);

			if(map.containsKey(userID)) {
				if(localDateTimeFormat.isAfter(map.get(userID))) {
					map.put(userID, localDateTimeFormat);
				}
			}else {
				map.put(userID, localDateTimeFormat);
			}

		}

		System.out.println("map = " + map);

		Set<String> set = map.keySet();
		Iterator<String> iterator = set.iterator();

		while(iterator.hasNext()) {
			String userID = iterator.next();
			LocalDateTime logTime_One = map.get(userID);

			if(logTime_One.isBefore(localDateTime)) {
				returnUserID= userID;
				localDateTime = logTime_One;
			}else if(logTime_One.isEqual(localDateTime)) {
				if(returnUserID.compareTo(userID) > 0) {
					returnUserID = userID;
				}
			}
		}
		System.out.println("returnUserID = " +  returnUserID);
		return returnUserID;
	}
}
