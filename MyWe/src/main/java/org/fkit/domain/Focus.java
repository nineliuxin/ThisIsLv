package org.fkit.domain;

public class Focus {
		private Integer id;
		private Integer gather_id;
		private Integer user_id;
		public Integer getId() {
			return id;
		}
		public void setId(Integer id) {
			this.id = id;
		}
		public Integer getGather_id() {
			return gather_id;
		}
		public void setGather_id(Integer gather_id) {
			this.gather_id = gather_id;
		}
		public Integer getUser_id() {
			return user_id;
		}
		public void setUser_id(Integer user_id) {
			this.user_id = user_id;
		}
		@Override
		public String toString() {
			return " Focus[ id="+id+",gather_id="+gather_id+",user_id="+user_id+"]";
}
}
