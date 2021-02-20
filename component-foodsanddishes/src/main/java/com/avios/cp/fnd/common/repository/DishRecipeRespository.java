package com.avios.cp.fnd.common.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.avios.cp.fnd.common.entity.DishRecipe;

@Repository
public interface DishRecipeRespository extends JpaRepository<DishRecipe, Long> {

}
