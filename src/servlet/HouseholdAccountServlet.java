package servlet;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import model.Kakeibo;
import model.KakeiboLogic;
import model.User;

/**
 * Servlet implementation class HouseAccountServlet
 */
@WebServlet("/HouseholdAccount")
public class HouseholdAccountServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

    /**
     * @see HttpServlet#HttpServlet()
     */
    public HouseholdAccountServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

		// パラメータの取得
		String comand = request.getParameter("comand");

		// 画面表示メッセージ
		String msg = "";
		// 表示JSP
		String dispacherName = "";
		// ログインユーザー
		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		// 現在の月度を取得
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat datepattern = new SimpleDateFormat("yyyy/MM");
		String date = datepattern.format(currentDate.getTime());

		KakeiboLogic kakeiboLogic = new KakeiboLogic();
		List<Kakeibo> kakeiboList = new ArrayList<Kakeibo>();

		try {
			if (user == null) {
				comand = "login";
				dispacherName = "/WEB-INF/jsp/main.jsp";
			}else {
				Connection con = kakeiboLogic.getConnection();
				if ("insert".equals(comand)) {
					dispacherName = "/WEB-INF/jsp/KakeiboInput.jsp";
				} else if ("detail".equals(comand)) {
					// 家計簿一覧リストを作成
					kakeiboList = kakeiboLogic.selectKakeibo(date, user, con);
					dispacherName = "/WEB-INF/jsp/KakeiboDetail.jsp";
				} else if ("edit".equals(comand)) {
					// 家計簿一覧リストを作成
					kakeiboList = kakeiboLogic.selectKakeibo(date, user, con);
					dispacherName = "/WEB-INF/jsp/KakeiboEdit.jsp";
				} else {
					msg = "不正な遷移です。TOPページからやり直してください。";
					dispacherName = "/index.jsp";
				}
			}
			// パラメータに値を設定
			request.setAttribute("msg", msg);
			request.setAttribute("kakeiboList", kakeiboList);
			request.setAttribute("date", date);
			request.setAttribute("comand", comand);

		} catch (Exception e ) {
			e.printStackTrace();
			msg = "処理に失敗しました。";
		}

		// 画面フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(dispacherName);
		dispatcher.forward(request, response);

	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// パラメータの取得
		String comand = request.getParameter("comand");
		String moneyType = request.getParameter("money_type");
		String category = request.getParameter("category");
		String amount = request.getParameter("amount");
		String memo = request.getParameter("memo");
		String kakeiboID = request.getParameter("kakeibo_id");

		// 画面表示メッセージ
		String msg = null;
		// 表示JSP
		String dispacherName = "/WEB-INF/jsp/main.jsp";

		// 現在の月度を取得
		Calendar currentDate = Calendar.getInstance();
		SimpleDateFormat datepattern = new SimpleDateFormat("yyyy/MM");
		String date = datepattern.format(currentDate.getTime());

		HttpSession session = request.getSession();
		User user = (User)session.getAttribute("loginUser");
		Kakeibo kakeibo = new Kakeibo(moneyType, category, amount, memo);
		if (null != kakeiboID) {
			kakeibo.setId(kakeiboID);
		}

		KakeiboLogic kakeiboLogic = new KakeiboLogic();
		List<Kakeibo> kakeiboList = new ArrayList<Kakeibo>();
		Connection con = null;

		try {
			// DB接続
			con = kakeiboLogic.getConnection();

			if ("insert".equals(comand)) {
				if (kakeiboLogic.insertKakeibo(kakeibo, user, con)) {
					msg = "登録が成功ました。";
				} else {
					msg = "登録が失敗しました。";
				}
			} else if ("detail".equals(comand)) {
				dispacherName = "/WEB-INF/jsp/KakeiboDetail.jsp";
			} else if ("update".equals(comand)) {

				if (kakeiboLogic.updateKakeibo(kakeibo, user, con)) {
					dispacherName = "/WEB-INF/jsp/KakeiboEdit.jsp";
				}
			} else if ("delete".equals(comand)) {
				if (kakeiboLogic.deleteKakeibo(kakeibo, user, con)) {
					dispacherName = "/WEB-INF/jsp/KakeiboEdit.jsp";
				}
			}

			// 家計簿一覧リストを作成
			kakeiboList = kakeiboLogic.selectKakeibo(date, user, con);

		} catch (Exception e) {
			e.printStackTrace();
			msg = "処理に失敗しました。";
		} finally {
			try {
				kakeiboLogic.closeConnection(con);
			} catch (SQLException e) {
				e.printStackTrace();
			}

		}

		// パラメータに値を設定
		request.setAttribute("kakeiboList", kakeiboList);
		request.setAttribute("msg", msg);
		request.setAttribute("date", date);
		// 画面フォワード
		RequestDispatcher dispatcher = request.getRequestDispatcher(dispacherName);
		dispatcher.forward(request, response);


	}

}
