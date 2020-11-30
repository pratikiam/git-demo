package com.crs.demo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import org.hibernate.annotations.Type;

@Entity
@Table(name="Abc")
public class MenuMasterEntity extends Auditable{	
	@Id	
	@Column(name="cateid")
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int categoryid;
	
	@Column(name="descr")
	private String description;
	
	@Column(name="pareid")
	private int parentid;
	
	
	
	@Override
	public String toString() {
		return "MenuMasterEntity [parentid=" + parentid + ", description=" + description + ", categoryid=" + categoryid
				+ "]";
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public int getParentid() {
		return parentid;
	}

	public void setParentid(int parentid) {
		this.parentid = parentid;
	}


	public int getCategoryid() {
		return categoryid;
	}

	public void setCategoryid(int categoryid) {
		this.categoryid = categoryid;
	}

	
	

}

