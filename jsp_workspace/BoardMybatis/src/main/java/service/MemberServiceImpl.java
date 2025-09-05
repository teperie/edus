package service;

import dao.MemberDao;
import dto.Member;

public class MemberServiceImpl implements MemberService {

	MemberDao memberDao = new MemberDao();

	@Override
	public void join(Member member) throws Exception {
		Member smember = memberDao.select(member.getId());
		if (smember != null)
			throw new Exception("기존 가입된 회원입니다.");
		memberDao.insert(member);
	}

	@Override
	public Member login(String id, String password) throws Exception {
		Member member = memberDao.select(id);
		if (member == null)
			throw new Exception("아이디가 틀립니다.");
		if (!member.getPassword().equals(password))
			throw new Exception("비밀번호가 틀립니다.");
		return member;
	}

	@Override
	public boolean checkMemberId(String id) throws Exception {
		Member member = memberDao.select(id);
		return member != null;
	}

	@Override
	public void close() throws Exception {
		if (memberDao != null) {
			memberDao.close();
		}
	}
}
