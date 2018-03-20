package com.akshay.concurrencyStrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.springframework.transaction.annotation.Transactional;

@Entity
@Table(name = "CONCURRENCY_STRATEGY_Employee")
//@Cache(usage=CacheConcurrencyStrategy.READ_ONLY)    //this will not work if you are not enable secind level cache
//@Cache(usage=CacheConcurrencyStrategy.NONSTRICT_READ_WRITE)
//@Cache(usage=CacheConcurrencyStrategy.READ_WRITE)
@Cache(usage=CacheConcurrencyStrategy.TRANSACTIONAL)
public class CONCURRENCY_STRATEGY_Employee {

	@Id
	@GeneratedValue
	@Column(name = "ID", nullable = false)
	private int id;

	@Column(name = "USERNAME", nullable = false)
	private String username;

	@Column(name = "NAME", nullable = false)
	private String name;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
