
public class ForTest12 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		String str = "*";
		int n = 5;
		
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < n - i; j++) {
				for (int k = 0; k < str.length(); k++) {
					System.out.print(' ');
				}
			}
			for (int j = 0; j < (i << 1) - 1; j++) {
				System.out.print(str);
			}
			System.out.println();
		}
	}

}
