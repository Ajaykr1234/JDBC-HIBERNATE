package org.jsp.product.dto;

public class ProductDetails {

	private int id;
	private String pname;
	private String brand;
	private String cate;
	private String desce;
	private double cost;
	private String imgUrl;

	public ProductDetails() {

	}

	public ProductDetails(int id, String pname, String brand, String cate, String desce, double cost, String imgUrl) {
		this.id = id;
		this.pname = pname;
		this.brand = brand;
		this.cate = cate;
		this.desce = desce;
		this.cost = cost;
		this.imgUrl = imgUrl;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public String getBrand() {
		return brand;
	}

	public void setBrand(String brand) {
		this.brand = brand;
	}

	public String getCate() {
		return cate;
	}

	public void setCate(String cate) {
		this.cate = cate;
	}

	public String getDesce() {
		return desce;
	}

	public void setDesce(String desce) {
		this.desce = desce;
	}

	public double getCost() {
		return cost;
	}

	public void setCost(double cost) {
		this.cost = cost;
	}

	public String getImgUrl() {
		return imgUrl;
	}

	public void setImgUrl(String imgUrl) {
		this.imgUrl = imgUrl;
	}

}
