package servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.LoginLogic;
import model.SignupLogic;
import model.User;

/**
 * Servlet implementation class SignupServlet
 */
@WebServlet("/Signup")
public class SignupServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public SignupServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/signup.jsp");
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// リクエストパラメータの取得
		String userName = request.getParameter("userName");
		String password = request.getParameter("password");
		String msg =null;

		try {
			User user = new User(userName, password);
			SignupLogic SignupLogic = new SignupLogic();
			//ユーザー登録
			SignupLogic.insertUser(user);
			LoginLogic loginLogic = new LoginLogic();
			// 登録したユーザーを再検索
			if (loginLogic.existUser(user)) {
				HttpSession session = request.getSession();
				session.setAttribute("loginUser", user);
				msg = "ユーザー登録が完了しました。";
			} else {
				response.sendRedirect("/WEB-INF/jsp/signUp.jsp");
				msg = "登録できませんでした。";
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		request.setAttribute("msg", msg);
		RequestDispatcher dispatcher = request.getRequestDispatcher("/WEB-INF/jsp/main.jsp");
		dispatcher.forward(request, response);

	}

}
