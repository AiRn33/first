package com.spring.controller;


import java.sql.Connection;

import javax.inject.Inject;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class MySqlTests {
	
	
	@Inject
	private DataSource ds;
	
	@Test
	public void testCOnnection() throws Exception {
		try(Connection con = ds.getConnection()){
			System.out.println(con);
		}catch(Exception e)
		{
			System.out.println("씨발 오류요");
			e.printStackTrace();
		}
	}
	
}
