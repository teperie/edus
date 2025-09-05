package service;

import dao.MemberDAO;
import dto.Member;

public class MemberServiceImpl implements MemberService {

	@Override
	public void join(Member member) throws Exception {
		Member smember = MemberDAO.select(member.getId());
		if(smember!=null) throw new Exception("기존 가입된 회원입니다.");
		MemberDAO.insert(member);
	}

	@Override
	public Member login(String id, String password) throws Exception {
		Member member = MemberDAO.select(id);
		if(member==null) throw new Exception("아이디가 틀립니다.");
		if(!member.getPassword().equals(password)) throw new Exception("비밀번호가 틀립니다.");
		return member;
	}
}
