package org.jsp.one2manyBi;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Merchant {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false)
	private String name;

	@Column(nullable = false, unique = true)
	private String gst_number;

	@Column(nullable = false, unique = true)
	private long pnone;

	@Column(nullable = false)
	private String password;

	@OneToMany(cascade = CascadeType.ALL, mappedBy = "merchant")
	private List<Product> product;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getGst_number() {
		return gst_number;
	}

	public void setGst_number(String gst_number) {
		this.gst_number = gst_number;
	}

	public long getPnone() {
		return pnone;
	}

	public void setPnone(long pnone) {
		this.pnone = pnone;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public List<Product> getProduct() {
		return product;
	}

	public void setProduct(List<Product> product) {
		this.product = product;
	}

	@Override
	public String toString() {
		return "Merchant [id=" + id + ", name=" + name + ", gst_number=" + gst_number + ", pnone=" + pnone
				+ ", password=" + password + "]";
	}

}
