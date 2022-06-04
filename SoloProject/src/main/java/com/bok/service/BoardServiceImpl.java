package com.bok.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bok.domain.BoardVO;
import com.bok.domain.UserVO;
import com.bok.mapper.BoardMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //final 클래스 주입
public class BoardServiceImpl implements BoardService{
	
	private final BoardMapper mapper;

	@Override
	public void register(BoardVO vo) {
		
		mapper.register(vo);
	}

	@Override
	public List<BoardVO> list(int userNumber) {
		return mapper.list(userNumber);
	}

	@Override
	public BoardVO get(int boardNumber) {
		return mapper.get(boardNumber);
	}

	@Override
	public void modify(BoardVO vo) {
		mapper.modify(vo);
	}

	@Override
	public void remove(int boardNumber) {
		mapper.remove(boardNumber);
	}
	
}
