package com.avios.cp.fnd.common.entity;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.avios.cp.fnd.food.entity.Food;

@Entity
@Table(name = "FOOD_RECIPE")
public class FoodRecipe {

	@EmbeddedId
	private FoodRecipeId foodRecipeId;

	@ManyToOne(fetch = FetchType.LAZY)
	private DishRecipe recipe;

	@ManyToOne(fetch = FetchType.EAGER)
	private Food food;

	@Column(name = "Quantity", columnDefinition = "DECIMAL(16,2)")
	private BigDecimal quantity;

	@Column(name = "CREATED_TIMESTAMP", columnDefinition = "TIMESTAMP", nullable = false)
	private Date createdTimestamp;

	@Column(name = "UPDATED_TIMESTAMP", columnDefinition = "TIMESTAMP")
	private Date updatedTimestamp;

	public FoodRecipeId getFoodRecipeId() {
		return foodRecipeId;
	}

	public void setFoodRecipeId(FoodRecipeId foodRecipeId) {
		this.foodRecipeId = foodRecipeId;
	}

	public DishRecipe getRecipe() {
		return recipe;
	}

	public void setRecipe(DishRecipe recipe) {
		this.recipe = recipe;
	}

	public Food getFood() {
		return food;
	}

	public void setFood(Food food) {
		this.food = food;
	}

	public BigDecimal getQuantity() {
		return quantity;
	}

	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}

	public Date getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(Date createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public Date getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(Date updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}
}
