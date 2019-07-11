package kr.green.test.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.green.test.service.BoardService;
import kr.green.test.vo.BoardVO;

@Controller
public class BoardController {
	@Autowired
	BoardService boardService;
	
	@RequestMapping(value="/board/list",method=RequestMethod.GET)
	public String boardListGet(Model model) {
		ArrayList<BoardVO> list = boardService.getBoardList();
		/*
		for(BoardVO tmp:list) {
			System.out.println(tmp);
		}
		*/
		
		model.addAttribute("list", list);
		return "board/list";
	}
	@RequestMapping(value="/board/display",method=RequestMethod.GET)
	public String boardDisplayGet(Model model, Integer num) {
		BoardVO board = boardService.getBoard(num);
		
		System.out.println(board);
		
		model.addAttribute("board", board);
		return "board/display";
	}
}