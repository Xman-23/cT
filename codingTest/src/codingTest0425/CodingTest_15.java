package codingTest0425;

import java.time.*;
import java.time.format.*;
import java.util.*;

public class CodingTest_15 {
	public static void main(String[] args) {
		String[] logs = {
			    "kim,2024-04-25 09:30:00",
			    "lee,2024-04-25 09:35:00",
			    "park,2024-04-25 09:30:00",
			    "choi,2024-04-25 09:20:20"
		};

		System.out.println(getUserID(logs));
	}

	public static String getUserID(String[] logs) {

		if(logs.length < 2) {
			return ""+-1;
		}

		LocalDateTime localDateTime = LocalDateTime.MAX;
		String returnUserID = "";

		for(int i=0; i<logs.length; i++) {
			String[] stringArray = logs[i].split(",");
			String userID = stringArray[0];
			String logDateTime = stringArray[1];
			
			DateTimeFormatter dateTimeFormatter =  DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime localDateTimeCompare = LocalDateTime.parse(logDateTime,dateTimeFormatter);

			if(localDateTimeCompare.isBefore(localDateTime)) {
				localDateTime = localDateTimeCompare;
				returnUserID = userID;
			}else if(localDateTimeCompare.isEqual(localDateTime)) {
				if(returnUserID.compareTo(userID) > 0) {
					returnUserID = userID;
				}
			}
		}

		return returnUserID;
	}
}
