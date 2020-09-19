package org.fkit.domain;

public class Sercret {
		private Integer id;
		private Integer gather_id;
		private String content;
		private String act_img;
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
		public String getContent() {
			return content;
		}
		public void setContent(String content) {
			this.content = content;
		}
		public String getAct_img() {
			return act_img;
		}
		public void setAct_img(String act_img) {
			this.act_img = act_img;
		}
		@Override
		public String toString(){
			return "Sercret[ id="+id+",gather_id="+gather_id+",content="+content+",act_img="+act_img+"]";
		}
		
}
