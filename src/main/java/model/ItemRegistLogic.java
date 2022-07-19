package model;

import dao.ItemRegistDAO;


public class ItemRegistLogic {
	public void execute(ItemManage rgt) {
		ItemRegistDAO dao = new ItemRegistDAO();
		dao.create(rgt);
	}

}
