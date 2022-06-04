package com.bok.domain;

import java.util.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private int userNumber;
	private int boardNumber;
	private String title;
	private String content;
	private Date createDay;
}
