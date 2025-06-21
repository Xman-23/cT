package codingTest0425;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Arrays;


public class CodingTest_3 {
	public static void main(String[] args) {
		String[] logs = {
			    "user1 2025-04-24 09:15:30",
			    "user2 2025-04-24 09:16:10",
			    "user1 2025-04-25 10:20:30",
			    "user3 2025-04-25 10:20:30",  // 동일한 시각
			    "user4 2025-04-24 09:17:00"
		};
		String userId = CodingTest_3.getUserId(logs);
		System.out.println(userId);
		System.out.println(Integer.MAX_VALUE);
	}

	public static String getUserId(String[] logs){
		System.out.println("메서드 도입부 " + Arrays.toString(logs));
		String userId_One = ""; // userId_One 초기화
		LocalDateTime localDateTime  = LocalDateTime.MIN;
		
		for(int i=0; i<logs.length; i++) {
			String[] logsSplit = logs[i].split(" "); //배열을 공백기준으로 Split하여 배열을 넣는다.

			// logsSplit의 길이는 3이여야함, 3이 아니면 잘못된 로그형식이므로 무시하고 for문 재시작
			if(logsSplit.length < 3) { 
				 System.out.println("잘못된 로그 형식입니다.");
				 continue; // 잘못된 로그형식일시 무시하고 for문 재시작
			}

			String userId_Two = logsSplit[0]; // 유저 ID 저장
			String stringTime = logsSplit[1] + " " + logsSplit[2]; // 시간으로 변형 시킬 시간문자열이 들어가있음

			DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime logTime = LocalDateTime.parse(stringTime, dateTimeFormatter);

			if(logTime.isAfter(localDateTime)) {
				localDateTime = logTime;
				userId_One = userId_Two;
			}else if (logTime.equals(localDateTime)) {
				userId_One = userId_Two;
			}
		}

		System.out.println(userId_One); // 값 확인
		return userId_One;
	}
}
