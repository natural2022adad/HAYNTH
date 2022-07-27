package servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
import model.Key;

@WebServlet("/ItemCategoryServlet")
@MultipartConfig(location="/tmp", maxFileSize=192048576) //画像アップロードに必要
public class ItemCategoryServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		Key Jbk = new Key();
		
		System.out.println("numKey"+Jbk.getNumKey());
		
		Jbk.setKey(request.getParameter("ctg"));
		
		System.out.println(Jbk.getKey());
		System.out.println("修正"+request.getParameter("修正"));
		System.out.println("delete"+request.getParameter("delete"));
		if(Jbk.getKey() == null) {
			if(request.getParameter("修正") != null) {
				Jbk.setKey(request.getParameter("修正"));
				Jbk.setNumKey(Integer.valueOf(Jbk.getKey()));
				Jbk.setKey(null);
				request.setAttribute("Jbk",Jbk);
				 System.out.println("numkey" + Jbk.getNumKey());
				 GetCategoryLogic f = new GetCategoryLogic();
					List<Item> ctgList = f.execute(Jbk);
					request.setAttribute("ctgList", ctgList);
					if(Jbk.getNumKey() > 0) {
						RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemChanged.jsp");
						dispatcher.forward(request, response);
					}
			}else if(request.getParameter("delete") != null){
				Jbk.setKey(request.getParameter("delete"));
				Jbk.setNumKey(Integer.valueOf(Jbk.getKey()));
				Jbk.setKey(null);
				request.setAttribute("Jbk",Jbk);
				//Delete前にデータをリクエストスコープに格納
						 GetCategoryLogic f = new GetCategoryLogic();
						List<Item> ctgList = f.execute(Jbk);
						System.out.println("ctgList" + ctgList);
						request.setAttribute("ctgList", ctgList);
				//Delete			
				 DeleteIitemLogic d = new DeleteIitemLogic();
					d.execute(Jbk);
					
					//request.setAttribute("ctgList", ctgList);
					RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemManage.jsp");
					dispatcher.forward(request, response);
					}
			
		} else if(Jbk.getKey() != null){
			request.setAttribute("Jbk",Jbk);
			GetCategoryLogic f = new GetCategoryLogic();
			List<Item> ctgList = f.execute(Jbk);
			request.setAttribute("ctgList", ctgList);
			System.out.println("ctgList" + ctgList);
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
		System.out.println("itemCategoryServlet_doPOST");
		HttpSession session = request.getSession();
		Item c = (Item) session.getAttribute("c");
		System.out.println(c);
		
		Key Jbk = new Key();
		
		System.out.println("numKey"+Jbk.getNumKey());
		
		String category = request.getParameter("category");
		String name = request.getParameter("itemName");
		String price = request.getParameter("itemPrice");
		String quantity = request.getParameter("itemQuat");
		String explanation = request.getParameter("itemExplan");
		String image_path = request.getParameter("image_path");
		String image_path2 = request.getParameter("image_path2");
		String image_path3= request.getParameter("image_path3");
		System.out.println("image_path2"+image_path2);
		System.out.println("image_path3"+image_path3);
		//画像保存　2枚目以降追加リストに入れるhttps://qastack.jp/programming/2422468/how-to-upload-files-to-server-using-jsp-servlet
		
		if((image_path != null && image_path2 == null && image_path3 == null)||(image_path == null && image_path2 == null && image_path3 == null)) {
			System.out.println("if文_1枚目か0枚");
			ArrayList<String> image_paths =new ArrayList<String>();
			List<Part> fileParts = request.getParts().stream().filter(part -> "item".equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">
			System.out.println("fileParts"+fileParts);
			if(fileParts.size() != 0) {
			    for (Part part : fileParts) {
			    	System.out.println(part);
			    	//ファイル名を取得
			    	image_paths.add(part.getSubmittedFileName());
			    	System.out.println("ファイル名"+part.getSubmittedFileName());
			    	String path=getServletContext().getRealPath("/upload");
			    	//実際にファイルが保存されるパス確認
			    	System.out.println(path);
					//書き込み
					part.write(path+File.separator+part.getSubmittedFileName());
			    }
			    if(image_path == null) {
			    	image_path = image_paths.get(0);
			    	image_path2 = image_paths.get(1);
				    image_path3 = image_paths.get(2);
				    System.out.println("image_path"+ image_path);
				    System.out.println("image_path2"+ image_path2);
				    System.out.println("image_path3"+ image_path3);
			    }else if(image_path2 == null && image_paths.size() == 2){
				    image_path2 = image_paths.get(0);
				    image_path3 = image_paths.get(1);
				    System.out.println("image_path2"+ image_path2);
				    System.out.println("image_path3"+ image_path3);
				}else if(image_path2 == null && image_paths.size() == 1){
				    image_path2 = image_paths.get(0);
				    System.out.println("image_path2"+ image_path2);
				}
			}
		} else if(image_path != null && image_path2 != null && image_path3 == null) {
			//参考サイトhttps://tmg0525.hatenadiary.jp/entry/2017/08/14/175501　
			//https://joytas.net/programming/jsp_servlet/fileupload
			Part part=request.getPart("item");
				System.out.println("if文内part"+part);
			//ファイル名を取得
			image_path3 =part.getSubmittedFileName();//ie対応が不要な場合
			//アップロードするフォルダ
			String path=getServletContext().getRealPath("/upload");
			//実際にファイルが保存されるパス確認
			System.out.println(path);
			//書き込み
			part.write(path+File.separator+image_path3);
		}
		Jbk.setKey(request.getParameter("itemId"));
		System.out.println("key"+Jbk.getKey());
		System.out.println("category"+category);
		System.out.println("name"+name);
		System.out.println("price"+price);
		System.out.println("cquantity"+quantity);
		System.out.println("explanation"+explanation);
		System.out.println("image_path"+image_path);
		System.out.println("image_path2"+image_path2);
		System.out.println("image_path3"+image_path3);
		
		Item cng = new Item(category,name,explanation,image_path,image_path2,image_path3,Integer.parseInt(price),Integer.parseInt(quantity));
		System.out.println(cng);
		ItemRegistLogic rgt = new ItemRegistLogic();
		rgt.execute2(cng,Jbk);
		System.out.println("商品変更完了");
		
		session.setAttribute("cng",cng);
		request.setAttribute("Jbk",Jbk);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemRegist.jsp");
		dispatcher.forward(request, response);
	}

}
