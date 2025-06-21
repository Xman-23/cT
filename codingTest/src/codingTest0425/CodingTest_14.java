package codingTest0425;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CodingTest_14 {
	public static void main(String[] args) {
		String[] logs = {
				"kim,2024-04-25 09:30:00",
				"lee,2024-04-25 09:35:00",
				"park,2024-04-25 09:35:00",
				"choi,2024-04-25 09:20:20"
		};
		System.out.println(getUserID(logs));
	}

	public static String getUserID(String[] logs) {

		if(logs.length<0) {
			return ""+1;
		}


		String returnUserID = "";
		LocalDateTime localDateTime = LocalDateTime.MIN;


		for(int i=0; i<logs.length; i++) {
			String[] stringArrayOne = logs[i].split(",");
			String userID = stringArrayOne[0];
			String logTime = stringArrayOne[1];

			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime logTimeFormat = LocalDateTime.parse(logTime,dateTimeFormatter);
	
			if(logTimeFormat.isAfter(localDateTime)) {
				localDateTime = logTimeFormat;
				returnUserID = userID;
			}else if(logTimeFormat.isEqual(logTimeFormat)) {
				if(returnUserID.compareTo(userID) >0) {
					returnUserID = userID;
				}
			}
		}

		return returnUserID;
	}
}
