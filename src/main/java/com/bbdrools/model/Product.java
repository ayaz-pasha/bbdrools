package com.bbdrools.model;

import java.util.List;

import lombok.Data;

@Data
public class Product {

	private int id;
	private String name;
	private String desc;
	private double mrp;
	private double sp;
	private double cp;
	
	private List<Discount> discounts;
}
