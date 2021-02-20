package com.avios.cp.fnd.food.constant;

public interface FoodConstants {

	enum Fields {
		PK("PK"),
		FOOD_NAME("FoodName");
		
		private String value;
		
		private Fields(String value) {
			this.value = value;
		}
		
		public String value() {
			return this.value;
		}
	};
	
	enum Constant {
		PAGE("page"),
		BATCH_SIZE("size");
		
		private String value;
		
		private Constant(String value) {
			this.value = value;
		}
		
		public String value() {
			return this.value;
		}
	};
}
