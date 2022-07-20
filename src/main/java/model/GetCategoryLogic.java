package model;

import java.util.List;

import dao.CategoryDAO;

public class GetCategoryLogic {
	
	public List<Item> execute() {
		System.out.println(" GetCategoryLogic");
	CategoryDAO dao = new CategoryDAO();
	List<Item> ctgList = dao.findAll();
	return ctgList;
	}

}
