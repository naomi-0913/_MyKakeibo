/**
 *
 */
package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import dao.KakeiboDao;

/** 家計簿データ処理(登録、更新、削除)を行うクラス
 * @author naomi
 */
public class KakeiboLogic {

	/** 家計簿Dao */
	KakeiboDao kakeiboDao = new KakeiboDao();
	/** 家計簿情報 */
	Kakeibo kakeiboInfo = null;
	/** Connection */
	Connection con = null;

	/** DB接続
	 * @return con
	 * @throws IOException
	 * @throws SQLException
	 */
	public Connection getConnection() {
		con = kakeiboDao.getConnection();
		return con;
	 }

	/** クローズ
	 * @param con
	 * @throws IOException
	 * @throws SQLException
	 */
	public void closeConnection(Connection con) throws SQLException {
		kakeiboDao.closeConnection(con);
	}

	/** 家計簿の登録
	 * @param kakeibo
	 * @param user
	 * @param con
	 * @return
	 */
	public boolean insertKakeibo (Kakeibo kakeibo, User user, Connection con) throws SQLException, IOException {
		if (kakeiboDao.insertKakeibo(kakeibo, user, con)) {
			return true;
		}
		return false;
	}

	/** 家計簿の検索
	 * @param kakeiboInfo
	 * @param user
	 * @param con
	 * @return list
	 * @throws SQLException
	 * @throws IOException
	 */
	public List<Kakeibo> selectKakeibo(String month, User user, Connection con) throws SQLException, IOException {
		List<Kakeibo> list = new ArrayList<Kakeibo>();
		list = kakeiboDao.selectKakeibo(month, user, con);
		return list;
	}


}
