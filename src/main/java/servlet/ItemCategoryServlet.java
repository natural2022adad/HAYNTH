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
import model.ItemChange;
import model.ItemChangeLogic;

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
		String itemName = request.getParameter("itemName");
		String itemPrice = request.getParameter("itemPrice");
		String itemQuat = request.getParameter("itemQuat");
		String itemExplan = request.getParameter("itemExplan");
		String image_path = request.getParameter("image_path");
		String image_path2 = request.getParameter("image_path2");
		//画像保存　
				//参考サイトhttps://tmg0525.hatenadiary.jp/entry/2017/08/14/175501　
				//https://joytas.net/programming/jsp_servlet/fileupload
				Part part=request.getPart("item");
				//ファイル名を取得
				String filename=part.getSubmittedFileName();//ie対応が不要な場合
				
				//アップロードするフォルダ
				String path=getServletContext().getRealPath("/upload");
				//実際にファイルが保存されるパス確認
				System.out.println(path);
				//書き込み
				part.write(path+File.separator+filename);
		key  = request.getParameter("itemId");
		System.out.println("key"+key);
		System.out.println("category"+category);
		System.out.println("name"+itemName);
		System.out.println("price"+itemPrice);
		System.out.println("cquantity"+itemQuat);
		System.out.println("explanation"+itemExplan);
		System.out.println("image_path"+image_path);
		
		ItemChange cng = new ItemChange(category,itemName,itemExplan,image_path,Integer.parseInt(itemPrice),Integer.parseInt(itemQuat));
		System.out.println(cng);
		ItemChangeLogic rgt = new ItemChangeLogic();
		rgt.execute(cng);
		
		session.setAttribute("cng",cng);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/HAYNTH/ItemManageServlet");
		dispatcher.forward(request, response);
	}

}
