package com.avios.cp.fnd.common.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFoodRecipeId is a Querydsl query type for FoodRecipeId
 */
@Generated("com.querydsl.codegen.EmbeddableSerializer")
public class QFoodRecipeId extends BeanPath<FoodRecipeId> {

    private static final long serialVersionUID = 327037855L;

    public static final QFoodRecipeId foodRecipeId = new QFoodRecipeId("foodRecipeId");

    public final NumberPath<Long> foodPK = createNumber("foodPK", Long.class);

    public final NumberPath<Long> recipePK = createNumber("recipePK", Long.class);

    public QFoodRecipeId(String variable) {
        super(FoodRecipeId.class, forVariable(variable));
    }

    public QFoodRecipeId(Path<? extends FoodRecipeId> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFoodRecipeId(PathMetadata metadata) {
        super(FoodRecipeId.class, metadata);
    }

}

