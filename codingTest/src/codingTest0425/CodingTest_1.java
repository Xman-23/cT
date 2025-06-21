package codingTest0425;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;
import java.util.Date;

import javax.swing.text.DateFormatter;

public class CodingTest_1 {
/*	문제 설명
	한 시스템에 사용자들이 접속한 기록이 배열
    각 기록은 userId, timestamp 형의 문자열 (String변수 2개 선언)
    Timestamp는 ''YYYY-MM-DD HH:MM:SS" LocalTime 사용
 */
	public static void main(String args[]) {
		//시스템에 사용자들이 접속한 기록의 배열
		String[] logs = {
				"kim 2024-09-01 12:15:22",
				"lee 2024-09-01 13:20:33",
				"park 2024-09-01 11:00:45",
				"lee 2024-09-01 14:10:05",
		};
		String userId = getUserID(logs);
		System.out.println(userId);
	}
	
	public static String getUserID(String[] parameter) {
		System.out.println("메서드 도입부, " + Arrays.toString(parameter));
		String latestuserId = "";
		LocalDateTime localDateTime = LocalDateTime.MIN; //LocalDateTime 초기화

		for(int i=0; i<parameter.length; i++) {
			String[] parmeterSplit = parameter[i].split(" ");
			System.out.println("parameterSplit,"+ Arrays.toString(parmeterSplit));
			String userId = parmeterSplit[0];
			String timeStamp = parmeterSplit[1]+" " + parmeterSplit[2];
			System.out.println("timeStamp, [" +i +"], "+ timeStamp);
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime logTime = LocalDateTime.parse(timeStamp, dateTimeFormatter);
			System.out.println("logTime, " + logTime);
			
			//만약 log타임이 localDatetime 보다 이후에 접속했다면
			if(logTime.isAfter(localDateTime) ) {
				localDateTime = logTime;
				latestuserId = userId;
			}

		}
		return latestuserId;
	}
}
