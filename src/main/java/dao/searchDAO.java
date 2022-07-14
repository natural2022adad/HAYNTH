package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Item;
import model.Search;
import sql_logic.AllSearchDAO_sql_logic;


public class searchDAO {
	private final String JDBC_URL="jdbc:mysql://localhost:3306/haynth?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER="root";
	private final String DB_PASS="";

//　検索ワードをデータベースから見つける
public List<Item> findword(Search word) {
	List<Item> itemlist=new ArrayList<>();
	
	AllSearchDAO_sql_logic sql_logic=new AllSearchDAO_sql_logic();
	try {
		Class.forName("com.mysql.jdbc.Driver");
	} catch (ClassNotFoundException e1) {
		// TODO: handle exception
		e1.printStackTrace();
	}
	
	//データベース接続
	 try(Connection conn=DriverManager.getConnection(JDBC_URL,DB_USER,DB_PASS)){

		 
		 //SQL文　検索ワードを挿入
		 String sql=sql_logic.ALL_SEARCH(word.getWord()); 
		 PreparedStatement pStmt=conn.prepareStatement(sql);
		 
		 //sql
		 System.out.println(sql);
		 
		 ResultSet rs=pStmt.executeQuery();
		 
		 System.out.println(rs);
		 
		 //リストに検索結果を保存
		 while(rs.next()) {
			 String category=rs.getNString("CATEGORY");
			 //中身
			 System.out.println(category);
			 
			 String name=rs.getNString("NAME");
			 String explanation=rs.getNString("EXPLANATION");
			 String image_path=rs.getNString("IMAGE_PATH");
			 int item_id=rs.getInt("ITEM_ID");
			 int price=rs.getInt("PRICE");
			 int quantity=rs.getInt("QUANTITY");
			 Item item=new Item(category,name,explanation,image_path,price,quantity,item_id);
			 itemlist.add(item);
			//カテゴリー
			 System.out.println("LIST;"+item.getCategory());
		 }
	 }catch(SQLException e) {
		 e.printStackTrace();
		 return null;
	 }

	return null;
}
}
