package chapter6;

import java.util.Scanner;

public class Bank {
	Scanner sc;
	Account[] accs;
	int cnt;

	Bank() {
		sc = new Scanner(System.in);
		accs = new Account[100];
	}

	void makeAccount() {
		// 1. 계좌번호, 이름, 입금액을 입력받아 변수에 담는다.
		System.out.print("계좌번호: ");
		String id = sc.nextLine();
		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("입금액: ");
		int balance = Integer.parseInt(sc.nextLine());

		// 2. account 객채를 생성하여 입력받은 값으로 속성을 초기화한다.
		Account acc = new Account(id, name, balance);

		// 3. 생성한 객채를 accs 배열에 담는다.
		accs[cnt++] = acc;
	}

	int menu() {
		System.out.println("[코스타 은행]");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 계좌조회");
		System.out.println("5. 전채계좌조회");
		System.out.println("6. 계좌송금");
		System.out.println("0. 종료");
		System.out.print("선택>> ");
		return Integer.parseInt(sc.nextLine());
	}

	void deposit() {
		System.out.println("[입금]");
		System.out.print("계좌번호: ");
		String id = sc.nextLine();

		Account ac = searchAccById(id);
		if (ac == null) {
			System.out.println("그런거 없어요");
			return;
		}

		System.out.print("입금액: ");
		int amount = Integer.parseInt(sc.nextLine());

		ac.deposit(amount);
		System.out.println("잔액: " + ac.balance);
	}

	void withdraw() {
		System.out.println("[출금]");
		System.out.print("계좌번호: ");
		String id = sc.nextLine();

		Account ac = searchAccById(id);
		if (ac == null) {
			System.out.println("그런거 없어요");
			return;
		}

		System.out.print("출금액: ");
		int amount = Integer.parseInt(sc.nextLine());

		ac.withdraw(amount);
		System.out.println("잔액: " + ac.balance);
	}

	Account searchAccById(String id) {
		Account ac = null;
		for (int i = 0; i < cnt; i++) {
			if (accs[i].id.equals(id)) {
				ac = accs[i];
				break;
			}
		}
		return ac;
	}

	void accountInfo() {
		System.out.println("[계좌조회]");
		System.out.print("계좌번호: ");
		String id = sc.nextLine();

		Account ac = searchAccById(id);

		// 2. 찾은 계좌의 정보를 읽어와 콘솔에 출력한다.
		// 있으면 출력, 없으면 없다고 출력
		if (ac != null) {
			System.out.println(ac.info());
		} else {
			System.out.println("그런거 없어요");
		}

	}

	void allAccountInfo() {
		for (int i = 0; i < cnt; i++) {
			System.out.println(accs[i].info());
		}
	}

	void transfer() {
		System.out.println("[계좌송금]");
		System.out.print("보내는계좌번호: ");
		String sid = sc.nextLine();

		Account sac = searchAccById(sid);
		if (sac == null) {
			System.out.println("보내는 계좌번호가 틀립니다.");
			return;
		}

		System.out.print("받는계좌번호: ");
		String rid = sc.nextLine();

		Account rac = searchAccById(sid);
		if (rac == null) {
			System.out.println("받는 계좌번호가 틀립니다.");
			return;
		}

		System.out.print("송금액: ");
		int amount = Integer.parseInt(sc.nextLine());
		if (sac.withdraw(amount)) {
			rac.deposit(amount);
		}
		;

	}

	public static void main(String[] args) {
		Bank bank = new Bank();
		int sel;
		Loop: while (true) {
			sel = bank.menu();
			switch (sel) {
			case 0:
			default:
				break Loop;
			case 1:
				bank.makeAccount();
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
		}
	}
}

// [코스타 은행]
// 1. 계좌개설
// 2. 입금
// 3. 출금
// 4. 계좌조회
// 5. 전채계좌조회
// 0. 종료
// 선택>> 2
// [계좌조회]
// 계좌번호: 1001
// 계좌번호: 1001, 이름: 홍길동, 잔액: 100000