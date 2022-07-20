package model;

public class Item {
	private String category;
	private String name;
	private String explanation;
	private String image_path;
	private int price;
	private int quantity;
	private int item_id;
	
	public Item(String category,String name,String explanation,String image_path,int price,int quantity,
			int item_id) {
		this.category =category;
		this.name=name;
		this.explanation=explanation;
		this.image_path=image_path;
		
		this.price=price;
		this.quantity=quantity;
		this.item_id=item_id;
	}
	public Item(String category,String name,String explanation,String image_path,int price,int quantity) {
		this.category =category;
		this.name=name;
		this.explanation=explanation;
		this.image_path=image_path;
		
		this.price=price;
		this.quantity=quantity;
		this.item_id=0;
	}


	public String getCategory() {
		return category;
	}

	public String getName() {
		return name;
	}

	public String getExplanation() {
		return explanation;
	}

	public String getImage_path() {
		return image_path;
	}

	public int getPrice() {
		return price;
	}

	public int getQuantity() {
		return quantity;
	}

	public int getItem_id() {
		return item_id;
	}
	

}
