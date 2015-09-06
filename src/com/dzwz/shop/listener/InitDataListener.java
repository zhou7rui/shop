package com.dzwz.shop.listener;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.dzwz.shop.model.Product;

import com.dzwz.shop.dao.CategoryDao;
import com.dzwz.shop.dao.ProductDao;
import com.dzwz.shop.model.Category;



/**
 * 用与项目启动的时候初始化
 * @author zrui
 * @time 2015年9月6日17:41:55
 * @version v.0.1
 *
 */



public class InitDataListener implements ServletContextListener {
	
	ApplicationContext context=null;
	ProductDao productDao = null;
	CategoryDao categoryDao = null;

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		//1.获取业务逻辑查询商品信息
		
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		
		//ServletContext 中获取Sping 配置信息
		 context = WebApplicationContextUtils.getWebApplicationContext(event.getServletContext());	
		 categoryDao  = (CategoryDao) context.getBean("categoryDao");
		 productDao  = (ProductDao) context.getBean("productDao");
		 
		 System.out.println(productDao);
		 List<List<Product>> proList = new ArrayList<>();
		 
		 for (Category category : categoryDao.queryBycut(true)) {
			 proList.add(productDao.querybycid(category.getId()));
		}
		 //把查询的信息放入applicaion
		 
		 event.getServletContext().setAttribute("proList", proList);
	}

}
