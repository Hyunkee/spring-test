package kr.green.test.dao;

import kr.green.test.vo.MemberVO;

public interface MemberDAO {

	MemberVO getMember(String id);

	void memberShip(MemberVO mVo);

	void modify(MemberVO user);
	
}