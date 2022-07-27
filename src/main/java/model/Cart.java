package model;

import java.io.Serializable;

public class Cart implements Serializable {
	
	private int quantity;
	
	public Cart() {	}
	
	public Cart(int quantity) {
		this.quantity = quantity;;
		
	}

	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	

}
