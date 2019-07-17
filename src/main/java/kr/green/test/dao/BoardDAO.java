package kr.green.test.dao;

import java.util.ArrayList;

import kr.green.test.vo.BoardVO;

public interface BoardDAO {

	ArrayList<BoardVO> getBoardList();

	BoardVO getBoard(Integer num);

	void insertBoard(BoardVO boardVO);

	void deleteBoard(BoardVO boardVO);

	void updateBoard(BoardVO nVo);	

}

