package model;

import dao.ItemRegistDAO;


public class ItemRegistLogic {
	public void execute(Item mng) {
		ItemRegistDAO dao = new ItemRegistDAO();
		dao.create(mng);
	}
	//商品変更
	public void execute2(Item cng,Key Jbk) {
			System.out.println("sinItemChangeLogic");
			ItemRegistDAO dao = new ItemRegistDAO();
			dao.change(cng, Jbk);
		}
	/*public void execute(ItemChange cng) {
		ItemRegistDAO dao = new ItemRegistDAO();
		dao.recreate(cng);
	}*///上に移植したので必要ないはず
	

}
