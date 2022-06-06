package com.spring.mapper;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TestMappers implements TestMapper{

	
	private final TestMapper mapper;
	
	public int selectTest() {
		return mapper.selectTest();
	}

}
