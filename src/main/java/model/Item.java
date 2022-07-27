package model;

public class Item {
	private String category;
	private String name;
	private String explanation;
	private String image_path;
	private String image_path2;
	private String image_path3;
	private int price;
	private int quantity;
	private int item_id;
	
	public Item(String category,String name,String explanation,String image_path,String image_path2,String image_path3,int price,int quantity,
			int item_id) {
		this.category =category;
		this.name=name;
		this.explanation=explanation;
		this.image_path=image_path;
		this.image_path2=image_path2;
		this.image_path3=image_path3;
		
		this.price=price;
		this.quantity=quantity;
		this.item_id=item_id;
	}
	public Item(String category,String name,String explanation,String image_path,int price,int quantity,
			int item_id) {
		this.category =category;
		this.name=name;
		this.explanation=explanation;
		this.image_path=image_path;
		this.image_path2=null;
		this.image_path3=null;
		
		this.price=price;
		this.quantity=quantity;
		this.item_id=item_id;
	}
	public Item(String category,String name,String explanation,String image_path,String image_path2,String image_path3,int price,int quantity) {
		this.category =category;
		this.name=name;
		this.explanation=explanation;
		this.image_path=image_path;
		this.image_path2=image_path2;
		this.image_path3=image_path3;
		
		this.price=price;
		this.quantity=quantity;
		this.item_id=0;
	}
	public Item(String category,String name,String explanation,String image_path,int price,int quantity) {
		this.category =category;
		this.name=name;
		this.explanation=explanation;
		this.image_path=image_path;
		this.image_path2=null;
		this.image_path3=null;
		
		this.price=price;
		this.quantity=quantity;
		this.item_id=0; //item_idを取得できない時に使う
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

	public String getImage_path2() {
		return image_path2;
	}
	public String getImage_path3() {
		return image_path3;
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
