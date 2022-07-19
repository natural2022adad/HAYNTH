package model;

import dao.CategoryDAO;

public class DeleteIitemLogic {
	public void execute(){
		System.out.println(" DeleteIitemLogic");
		CategoryDAO dao = new CategoryDAO(); 
		dao.deleteItem();
	}
}
