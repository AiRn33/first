package com.bok.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.bok.domain.BoardVO;
import com.bok.domain.UserVO;
import com.bok.mapper.UserMapper;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor //final 클래스 주입
public class UserServiceImpl implements UserService {
	
	private final UserMapper mapper;
	
	public void joinMember(UserVO vo) {
		
		mapper.joinMember(vo);
	}

	public int login(UserVO vo) {
		
		
		return mapper.login(vo);
	}

	@Override
	public int idcheck(UserVO vo) {

		return mapper.idcheck(vo);
	}

	@Override
	public List<BoardVO> boardCheck(int userNumber) {
		return mapper.boardCheck(userNumber);
	}

	@Override
	public UserVO userGet(int userNumber) {
		return mapper.userGet(userNumber);
	}


}
