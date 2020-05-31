/**
 *
 */
package model;

import dao.UserDao;

/** ユーザー登録を行うクラス
 * @author naomi
 */
public class SignupLogic {

	public void insertUser(User user) {
		UserDao userDao = new UserDao();
		userDao.insertUser(user);
	}


}
