package chapter_Two_time_comPlexity;

import java.util.Arrays;
//O(NM)을 이진탐색하는 방법
public class BinarySearchNM {

    public static boolean binarySearch(int[] arr, int target) {
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (arr[mid] == target) {
                return true;
            } else if (arr[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        int[] arr = {3, 6, 8, 10, 15, 20, 25};
        int[] targets = {8, 20, 5};

        Arrays.sort(arr);  // 이진 탐색 전 정렬 필수
        //target에 있는 배열을 한번에 값으로 넘기는것이아닌
        for (int target : targets) {
            if (binarySearch(arr, target)) {
                System.out.println(target + " 존재합니다.");
            } else {
                System.out.println(target + " 없습니다.");
            }
        }
    }
}