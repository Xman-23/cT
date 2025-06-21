package chapter_Four_String;
//시저 암호
public class CaesarCipher {
	public static void main(String[] args) {
	}
}

class CaesarCipherSolution {

	public CaesarCipherSolution() {
		super();
	}
	public static String caesarChiperSolution(String str, int shift) {
		StringBuilder sb = new StringBuilder();

		for(int i=0; i<str.length(); i++) {
			char ch = str.charAt(i);
			//*대문자*
			if(ch>='A' &&  ch<='Z') {
				ch = (char)((ch-'A'+ shift)%26+'A');
				sb.append(ch);
			}else if(ch>='a' && ch<='z') {
				ch = (char)((ch-'a'+shift)%26+'a');
				sb.append(ch);
			}else if(Character.isAlphabetic(ch)) {
				sb.append(ch);
			}
		}
		return sb.toString();
	}
}
