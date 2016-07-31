package com.mobilions.fxonline;

import java.io.Serializable;

public class TabRow implements Serializable {

	private static final long serialVersionUID = 1L;
	String cur;
	double pos1;
	double pos2;
	
	int age;
	double pnl;
	double book;
	double mkt;
	 
	public TabRow(String cur, double pos1, double pos2, int age, double pnl,
			double book, double mkt) {
		super();
		this.cur = cur;
		this.pos1 = pos1;
		this.pos2 = pos2;
		this.age = age;
		this.pnl = pnl;
		this.book = book;
		this.mkt = mkt;
	}
	
	
}

