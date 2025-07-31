
public class HexToBinaryExam {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		char[] hex = { 'C', 'a', 'F', 'Y', 'e', '2', '4', 'Z', 'H' };
		String[] binary = { "0000", "0001", "0010", "0011", "0100", "0101", "0110", "0111", "1000", "1001", "1010",
				"1011", "1100", "1101", "1110", "1111" };

		
		
		
		String result = "";
		String notHex = "";

		for (int i = 0; i < hex.length; i++) {
			char ch = hex[i];
			if (ch >= '0' && ch <= '9') {
				result += binary[ch - '0'];
			} else if (ch >= 'A' && ch <= 'F') {
				result += binary[ch - 'A' + 10];
			} else if (ch >= 'a' && ch <= 'f') {
				result += binary[ch - 'a' + 10];
			} else {
				notHex += ch;
			}
		}
		System.out.println(result);
		System.out.println(notHex);
	}

}
