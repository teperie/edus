package service;

import java.util.List;

import dao.AccountDao;
import dto.Account;
import exc.BankException;
import exc.ERR_CODE;

public class AccountServiceImpl implements AccountService {
	
	public AccountServiceImpl() {
		new AccountDao();
	}

	@Override
	public void makeAccount(Account acc) throws Exception {
		Account sacc = AccountDao.select(acc.getId());
		if(sacc!=null) throw new BankException(ERR_CODE.DOUBLEID);
		AccountDao.insert(acc);
	}

	@Override
	public Account deposit(String id, Integer money) throws Exception {
		Account acc = AccountDao.select(id);
		if(acc==null) throw new BankException(ERR_CODE.ACCID);
		acc.deposit(money);
		AccountDao.update(id, acc.getBalance());
		return acc;
	}

	@Override
	public Account withdraw(String id, Integer money) throws Exception {
		Account acc = AccountDao.select(id);
		if(acc==null) throw new BankException(ERR_CODE.ACCID);
		acc.withdraw(money);
		AccountDao.update(id, acc.getBalance());
		return acc;
	}

	@Override
	public Account searchById(String id) throws Exception {
		Account acc = AccountDao.select(id);
		if(acc==null) throw new BankException(ERR_CODE.ACCID);
		return acc;
	}

	@Override
	public void transfer(String sid, String rid, Integer money) throws Exception {
		Account sacc = AccountDao.select(sid);
		if(sacc==null) throw new BankException(ERR_CODE.ACCID);
		Account racc = AccountDao.select(rid);
		if(racc==null) throw new BankException(ERR_CODE.ACCID);
		sacc.withdraw(money);
		racc.receive(money);
		AccountDao.update(sid, money);
		AccountDao.update(rid, money);
	}

	@Override
	public List<Account> allAccountInfo() throws Exception {
		return AccountDao.selectList();
	}
	
	
}
