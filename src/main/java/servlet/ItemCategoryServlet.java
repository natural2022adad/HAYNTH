package servlet;

import java.io.File;
import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

import model.DeleteIitemLogic;
import model.GetCategoryLogic;
import model.Item;
import model.ItemRegistLogic;

@WebServlet("/ItemCategoryServlet")
@MultipartConfig(location="/tmp", maxFileSize=192048576) //画像アップロードに必要
public class ItemCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public static String key;
	public static int numKey;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		System.out.println("numKey"+numKey);
		key = null;
		numKey = 0;
		System.out.println("numKey"+numKey);
		
		key = request.getParameter("ctg");
		
		System.out.println(key);
		System.out.println("修正"+request.getParameter("修正"));
		System.out.println("delete"+request.getParameter("delete"));
		if(key == null) {
			if(request.getParameter("修正") != null) {
				 key = request.getParameter("修正");
				 numKey = Integer.valueOf(key);
				 key = null;
				 System.out.println("numkey" + numKey);
				 GetCategoryLogic f = new GetCategoryLogic();
					List<Item> ctgList = f.execute();
					request.setAttribute("ctgList", ctgList);
					if(numKey > 0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemChanged.jsp");
						dispatcher.forward(request, response);
					}
			}else if(request.getParameter("delete") != null){
				key = request.getParameter("delete");
				 numKey = Integer.valueOf(key);
				 key = null;
				 //image_pathを取得しておく
				 
				//Delete前にデータをリクエストスコープに格納
						 GetCategoryLogic f = new GetCategoryLogic();
						List<Item> ctgList = f.execute();
						System.out.println("ctgList" + ctgList);
						request.setAttribute("ctgList", ctgList);
				//Delete			
				 DeleteIitemLogic d = new DeleteIitemLogic();
					d.execute();
					
					//request.setAttribute("ctgList", ctgList);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemManage.jsp");
					dispatcher.forward(request, response);
					}
			
		} else if(key != null){
			GetCategoryLogic f = new GetCategoryLogic();
			List<Item> ctgList = f.execute();
			request.setAttribute("ctgList", ctgList);
			//if(numKey > 0) {
				//RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemChanged.jsp");
				//dispatcher.forward(request, response);
			//}
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemCategory.jsp");
			dispatcher.forward(request, response);
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session = request.getSession();
		Item c = (Item) session.getAttribute("c");
		System.out.println(c);
		System.out.println("inumKey"+numKey);
		key = null;
		numKey = 0;
		System.out.println("numKey"+numKey);
		
		String category = request.getParameter("category");
		String name = request.getParameter("itemName");
		String price = request.getParameter("itemPrice");
		String quantity = request.getParameter("itemQuat");
		String explanation = request.getParameter("itemExplan");
		String image_path = request.getParameter("image_path");
		String image_path2 = request.getParameter("image_path2");
		System.out.println("image_path2"+image_path2);
		//画像保存　
				//参考サイトhttps://tmg0525.hatenadiary.jp/entry/2017/08/14/175501　
				//https://joytas.net/programming/jsp_servlet/fileupload
				Part part=request.getPart("item");
				if(part.getSize() != 0 && image_path2 == null) {
					System.out.println("if文内part"+part);
				//ファイル名を取得
				image_path2=part.getSubmittedFileName();//ie対応が不要な場合
				
				//アップロードするフォルダ
				String path=getServletContext().getRealPath("/upload");
				//実際にファイルが保存されるパス確認
				System.out.println(path);
				//書き込み
				part.write(path+File.separator+image_path2);
				}
		key  = request.getParameter("itemId");
		System.out.println("key"+key);
		System.out.println("category"+category);
		System.out.println("name"+name);
		System.out.println("price"+price);
		System.out.println("cquantity"+quantity);
		System.out.println("explanation"+explanation);
		System.out.println("image_path"+image_path);
		System.out.println("image_path2"+image_path2);
		
		Item cng = new Item(category,name,explanation,image_path,Integer.parseInt(price),Integer.parseInt(quantity));
		System.out.println(cng);
		ItemRegistLogic rgt = new ItemRegistLogic();
		rgt.execute2(cng);
		System.out.println("商品変更完了");
		
		session.setAttribute("cng",cng);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemRegist.jsp");
		dispatcher.forward(request, response);
	}

}
