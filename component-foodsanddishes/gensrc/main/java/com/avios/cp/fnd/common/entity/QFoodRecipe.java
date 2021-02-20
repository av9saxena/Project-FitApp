package com.avios.cp.fnd.common.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.PathInits;


/**
 * QFoodRecipe is a Querydsl query type for FoodRecipe
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFoodRecipe extends EntityPathBase<FoodRecipe> {

    private static final long serialVersionUID = 554529636L;

    private static final PathInits INITS = PathInits.DIRECT2;

    public static final QFoodRecipe foodRecipe = new QFoodRecipe("foodRecipe");

    public final DateTimePath<java.util.Date> createdTimestamp = createDateTime("createdTimestamp", java.util.Date.class);

    public final com.avios.cp.fnd.food.entity.QFood food;

    public final QFoodRecipeId foodRecipeId;

    public final NumberPath<java.math.BigDecimal> quantity = createNumber("quantity", java.math.BigDecimal.class);

    public final QDishRecipe recipe;

    public final DateTimePath<java.util.Date> updatedTimestamp = createDateTime("updatedTimestamp", java.util.Date.class);

    public QFoodRecipe(String variable) {
        this(FoodRecipe.class, forVariable(variable), INITS);
    }

    public QFoodRecipe(Path<? extends FoodRecipe> path) {
        this(path.getType(), path.getMetadata(), path.getMetadata().isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFoodRecipe(PathMetadata metadata) {
        this(metadata, metadata.isRoot() ? INITS : PathInits.DEFAULT);
    }

    public QFoodRecipe(PathMetadata metadata, PathInits inits) {
        this(FoodRecipe.class, metadata, inits);
    }

    public QFoodRecipe(Class<? extends FoodRecipe> type, PathMetadata metadata, PathInits inits) {
        super(type, metadata, inits);
        this.food = inits.isInitialized("food") ? new com.avios.cp.fnd.food.entity.QFood(forProperty("food")) : null;
        this.foodRecipeId = inits.isInitialized("foodRecipeId") ? new QFoodRecipeId(forProperty("foodRecipeId")) : null;
        this.recipe = inits.isInitialized("recipe") ? new QDishRecipe(forProperty("recipe")) : null;
    }

}

