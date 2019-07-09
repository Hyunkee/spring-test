package kr.green.test.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.test.dao.MemberDAO;
import kr.green.test.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDao;
	
	@Override
	public boolean getId(MemberVO mVo) {
		if(mVo == null)
			return false; 
		MemberVO oVo = memberDao.getMember(mVo.getId());
		if(oVo == null)			
			return false; 
		if(oVo.getPw().equals(mVo.getPw()))		
			return true;		
		return false;		
	}
}
