import java.util.Scanner;

public class ForTest5 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		System.out.println("문자 입력");
		String str = sc.nextLine();
		System.out.println("층수 입력");
		int max = Integer.parseInt(sc.nextLine());
		System.out.println("모양 입력");
		System.out.println("1: 직삼각 , 2: 역직삼각, 3: 삼각, 4: 으른쪽역직삼각");
		String shape = sc.nextLine();

		switch (shape) {

		case "1":
		default:
			for (int i = 1; i <= max; i++) {
				for (int j = 0; j < i; j++) {
					System.out.print(str);
				}
				System.out.println();
			}
			break;
		case "3":
			for (int i = 1; i <= max; i++) {
				for (int j = 0; j < max - i; j++) {
					for (int k = 0; k < str.length(); k++) {
						System.out.print(' ');
					}
				}
				for (int j = 0; j < (i << 1) - 1; j++) {
					System.out.print(str);
				}
				System.out.println();
			}
			break;

		case "2":
			for (int i = 0; i < max; i++) {
				for (int j = 0; j < max - i; j++) {
					System.out.print(str);
				}
				System.out.println();
			}
			break;
		case "4":
			for (int i = 0; i < max; i++) {
				for (int j = 0; j < i; j++) {
					for (int k = 0; k < str.length(); k++) {
						System.out.print(' ');
					}
				}
				for (int j = 0; j < max - i; j++) {
					System.out.print(str);
				}
				System.out.println();
			}
			break;
		}
		sc.close();
	}

}
