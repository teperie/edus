package dao;

import org.apache.ibatis.session.SqlSession;

import dto.Member;
import util.MybatisSqlSessionFactory;

public class MemberDao implements AutoCloseable {

	SqlSession sqlSession = MybatisSqlSessionFactory.getSqlSessionFactory().openSession();

	public void insert(Member member) throws Exception {
		sqlSession.insert("mapper.member.insertMember", member);
		sqlSession.commit();
	}

	public Member select(String id) throws Exception {
		Member member = sqlSession.selectOne("mapper.member.selectMember", id);
		return member;
	}

	@Override
	public void close() throws Exception {
		if (sqlSession != null) {
			sqlSession.close();
		}
	}

}
