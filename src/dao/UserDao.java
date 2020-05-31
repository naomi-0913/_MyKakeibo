/**
 *
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.User;

/** Userテーブルに対してデータの抽出・挿入を行うクラス
 * @author naomi
 */
public class UserDao {
//	DB接続に使用する情報
	private final String JDBC_URL ="jdbc:mysql://localhost/doko_tsubu";
	private final String DB_USER = "doko";
	private final String DB_PASS = "Q5-dA4TD";

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;


	/** DB接続
	 * @return　Connection con
	 */
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			con = DriverManager.getConnection(JDBC_URL, DB_USER, DB_PASS);
		} catch (SQLException |ClassNotFoundException e) {
			e.printStackTrace();
		}
		return con;
	}


	/** closeメソッド
	 * @param con
	 * @param pst
	 * @param rs
	 */
	public void close(Connection con, PreparedStatement pst, ResultSet rs) {
		if(con != null) {
			try {
				con.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(pst != null) {
			try {
				pst.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		if(rs != null) {
			try {
				rs.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
	}

	/** ユーザー名とPWを条件にuserテーブルを検索
	 * @param user
	 * @return userInfo(取得したユーザー情報)
	 */
	public User findUser(User user) {
		User userInfo = null;

		// ユーザー検索
		try {
			con = getConnection();
			String sql = "SELECT ID, user_name, password from user where user_name = ? and password = ?;";
			pst = con.prepareStatement(sql);
			pst.setString(1, user.getName());
			pst.setString(2, user.getPass());
			rs = pst.executeQuery();

			// 取得データを移行
			if (rs.next()) {
				String id = rs.getString("ID");
				String userName = rs.getString("user_name");
				String userPass = rs.getString("password");
				userInfo = new User(userName, userPass);
				return userInfo;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(con, pst, rs);
		}
		return userInfo;
	}

	/** ユーザー情報を追加
	 * @param user
	 */
	public boolean insertUser(User user) {
		try {
			con = this.getConnection();
			String sql = "insert into user (user_name, password, created, modified ) values (?, ?, now(), now());";
			pst = con.prepareStatement(sql);
			pst.setString(1,user.getName());
			pst.setString(2, user.getPass());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			this.close(con, pst, rs);
		}
	}

}
