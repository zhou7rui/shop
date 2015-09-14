package com.dzwz.shop.service;



import java.util.HashSet;
import java.util.List;
import java.util.Set;

import net.sf.json.JSONSerializer;
import net.sf.json.test.JSONAssert;

import com.dzwz.shop.dao.SorderDao;
import com.dzwz.shop.model.Forder;
import com.dzwz.shop.model.Product;
import com.dzwz.shop.model.Sorder;

public class SorderServiceImpl extends BaseServiceImpl<Sorder> implements
		SorderService {
	
	public SorderDao sorderDao;
	 
	
	
	public void setSorderDao(SorderDao sorderDao) {
		this.sorderDao = sorderDao;
	}

	@Override
	public Forder addSorder(Forder forder, Product product) {
		Sorder sorder = productToSorder(product);
		boolean isHave = false;
		//判断是否重复
		for(Sorder old:forder.getSorders()){
			if(old.getProduct().getId().equals(sorder.getProduct().getId())){
				//有重复则添加商品
				old.setNumber(old.getNumber()+sorder.getNumber());
				isHave = true;
				break;
			}
		}
		//说明购物车中的商品不存在,添加
		if(!isHave){
			
			//建立购物项与购物车的联系，此时的forder.id为null,在库的时候是forder 先入库	
			sorder.setForder(forder);
			
			forder.getSorders().add(sorder);
		}
		return forder;
	}
	
	/**
	 * 将得到的商品信息放进购物项
	 * @author zrui
	 * @time 2015年9月8日16:51:12
	 * @vserion v.0.1
	 * 
	 */
	@Override
	public Sorder productToSorder(Product product) {
		Sorder sorder = new Sorder();
		sorder.setName(product.getName());
		sorder.setPrice(product.getPrice());
		sorder.setNumber(1);
		sorder.setProduct(product);
		return sorder;
	}

	@Override
	public Forder upadteSorder(Forder forder, Sorder sorder) {
		for(Sorder temp:forder.getSorders()){
			if(temp.getProduct().getId().equals(sorder.getId())){
				temp.setNumber(sorder.getNumber());
			}
		}
		return forder;
	}

	@Override
	public List<Object> querySale(int number) {
	
		return sorderDao.querySale(number);
	}
	
	
	
}
