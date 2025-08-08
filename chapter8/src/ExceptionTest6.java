

class Account {
	int balance;

	Account(int balance) {
		this.balance = balance;
	}

	void deposit(int money) throws Exception {
		if (money <= 0)
			throw new Exception("돈내놔");
	}

	void withdraw(int money) throws Exception {
		if (balance < money)
			throw new Exception("돈없어");
	}

	int getBalance() {
		return balance;
	}
}

public class ExceptionTest6 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Account acc = new Account(100000);

		try {
			acc.deposit(10000);
			System.out.println(acc.getBalance());
			acc.withdraw(200000);
		} catch (Exception e) {
			System.out.println(e.getLocalizedMessage());
		}
	}

}
