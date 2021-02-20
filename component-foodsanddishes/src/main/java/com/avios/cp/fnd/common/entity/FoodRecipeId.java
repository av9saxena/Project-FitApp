package com.avios.cp.fnd.common.entity;

import java.io.Serializable;
import java.util.Objects;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class FoodRecipeId implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Column(name = "FOOD_PK")
	private Long foodPK;

	@Column(name = "RECIPE_PK")
	private Long recipePK;

	public Long getFoodPK() {
		return foodPK;
	}

	public void setFoodPK(Long foodPK) {
		this.foodPK = foodPK;
	}

	public Long getRecipePK() {
		return recipePK;
	}

	public void setRecipePK(Long recipePK) {
		this.recipePK = recipePK;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;

		if (o == null || getClass() != o.getClass())
			return false;

		FoodRecipeId that = (FoodRecipeId) o;
		return Objects.equals(foodPK, that.foodPK) && Objects.equals(recipePK, that.recipePK);
	}

	@Override
	public int hashCode() {
		return Objects.hash(foodPK, recipePK);
	}
}
