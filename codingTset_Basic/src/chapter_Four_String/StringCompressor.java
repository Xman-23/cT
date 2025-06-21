package chapter_Four_String;

public class StringCompressor {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}

class StringCompressorSolution {
	StringCompressorSolution(){
		super();
	}

	public static void stringCompressorSolution(String string) {
		int stringLength = string.length();
		//len을 1부터 시작하는 이유는 substring을 사용해야 하며,
		/*
		예시: 문자열 "aaaa"
		길이: 4

		검사 가능한 len: 1, 2까지만 의미 있음

		✔ len = 1 → ["a", "a", "a", "a"]
		압축: 4a → 길이 2

		✔ len = 2 → ["aa", "aa"]
		압축: 2aa → 길이 3

		✘ len = 3 → ["aaa", "a"]
		"aaa" ≠ "a" → 반복 불가 → 압축 못 함

		결과는 그대로 "aaaa" → 길이 4 → 원래보다 길어짐

		✘ len = 4 → ["aaaa"]
		문자열 1개 → 반복 없음 → 압축 불가

		결과는 "aaaa" → 길이 4
		 */
		for(int len = 1; len<=string.length()/2; len++) {
			StringBuilder stringBuilder = new StringBuilder();
			//비교할 이전의 문자열 ex) "ab" 중에 "a" 해당
			String prevString = string.substring(0,len);
			int count = 1;
			for(int i=len; i<string.length();i++) {
				/*
				 	i + len <= s.length() 는:

					substring 범위 오류를 방지하기 위한 안전 조건입니다.

					Java의 substring(start, end)가 end를 포함하지 않기 때문에 <= 를 써야 마지막 문자까지 잘라올 수 있습니다
					
					len이 2일 때는 문자열을 2글자씩 잘라가는데, 
					
					문자열 길이가 홀수이면 마지막 남은 문자 하나는 잘라낼 수 없어서, 
					따로 substring(i)로 가져온다
					>> 즉 , **"끝에 남은 문자 따로 챙겨주는 장치"**가 되는 겁니다!
				 */
				String currentString = (i+len <= string.length()) ? string.substring(i,i+len) : string.substring(i);

				if(currentString.equals(prevString)) {
					count++;
				}else {
					if(count > 1) {
						stringBuilder.append(count);
					}else {
						stringBuilder.append(prevString);
						prevString = currentString;
						count =1;
					}
				}
			}
			//마지막 문자 담기
			if(count > 1) {
				stringBuilder.append(count);
			}
			stringBuilder.append(prevString);

			stringLength = Math.min(stringLength, stringBuilder.length());
		}
	}
}
