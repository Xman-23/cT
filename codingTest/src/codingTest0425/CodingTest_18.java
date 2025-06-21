package codingTest0425;

import java.util.*;
import java.time.format.*;
import java.math.*;
import java.time.*;
import java.lang.*;
import java.io.*;

public class CodingTest_18 {
	public static void main(String[] args) {
		String[] stringArray = {
				"kim,2023-05-20 09:00:00",
				"lee,2023-05-21 09:00:00",
				"park,2023-05-20 09:00:00",
				"choi,2023-05-22 10:30:00"	
		};
		String returnValue = getValue(stringArray);
		System.out.println(returnValue);
	}
	public static String getValue(String[] stringArray) {

		LocalDateTime logTime = LocalDateTime.MAX;
		String returnString = "";
		
		for(int i=0; i<stringArray.length; i++) {
			String[] arraySplit = stringArray[i].split(",");
			String userID = arraySplit[0];
			String arrayLogTime = arraySplit[1];

			DateTimeFormatter logTimeFormat = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
			LocalDateTime localDateTime = LocalDateTime.parse(arrayLogTime,logTimeFormat);
			if(localDateTime.isBefore(logTime)) {
				returnString = userID;
				logTime = localDateTime;
				System.out.println("returnString =" + returnString);
			}else if(localDateTime.isEqual(logTime)) {
				if(returnString.compareTo(userID) > 0) {
					returnString = userID;
				}
			}
		}

		return returnString;
	}
}
