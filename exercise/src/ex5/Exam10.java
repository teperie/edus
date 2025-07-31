package ex5;

public class Exam10 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] abcCode = { '`', '~', '!', '@', '#', '$', '%', '^', '&', '*', '(', ')', '-', '_', '+', '=', '|', '[',
				']', '{', '}', ';', ':', ',', '.', '/' };
		// 0 1 2 3 4 5 6 7 8 9
		char[] numCode = { 'q', 'w', 'e', 'r', 't', 'y', 'u', 'i', 'o', 'p' };
		String src = "abc123";
		String result = "";
		// 문자열 src의 문자를 charAt()으로 하나씩 읽어서 변환 후 result에 저장
		for (int i = 0; i < src.length(); i++) {
			char ch = src.charAt(i);
			/*
			 * (1) 알맞은 코드를 넣어 완성하시오.
			 */
			if (ch >= 'a' && ch <= 'z') {
				ch = abcCode[ch - 'a'];
//			} else if (ch >= 'A' && ch <= 'Z') {
//				ch = abcCode[ch - 'A'];
			} else if (ch >= '0' && ch <= '9') {
				ch = numCode[ch - '0'];
			}
			result += ch;
		}
		System.out.println("src:" + src);
		System.out.println("result:" + result);
	}

}
