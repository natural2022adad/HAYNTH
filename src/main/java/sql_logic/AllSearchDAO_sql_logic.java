package sql_logic;

public class AllSearchDAO_sql_logic {
	public String ALL_SEARCH(String comand) {
		String  sql="SELECT * FROM item WHERE CATEGORY LIKE \"%"+comand+"%\" \n"
				+ "OR NAME LIKE \"%"+comand+"%\" \n"
				+ "OR EXPLANATION LIKE \"%"+comand+"%\"; ";
		return sql;
	}

}
