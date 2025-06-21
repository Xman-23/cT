package chater_Three_Array;

import java.util.Arrays;

public class DrawLineExample {
    public static void main(String[] args) {
        // 예시 직선: 2x - 3y + 6 = 0
        int A = 2;
        int B = -3;
        int C = 6;
        //x의 간격은 20이지만 그 간격 사이에는 21개의 숫자가 존재 =21개가 열 인덱스 배열의 길이
        int minX = -10; //음수 x 좌표
        int maxX = 10; // 양수 x 좌표  
        //y의 간격은 20이지만 그 간격 사이에는 21개의 숫자가 존재 = 21개가 행 인덱스 배열의 길이
        int minY = -10; // 음수 y 좌표;
        int maxY = 10; //양수 x 좌표
        //두 x,y좌표 간격사이의 존재하는 숫자 (21,21)
        char[][] grid = new char[maxY - minY + 1][maxX - minX + 1];
        //2차원배열의 주소(데이터)가 담긴 1차원 배열을 가져와 ,
    
        for (char[] row : grid) {
        	//각 1차원 배열마다 2차원 배열의 데이터를 모두 '.'로 채움
            Arrays.fill(row, '.');
        }

        // 직선 위에 있는 점을 찾기 (정수 좌표 내에서 오차 범위 0.5 이내)
        for (int x = minX; x <= maxX; x++) {
            for (int y = minY; y <= maxY; y++) {
                double val = A * x + B * y + C; //직선을 구하는 방정식
                // 직선 방정식을 만족하는 점을 오차 범위 내에서 '*' 표시
                if (Math.abs(val) < 0.5) { // 0와 같다면은 그건 직선위에 점이있다는걸 뜻함, 여기는 약간의 오차범위를 주기위해 '0.5'를 기준으로 잡음
                    // 배열의 인덱스는 y 방향이 위에서 아래로 증가하니까, y 좌표를 뒤집어 줌
                    int gridY = maxY - y; 
                    int gridX = x - minX;
                    grid[gridY][gridX] = '*'; //직선에 점 찍기
                }
            }
        }

        // 출력
        for (char[] row : grid) {
            System.out.println(new String(row));
        }
    }
}