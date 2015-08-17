package com.dzwz.shop.test;

import java.sql.SQLException;

import javax.annotation.Resource;
import javax.sql.DataSource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class) // 
@ContextConfiguration(locations="classpath:applicationContext-public.xml") // 
public class testDataSource {
	
	@Resource
	private DataSource dataSource;
	
	@Test
	public void testDataSource(){
		
//	    ApplicationContext act = new ClassPathXmlApplicationContext("applicationContext-public.xml");
//		DataSource dataSource = act.getBean(DataSource.class);
		try {
			System.out.println(dataSource.getConnection());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
