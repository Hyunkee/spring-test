package kr.green.test.controller;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.test.dao.MemberDAO;
import kr.green.test.service.MemberService;
import kr.green.test.vo.MemberVO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	MemberService memberService;
	
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model, String id) {
		logger.info("페이지 실행");
		
		//String email = memberDAO.getEmail(id);
		//System.out.println(email);
		//model.addAttribute("email",email);
		return "login";
	}
	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public String loginGet() {
		logger.info("로그인페이지 실행");
		
		return "login";		
	}
	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public String loginPost(MemberVO mVo) {
		logger.info("로그인페이지 확인");
		
		if(memberService.getId(mVo)) {
			return "redirect:/";
		}
		return "redirect:/login";
	}
}
