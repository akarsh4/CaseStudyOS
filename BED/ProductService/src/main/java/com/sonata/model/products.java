package com.sonata.model;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class products {
	@Id
	private long  prod_id;
	private String prod_name;
	private String prod_category;
	private double prod_price;
	private String prod_color;
	private String prod_description;
	private String prod_image;

	
	public products(){
		
	}


	public products(long prod_id, String prod_name, String prod_category, double prod_price, String prod_color,
			String prod_description, String prod_image) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.prod_category = prod_category;
		this.prod_price = prod_price;
		this.prod_color = prod_color;
		this.prod_description = prod_description;
		this.prod_image = prod_image;
	}


	public long getProd_id() {
		return prod_id;
	}


	public void setProd_id(long prod_id) {
		this.prod_id = prod_id;
	}


	public String getProd_name() {
		return prod_name;
	}


	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}


	public String getProd_category() {
		return prod_category;
	}


	public void setProd_category(String prod_category) {
		this.prod_category = prod_category;
	}


	public double getProd_price() {
		return prod_price;
	}


	public void setProd_price(double prod_price) {
		this.prod_price = prod_price;
	}


	public String getProd_color() {
		return prod_color;
	}


	public void setProd_color(String prod_color) {
		this.prod_color = prod_color;
	}


	public String getProd_description() {
		return prod_description;
	}


	public void setProd_description(String prod_description) {
		this.prod_description = prod_description;
	}


	public String getProd_image() {
		return prod_image;
	}


	public void setProd_image(String prod_image) {
		this.prod_image = prod_image;
	}
	
	
}
