package org.jsp.one2oneBi;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;

@Entity
public class AadharCard {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	@Column(nullable = false, unique = true)
	private long number;

	@Column(nullable = false)
	private LocalDate dob;

	@Column(nullable = false)
	private String cirty;

	@OneToOne(mappedBy = "Card")
	private User user;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public long getNumber() {
		return number;
	}

	public void setNumber(long number) {
		this.number = number;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getCirty() {
		return cirty;
	}

	public void setCirty(String cirty) {
		this.cirty = cirty;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	@Override
	public String toString() {
		return "AadharCard [id=" + id + ", number=" + number + ", dob=" + dob + ", cirty=" + cirty + ", user=" + user
				+ "]";
	}

}
