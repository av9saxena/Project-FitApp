package com.avios.cp.fnd.food.entity;

import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "FOOD")
public class Food {

	public Food() {
		this.createdTimestamp = LocalDateTime.now(ZoneId.of("UTC")).toString();
	}

	@Id
	@Column(name = "PK")
	@GeneratedValue
	@JsonProperty("PK")
	private Long pk;

	@JsonProperty("FoodName")
	@Column(name = "FOOD_NAME", unique = true)
	private String foodName;

	@JsonProperty("FoodShortDesc")
	@Column(name = "FOOD_SHORT_DESC", length = 300)
	private String foodShortDesc;

	@JsonProperty("FoodLargeDesc")
	@Column(name = "FOOD_LARGE_DESC", length = 500)
	private String foodLargeDesc;

	@JsonProperty("EstimatedCalories")
	@Column(name = "ESMT_CALS")
	private String estimatedCalories;

	@JsonProperty("Protein")
	@Column(name = "NUTR_PROTEIN")
	private String nutr_protein;

	@JsonProperty("Carbs")
	@Column(name = "NUTR_CARBS")
	private String nutr_carbs;

	@JsonProperty("Fats")
	@Column(name = "NUTR_FATS")
	private String nutr_fats;

	@JsonProperty("OtherNutrients")
	@Column(name = "NUTR_OTHERS")
	private String nutr_others;

	@JsonProperty("CreatedOn")
	@Column(name = "CREATED_TIMESTAMP")
	private String createdTimestamp;

	@JsonProperty("UpdatedOn")
	@Column(name = "UPDATED_TIMESTAMP")
	private String updatedTimestamp;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getFoodName() {
		return foodName;
	}

	public void setFoodName(String foodName) {
		this.foodName = foodName;
	}

	public String getFoodShortDesc() {
		return foodShortDesc;
	}

	public void setFoodShortDesc(String foodShortDesc) {
		this.foodShortDesc = foodShortDesc;
	}

	public String getFoodLargeDesc() {
		return foodLargeDesc;
	}

	public void setFoodLargeDesc(String foodLargeDesc) {
		this.foodLargeDesc = foodLargeDesc;
	}

	public String getEstimatedCalories() {
		return estimatedCalories;
	}

	public void setEstimatedCalories(String estimatedCalories) {
		this.estimatedCalories = estimatedCalories;
	}

	public String getNutr_protein() {
		return nutr_protein;
	}

	public void setNutr_protein(String nutr_protein) {
		this.nutr_protein = nutr_protein;
	}

	public String getNutr_carbs() {
		return nutr_carbs;
	}

	public void setNutr_carbs(String nutr_carbs) {
		this.nutr_carbs = nutr_carbs;
	}

	public String getNutr_fats() {
		return nutr_fats;
	}

	public void setNutr_fats(String nutr_fats) {
		this.nutr_fats = nutr_fats;
	}

	public String getNutr_others() {
		return nutr_others;
	}

	public void setNutr_others(String nutr_others) {
		this.nutr_others = nutr_others;
	}

	public String getCreatedTimestamp() {
		return createdTimestamp;
	}

	public void setCreatedTimestamp(String createdTimestamp) {
		this.createdTimestamp = createdTimestamp;
	}

	public String getUpdatedTimestamp() {
		return updatedTimestamp;
	}

	public void setUpdatedTimestamp(String updatedTimestamp) {
		this.updatedTimestamp = updatedTimestamp;
	}

	@Override
	public String toString() {
		return "Food [pk=" + pk + ", foodName=" + foodName + ", foodShortDesc=" + foodShortDesc + ", foodLargeDesc="
				+ foodLargeDesc + ", estimatedCalories=" + estimatedCalories + ", nutr_protein=" + nutr_protein + ", nutr_carbs="
				+ nutr_carbs + ", nutr_fats=" + nutr_fats + ", nutr_others=" + nutr_others + ", createdTimestamp="
				+ createdTimestamp + ", updatedTimestamp=" + updatedTimestamp + "]";
	}
}
