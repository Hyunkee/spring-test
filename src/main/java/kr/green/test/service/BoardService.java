package kr.green.test.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import kr.green.test.vo.BoardVO;

public interface BoardService {

	ArrayList<BoardVO> getBoardList();

	BoardVO getBoard(Integer i);

	public void insertBoard(BoardVO boardVO);

	public void deleteBoard(BoardVO boardVO);

	public void modifyBoard(BoardVO nVo);	

	boolean isWriter(HttpServletRequest r, Integer num);

	

	
	
}
