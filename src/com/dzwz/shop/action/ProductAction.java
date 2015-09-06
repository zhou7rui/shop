package com.dzwz.shop.action;

import java.util.HashMap;
import java.util.List;

import org.apache.struts2.ServletActionContext;

import com.dzwz.shop.model.Product;

public class ProductAction extends BaseAction<Product>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	public String productManage(){
		
		resultMap = new HashMap<String,Object>();
		List<Product> list = productService.QueryJoinProduct(model.getName(), page, rows);
		resultMap.put("rows", list);
		resultMap.put("total", productService.totalCategory(model.getName()));
		return "jsonSuccess";
	}
	
	
	public void save() throws Exception{
	    String filePath = ServletActionContext.getServletContext().getRealPath("/images");
		
		String pic = fileUplaod.uploadFile(fileImage,filePath);
		model.setPic(pic);
		//商品入库
		productService.save(model);
		
		
	}
}
