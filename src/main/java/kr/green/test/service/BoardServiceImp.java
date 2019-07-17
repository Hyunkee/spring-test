package kr.green.test.service;

import java.util.ArrayList;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import kr.green.test.dao.BoardDAO;
import kr.green.test.vo.BoardVO;
import kr.green.test.vo.MemberVO;

@Service
public class BoardServiceImp implements BoardService {
	@Autowired
	BoardDAO boardDao;

	@Override
	public ArrayList<BoardVO> getBoardList() {
		return boardDao.getBoardList();
	}

	@Override
	public BoardVO getBoard(Integer num) {
		if(num == null || num <= 0)
			return null;
		else
			return boardDao.getBoard(num);
	}

	@Override
	public void insertBoard(BoardVO boardVO) {		
		boardDao.insertBoard(boardVO);
	}

	@Override
	public void deleteBoard(BoardVO boardVO) {
		boardDao.deleteBoard(boardVO);
	}

	@Override
	public void modifyBoard(BoardVO nVo) {
		boardDao.updateBoard(nVo);		
	}
	
	@Override
	public boolean isWriter(HttpServletRequest r, Integer num) {
		MemberVO memberVO = (MemberVO)r.getSession().getAttribute("user");
		BoardVO boardVO = boardDao.getBoard(num);
		if(boardVO == null || memberVO == null)
			return false;
		if(boardVO.getWriter().equals(memberVO.getId())) {
			return true;
		}
		return false;
	}	
}
