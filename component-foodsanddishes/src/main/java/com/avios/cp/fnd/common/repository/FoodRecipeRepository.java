package com.avios.cp.fnd.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avios.cp.fnd.common.entity.FoodRecipe;
import com.avios.cp.fnd.common.entity.FoodRecipeId;

@Repository
public interface FoodRecipeRepository extends JpaRepository<FoodRecipe, FoodRecipeId> {

}
