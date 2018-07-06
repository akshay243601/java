package com.akshay.ejbBeans;

import javax.ejb.Stateless;

@Stateless
public class StatelessEJB {

	private int i, j, k;

	public int getI() {
		return i;
	}

	public void setI(int i) {
		this.i = i;
	}

	public int getJ() {
		return j;
	}

	public void setJ(int j) {
		this.j = j;
	}

	public int getK() {
		return k;
	}

	public void setK(int k) {
		this.k = k;
	}

	public void add() {
		k = i + j;
	}
}
