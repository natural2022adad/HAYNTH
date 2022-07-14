package model;

import dao.KanriDAO;

public class KanriLogic {
	public void execute(Kanri kanri) {
		KanriDAO dao = new KanriDAO();
		dao.create(kanri);
	}
}
