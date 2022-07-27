package servlet;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;


@WebServlet("/InCartServlet")
public class InCartServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
  
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		HttpSession session =request.getSession();
		ArrayList<Cart> cart = (ArrayList<Cart>) session.getAttribute("cart");
		System.out.println("cart1"+cart);
		int item_id= Integer.parseInt(request.getParameter("item_id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		Cart a = new Cart(item_id,quantity);
		
		if(cart.contains(a)) {
			int b = cart.indexOf(a);
			a.setQuantity(a.getQuantity()+cart.get(b).getQuantity());
		}
		cart.add(a);
		System.out.println("cart1"+cart);
		session.setAttribute("cart",cart);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemCategory.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

}
