/**
 *
 */
package model;

import java.io.Serializable;

/** ユーザー情報を保持するクラス
 * @author naomi
 */
public class User implements Serializable {
	private String id ; //ID
	private String name; //ユーザー名
	private String pass; //パスワード

	public User() {}
	public User(String name, String pass) {
		//this.id = id;
		this.name = name;
		this.pass = pass;
	}
	/** @return id */
	public String getid() { return id; }
	/** @return name */
	public String getName() { return name; }
	/** @return pass */
	public String getPass() { return pass; }

}
