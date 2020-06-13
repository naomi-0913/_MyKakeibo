/**
 *
 */
package model;

/** 家計簿情報を保持するクラス
 * @author naomi
 */
public class Kakeibo {
	private String id;
	private String moneyType;
	private String category;
	private String amount;
	private String memo;
	private String user_id;
	private String month;

	public Kakeibo() {}
	public Kakeibo(String moneyType, String category, String amount, String memo) {
		this.moneyType = moneyType;
		this.category = category;
		this.amount = amount;
		this.memo = memo;
	}

	/** @param id セットする id */
	public void setId(String id) {
		this.id = id;
	}
	/** @param user_id セットする user_id */
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	/** @param month セットする month */
	public void setMonth(String month) {
		this.month = month;
	}
	/** @return money_tyoe */
	public String getmoneyType() {
		return moneyType;
	}
	/** @return category */
	public String getCategory() {
		return category;
	}
	/** @return amount */
	public String getAmount() {
		return amount;
	}
	/** @return memo */
	public String getMemo() {
		return memo;
	}
	/** @return user_id */
	public String getUser_id() {
		return user_id;
	}
	/** @return month */
	public String getMonth() {
		return month;
	}

}
