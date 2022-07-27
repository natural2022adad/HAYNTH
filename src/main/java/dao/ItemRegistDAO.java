package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import model.Item;
import model.Key;

public class ItemRegistDAO {
	private final String JDBC_URL="jdbc:mysql://localhost:3306/haynth?characterEncoding=UTF-8&serverTimezone=JST";
	private final String DB_USER="root";
	private final String DB_PASS="";
	
	public boolean create(Item rgt) {
try {
			
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e1) {
			// TODO: handle exception
			e1.printStackTrace();
		}
//データベースへ接続
		try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
			
			//INSERT文の準備（idは自動連番なので指定しなくてもよい）
			String sql = "INSERT INTO ITEM(CATEGORY, NAME, EXPLANATION, PRICE, QUANTITY, IMAGE_PATH, IMAGE_PATH2, IMAGE_PATH3) VALUES(?, ?, ?, ?, ? ,? , ?, ?)";
			PreparedStatement pSmt = conn.prepareStatement(sql);
			
			// INSERT文中の「？」に使用する値を設定しSQLを完成
			pSmt.setString(1, rgt.getCategory());
			pSmt.setString(2, rgt.getName());
			pSmt.setString(3, rgt.getExplanation());
			pSmt.setInt(4, rgt.getPrice());
			pSmt.setInt(5, rgt.getQuantity());
			pSmt.setString(6, rgt.getImage_path());
			pSmt.setString(7, rgt.getImage_path2());
			pSmt.setString(8, rgt.getImage_path3());
			
			//INSERT文を実行（resulｔには追加された行数が代入される）
			int result = pSmt.executeUpdate();
			if (result != 1) {
				return false;
			}
	
		}catch (SQLException e) {
			e.printStackTrace();
			return false;
		}
		return true;
	}	
	/*public boolean recreate(ItemChange cng) {
		try {
					
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
		//データベースへ接続
				try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
					
					//INSERT文の準備（idは自動連番なので指定しなくてもよい）
					String sql = "INSERT INTO ITEM(CATEGORY, NAME, EXPLANATION, PRICE, QUANTITY, IMAGE_PATH) VALUES(?, ?, ?, ?, ? ,?)";
					PreparedStatement pSmt = conn.prepareStatement(sql);
					
					// INSERT文中の「？」に使用する値を設定しSQLを完成
					pSmt.setString(1, cng.getCategory());
					pSmt.setString(2, cng.getName());
					pSmt.setString(3, cng.getExplanation());
					pSmt.setInt(4, cng.getPrice());
					pSmt.setInt(5, cng.getQuantity());
					pSmt.setString(6, cng.getImage_path());
					
					//INSERT文を実行（resulｔには追加された行数が代入される）
					int result = pSmt.executeUpdate();
					if (result != 1) {
						return false;
					}
			
				}catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}*/	
	public boolean change(Item cng,Key Jbk) {
		try {
					
					Class.forName("com.mysql.jdbc.Driver");
				} catch (ClassNotFoundException e1) {
					// TODO: handle exception
					e1.printStackTrace();
				}
		//データベースへ接続
				try (Connection conn = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS)) {
					System.out.println("changeDAO");
					int itemId = Integer.valueOf(Jbk.getKey());
					System.out.println("itemId"+itemId);
					String sql = "UPDATE `item` SET`CATEGORY`= ?,`NAME`= ?,`EXPLANATION`= ?,`PRICE`= ?,`QUANTITY`= ?,`IMAGE_PATH`= ?,`IMAGE_PATH2`= ?,`IMAGE_PATH3`= ? WHERE  `ITEM_ID`=" + itemId +";";
					PreparedStatement pSmt = conn.prepareStatement(sql);
					
					// INSERT文中の「？」に使用する値を設定しSQLを完成
					pSmt.setString(1, cng.getCategory());
					pSmt.setString(2, cng.getName());
					pSmt.setString(3, cng.getExplanation());
					pSmt.setInt(4, cng.getPrice());
					pSmt.setInt(5, cng.getQuantity());
					pSmt.setString(6, cng.getImage_path());
					pSmt.setString(7, cng.getImage_path2());
					pSmt.setString(8, cng.getImage_path3());
					
					//INSERT文を実行（resulｔには追加された行数が代入される）
					int result = pSmt.executeUpdate();
					if (result != 1) {
						return false;
					}
			
				}catch (SQLException e) {
					e.printStackTrace();
					return false;
				}
				return true;
			}


}
