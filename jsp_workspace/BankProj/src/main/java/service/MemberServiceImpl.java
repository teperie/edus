package service;

import java.util.List;

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

}
