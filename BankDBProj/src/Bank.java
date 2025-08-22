
import java.util.List;
import java.util.Scanner;

import acc.Account;
import acc.SpecialAccount;
import exc.BankException;
import exc.ERR_CODE;
import dao.AccountDao;

public class Bank {
	Scanner sc;

	Bank() {
		sc = new Scanner(System.in);
	}

	void makeAccount() throws BankException {
		// 1. 계좌번호, 이름, 입금액을 입력받아 변수에 담는다.
		System.out.println("[일반계좌개설]");
		System.out.print("계좌번호: ");
		String id = sc.nextLine();

		Account ac = null;

		ac = AccountDao.select(id);

		if (ac != null)
			throw new BankException(ERR_CODE.DOUBLEID);

		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("입금액: ");
		int balance = Integer.parseInt(sc.nextLine());

		// 2. account 객채를 생성하여 입력받은 값으로 속성을 초기화한다.
		Account acc = new Account(id, name, balance);

		// 3. 생성한 객채를 accs 배열에 담는다.
		AccountDao.insert(acc);
	}

	void makeSpecialAccount() throws BankException {
		// 1. 계좌번호, 이름, 입금액을 입력받아 변수에 담는다.
		System.out.println("[특별계좌개설]");
		System.out.print("계좌번호: ");
		String id = sc.nextLine();

		Account ac = null;

		try {
			ac = searchAccById(id);
		} catch (BankException e) {
		}

		if (ac != null)
			throw new BankException(ERR_CODE.DOUBLEID);

		System.out.print("이름: ");
		String name = sc.nextLine();
		System.out.print("입금액: ");
		int balance = Integer.parseInt(sc.nextLine());
		System.out.print("등급(VIP, Gold, Silver, Normal): ");
		String grade = sc.nextLine();

		// 2. account 객채를 생성하여 입력받은 값으로 속성을 초기화한다.
		SpecialAccount acc = new SpecialAccount(id, name, balance, grade);

		// 3. 생성한 객채를 accs 배열에 담는다.
		AccountDao.insert(acc);
	}

	int menu() throws BankException {
		System.out.println("[코스타 은행]");
		System.out.println("1. 계좌개설");
		System.out.println("2. 입금");
		System.out.println("3. 출금");
		System.out.println("4. 계좌조회");
		System.out.println("5. 전채계좌조회");
		System.out.println("6. 계좌송금");
		System.out.println("7. 계좌삭제");
		System.out.println("0. 종료");
		System.out.print("선택>> ");

		int input = 999;
		input = Integer.parseInt(sc.nextLine());

		if (input < 0 || input > 7) {
			throw new BankException("메뉴오류", ERR_CODE.MENU);
		}

		return input;
	}

	void makeAccMenu() throws BankException {
		System.out.println("[계좌개설]");
		System.out.println("1. 일반계좌");
		System.out.println("2. 특별계좌");
		System.out.print("선택>> ");
		int sel = 999;
		sel = Integer.parseInt(sc.nextLine());
		if (sel == 1) {
			makeAccount();
		} else if (sel == 2) {
			makeSpecialAccount();
		}
	}

	void delete() throws BankException {
		System.out.println("[계좌삭제]");
		System.out.print("계좌번호: ");
		String id = sc.nextLine();
		AccountDao.delete(id);
	}

	void deposit() throws BankException {
		System.out.println("[입금]");
		System.out.print("계좌번호: ");
		String id = sc.nextLine();

		Account ac = AccountDao.select(id);

		System.out.print("입금액: ");

		int amount;

		try {
			amount = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			throw new BankException(ERR_CODE.DEPOSIT);
		}

		ac.addBalance(amount);
		System.out.println("잔액: " + ac.getBalance());
	}

	void withdraw() throws BankException {
		System.out.println("[출금]");
		System.out.print("계좌번호: ");
		String id = sc.nextLine();

		Account ac = AccountDao.select(id);
		if (ac == null) {
			System.out.println("그런거 없어요");
			return;
		}

		System.out.print("출금액: ");
		int amount;

		try {
			amount = Integer.parseInt(sc.nextLine());
		} catch (NumberFormatException e) {
			throw new BankException("금액 확인", ERR_CODE.MENU);
		}
		ac.withdraw(amount);
		System.out.println("잔액: " + ac.getBalance());
	}

	Account searchAccById(String id) throws BankException {
		Account ac = null;

		ac = AccountDao.select(id);

		if (ac == null)
			throw new BankException(ERR_CODE.ACCID);
		return ac;
	}

	void accountInfo() throws BankException {
		System.out.println("[계좌조회]");
		System.out.print("계좌번호: ");
		String id = sc.nextLine();

		Account ac = AccountDao.select(id);
		if (ac == null) {
			throw new BankException(ERR_CODE.ACCID);
		}

		System.out.println(ac.info());
	}

	void allAccountInfo() {
		System.out.println("[전체계좌조회]");
		List<Account> list = AccountDao.selectList();
		if (list.size() == 0) {
			System.out.println("개설된 계좌가 없습니다");
			return;
		}

		for (Account ac : list) {
			System.out.println(ac);
		}

		// for (Account account : accs) {
		// System.out.println(account.info());
		// }

		// Iterator<Account> it = accs.iterator();

		//
		// while (it.hasNext())
		// System.out.println(it.next().info());

		// ListIterator<Account> lit = accs.listIterator(accs.size());

	}

	void transfer() throws BankException {
		System.out.println("[계좌송금]");
		System.out.print("보내는계좌번호: ");
		String sid = sc.nextLine();

		Account sac = AccountDao.select(sid);

		System.out.print("받는계좌번호: ");
		String rid = sc.nextLine();

		Account rac = AccountDao.select(rid);

		System.out.print("송금액: ");
		int amount = Integer.parseInt(sc.nextLine());
		if (sac.withdraw(amount)) {
			rac.receive(amount);
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
// 머리가 안돈다구요