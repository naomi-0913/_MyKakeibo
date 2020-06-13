package model;

import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

import dao.UserDao;

/** ログイン処理クラス
 * @author naomi
 */
public class UserLogic {

	/** ユーザーDao */
	UserDao userDao = new UserDao();
	/** ユーザー情報 */
	User userInfo = null;
	/** Connection */
	Connection con = null;

	/** DB接続
	 * @return con
	 * @throws IOException
	 * @throws SQLException
	 */
	public Connection getConnection() throws IOException, SQLException {
		con = userDao.getConnection();
		return con;
	 }

	/** クローズ
	 * @param con
	 * @throws IOException
	 * @throws SQLException
	 */
	public void closeConnection(Connection con) throws IOException, SQLException {
		userDao.closeConnection(con);
	}

	/** ユーザー情報の検索
	 * @param user
	 * @return ユーザー情報
	 */
	public User selectUser (User user, Connection con) throws IOException, SQLException {
		userInfo = userDao.selectUser(user, con);
		if (userInfo != null) {
			return userInfo;
		} else {
			return null;
		}
	}

	/** ユーザー登録
	 * @param user
	 */
	public void insertUser(User user, Connection con) throws IOException, SQLException {
		userDao.insertUser(user, con);
	}

	/** ユーザー情報の更新
	 * @param user
	 */
	public void updateUser(User user, Connection con) throws IOException, SQLException {
		userInfo = userDao.selectUser(user, con);
		userDao.updateUser(userInfo, con);
	}




}
