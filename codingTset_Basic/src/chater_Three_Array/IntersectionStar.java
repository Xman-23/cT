package chater_Three_Array;

import java.util.*;
import java.math.*;

public class IntersectionStar {

	public static void main(String[] args) {
		IntersectionStar solver = new IntersectionStar();

        int[][] lines = {
            {2, -1, 4},
            {-2, -1, 4},
            {0, -1, 1},
            {5, -8, -12},
            {5, 8, 12}
        };

        String[] result = solver.solution(lines);

        for (String line : result) {
            System.out.println(line);
        }
		
	}

	private static class Point {
		//정수 (x,y)
		long x = 0;
		long y = 0;
		@Override
		public int hashCode() {
			return Objects.hash(x, y);
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Point other = (Point) obj;
			return x == other.x && y == other.y;
		}
		private Point(long x, long y) {
			this.x = x ;
			this.y = y;
		}
	}
	//1.1 교점 좌표 구하기
	private Point intersection(long a1, long b1, long c1, long a2, long b2, long c2) {
		//x = (b1*c2 - b2*c1) / (a1*b2 - a2*b1) 소수점으로 올 수도 있으므로 double 타입 
		//y = (c1*a2 - c2*a1) / (a1*b2 - a2*b1) 소수점으로  올 수도 있으므로 double 타입
	    long denominator = a1 * b2 - a2 * b1;
	    if (denominator == 0) return null;

	    double x = (double)(b1 * c2 - b2 * c1) / denominator;
	    double y = (double)(c1 * a2 - c2 * a1) / denominator;
		
		long returnLongX = 0;
		long returnLongY = 0;
		//정수 좌표만 받음
		if(x != Math.floor(x) || y != Math.floor(y)) {
			return null; // 나머지가 있으면 정수가 아님 그러므로 return
		}else {
			//정수 좌표 라면 double 타입을 long 타입으로 변경
			returnLongX = (long)x;
			returnLongY = (long)y;
		}
		

		return new Point(returnLongX,returnLongY);
	}

	private Point getMinPoint(Set<Point> point) {
		Long minX = Long.MAX_VALUE; //
		Long minY = Long.MAX_VALUE;

		for(Point p : point) {
			if(p.x < minX) {
				minX = p.x;
			}
			if(p.y < minY) {
				minY = p.y;
			}
		}

		return new Point(minX,minY);
	}

	private Point getMaxPoint(Set<Point> point) {
		Long maxX = Long.MIN_VALUE;
		Long maxY = Long.MIN_VALUE;

		for(Point p : point ) {
			if(p.x > maxX) {
				maxX = p.x;
			}
			if(p.y > maxY) {
				maxY = p.y;
			}
		}

		return new Point(maxX,maxY);
	}

	//solution 메서드 가 2차원 배열의 input 값을 받아서 output 값을 리턴 해줄꺼임
	//line == 직선 == 예문
	//y,x 좌표 구하기 위한 
	public String[] solution(int[][] line) {
		//개발자가 직접 만든 클래스들은 hashCode()와 equals() 메서드 가 오버라이드 가 되어 있지않아,
		//Set.add() 할때 Set에 제너릭선언이 된 클래스의 멤버들이 중복이 되어도 중복 제거가 되지 않는다.
		//그러므로 개발자가 직접만들 클래스들은 Set이나 중복제거를 위해서 hashCode()와 equals() 메서드를 오버라이드 해줘야한다
		Set<Point> points = new HashSet<Point>();

		//직선들 을 정수 좌표로 바꿔주기 위한 2중 for문 선언 N(N-1)/2 (조합) 사용
		//예문이 5개 즉 직선이 5개 일때에는 10개의 경우의수 가 나옴(중복없이)
		/*예문
		  	{2, -1, 4},
            {-2, -1, 4},
            {0, -1, 1},
            {5, -8, -12},
            {5, 8, 12}
		 */
		for(int i=0; i<line.length;i++) {
			for(int j=i+1; j<line.length;j++) {
				//(0,x),(1,x)에 해당
				int a1 = line[i][0]; 
				int b1 = line[i][1];
				int c1 = line[i][2];

				//(x.0),(x.1)에 해당
				int a2 = line[j][0];
				int b2 = line[j][1];
				int c2 = line[j][2];

				Point point = intersection(a1, b1, c1, a2, b2, c2);

				//정수 좌표가 들어있는 Point 클래스인지 판별
				if(point != null) {
					points.add(point);
				}
			}
		}
		//순회해서 가장 작은 x,y 좌표를 가진 Point Class
		Point minPoint = getMinPoint(points);
		//순회해서 가장 큰 'x,y' 좌표를 가진 Point Class
		Point maxPoint = getMaxPoint(points);
		//'x,y' 좌표의 간격을 구한후 그 간격 사이에 존재하는 숫자를 구해주기 위해서 +1 이 값이 배열의 길이
		//PointClass 의 좌표 (x,y)는 long 타입이므로, 'int' 로 캐스팅 후 x,y 저장 
		int arrX  = (int)(maxPoint.x - minPoint.x + 1);
		int arrY = (int)(maxPoint.y - minPoint.y + 1);

		//배열의 길이는 'int'만 허용
		char[][] arrStar = new char[arrY][arrX];
		for(char[] row : arrStar) {
			Arrays.fill(row, '.'); //각 행의 모든 'char'타입의 데이터 '.'로 채움(Arrays.fill)
		}

		//본격적인 별 찍기
		for(Point p : points) {
			//minPointX = ex) -4 - (-4) => -4+4 = 0 'x'는 가장 작은 값이 열(가로(x))인덱스 '0'을 가짐
			int resultX = (int)(p.x - minPoint.x); // 'x' 좌표 구하기 
			//maxPointX = ex) +4 -(+4) => +4-4 =0 'y'는 가장 큰 값이 행(세로(y))인덱스 '0'을 가짐
			int resultY = (int)(maxPoint.y - p.y); // 'y' 좌표 구하기
			//배열은 'int'만 길이로 받을 수 있음
			arrStar[resultY][resultX] = '*'; // 진짜 별찍기.
 		}
		//별 다 찍었으면 'String'으로 결합하여 배열로 'char'배열의 행만큼 String[] 배열로 반환 
		//✔ char[][] → String[] 변환은 출력 편의성 또는 리턴 목적이고,
		//✔ 내용 자체는 변하지 않으며, 그대로 문자열로 바꾸는 것입니다.
		//문자(char)이 배열로 구성되어있으면 문자열로 변환이 가능
		String[] returnStringArray = new String[arrStar.length];
		for(int i=0; i<arrStar.length;i++) {
			//'String' 생성자 중 'char' 배열을 받아 'String' 으로 반환해주는 생성자 이용
			returnStringArray[i] = new String(arrStar[i]);
		}
		return returnStringArray;
	}
}



//내부 클래스 활용
class P {
	
	 static class Point {
		
	}
}
