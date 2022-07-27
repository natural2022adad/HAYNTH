package servlet;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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

import model.Item;

@WebServlet("/ItemManageServlet")
@MultipartConfig(location="/tmp", maxFileSize=192048576) //画像アップロードに必要
public class ItemManageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		
		HttpSession session = request.getSession();
		/*ArrayList<Cart> cart =(ArrayList<Cart>) session.getAttribute("cart");
		if(cart.size()==0) {
			System.out.println("session"+session);
			System.out.println("cart"+cart);
			Cart a = new Cart(0,0);
			cart.add(a);
			System.out.println("ifcart"+cart);
			session.setAttribute("cart", cart);
			} else {
			
			System.out.println("elsecart"+cart);
			}*/
		Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
		Item mng = (Item) request.getAttribute("mng");
		
		request.setAttribute("mng", mng);
		System.out.println("mng"+mng);
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
		String image_path = null;
		String image_path2 = null;
		String image_path3 = null;
		//画像保存　
		//参考サイトhttps://tmg0525.hatenadiary.jp/entry/2017/08/14/175501　
		//https://joytas.net/programming/jsp_servlet/fileupload
		ArrayList<String> image_paths =new ArrayList<String>();
		List<Part> fileParts = request.getParts().stream().filter(part -> "item".equals(part.getName()) && part.getSize() > 0).collect(Collectors.toList()); // Retrieves <input type="file" name="file" multiple="true">
		System.out.println("fileParts"+fileParts);
		if(fileParts.size() != 0) {
	    for (Part part : fileParts) {
	    	
	    	System.out.println(part);
	    	//ファイル名を取得
	    	image_paths.add(part.getSubmittedFileName());
	    	String path=getServletContext().getRealPath("/upload");
	    	//実際にファイルが保存されるパス確認
	    	System.out.println(path);
			//書き込み
			part.write(path+File.separator+image_path);
	        //String fileName = Paths.get(filePart.getSubmittedFileName()).getFileName().toString(); // MSIE fix.
	        //InputStream fileContent = filePart.getInputStream();
	        // ... (do your job here)
	        //System.out.println("fileName"+fileName);
	        //System.out.println("fileContent"+fileContent);
	    }
	    image_path = image_paths.get(0);
	    if(fileParts.size() >= 2) {
	    	image_path2 = image_paths.get(1);
	    	 if(fileParts.size() >= 3) {
	    		 image_path3 = image_paths.get(2);
	    	 }
	    }
	    
	    System.out.println(" image_path"+ image_path);
	    System.out.println(" image_path"+ image_path2);
	    System.out.println(" image_path"+ image_path3);
		}
		
		/*if(part2.getSize() != 0) {
			
			System.out.println("if文内part"+part);
		//ファイル名を取得
		image_path=part2.getSubmittedFileName();//ie対応が不要な場合
		
		//アップロードするフォルダ
		String path=getServletContext().getRealPath("/upload");
		//実際にファイルが保存されるパス確認
		System.out.println(path);
		//書き込み
		part.write(path+File.separator+image_path);
	
		} else{
		image_path = "noimg.jpg";
		}*/
		
	//入力値のnullチェック
		if(category == null | category.length() ==0) {
			System.out.println("category"+category);
			request.setAttribute("errorMsg1", "categoryを選択してください");
		}
		if(name == null ||name.length() ==0) {
			System.out.println("name"+name);
			request.setAttribute("errorMsg2", "商品名を入力してください");
		}
		if(explanaton == null || explanaton.length() ==0) {
			System.out.println("explanaton"+explanaton);
			request.setAttribute("errorMsg3", "説明文を入力してください");
		}
		if((category == null || category.length() ==0) || (name == null || name.length() ==0) ||(explanaton == null || explanaton.length() ==0)) {
			Item mng = new Item(category, name,explanaton,image_path,Integer.parseInt(price),Integer.parseInt(quantity));
			System.out.println("mngインスタンス生成");
			request.setAttribute("mng",mng);
			
			RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemManage.jsp");
			dispatcher.forward(request, response);
			
		}
		Item mng = new Item(category, name,explanaton,image_path,image_path2, image_path3,Integer.parseInt(price),Integer.parseInt(quantity));
	
		System.out.println("itemManage内mng"+mng);
		HttpSession session = request.getSession();
		session.setAttribute("mng",mng);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemConfirm.jsp");
		dispatcher.forward(request, response);
		
	}

}
