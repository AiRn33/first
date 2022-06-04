package com.bok.service;

import java.util.List;

import com.bok.domain.BoardVO;


public interface BoardService {

	void register(BoardVO vo);
	List<BoardVO> list(int userNumber);
	BoardVO get(int boardNumber);
	void modify(BoardVO vo);
	void remove(int boardNumber);
}
