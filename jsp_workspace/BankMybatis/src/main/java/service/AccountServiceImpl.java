package service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import dao.AccountDAO;
import dao.AccountDaoImpl;
import dto.Account;

public class AccountServiceImpl implements AccountService {

	private AccountDAO dao;

	public AccountServiceImpl() {
		dao = new AccountDaoImpl();
	}

	@Override
	public void makeAccount(Account acc) throws Exception {
//		Account sacc = AccountDaoImpl.select(acc.getId());
//		if (sacc != null)
//			throw new BankException(ERR_CODE.DOUBLEID);
//		AccountDaoImpl.insert(acc);
		dao.insert(acc);
	}

	@Override
	public Account deposit(String id, Integer money) throws Exception {
		Account acc = null;
		acc = dao.select(id);
		Map<String, Object> param = new HashMap<>();
		param.put("id", id);
		param.put("balance", acc.getBalance() + money);
		dao.updateBalance(param);

		return acc;
	}

	@Override
	public Account withdraw(String id, Integer money) throws Exception {
		Account acc = null;

		acc = dao.select(id);
		acc.withdraw(money);
		Map<String, Object> param = new HashMap<>();
		param.put("id", id);
		param.put("balance", acc.getBalance() - money);
		dao.updateBalance(param);
		return acc;
	}

	@Override
	public Account accountInfo(String id) throws Exception {
		return dao.select(id);
	}

	@Override
	public Account transfer(String sid, String rid, Integer money) throws Exception {
		Account sacc = null;
		return sacc;
	}

	@Override
	public Map<String, Object> allAccountInfo(Integer page) throws Exception {
		Map<String, Object> map = new HashMap<>();
		int totalCount = dao.selectAccountCount();
		int pageSize = 5;
		int totalPage = (totalCount + pageSize - 1) / pageSize;
		map.put("totalPage", totalPage);
		map.put("curPage", page);
		map.put("accList", dao.selectList(page));
		return map;
	}

	@Override
	public boolean checkAccountDuplicated(String id) throws Exception {
		Account acc = null;
		return acc != null;
	}

	@Override
	public int getAccountCount() throws Exception {
		return dao.selectAccountCount();
	}
}