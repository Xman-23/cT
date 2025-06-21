package chapter_Two_time_comPlexity;

public class O_logN {

	O_logN(){
		super();
	}

	public static void main(String[] args) {
		

	}

	public static boolean oLogN(int[] arr, int target) {

		int start = 0; //배열의 시작은 '0'에서 부터 시작
		int end = arr.length-1; //배열의 끝은 'arr.length-1'

		// 만약 start 가 end 보다 크다면 이미 배열을 다 돌아봤다는 의미
		while(start<=end) {
			int mid = (start+end)/2;
			if(arr[mid] == target) {
				return true;
			}else if(arr[mid] < target) { 
				//arr[mid]의 값이 target 보다 작을때는 target의 값이 현재 mid 인덱스 보다 오른쪽(뒤)에 있을 가능성이 있으므로,
				//오른쪽으로 한칸 이동하여 탐색 범위를 좁혀나간다
				start = mid+1;
			}else if(arr[mid] > target)
				//arr[mid]의 값이 target 보다 클때는 target의 값이 현재 mid 인덱스 보다 왼쪽(앞)에 있을 가능성이 있으므로,
				//왼쪽으로 한칸 이동하여 탐색 범위를 좁혀 나간다
				end = mid-1;
		}
		return false; // target의 값이 없다는것을 의미하므로 false 반환
	}
}
