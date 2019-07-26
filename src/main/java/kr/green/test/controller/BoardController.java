package kr.green.test.controller;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.test.pagination.Criteria;
import kr.green.test.pagination.PageMaker;
import kr.green.test.service.BoardService;
import kr.green.test.vo.BoardVO;

@Controller
public class BoardController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/board/list")	
	public String boardList(Model model, Criteria cri) {
		logger.info("페이징");
	    int totalCount = boardService.countBoard(cri);
	    
	    PageMaker pageMaker = new PageMaker();
	    //pageMaker의 displayPageNum 설정
	    pageMaker.setDisplayPageNum(2);
	    //pageMaker의 현재 페이지 정보 설정
	    pageMaker.setCriteria(cri);
	    //pageMakek의 총 게시글 수 설정
	    pageMaker.setTotalCount(totalCount);	    
	    ArrayList<BoardVO> list 
	        =  (ArrayList<BoardVO>)boardService.listPage(pageMaker.getCriteria());	    
	    model.addAttribute("list",list);
	    model.addAttribute("pageMaker", pageMaker);
	    return "/board/list";
	}
	@RequestMapping(value="/board/display",method=RequestMethod.GET)
	public String boardDisplayGet(Model model, Integer num) {
		BoardVO board = boardService.getBoard(num);
		model.addAttribute("board", board);
		return "board/display";
	}
	@RequestMapping(value="/board/insert",method=RequestMethod.GET)
	public String boardInsertGet() {
		//logger.info("insert페이지");
		return "board/insert";
	}
	@RequestMapping(value="/board/insert",method=RequestMethod.POST)
	public String boardInsertPost(BoardVO boardVO) {
		//logger.info("insert페이지 확인");		
		boardService.insertBoard(boardVO);		
		return "redirect:/board/list";
	}
	@RequestMapping(value="/board/delete",method=RequestMethod.GET)
	public String boardDeleteGet(BoardVO boardVO, HttpServletRequest r, Integer num) {
		//logger.info("delete 확인");		
		if(boardService.isWriter(r, num)) {
			boardService.deleteBoard(boardVO);
			return "redirect:/board/list";
		}			
		return "redirect:/board/list";
	}
	@RequestMapping(value="/board/modify",method=RequestMethod.GET)
	public String boardModifyGet(Model model,HttpServletRequest r,Integer num) {
		logger.info("modify페이지 실행");
		BoardVO bVo = boardService.getBoard(num);
		if(boardService.isWriter(r, num)) {
			model.addAttribute("board",bVo);
			return "/board/modify";
		}		
		return "redirect:/board/list";
	}
	@RequestMapping(value="/board/modify",method=RequestMethod.POST)
	public String boardModifyPost(BoardVO nVo) {
		logger.info("modify페이지 등록 ");		
		boardService.modifyBoard(nVo);
		return "redirect:/board/list";
	}	
}