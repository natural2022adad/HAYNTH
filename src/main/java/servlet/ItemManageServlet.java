package servlet;

import java.io.File;
import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.Item;

@WebServlet("/ItemManageServlet")
@MultipartConfig(location="/tmp", maxFileSize=192048576) //画像アップロードに必要
public class ItemManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemManage.jsp");
		dispatcher.forward(request, response);
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("category");
		String name = request.getParameter("itemName");
		String price = request.getParameter("itemPrice");
		String quantity = request.getParameter("itemQuat");
		String explanaton = request.getParameter("itemExplan");
		
		System.out.println("category"+category);
		
		//画像保存　
		//参考サイトhttps://tmg0525.hatenadiary.jp/entry/2017/08/14/175501　
		//https://joytas.net/programming/jsp_servlet/fileupload
		Part part=request.getPart("item");
		System.out.println("part"+part);
		//ファイル名を取得
		String imaege_path=part.getSubmittedFileName();//ie対応が不要な場合
		System.out.println("imaege_path"+imaege_path);
		
		//アップロードするフォルダ
		String path=getServletContext().getRealPath("/upload");
		//実際にファイルが保存されるパス確認
		System.out.println(path);
		//書き込み
		part.write(path+File.separator+imaege_path);
		
		Item mng = new Item(category, name,explanaton,imaege_path,Integer.parseInt(price),Integer.parseInt(quantity));
		System.out.println("mng"+mng);
		HttpSession session = request.getSession();
		session.setAttribute("mng",mng);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemConfirm.jsp");
		dispatcher.forward(request, response);
		
	}

}
