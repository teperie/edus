package service;

import java.util.List;

import dao.AccountDAO;
import dao.AccountDaoImpl;
import dto.Account;
import exc.BankException;
import exc.ERR_CODE;

public class AccountServiceImpl implements AccountService {

	private AccountDAO accountDAO;

	public AccountServiceImpl() {
		this.accountDAO = new AccountDaoImpl();
	}

	@Override
	public void makeAccount(Account acc) throws Exception {
		accountDAO.insert(acc);
	}

	@Override
	public Account deposit(String id, Integer money) throws Exception {
		Account acc = AccountDaoImpl.select(id);
		if (acc == null)
			throw new BankException(ERR_CODE.ACCID);
		acc.deposit(money);
		AccountDaoImpl.update(id, acc.getBalance());
		return acc;
	}

	@Override
	public Account withdraw(String id, Integer money) throws Exception {
		Account acc = AccountDaoImpl.select(id);
		if (acc == null)
			throw new BankException(ERR_CODE.ACCID);
		acc.withdraw(money);
		AccountDaoImpl.update(id, acc.getBalance());
		return acc;
	}

	@Override
	public Account accountInfo(String id) throws Exception {
		return AccountDaoImpl.select(id);
	}

	@Override
	public Account transfer(String sid, String rid, Integer money) throws Exception {
		Account sacc = AccountDaoImpl.select(sid);
		if (sacc == null)
			throw new BankException("보내는계좌", ERR_CODE.ACCID);
		Account racc = AccountDaoImpl.select(rid);
		if (racc == null)
			throw new BankException("받는계좌", ERR_CODE.ACCID);
		sacc.withdraw(money);
		racc.receive(money);
		AccountDaoImpl.update(sid, sacc.getBalance());
		AccountDaoImpl.update(rid, racc.getBalance());
		return sacc;
	}

	@Override
	public List<Account> allAccountInfo() throws Exception {
		return AccountDaoImpl.selectList();
	}

	@Override
	public boolean checkAccountDuplicated(String id) throws Exception {
		Account acc = AccountDaoImpl.select(id);
		return acc != null;
	}
}
