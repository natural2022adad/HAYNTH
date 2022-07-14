package dao;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public abstract class HaynthDAO {
	
	private final String JDBC_URL ="jdbc:mysql://localhost:3306/HAYNTH?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER = "root";
	private final String DB_PASS = "";
	
		
	public void find(){
	
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
		
	//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
	
		}catch (SQLException e) {
			e.printStackTrace();
		
		}
		return;
	}	

}
