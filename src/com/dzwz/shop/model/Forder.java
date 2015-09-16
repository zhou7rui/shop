package com.dzwz.shop.model;


import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * Forder entity. @author MyEclipse Persistence Tools
 */

public class Forder implements java.io.Serializable {

	// Fields

	private Integer id;
	private User user;
	private Status status;
	private String name;
	private String phone;
	private String remak;
	private Double price;
	private Date createdate;
	private String post;
	private String address;
	private List<Sorder> sorders = new CopyOnWriteArrayList<Sorder>();

	// Constructors

	/** default constructor */
	public Forder() {
	}
	
	

	public Forder(CopyOnWriteArrayList sorders) {
		super();
		this.sorders = sorders;
	}



	// Property accessors

	@Override
	public String toString() {
		return "Forder [id=" + id + ", user=" + user + ", status=" + status
				+ ", name=" + name + ", phone=" + phone + ", remak=" + remak
				+ ", price=" + price + ", createdate=" + createdate + ", post="
				+ post + ", address=" + address + ", sorders=" + sorders + "]";
	}



	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public User getUser() {
		return this.user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return this.phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getRemak() {
		return this.remak;
	}

	public void setRemak(String remak) {
		this.remak = remak;
	}

	public Double getPrice() {
		return this.price;
	}

	public void setPrice(Double price) {
		this.price = price;
	}

	public Date getCreatedate() {
		return this.createdate;
	}

	public void setCreatedate(Date createdate) {
		this.createdate = createdate;
	}

	public String getPost() {
		return this.post;
	}

	public void setPost(String post) {
		this.post = post;
	}

	public String getAddress() {
		return this.address;
	}

	public void setAddress(String address) {
		this.address = address;
	}



	public List<Sorder> getSorders() {
		return sorders;
	}



	public void setSorders(List<Sorder> sorders) {
		this.sorders = sorders;
	}


}