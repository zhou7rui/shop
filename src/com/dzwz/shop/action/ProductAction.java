package com.dzwz.shop.action;

import java.io.ByteArrayInputStream;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.apache.struts2.ServletActionContext;

import com.dzwz.shop.model.Product;

public class ProductAction extends BaseAction<Product>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	/**
	 *  商品查询
	 * @author zrui
	 * @time 2015年9月7日15:35:57
	 * @version v.0.1
	 */
	
	public String productManage(){
		
		resultMap = new HashMap<String,Object>();
		List<Product> list = productService.QueryJoinProduct(model.getName(), page, rows);
		resultMap.put("rows", list);
		resultMap.put("total", productService.totalCategory(model.getName()));
		return "jsonSuccess";
	}
	
	/**
	 *  商品添加 
	 * @author zrui
	 * @throws Exception
	 * @time 2015年9月7日15:35:57
	 * @version v.0.1
	 */
	public void save() throws Exception{
	    String filePath = ServletActionContext.getServletContext().getRealPath("/images");
		
		String pic = fileUplaod.uploadFile(fileImage,filePath);
		model.setPic(pic);
		//商品入库
		productService.save(model);
	}
	
	/**
	 * 类别删除
	 * @author zrui
	 * @time 2015年8月27日17:14:05
	 * @version v.0.1
	 */
	public String deleteByids(){
		
		System.out.println(ids);
		productService.deleteByids(ids);
		inputStream = new ByteArrayInputStream("true".getBytes());
		return "stream";
	}
	
	
	/**
	 * 类别更新
	 * @author zrui
	 * @time 2015年9月7日15:40:33
	 * @version v.0.1
	 */
	public void update(){
		System.out.println(model);
		productService.update(model);
		
	}
	
	/**
	 * 根据id 查询商品信息
	 *	@author zrui
	 * @time 2015年9月7日15:40:33
	 * @version v.0.1
	 * 
	 */
	public String queryByid(){
		request.put("product", productService.queryByid(model.getId()));
		return "detail";
	}
	
	//搜索参数
	private String q;
	
	public String getQ() {
		return q;
	}

	public void setQ(String q) {
		this.q = q;
	}

	/**
	 * 
	 * 商品搜索
	 * @author zrui
	 * @time 2015年10月20日17:38:17
	 * @version v0.1
	 * @return
	 */
	public String search(){
		if(page == 0){
			page = 1;
		}
	  //根据商品名查询 及分页支持
	  List<Product> productinfo;
	
		System.out.println(q);
		productinfo = productService.QueryJoinProduct(q.toString(),page , 10);
		request.put("productinfo", productinfo);
	  return "productinfo";
	
	}
	
	
	
}
