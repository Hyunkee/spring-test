package kr.green.test;



import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.test.dao.testDAO;

@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Autowired
	testDAO testDAO;
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home() {
		logger.info("페이지 실행");
		
		String test = testDAO.getEmail("123456789");
		System.out.println(test);
		return "home";
	}
	
}
