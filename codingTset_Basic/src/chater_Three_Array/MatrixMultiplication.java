package chater_Three_Array;

public class MatrixMultiplication {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}
}
class MatrixMultiplicationSolution {

	MatrixMultiplicationSolution() {
		
	}

	public static int[][] matrixMultiplicationSolution (int[][] arrOne, int[][] arrTwo) {
		//행렬의 곱은 왼쪽 배열의 행의 갯수 와 오른쪽 배열의 열의 갯수 구조를 가진다
		int[][] returnArray = new int[arrOne.length][arrTwo[0].length];

		if(arrOne[0].length != arrTwo.length) {
			return null;
		}

		for(int i=0; i<returnArray.length;i++) {
			for(int j=0; j<returnArray[0].length;j++) {
				returnArray[i][j] = 0; // 각 배열의 노드(좌표(위치)) 마다 'returnArray[i][j]'을 초기화 해줘야함
				//ex) {0,0} = returnArray[i][j], {0,1} = returnArray[i][j], {1,0} = returnArray[i][j], {1,1} = returnArray[i][j]
				for(int k=0; k<arrTwo.length; k++) {
					returnArray[i][j] = returnArray[i][j] + arrOne[i][k] * arrTwo[k][j];
				}
			}
		}

		return returnArray;
	}
}
