/**
 *
 */
package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import model.Kakeibo;
import model.User;

/** Userテーブルに対してデータの抽出・挿入を行うクラス
 * @author naomi
 */
public class KakeiboDao {
//	DB接続に使用する情報
	private final String JDBC_URL = "jdbc:mysql://localhost:3306/mykakeibo";
	private final String DB_USER = "kakeibo";
	private final String DB_PASS = "|4nCV8e2";

	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	/** DB接続
	 * @return　Connection con
	 */
	public Connection getConnection() {
		Connection con = null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
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

	/** 家計簿の登録
	 * @param kakeibo
	 * @param user
	 * @return true:成功、false:失敗
	 */
	public boolean insertKakeibo(Kakeibo kakeibo, User user) {
		try {
			con = this.getConnection();
			String sql = "insert into kakeibo (money_type, category, amount, memo, user_id, month, created, modified) values (" +
					"?, ?, ?, ?, ?, DATE_FORMAT(now(),'%Y/%m'), now(), now()) ";
			pst = con.prepareStatement(sql);
			pst.setString(1, kakeibo.getmoneyType());
			pst.setString(2, kakeibo.getCategory());
			pst.setString(3, kakeibo.getAmount());
			pst.setString(4, kakeibo.getMemo());
			pst.setString(5,user.getId());
			pst.executeUpdate();
			return true;
		} catch (SQLException e) {
			e.printStackTrace();
			return false;
		} finally {
			this.close(con, pst, rs);
		}
	}

	public void selectKakeibo(Kakeibo kakeibo, User user) {

		try {
			con = this.getConnection();
			String sql = "select * from kakeibo where money_type = ?, user_id= ?, month = ?";
			pst = con.prepareStatement(sql);
			pst.setString(1, kakeibo.getmoneyType());
			pst.setString(2, user.getId());
			pst.setString(3, kakeibo.getMonth());
			rs = pst.executeQuery();
			if (rs.next()) {

			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			this.close(con, pst, rs);
		}

	}

}
