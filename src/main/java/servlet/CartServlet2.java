package servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Cart;
import model.GetCategoryLogic;
import model.Item;
import model.Key;


@WebServlet("/CartServlet2")
public class CartServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	
		List<Item> ctgList = new ArrayList<Item>();
		System.out.println("JctgList"+ctgList);
		Key Jbk = new Key();
		System.out.println("Jbk"+Jbk);
		
		HttpSession session =request.getSession();
		//ArrayList<Cart> cart = (ArrayList<Cart>) session.getAttribute("cart");
		Map<String, Integer> cart = (Map<String, Integer>) session.getAttribute("cart");
		System.out.println("CartServlet_cart1"+cart);
		
		String item_id = request.getParameter("item_id");
		//int item_id= Integer.parseInt(request.getParameter("item_id"));
		int quantity = Integer.parseInt(request.getParameter("quantity"));
		//Cart a = new Cart(item_id,quantity);
		if(cart.get(item_id)==null) {
			cart.put(item_id, quantity);
		} else {
			quantity += cart.get(item_id);
			cart.put(item_id, quantity);
			System.out.println("quantity"+quantity);
		}
		/*System.out.println("cart.contains(a)"+cart.contains(a));
		if(cart.containsAll() { //同じ商品かどうかチェック
			System.out.println("同じ商品あり");
			System.out.println("cart.size()"+cart.size());
			int b = cart.indexOf(a); //bと同じ商品のindex番号を探す
			a.setQuantity(a.getQuantity()+cart.get(b).getQuantity());//商品数を追加
			cart.remove(b);
			System.out.println("cart.size()"+cart.size());//先に入れた商品を削除
			//※後に入れた商品を削除するにはset(b,a);をして下のcart.add(a);をelseに入れる
		}
		cart.add(a);*/
		int total_quant = 0;
		for(String itm_id : cart.keySet()) {
			int item_quant = cart.get(itm_id);
			total_quant = total_quant + item_quant;
		}
		System.out.println("total_quant"+total_quant);
		Cart totalQuant = new Cart(total_quant);
		System.out.println("totalQuant"+totalQuant);
		session.setAttribute("totalQuant",totalQuant);
		
		System.out.println("cart1"+cart);
		session.setAttribute("cart",cart);
		
		
		Jbk.setKey(request.getParameter("ctg"));
		GetCategoryLogic f = new GetCategoryLogic();
		ctgList = f.execute(Jbk);
		request.setAttribute("ctgList", ctgList);
		//元のページに戻るため
		request.setAttribute("Jbk", Jbk);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemDetail.jsp");
		dispatcher.forward(request, response);
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
