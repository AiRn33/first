package com.bok.service;

import java.util.List;

import com.bok.domain.BoardVO;
import com.bok.domain.UserVO;

public interface UserService {

	void joinMember(UserVO vo);
	int login(UserVO vo);
	int idcheck(UserVO vo);
	List<BoardVO> boardCheck(int userNumber);
	UserVO userGet(int userNumber);
}
