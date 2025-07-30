import java.util.Scanner;

public class CoffeeMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.println("[코스타 커피 자판기]");
			System.out.println("1. 블랙커피(120원)");
			System.out.println("2. 말크커피(380원)");
			System.out.println("3. 설탕커피(250원)");
			System.out.println("4. 딸기우유(230원)");
			System.out.println("0. 자판기종료");
			System.out.print("선택>>");
			int menu = sc.nextInt();
			if (menu == 0) break;
			
			System.out.print("돈을 넣으세요: ");
			int money = sc.nextInt();

			int change = money;

			switch (menu) {
			case 1:
				change -= 120;
				break;
			case 2:
				change -= 380;
				break;
			case 3:
				change -= 250;
				break;
			case 4:
				change -= 230;
				break;
			default:
				break;
			}

			int coin500 = change / 500;
			change %= 500;

			int coin100 = change / 100;
			change %= 100;

			int coin50 = change / 50;
			change %= 50;

			int coin10 = change / 10;
			change %= 10;

			System.out.println("거스름돈");
			System.out.printf("500원: %d개\n", coin500);
			System.out.printf("100원: %d개\n", coin100);
			System.out.printf("50원: %d개\n", coin50);
			System.out.printf("10원: %d개\n", coin10);
		}
		
		sc.close();

	}

}
