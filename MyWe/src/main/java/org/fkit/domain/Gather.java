package org.fkit.domain;

public class Gather {
	private Integer id;			// id
	private Integer user_id; //用户编号
	private String user_img;//用户头像
	private String user_name;	// 用户名
	private String title;	// 标题
	private String date;		// 发布日期
	private String content;// 内容
	private String travel_city;//旅游出发和目的地
	private String travel_date;//旅游出发时间和返回时间
	private Integer sex;//想召集的人的性别
	private String images;//上传的图片
	private Integer focus;//关注的人数
	private Integer joiner;//想加入的人数
	private String connection;//联系方式
	private String con_status;//联系方式显示状态
	public Integer getFocus() {
		return focus;
	}
	public void setFocus(Integer focus) {
		this.focus = focus;
	}
	public Integer getJoiner() {
		return joiner;
	}
	public void setJoin(Integer joiner) {
		this.joiner = joiner;
	}
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
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public String getTravel_city() {
		return travel_city;
	}
	public void setTravel_city(String travel_city) {
		this.travel_city = travel_city;
	}
	public String getTravel_date() {
		return travel_date;
	}
	public void setTravel_date(String travel_date) {
		this.travel_date = travel_date;
	}
	public Integer getSex() {
		return sex;
	}
	public void setSex(Integer sex) {
		this.sex = sex;
	}
	public String getImages() {
		return images;
	}
	public void setImages(String images) {
		this.images = images;
	}
	
	@Override
	public String toString() {
		return " Gather[id=" + id + ",user_id=" +user_id + ", user_img=" +user_img + "user_name=" + user_name + ", title="
				+ title + ",date =" + date + ", content=" + content + ", travel_city=" + travel_city + ","
						+ " travel_date=" + travel_date + ",sex=" + sex + ", images=" + images + ", focus=" +focus+ "， joiner=" +joiner+ ","
								+ "connection="+connection+",con_status="+con_status+"]";
	}
	public String getUser_img() {
		return user_img;
	}
	public void setUser_img(String user_img) {
		this.user_img = user_img;
	}
	public String getConnection() {
		return connection;
	}
	public void setConnection(String connection) {
		this.connection = connection;
	}
	public String getCon_status() {
		return con_status;
	}
	public void setCon_status(String con_status) {
		this.con_status = con_status;
	}
}
