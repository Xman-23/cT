package codingTest0516;

import java.util.*;
public class CodingTest0516 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
class Solution {
	//충돌
    public String solution(String[] logs) {
        Schedule[] schedules = new Schedule[logs.length];
        for (int i = 0; i < logs.length; i++) {
            String[] times = logs[i].split("~");
            schedules[i] = new Schedule(times[0], times[1]);
        }

        Arrays.sort(schedules); // 시작 시간 기준 정렬

        for (int i = 0; i < schedules.length - 1; i++) {
            if (schedules[i].end > schedules[i + 1].start) {
                return "YES"; 
                // 충돌 있음
            }
        }

        return "NO"; // 충돌 없음
    }

    class Schedule implements Comparable<Schedule> {
        int start;
        int end;

        Schedule(String startTime, String endTime) {
            this.start = toMinutes(startTime);
            this.end = toMinutes(endTime);
        }

        int toMinutes(String time) {
            String[] parts = time.split(":");
            int hour = Integer.parseInt(parts[0]);
            int minute = Integer.parseInt(parts[1]);
            return hour * 60 + minute;
        }

        @Override
        public int compareTo(Schedule other) {
            return this.start - other.start;
        }
    }
    
    public static int maxProduct(int[] nums) {
        if (nums == null || nums.length == 0) return 0;

        int maxProd = nums[0];
        int minProd = nums[0];
        int result = nums[0];

        for (int i = 1; i < nums.length; i++) {
            int curr = nums[i];
            // maxProd, minProd 둘 다 현재 값과 곱해본 후 최댓값과 최솟값을 갱신
            int tempMax = Math.max(curr, Math.max(maxProd * curr, minProd * curr));
            int tempMin = Math.min(curr, Math.min(maxProd * curr, minProd * curr));

            maxProd = tempMax;
            minProd = tempMin;

            result = Math.max(result, maxProd);
        }

        return result;
    }

}