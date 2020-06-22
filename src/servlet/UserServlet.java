package servlet;

import java.io.IOException;
import java.sql.Connection;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.User;
import model.UserLogic;

/** ユーザーに関する処理用のサーブレットクラス
 * Servlet implementation class UserServlet
 */
@WebServlet("/User")
public class UserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public UserServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String comand = request.getParameter("comand");
		String dispacherName = "";

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");

			try {
					if ("login".equals(comand) || "signup".equals(comand)) {
						dispacherName = "/WEB-INF/jsp/main.jsp";
					//更新
					} else if ("update".equals(comand)) {
						dispacherName = "/WEB-INF/jsp/main.jsp";
					// ログアウト
					} else if ("logout".equals(comand)) {
						session.invalidate();
						dispacherName = "/index.jsp";
					}

			} catch (Exception e) {
				e.printStackTrace();
			}

		if (user != null) {
			session.setAttribute("longinUser", user);
		}
		request.setAttribute("comand", comand);
		// 画面フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(dispacherName);
		dispatcher.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// パラメータの取得
		String name = request.getParameter("user_name");
		String password = request.getParameter("password");
		String comand = request.getParameter("comand");
		// 画面表示メッセージ
		String msg = "";
		// 表示JSP
		String dispacherName = "/WEB-INF/jsp/main.jsp";

		UserLogic userLogic = new UserLogic();
		Connection con = null;

		//ユーザー情報の取得
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");

		try {
			// DB接続
			con = userLogic.getConnection();

			// ログイン処理
			if ("login".equals(comand) && user == null ) {
				user = new User(name, password);
				user = userLogic.selectUser(user, con);
				msg = "ログインしました。";
			//ユーザー登録
			} else if("signup".equals(comand)) {
				userLogic.insertUser(user, con);
				msg = "ユーザー情報を登録しました。";
			// 更新処理
			} else if ("update".equals(comand)) {
				userLogic.updateUser(user, con);
				msg = "ユーザー情報を更新しました。";
			// 最新の情報を再検索
			} else if (!"login".equals(comand)) {
				user = userLogic.selectUser(user, con);
			}else {
				msg = "不正な遷移です。TOPページからやり直してください。";
				dispacherName = "/index.jsp";
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "処理に失敗しました。";
		} finally {
			//クローズ
			try {
				userLogic.closeConnection(con);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		// パラメータに値を設定
		request.setAttribute("msg", msg);
		session.setAttribute("loginUser", user);
		// 画面フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(dispacherName);
		dispatcher.forward(request, response);

	}

}
