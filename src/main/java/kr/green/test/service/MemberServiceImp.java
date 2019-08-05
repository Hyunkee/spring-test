package kr.green.test.service;

import javax.mail.internet.MimeMessage;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import kr.green.test.dao.MemberDAO;
import kr.green.test.vo.MemberVO;

@Service
public class MemberServiceImp implements MemberService {

	@Autowired
	MemberDAO memberDao;
	@Autowired
	BCryptPasswordEncoder passwordEncoder;
	@Autowired
	private JavaMailSender mailSender;
	
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

	@Override
	public MemberVO getLogin(MemberVO mVo) {
		if(mVo == null)
			return null;
		MemberVO gVo = memberDao.getMember(mVo.getId());
		if(gVo == null)			
			return null; 
		if(passwordEncoder.matches(mVo.getPw(), gVo.getPw()))		
			return gVo;
		return null;
	}

	@Override
	public void memberShip(MemberVO mVo) {
		if(mVo == null)
			return;
		String encPw = passwordEncoder.encode(mVo.getPw());
		mVo.setPw(encPw);
		memberDao.memberShip(mVo);
	}

	@Override
	public String getVal(String str) {
		String [] tmpStr = str.split("=");
		if(tmpStr.length != 2)
			return null;
		return tmpStr[1];
		// 예를들어 id=123이면 tmpStr[0]에는 id가 tmpStr[1]에는 123 이 저장이된다. 
	}

	@Override
	public boolean isMember(String id, String email) {
		MemberVO user = memberDao.getMember(id);
		if(user != null && user.getEmail().equals(email))
			return true;
		return false;
	}

	@Override
	public void sendEmail(String title, String contents, String email) {
		try {
	        MimeMessage message = mailSender.createMimeMessage();
	        MimeMessageHelper messageHelper 
	            = new MimeMessageHelper(message, true, "UTF-8");
	        String setfrom ="lkokvke33@gmail.com";
	        messageHelper.setFrom(setfrom);  // 보내는사람 생략하거나 하면 정상작동을 안함
	        messageHelper.setTo(email);     // 받는사람 이메일
	        messageHelper.setSubject(title); // 메일제목은 생략이 가능하다
	        messageHelper.setText(contents);  // 메일 내용

	        mailSender.send(message);
	    } catch(Exception e){
	        System.out.println(e);
	    }
		
	}

	@Override
	public void modify(String id, String newPw) {
		MemberVO user = memberDao.getMember(id);
		if(user == null) 
			return ;
		String encPw = passwordEncoder.encode(newPw);
		user.setPw(encPw);
		memberDao.modify(user);
	}

	@Override
	public MemberVO modify(MemberVO mVo, String oldPw) {
		if(mVo == null)
			return null;
		MemberVO oVo = memberDao.getMember(mVo.getId());
		if(!passwordEncoder.matches(oldPw, oVo.getPw()))
			return null;
		if(mVo.getPw().length() == 0) {
			mVo.setPw(oVo.getPw());
		}else {
			String encPw= passwordEncoder.encode(mVo.getPw());
			mVo.setPw(encPw);
		}
		memberDao.modify(mVo);
		return mVo;
	}

	
	// 회원 정보 수정을 했을시 DB에는 정보가 실시간으로 업데이트가 되지만 
	// 현재 페이지에서는(jsp) 현재 유저의 정보가 업데이트가 되지 않기 때문에
	// 현재 유저의 정보가 업데이트 되도록 설정 해주어야 한다.
	@Override
	public boolean updateUserToSession(HttpServletRequest r, MemberVO nUser) {
		if(nUser == null)
			return false;
		HttpSession s = r.getSession();
		s.removeAttribute("user"); // 이전 회원정보 제거
		s.setAttribute("user", nUser); // 새 회원 정보 추가
		return true;
	}

	

//	@Override
//	public void modify(MemberVO mVo) {
//		if(mVo == null)
//			return;
//		String emptyPw = mVo.getPw();		
//		MemberVO oVo = memberDao.getMember(mVo.getId());		
//		String encPw = passwordEncoder.encode(mVo.getPw());
//		if(emptyPw == "") {
//			mVo.setPw(oVo.getPw());
//		}else {
//		}
//		memberDao.modify(mVo);
//		
//	}
}
