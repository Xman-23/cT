package codingTest0425;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class CodingTest_13 {
	public static void main(String[] args) {
		//2차원 배열 선언
		String[][] stringArray = {
				{"kim", "2024-04-25 09:30:00"},
				{"lee", "2024-04-25 09:35:00"},
				{"park", "2024-04-25 09:35:00"},
				{"choi", "2024-04-25 09:20:20"}
		};
		String resultUserID = CodingTest_13.getUserId(stringArray);
		System.out.println(resultUserID);
	}
	public static String getUserId(String[][] stringArray) {

		if(stringArray.length<0) {
			return ""+-1;
		}

		LocalDateTime localDateTime = LocalDateTime.MIN; // LocalDateTime 초기화
		String returnUserID = "";

		for(int i=0; i<stringArray.length;i++) {
			System.out.println("["+i+"]"+"번째행 1차원 배열 도입");
			for(int j=0; j<stringArray[i].length; j++) {
				System.out.println("["+i+"]"+"["+j+"]"+"번째열 2차원 배열 도입");
				String userID = stringArray[i][0];
				String logDateTime = stringArray[i][1];
				System.out.println("userID =" + userID + ", logDateTime = " + logDateTime);
		
				DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss"); 
				LocalDateTime logTime = LocalDateTime.parse(logDateTime, dateTimeFormatter);

				System.out.println("dateFormat = " + logTime);

				if(logTime.isAfter(localDateTime)) {
					returnUserID = userID;
					localDateTime = logTime;

					System.out.println("returnUserID = " + returnUserID);
				}else if (logTime.isEqual(localDateTime)) {
					if(returnUserID.compareTo(userID) > 0) {
						returnUserID = userID;
					}
				}
			}
		}
		System.out.println("returnUserID = " + returnUserID);
		return returnUserID;
	}
}
