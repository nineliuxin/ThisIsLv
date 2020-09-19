package org.fkit.domain;

public class Collection {
	private Integer id;
	private Integer user_id;
	private Integer strategy_id;
	private String date;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public Integer getStrategy_id() {
		return strategy_id;
	}
	public void setStrategy_id(Integer strategy_id) {
		this.strategy_id = strategy_id;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	@Override
	public String toString() {
		return " Dianzan[id=" + id + ", user_id=" + user_id + ", strategy_id=" +strategy_id + ", date=" +date + "]";
	}
}
