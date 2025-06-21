package chapter_Six_Brute_Force_Search;

import java.util.ArrayList;
import java.util.List;

public class MockExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class MockExamSolution {

	public MockExamSolution() {
		super();
	}



	public static int[] mockExam(int[] answers) {
		int[] oneStudent = {1, 2, 3, 4, 5}; // 첫번째 학생
		int[] twoStudent = {2, 1, 2, 3, 2,4, 2, 5};// 두번째 학생
		int[] threeStudent= {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

		int oneStudentScore = 0;
		int twoStudentScore = 0;
		int threeStudentScore = 0;
		//answers = [1, 2, 3, 4, ,5]

		for(int i=0; i<answers.length; i++) {
			int answer = answers[i];
			//'i' 를 'answers.length'로 나머지를 구할경우
			//첫번째 학생은 배열의 길이가 answer의 길이와 맞아 문제가 없지만
			int oneStudentPick = oneStudent[i % oneStudent.length];
			//두번째 학생은 '6번째 문제'때 원래 가져와야할 '4'가 아닌 '2'를 가져와 문제가 생긴다 
			int twoStudentPick = twoStudent[i % twoStudent.length];
			//세번쨰 학생의 경우는 '6번쨰 문'때 '원래 가져와야할 '2'가 아닌 '3'을 가져와 문제가 생긴다 
			//즉, 자기의 찍는 패턴의 길이를 가져와서 나눠줘야지만 원하는 값이 나온다
			int threeStudentPick = threeStudent[i % threeStudent.length];
			//'if - else' 문 처리 x
			//'if문' 은 한번만 "true"면은 'if문'을 한번만 타기때문에
			//학생들중 문제를 맞춘사람이 여러명일 수 있으므로 'if문'을 분리해야한다.
			if(answer == oneStudentPick) {
				oneStudentScore++;
			}

			if(answer == twoStudentPick) {
				twoStudentScore++;
			}

			if(answer == threeStudentPick) {
				threeStudentScore++;
			}
		}

		int maxScore = Math.max(oneStudentScore, Math.max(twoStudentScore, threeStudentScore));

		List<Integer> list = new ArrayList<Integer>();

		if(maxScore == oneStudentScore) {
			list.add(1);
		}

		if(maxScore == twoStudentScore) {
			list.add(2);
		}

		if(maxScore == threeStudentScore) {
			list.add(3);
		}

		int[] returnIntArray = new int[list.size()];

		for(int i=0; i<returnIntArray.length; i++) {
			returnIntArray[i] = list.get(i);
		}

		return returnIntArray;
	}
}
