package model;

import dao.UserDao;

/** ログイン処理クラス
 * @author naomi
 */
public class LoginLogic {

	/** ユーザー情報の有無の確認
	 * @param user
	 * @return true:あり, false:なし
	 */
	public boolean existUser (User user) {
		UserDao UserDao = new UserDao();
		User userInfo = UserDao.findUser(user);

		if (userInfo != null) {
			return true;
		} else {
			return false;
		}
	}

//	public void databaseConnection() {
//		UserDao UserDao = new UserDao();
//		UserDao.getConnection();
//	}

}
