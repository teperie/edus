package ex9;

public class Exam9 {

	public static String delChar(String src, String delCh) {
		StringBuffer sb = new StringBuffer(src);

		for (int i = 0; i < sb.length();) {
			char c = sb.charAt(i);
			if (delCh.indexOf(c) != -1) {
				sb.deleteCharAt(i); // 해당 문자를 삭제하고 인덱스는 증가하지 않음
			} else {
				i++; // 삭제 안 하면 다음 문자로 이동
			}
		}

		return sb.toString();
	}

	public static void main(String[] args) {

		System.out.println("(1!2@3^4~5)" + " -> " + delChar("(1!2@3^4~5)", "~!@#$%^&*()"));

		System.out.println("(1	2	3	4\t5)" + " -> " + delChar("(1	2	3	4\t5)", " \t"));
	}
}
