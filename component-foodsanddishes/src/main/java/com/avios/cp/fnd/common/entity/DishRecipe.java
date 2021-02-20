package com.avios.cp.fnd.common.entity;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "DISH_RECIPES")
public class DishRecipe implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PK")
	@GeneratedValue
	@JsonProperty("PK")
	private Long pk;

	@JsonProperty("DishPK")
	@Column(name = "DISH_PK")
	private Long dishPk;

	@JsonProperty("RecipeTitle")
	@Column(name = "RECIPE_TITLE", unique = true)
	private String recipeTitle;

	@JsonProperty("RecipeShortDesc")
	@Column(name = "RECIPE_SHORT_DESC", length = 300)
	private String recipeShortDesc;

	@JsonProperty("RecipeLargeDesc")
	@Column(name = "RECIPE_LARGE_DESC", length = 500)
	private String recipeLargeDesc;

	@JsonProperty("RecipeSteps")
	@Column(name = "RECIPE_STEPS", columnDefinition = "TEXT")
	private String recipeSteps;

	@JsonProperty("EstimatedCalories")
	@Column(name = "ESMT_CALS")
	private String estimatedCalories;

	@JsonProperty("EstimatedPrepTime")
	@Column(name = "ESMT_PREP_TIME")
	private String estimatedPrepTime;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public Long getDishPk() {
		return dishPk;
	}

	public void setDishPk(Long dishPk) {
		this.dishPk = dishPk;
	}

	public String getRecipeTitle() {
		return recipeTitle;
	}

	public void setRecipeTitle(String recipeTitle) {
		this.recipeTitle = recipeTitle;
	}

	public String getRecipeShortDesc() {
		return recipeShortDesc;
	}

	public void setRecipeShortDesc(String recipeShortDesc) {
		this.recipeShortDesc = recipeShortDesc;
	}

	public String getRecipeLargeDesc() {
		return recipeLargeDesc;
	}

	public void setRecipeLargeDesc(String recipeLargeDesc) {
		this.recipeLargeDesc = recipeLargeDesc;
	}

	public String getRecipeSteps() {
		return recipeSteps;
	}

	public void setRecipeSteps(String recipeSteps) {
		this.recipeSteps = recipeSteps;
	}

	public String getEstimatedCalories() {
		return estimatedCalories;
	}

	public void setEstimatedCalories(String estimatedCalories) {
		this.estimatedCalories = estimatedCalories;
	}

	public String getEstimatedPrepTime() {
		return estimatedPrepTime;
	}

	public void setEstimatedPrepTime(String estimatedPrepTime) {
		this.estimatedPrepTime = estimatedPrepTime;
	}
}
