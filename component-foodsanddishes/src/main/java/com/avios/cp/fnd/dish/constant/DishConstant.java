package com.avios.cp.fnd.dish.constant;

public interface DishConstant {
	
	enum Fields {
		PK("PK"),
		DISH_NAME("DishName");

		private String value;

		private Fields(String value) {
			this.value = value;
		}

		public String value() {
			return this.value;
		}
	};
}
