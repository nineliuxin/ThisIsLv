package org.fkit.domain;

public class User {
		private Integer id;
		private String open_id;
		private String user_name;
		private String user_img;
		private Integer focus;
		private Integer fans;
		
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
		@Override
		public String toString() {
			return " User[id=" + id + ", open_id=" + open_id + ",user_name=" + user_name + ",user_img=" + user_img + ",focus="+focus+",fans="+fans+"]";
		}
		public String getOpen_id() {
			return open_id;
		}
		public void setOpen_id(String open_id) {
			this.open_id = open_id;
		}
		public String getUser_img() {
			return user_img;
		}
		public void setUser_img(String user_img) {
			this.user_img = user_img;
		}
		public Integer getFans() {
			return fans;
		}
		public void setFans(Integer fans) {
			this.fans = fans;
		}
		public Integer getFocus() {
			return focus;
		}
		public void setFocus(Integer focus) {
			this.focus = focus;
		}
}
