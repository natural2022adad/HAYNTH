package model;
import java.io.Serializable;

public class Kanri implements Serializable {
	
	private String category;
	private String itemName;
	private int itemPrice;
	private int itemQuat;
	private String itemExplan;
	public String getCategory() {
		return category;
	}

	public void setCategory(String category) {
		this.category = category;
	}

	public String getItemName() {
		return itemName;
	}

	public void setItemName(String itemName) {
		this.itemName = itemName;
	}

	public int getItemPrice() {
		return itemPrice;
	}

	public void setItemPrice(int itemPrice) {
		this.itemPrice = itemPrice;
	}

	public int getItemQuat() {
		return itemQuat;
	}

	public void setItemQuat(int itemQuat) {
		this.itemQuat = itemQuat;
	}

	public String getItemExplan() {
		return itemExplan;
	}

	public void setItemExplan(String itemExplan) {
		this.itemExplan = itemExplan;
	}

	public String getItemImg() {
		return itemImg;
	}

	public void setItemImg(String itemImg) {
		this.itemImg = itemImg;
	}

	private String itemImg;
	
	public Kanri(String category,String itemName,int itemPrice,int itemQuat,String itemExplan,String itemImg) {
		this.category = category;
		this.itemName = itemName;
		this.itemPrice = itemPrice;
		this.itemQuat = itemQuat;
		this.itemExplan = itemExplan;
		this.itemImg = itemImg;
	}

}



	


	
	