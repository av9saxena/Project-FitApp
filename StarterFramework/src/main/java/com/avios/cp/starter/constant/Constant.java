package com.avios.cp.starter.constant;

public interface Constant {

	enum Fields {
		PK("PK");
		
		private String value;
		
		private Fields(String value) {
			this.value = value;
		}
		
		public String value() {
			return this.value;
		}
	}
}
