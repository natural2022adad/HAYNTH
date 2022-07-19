package servlet;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.GetSearchLogic;
import model.Item;
import model.Search;

/**
 * Servlet implementation class SearchMain
 */
@WebServlet("/SearchMain")
public class SearchMain extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SearchMain() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//response.getWriter().append("Served at: ").append(request.getContextPath());
		
		/*
		 * //セッションスコープから検索wordを取得
		HttpSession session=request.getSession();
		Search word=(Search)session.getAttribute("word");
		
		 * */
		//検索Word取得
		Search word=new Search("OO");
				
/*
 * 		//セッションスコープ内のインスタンスを削除
		session.removeAttribute("word");
 * */
		
		//検索リストを取得してリクエストスコープに保存
		GetSearchLogic getsearchlogic=new GetSearchLogic();
		List<Item> itemList=getsearchlogic.excute(word);
		request.setAttribute("itemList",itemList);
		
		System.out.println(word);
		
		System.out.println(itemList);
		
		//検索結果をjspに表示（フォワード）
		RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/index/search/result.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	//	doGet(request, response);
		
		//検索Word取得
		Search word=new Search("OO");
		
		//セッションスコープに保存
		HttpSession session = request.getSession();
		session.setAttribute("word", word);
		
		System.out.println(""+word);
	}

}
