/**
 *
 */
package model;

import java.io.Serializable;

/** ユーザー情報を保持するクラス
 * @author naomi
 */
public class User implements Serializable {
	private String id;
	private String name; //ユーザー名
	private String pass; //パスワード

	public User() {}
	public User(String name, String pass) {
		this.name = name;
		this.pass = pass;
	}

	/** @param id セットする id */
	public void setId(String id) {
		this.id = id;
	}
	/** @return name */
	public String getName() { return name; }
	/** @return pass */
	public String getPass() { return pass; }
	/** @return id */
	public String getId() {
		return id;
	}

}
