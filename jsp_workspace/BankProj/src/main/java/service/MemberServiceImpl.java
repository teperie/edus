package service;

import java.util.List;

import javax.servlet.http.HttpSession;

import dao.MemberDao;
import dto.Member;

public class MemberServiceImpl implements MemberService {

	@Override
	public void makeMember(Member member) throws Exception {
		Member mem = MemberDao.select(member.getId());
		if(mem!=null) throw new Exception("중복이에용");
		MemberDao.insert(member);
	}

	@Override
	public Member searchById(String id) throws Exception {
		return MemberDao.select(id);
	}

	@Override
	public List<Member> allMemberInfo() throws Exception {
		return MemberDao.selectList();
	}

	@Override
	public Member matchIdPw(String id, String password) throws Exception {
		Member mem = MemberDao.select(id);
		if(mem==null) throw new Exception("아이디가 없어요");
		if(!mem.getPassword().equals(password)) throw new Exception("비밀번호가 틀렸어요");
		return mem;
	}

	@Override
	public void logout(HttpSession session) {
		session.removeAttribute("loginInfo");
	}

}