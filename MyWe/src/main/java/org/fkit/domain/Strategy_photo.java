package org.fkit.domain;

public class Strategy_photo {
		private Integer id;
		private String image;
		
		public Integer getId() {
			return id;
		}

		public void setId(Integer id) {
			this.id = id;
		}

		public String getImage() {
			return image;
		}

		public void setImage(String image) {
			this.image = image;
		}

		@Override
		public String toString() {
			return " Strategy_photo[id=" + id + ", image=" + image +" ]";
		}
}
