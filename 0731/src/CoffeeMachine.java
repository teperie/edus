import java.util.Scanner;

public class CoffeeMachine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		int[] coin = { 500, 100, 50, 10 };
		int[] coinCnt = new int[4];

		String[] menuName = {"블랙커피", "밀크커피", "설탕커피", "딸기우유" };
		int[] price = { 120, 380, 250, 230 };

		while (true) {
			System.out.println("[코스타 커피 자판기]");
			for (int i = 0; i < menuName.length; i++) {
				System.out.printf("%d. %s(%d원)\n", i + 1, menuName[i], price[i]);
			}
			System.out.println("0. 자판기종료");
			System.out.print("선택>>");
			int menu = sc.nextInt();
			if (menu == 0)
				break;

			int change = 0;
			boolean isEnough = false;

			System.out.print("돈을 넣으세요: ");
			int money = sc.nextInt();
			change += money;

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
			if (change >= 0)
				isEnough = true;
			while (!isEnough) {
				System.out.printf("%d원이 모자랍니다. 돈을 넣으세요: ", -change);
				money = sc.nextInt();
				change += money;
				if (change >= 0)
					isEnough = true;
			}

			System.out.println("거스름돈");
			for (int i = 0; i < coinCnt.length; i++) {
				coinCnt[i] = change / coin[i];
				if (coinCnt[i] > 0)
					System.out.printf("%d원: %d개\n", coin[i], coinCnt[i]);
				change %= coin[i];
			}

//			int coin500 = change / 500;
//			change %= 500;
//
//			int coin100 = change / 100;
//			change %= 100;
//
//			int coin50 = change / 50;
//			change %= 50;
//
//			int coin10 = change / 10;
//			change %= 10;

//			System.out.println("거스름돈");
//			System.out.printf("500원: %d개\n", coin500);
//			System.out.printf("100원: %d개\n", coin100);
//			System.out.printf("50원: %d개\n", coin50);
//			System.out.printf("10원: %d개\n", coin10);
		}

		sc.close();

	}

}
