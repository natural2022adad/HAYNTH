package model;

import java.util.List;

import dao.searchDAO;

public class GetSearchLogic {
	public List<Item> excute(Search word){
//		Search word =new Search("OO");
		System.out.println("word:"+word.getWord());
		searchDAO dao =new searchDAO();
		List<Item> result=dao.findword(word);
		System.out.println("result:"+result);
		return result;
	}


}
