package kr.green.test.controller;



import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	MemberService memberService;	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String homeGet(Model model, String id) {
		//logger.info("페이지 실행");
		
		//String email = memberDAO.getEmail(id);
		//System.out.println(email);
		//model.addAttribute("email",email);
		return "home";
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String homePost(Model model, String id) {
		//logger.info("페이지 실행중");
		
		//String email = memberDAO.getEmail(id);
		//System.out.println(email);
		//model.addAttribute("email",email);
		return "redirect:/";
	}
	@RequestMapping(value = "/member", method = RequestMethod.GET)
	public String memberGet() {		
		return "member";
	}
	@RequestMapping(value = "/member", method = RequestMethod.POST)
	public String memberPost(MemberVO mVo) {
		memberService.memberShip(mVo);
		return "redirect:/";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() {
		//logger.info("로그인페이지 확인");
		
		return "login";		
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(Model model, MemberVO mVo) {
		//logger.info("로그인페이지 실행");
		
		MemberVO user = memberService.getLogin(mVo);
		if(user != null) {
			model.addAttribute("user",user);
			return "redirect:/";
		}
		return "redirect:/login";
	}
	@RequestMapping(value = "/nav", method = RequestMethod.GET)
	public String navGet() {
		//logger.info("nav페이지 확인");
		
		return "nav";		
	}
	@RequestMapping(value = "/logout", method = RequestMethod.GET)
	public String logoutGet(HttpServletRequest request) {
		//logger.info("로그아웃 실행");		
		HttpSession session = request.getSession();
		session.removeAttribute("user");
		return "redirect:/";	
	}
	@RequestMapping(value = "/password/find", method = RequestMethod.GET)
	public String passwordFindGet() {
		logger.info("비밀번호 찾기 페이지");		
		return "find";
	}
	@RequestMapping(value ="/checkemail")
	@ResponseBody
	public Map<Object, Object> emailcheck(@RequestBody String str){
	    Map<Object, Object> map = new HashMap<Object, Object>();
	    try {
			str = URLDecoder.decode(str, "UTF-8");
		} catch (UnsupportedEncodingException e) {
			e.printStackTrace();
		}
	    String [] tmpStr = str.split("&");
	    String id = memberService.getVal(tmpStr[0]);
	    String email = memberService.getVal(tmpStr[1]);
	    boolean isMember = memberService.isMember(id,email); 
	    map.put("isMember", isMember);	    		
	    return map;
	}
	@RequestMapping(value = "/password/send", method = RequestMethod.POST)
	public String passwordSendPost(String id, String email) {
		logger.info("비밀번호 생성하여 메일 보내기");
		String str ="0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ`~!@#$%^&*()_";
		String newPw ="";
		while(newPw.length() <8) {
			int index = (int)(Math.random()*str.length());
			newPw += str.charAt(index); // charAt 내가 원하는 문자열에서 하나의 문자를 꺼낼때 쓰임
		}
		String title ="변경된 비밀번호입니다.";
		String contents ="변경된 비밀번호입니다.\n"+newPw;
		memberService.sendEmail(title,contents,email);
		memberService.modify(id,newPw);
		return "redirect:/";
	}
	@RequestMapping(value = "/member/modify", method = RequestMethod.GET)
	public String memberModifyGet() {
		logger.info("회원 정보 수정 페이지");		
		return "modify";
	}
	@RequestMapping(value = "/member/modify", method = RequestMethod.POST)
	public String memberModifyPost(MemberVO mVo) {
		logger.info("회원 정보 수정 완료");
		//System.out.println(mVo);
		memberService.modify(mVo);
		return "redirect:/";
	}
}
