package org.pilger.model.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;


@Entity
public class Role extends Superclass implements Serializable {

	private static final long serialVersionUID = 1L;

	@Column(unique = true)
	private String rolename;

	public String getRolename() {
		return rolename;
	}

	public void setRolename(String rolename) {
		this.rolename = rolename;
	}

}
