package kr.green.test.service;

import org.springframework.stereotype.Service;

import kr.green.test.vo.MemberVO;

@Service
public interface MemberService {

	public boolean getId(MemberVO mVo);

	public MemberVO getLogin(MemberVO mVo);	

}
