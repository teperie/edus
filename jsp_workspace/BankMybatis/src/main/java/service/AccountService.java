package service;

import java.util.Map;

import dto.Account;

public interface AccountService {
	void makeAccount(Account acc) throws Exception;

	Account deposit(String id, Integer money) throws Exception;

	Account withdraw(String id, Integer money) throws Exception;

	Account accountInfo(String id) throws Exception;

	Account transfer(String sid, String rid, Integer money) throws Exception;

	Map<String, Object> allAccountInfo(Integer page) throws Exception;

	boolean checkAccountDuplicated(String id) throws Exception;
	
	int getAccountCount() throws Exception;
}
