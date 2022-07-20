package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Item;
import servlet.ItemCategoryServlet;

public class CategoryDAO {
	
	private final String JDBC_URL="jdbc:mysql://localhost:3306/haynth?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER="root";
	private final String DB_PASS="";
	
	public List<Item> findAll() {
		List<Item> ctgList = new ArrayList<>();
		System.out.println("new ArrayList<>()");
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			System.out.println("CtgDAOスタート");
			//ItemCategoryServleのkeyを持ってきたい
			String word = ItemCategoryServlet.key;
			int itemId = ItemCategoryServlet.numKey;
			String sql = null;
			System.out.println(word);
			if(word != null) {
				if(word.equals("allitem")) {
					sql = "SELECT * FROM `item` ";
					System.out.println(word+"sql実行");
				} else {
					sql = "SELECT * FROM `item` WHERE `CATEGORY` = '" + word +"'";
				}
			} else if(itemId > 0) {
				sql = "SELECT * FROM `item` WHERE `ITEM_ID` = " + itemId+";";
			}
			PreparedStatement pSmt = conn.prepareStatement(sql);
			//SELECTを実行して結果表を取得
			ResultSet rs = pSmt.executeQuery();
			
			//結果表に格納されたレコードの内容をインスタンスに設定し、ArrayListインスタンスに追加
			while (rs.next()) {
				System.out.println("while (rs.next())内");
				String category = rs.getString("CATEGORY");
				String name = rs.getString("NAME");
				String explanation = rs.getString("EXPLANATION");
				String image_path = rs.getString("IMAGE_PATH");
				System.out.println(image_path);
				int price= rs.getInt("PRICE");
				int quantity = rs.getInt("QUANTITY");
				int item_id = rs.getInt("ITEM_ID");
				Item item = new Item(category, name, explanation, image_path, price, quantity, item_id);
				ctgList.add(item);
				System.out.println("ArrayListに追加");
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return null;
		}
		System.out.println(ctgList);
		return ctgList;
	}
	
	public boolean deleteItem() {
		
		try {
			
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			System.out.println("CtgDAOスタートdeleteItem()");
			//ItemCategoryServleのkeyを持ってきたい
			String word = ItemCategoryServlet.key;
			int itemId = ItemCategoryServlet.numKey;
			String sql = null;
			System.out.println("word"+word);
			System.out.println("itemId"+itemId);
			if(word == null) {
				
				if(itemId > 0) {
					sql = "DELETE FROM `item` WHERE `ITEM_ID` =  " + itemId+";";
				}
			
			}
			PreparedStatement pSmt = conn.prepareStatement(sql);
			
			int result = pSmt.executeUpdate();//行数確認
			if (result != -1) {
				return false;
			}
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		System.out.println("true");
		return true;
	}

	
		
	
}

