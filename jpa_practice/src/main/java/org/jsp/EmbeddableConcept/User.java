package org.jsp.EmbeddableConcept;

import javax.persistence.EmbeddedId;
import javax.persistence.Entity;

@Entity
public class User {

	private String name;

	private String password;

	@EmbeddedId
	private UserPrimaryKey primarykey;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public UserPrimaryKey getPrimarykey() {
		return primarykey;
	}

	public void setPrimarykey(UserPrimaryKey primarykey) {
		this.primarykey = primarykey;
	}

	@Override
	public String toString() {
		return "User [name=" + name + ", password=" + password + ", primarykey=" + primarykey + "]";
	}

}
