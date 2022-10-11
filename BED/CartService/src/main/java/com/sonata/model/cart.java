package com.sonata.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class cart {
		
		@Id
		private long cart_id;
		private int prod_quantity;
		private String payment_mode;
		public long getCart_id() {
			return cart_id;
		}
		public void setCart_id(long cart_id) {
			this.cart_id = cart_id;
		}
		public int getProd_quantity() {
			return prod_quantity;
		}
		public void setProd_quantity(int prod_quantity) {
			this.prod_quantity = prod_quantity;
		}
		public String getPayment_mode() {
			return payment_mode;
		}
		public void setPayment_mode(String payment_mode) {
			this.payment_mode = payment_mode;
		}
		public cart(long cart_id, int prod_quantity, String payment_mode) {
			super();
			this.cart_id = cart_id;
			this.prod_quantity = prod_quantity;
			this.payment_mode = payment_mode;
		}
		public cart() {
			super();
			// TODO Auto-generated constructor stub
		}
		
		
		

}
