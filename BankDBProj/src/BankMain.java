import exc.BankException;

public class BankMain {
	public static void main(String[] args) {
		Bank bank = new Bank();
		int sel;

		
		Loop: while (true) {

			try {
				sel = bank.menu();
				switch (sel) {
				case 0:
				default:
					break Loop;
				case 1:
					bank.makeAccMenu();
					break;
				case 2:
					bank.deposit();
					break;
				case 3:
					bank.withdraw();
					break;
				case 4:
					bank.accountInfo();
					break;
				case 5:
					bank.allAccountInfo();
					break;
				case 6:
					bank.transfer();
					break;
				}
			} catch (NumberFormatException e) {
				System.out.println("입력 오류");
			} catch (BankException e) {
				System.out.println(e);
			}
		}
	}
}
