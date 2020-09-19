package org.fkit.domain;

public class Strategy {
	private Integer id;			// id
	private Integer user_id;//用户id
	private String user_name;	// 用户名
	private String user_img;//用户头像
	private String title;	// 标题
	private String date;		// 日期
	private String place;		// 地点
	private String content;// 内容
	private Integer dianzan;//点赞数
	private Integer shoucang;//收藏数
	private String cover;
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getUser_name() {
		return user_name;
	}
	public void setUser_name(String user_name) {
		this.user_name = user_name;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public String getPlace() {
		return place;
	}
	public void setPlace(String place) {
		this.place = place;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public Integer getDianzan() {
		return dianzan;
	}
	public void setDianzan(Integer dianzan) {
		this.dianzan = dianzan;
	}
	public Integer getShoucang() {
		return shoucang;
	}
	public void setShoucang(Integer shoucang) {
		this.shoucang = shoucang;
	}
	
	@Override
	public String toString() {
		return " Strategy[id=" + id + ", user_id=" + user_id + ", user_name=" + user_name + ",user_img=" + user_img + ", title="
				+ title + ",date =" + date + ", place=" + place
				+ ", content=" + content + ", dianzan=" + dianzan + ", shoucang=" + shoucang + ", cover=" + cover + "]";
	}
	public String getCover() {
		return cover;
	}
	public void setCover(String cover) {
		this.cover = cover;
	}
	public Integer getUser_id() {
		return user_id;
	}
	public void setUser_id(Integer user_id) {
		this.user_id = user_id;
	}
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}

}
