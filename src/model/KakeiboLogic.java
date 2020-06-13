/**
 *
 */
package model;

import dao.KakeiboDao;

/** 家計簿データ処理(登録、更新、削除)を行うクラス
 * @author naomi
 */
public class KakeiboLogic {

	public boolean insertKakeibo (Kakeibo kakeibo, User user) {
		KakeiboDao kakeiboDao = new KakeiboDao();
		if (kakeiboDao.insertKakeibo(kakeibo, user)) {
			return true;
		}
		return false;
	}

}
