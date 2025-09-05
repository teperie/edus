package dao;

import java.util.List;
import java.util.Map;

import dto.Account;

public interface AccountDAO {
	public void insert(Account acc);

	public void update(Account acc);
	
	public void updateBalance(Map<String, Object> param);

	public Account select(String id);

	public List<Account> selectList(Integer page);
	
	public Integer selectAccountCount();
}
