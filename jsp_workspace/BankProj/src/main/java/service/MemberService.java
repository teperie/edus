package service;

import java.util.List;

import javax.servlet.http.HttpSession;

import dto.Member;

public interface MemberService {
	void makeMember(Member acc) throws Exception;

	Member searchById(String id) throws Exception;

	List<Member> allMemberInfo() throws Exception;
	
	Member matchIdPw(String id, String password) throws Exception;
	
	void logout(HttpSession session);
}