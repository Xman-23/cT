package chapter_Five_Recursive;

public class QuadCompression {
    static int zeroCount = 0;
    static int oneCount = 0;

    public static void main(String[] args) {
        int[][] arr = {
            {1, 1, 0, 0},
            {1, 1, 0, 0},
            {0, 0, 1, 1},
            {0, 0, 1, 1}
        };
        //int[][],startY,startX,size
        compress(arr, 0, 0, arr.length);

        System.out.println("0 개수: " + zeroCount);
        System.out.println("1 개수: " + oneCount);
    }

    public static void compress(int[][] arr, int startY, int startX, int size) {
    	if(isSame(arr,startY,startX,size)) {
    		int number = arr[startY][startX];
    		if(number == 0) {
    			zeroCount++;
    		}else if(number == 1) {
    			oneCount++;
    		}
    	}
    	int newSize = size/2; //범위를 줄여가면서 압축하기 (문자열 압축과 비슷)

    	//왼쪽 위
    	compress(arr,startY,startX,newSize); //2X2 y(0~1), x(0~1);
    	//오른쪽 위
    	compress(arr,startY,startX+newSize,newSize); //2X2 y(0~1), x(2~3); 
    	//왼쪽 아래
    	compress(arr, startY+newSize, startX, newSize); //2X2 y(2~3),x(0~1);
    	//오른쪽 아래
    	compress(arr, startY+newSize, startX+newSize, newSize); //2X2 y(2~3),x(2~3)
    }

    public static boolean isSame(int[][] arr, int startY, int startX, int size) {
    	int number = arr[startY][startX]; //ex '0' or '1';
    	for(int i=startY; i<startY+size; i++) {//ex) 행(y) 좌표 (0~1),(2~3)
    		for(int j=startX; j<startX+size; j++) { //ex) 열(x)좌표 (0~1),(2-3)
    			if(number != arr[i][j]) {
    				return false;
    			//else 문 타면 안됨 사이즈 안에 같은수가 아닌데도 true가 나올 수 있음
    			//ex) (0,0) = '0' (0,1) = '0' , (1,0) = '1'
    			}
    		}
    	}
    	return true;
    }
}