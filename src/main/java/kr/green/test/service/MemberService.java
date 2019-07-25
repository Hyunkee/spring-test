package kr.green.test.service;

import org.springframework.stereotype.Service;

import kr.green.test.vo.MemberVO;

@Service
public interface MemberService {

	public boolean getId(MemberVO mVo);

	public MemberVO getLogin(MemberVO mVo);

	public void memberShip(MemberVO mVo);

	public String getVal(String str);

	public boolean isMember(String id, String email);

	public void sendEmail(String title, String contents, String email);

	public void modify(String id, String newPw);

	public void modify(MemberVO mVo);	

}
