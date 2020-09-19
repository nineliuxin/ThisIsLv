package org.fkit.domain;

public class Userfocus {
		private Integer id;
		private Integer user_focus;//被关注的人
		private Integer focus_user;//粉丝
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getUser_focus() {
			return user_focus;
		}
		public void setUser_focus(Integer user_focus) {
			this.user_focus = user_focus;
		}
		public Integer getFocus_user() {
			return focus_user;
		}
		public void setFocus_user(Integer focus_user) {
			this.focus_user = focus_user;
		}
		@Override
		public String toString() {
			return " Userfocus[id=" + id + ", user_focus=" + user_focus + ", focus_user=" +focus_user + "]";
		}
}
