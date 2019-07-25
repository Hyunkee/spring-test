package kr.green.test.dao;

import java.util.ArrayList;
import java.util.List;

import kr.green.test.pagination.Criteria;
import kr.green.test.vo.BoardVO;

public interface BoardDAO {

	ArrayList<BoardVO> getBoardList();

	BoardVO getBoard(Integer num);

	void insertBoard(BoardVO boardVO);

	void deleteBoard(BoardVO boardVO);

	void updateBoard(BoardVO nVo);

	int countBoard(Criteria cri);

	List<BoardVO> listPage(Criteria criteria);

	
	

}

