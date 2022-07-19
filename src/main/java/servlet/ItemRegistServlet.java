package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.ItemManage;
import model.ItemRegistLogic;
/**
 * Servlet implementation class ItemRegistServlet
 */
@WebServlet("/ItemRegistServlet")
public class ItemRegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		//セッションスコープに保存された商品情報を取得
		HttpSession session = request.getSession();
		ItemManage mng =(ItemManage) session.getAttribute("mng");
		ItemRegistLogic rgt = new ItemRegistLogic();
		rgt.execute(mng);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/itemRegist.jsp");
		dispatcher.forward(request, response);
		System.out.println("商品登録完了");
	}

}
