package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Item;
import model.ItemRegistLogic;

@WebServlet("/ItemRestorationServlet")
@MultipartConfig(location="/tmp", maxFileSize=192048576) //画像アップロードに必要
public class ItemRestorationServlet extends ItemCategoryServlet {
	private static final long serialVersionUID = 1L;
	
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//HttpSession session = request.getSession();
		Item c = (Item) request.getAttribute("c");
		System.out.println(c);
		System.out.println("inumKey"+numKey);
	
		
		String category = request.getParameter("category");
		String itemName = request.getParameter("name");
		String itemPrice = request.getParameter("price");
		String itemQuat = request.getParameter("quantity");
		String itemExplan = request.getParameter("explanation");
		String image_path = request.getParameter("image_path");
		
		
		key  = request.getParameter("itemId");
		System.out.println("key"+key);
		System.out.println("category"+category);
		System.out.println("name"+itemName);
		System.out.println("price"+itemPrice);
		System.out.println("cquantity"+itemQuat);
		System.out.println("explanation"+itemExplan);
		System.out.println("image_path"+image_path);
		
		Item cng = new Item(category,itemName,itemExplan,image_path,Integer.parseInt(itemPrice),Integer.parseInt(itemQuat));
		System.out.println(cng);
		ItemRegistLogic rgt = new ItemRegistLogic();
		rgt.execute(cng);
		
		request.setAttribute("cng",cng);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemRegist.jsp");
		dispatcher.forward(request, response);
	}

}
