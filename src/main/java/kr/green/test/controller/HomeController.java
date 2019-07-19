package kr.green.test.controller;



import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

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
	public String getHome(Model model, String id) {
		//logger.info("페이지 실행");
		
		//String email = memberDAO.getEmail(id);
		//System.out.println(email);
		//model.addAttribute("email",email);
		return "home";
	}
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public String postHome(Model model, String id) {
		//logger.info("페이지 실행중");
		
		//String email = memberDAO.getEmail(id);
		//System.out.println(email);
		//model.addAttribute("email",email);
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
}
