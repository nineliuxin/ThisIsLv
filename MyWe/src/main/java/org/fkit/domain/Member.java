package org.fkit.domain;

public class Member {
		private Integer id;
		private Integer gather_id;
		private Integer member_id;
		private String status;
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
		public Integer getMember_id() {
			return member_id;
		}
		public void setMember_id(Integer member_id) {
			this.member_id = member_id;
		}
		public String getStatus() {
			return status;
		}
		public void setStatus(String status) {
			this.status = status;
		}
		@Override
		public String toString() {
			return " Member[id=" + id + ",gather_id=" +gather_id + ", member_id=" + member_id + ", status="+ status + "]";
		}
}
