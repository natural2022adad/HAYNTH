package model;

import dao.ItemRegistDAO;


public class ItemChangeLogic {
	public void execute(ItemChange cng) {
		System.out.println("ItemChangeLogic");
		ItemRegistDAO dao = new ItemRegistDAO();
		dao.change(cng);
	}

}
