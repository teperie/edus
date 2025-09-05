package dao;

import java.sql.SQLException;

import dto.Account;

public interface AccountDAO {
	public void insert(Account acc) throws SQLException;
}
