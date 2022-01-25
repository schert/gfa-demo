package com.example.gfaBe.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

/**
 * The type Test.
 */
@Entity
@Table(name = "TestTable")
@EntityListeners(AuditingEntityListener.class)
public class Test {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long id;
	@Column(name = "VAL_1", nullable = true)
	private String val_1;
	@Column(name = "VAL_A", nullable = true)
	private String val_2;

	public Test(String val_1, String val_2) {
		super();
		this.val_1 = val_1;
		this.val_2 = val_2;
	}
	
	public String getVal_2() {
		return val_2;
	}

	public void setVal_2(String val_2) {
		this.val_2 = val_2;
	}

	public void setVal_1(String val_1) {
		this.val_1 = val_1;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getVal_1() {
		return val_1;
	}

	public void setFirstName(String val_1) {
		this.val_1 = val_1;
	}

	@Override
	public String toString() {
		return "Test [id=" + id + ", val_1=" + val_1 + ", val_2=" + val_2 + "]";
	}
}
