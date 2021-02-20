package com.avios.cp.fnd.common.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDishRecipe is a Querydsl query type for DishRecipe
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDishRecipe extends EntityPathBase<DishRecipe> {

    private static final long serialVersionUID = 838703008L;

    public static final QDishRecipe dishRecipe = new QDishRecipe("dishRecipe");

    public final NumberPath<Long> dishPk = createNumber("dishPk", Long.class);

    public final StringPath estimatedCalories = createString("estimatedCalories");

    public final StringPath estimatedPrepTime = createString("estimatedPrepTime");

    public final NumberPath<Long> pk = createNumber("pk", Long.class);

    public final StringPath recipeLargeDesc = createString("recipeLargeDesc");

    public final StringPath recipeShortDesc = createString("recipeShortDesc");

    public final StringPath recipeSteps = createString("recipeSteps");

    public final StringPath recipeTitle = createString("recipeTitle");

    public QDishRecipe(String variable) {
        super(DishRecipe.class, forVariable(variable));
    }

    public QDishRecipe(Path<? extends DishRecipe> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDishRecipe(PathMetadata metadata) {
        super(DishRecipe.class, metadata);
    }

}

