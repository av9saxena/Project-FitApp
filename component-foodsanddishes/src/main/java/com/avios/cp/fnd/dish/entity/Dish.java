package com.avios.cp.fnd.dish.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.ZoneId;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "DISH")
public class Dish implements Serializable {

	public Dish() {
		this.createdTimestamp = LocalDateTime.now(ZoneId.of("UTC")).toString();
	}

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@Column(name = "PK")
	@GeneratedValue
	@JsonProperty("PK")
	private Long pk;

	@JsonProperty("DishName")
	@Column(name = "DISH_NAME", unique = true)
	private String dishName;

	@JsonProperty("DishShortDesc")
	@Column(name = "DISH_SHORT_DESC", length = 300)
	private String dishShortDesc;

	@JsonProperty("DishLargeDesc")
	@Column(name = "DISH_LARGE_DESC", length = 500)
	private String dishLargeDesc;

	@JsonProperty("EstimatedCalories")
	@Column(name = "ESMT_CALS")
	private String estimatedCalories;

	@JsonProperty("NumOfRecipes")
	@Column(name = "NUM_OF_RECIPES")
	private Integer numOfRecipes;

	@JsonProperty("CreatedTimestamp")
	@Column(name = "CREATED_TIMESTAMP")
	private String createdTimestamp;

	@JsonProperty("UpdatedTimestamp")
	@Column(name = "UPDATED_TIMESTAMP")
	private String updatedTimestamp;

	public Long getPk() {
		return pk;
	}

	public void setPk(Long pk) {
		this.pk = pk;
	}

	public String getDishName() {
		return dishName;
	}

	public void setDishName(String dishName) {
		this.dishName = dishName;
	}

	public String getDishShortDesc() {
		return dishShortDesc;
	}

	public void setDishShortDesc(String dishShortDesc) {
		this.dishShortDesc = dishShortDesc;
	}

	public String getDishLargeDesc() {
		return dishLargeDesc;
	}

	public void setDishLargeDesc(String dishLargeDesc) {
		this.dishLargeDesc = dishLargeDesc;
	}

	public String getEstimatedCalories() {
		return estimatedCalories;
	}

	public void setEstimatedCalories(String estimatedCalories) {
		this.estimatedCalories = estimatedCalories;
	}

	public Integer getNumOfRecipes() {
		return numOfRecipes;
	}

	public void setNumOfRecipes(Integer numOfRecipes) {
		this.numOfRecipes = numOfRecipes;
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
		return "Dish [pk=" + pk + ", dishName=" + dishName + ", dishShortDesc=" + dishShortDesc + ", dishLargeDesc="
				+ dishLargeDesc + ", estimatedCalories=" + estimatedCalories + ", numOfRecipes=" + numOfRecipes
				+ ", createdTimestamp=" + createdTimestamp + ", updatedTimestamp=" + updatedTimestamp + "]";
	}
}
