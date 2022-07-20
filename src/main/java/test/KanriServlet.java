package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Kanri;


/**
 * Servlet implementation class kanri
 */
@WebServlet("/KanriServlet")
public class KanriServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
   
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("category");
		String itemName = request.getParameter("itemName");
		int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
		int itemQuat = Integer.parseInt(request.getParameter("itemQuat"));
		String itemExplan = request.getParameter("itemExplan");
		String itemImg = request.getParameter("itemImg");
		
		Kanri kanri = new Kanri(category, itemName,itemPrice,itemQuat,itemExplan,itemImg);
		HttpSession session = request.getSession();
		session.setAttribute("kanri",kanri);
		
		RequestDispatcher dispatcher = request.getRequestDispatcher("/test_kanrikakunin.jsp");
		dispatcher.forward(request, response);
		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		request.setCharacterEncoding("UTF-8");
		String category = request.getParameter("category");
		String itemName = request.getParameter("itemName");
		int itemPrice = Integer.parseInt(request.getParameter("itemPrice"));
		int itemQuat = Integer.parseInt(request.getParameter("itemQuat"));
		String itemExplan = request.getParameter("itemExplan");
		String itemImg = request.getParameter("itemImg");
	
		//入力値チェック
		if(category != null && category.length() != 0 && itemName != null && itemName.length() != 0 && itemPrice  <= 0 && itemQuat <= 0 && itemExplan!= null && itemExplan.length() != 0 && itemImg!= null && itemImg.length() != 0 ) {
			 
			//登録商品をつぶやきリストに追加
			Kanri kanri = new Kanri(category, itemName,itemPrice,itemQuat,itemExplan,itemImg);
			//PostMutterLogic postMutterLogic = new PostMutterLogic();
			//postMutterLogic.execute(mutter); //, mutterList削除

			
						
							
		} else {
			//エラーメッセージをリクエストスコープに保存
			request.setAttribute("errorMsg", "つぶやきが入力されていません");
		}
		
		//つぶやきリストを取得して、リクエストスコープに保存
		//GetMutterListLogic getMutterListLogic = new GetMutterListLogic();
		//List<Mutter> mutterList = getMutterListLogic.execute();
		//request.setAttribute("mutterList", mutterList);		
		
		//メイン画面にフォワード
		//<jsp:include page="/webapp/WEB-INF/jsp/main.jsp" />
		RequestDispatcher dispatcher = request.getRequestDispatcher("/kanrikakunin.jsp");
		dispatcher.forward(request, response);
	
		
	}

}
