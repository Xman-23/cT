package codingTest0425;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;

public class CodingTest_2 {
	public static void main(String[] args) {
		String[] logs = {
				"user1 2025-04-24 09:15:30",
				"user2 2025-04-24 09:16:10",
				"user1 2025-04-25 10:20:30"
		};
		
		String userId = CodingTest_2.getUserId(logs);
		System.out.println(userId);
	}
	
	public static String getUserId(String[] parameter) {
		System.out.println("메서드 도입부 " + Arrays.toString(parameter));
		String userId_One = ""; //"" 공백으로 초기화
		LocalDateTime localDateTime = LocalDateTime.MIN; //최소의 시간으로 초기화
		
		for(int i=0; i< parameter.length; i++) {
			String[] parmeterSplite = parameter[i].split(" "); //배열을 공백 기준으로 분할하여 배열로 반환
			System.out.println("parmeterSplite," + Arrays.toString(parmeterSplite));
			System.out.println("parmeterSpliteLength," + parameter.length);
			String userId_Two = parmeterSplite[0];
			String stringTime = parmeterSplite[1] + " " + parmeterSplite[2];
	
			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime logTime = LocalDateTime.parse(stringTime, dateTimeFormatter);
			
			System.out.println("logTime ["+ i + "]" + logTime );
			//localDateTime 보다 이후에 로그인한것을 체크하는 분기문
			if(logTime.isAfter(localDateTime)) {
				localDateTime = logTime;
				userId_One = userId_Two;
			}
		};
		System.out.println(userId_One);
		return userId_One;
	}
}
