package dao;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;

import dto.Account;
import util.MybatisSqlSessionFactory;

public class AccountDaoImpl implements AccountDAO {
	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();

	@Override
	public void insert(Account acc) {
		sqlSession.insert("mapper.account.insertAccount", acc);
		sqlSession.commit();
	}

	@Override
	public void update(Account acc) {
		sqlSession.update("mapper.account.updateAccount", acc);
		sqlSession.commit();
	}

	@Override
	public Account select(String id) {
		return sqlSession.selectOne("mapper.account.selectAccount", id);
	}

	@Override
	public List<Account> selectList(Integer page) {
		page = (page - 1) * 5;
		return sqlSession.selectList("mapper.account.selectAccountList", page);
	}

	@Override
	public void updateBalance(Map<String, Object> param) {
		sqlSession.update("mapper.account.updateBalance", param);
		sqlSession.commit();
	}

	@Override
	public Integer selectAccountCount() {
		return sqlSession.selectOne("mapper.account.selectAccountCount");
	}
}
