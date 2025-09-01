package service;

import java.util.List;

import dto.Member;

public interface MemberService {
	void makeMember(Member acc) throws Exception;

	Member searchById(String id) throws Exception;

	List<Member> allMemberInfo() throws Exception;
}
