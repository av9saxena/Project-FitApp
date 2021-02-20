package com.avios.cp.fnd.dish.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QDish is a Querydsl query type for Dish
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QDish extends EntityPathBase<Dish> {

    private static final long serialVersionUID = 508513441L;

    public static final QDish dish = new QDish("dish");

    public final StringPath createdTimestamp = createString("createdTimestamp");

    public final StringPath dishLargeDesc = createString("dishLargeDesc");

    public final StringPath dishName = createString("dishName");

    public final StringPath dishShortDesc = createString("dishShortDesc");

    public final StringPath estimatedCalories = createString("estimatedCalories");

    public final NumberPath<Integer> numOfRecipes = createNumber("numOfRecipes", Integer.class);

    public final NumberPath<Long> pk = createNumber("pk", Long.class);

    public final StringPath updatedTimestamp = createString("updatedTimestamp");

    public QDish(String variable) {
        super(Dish.class, forVariable(variable));
    }

    public QDish(Path<? extends Dish> path) {
        super(path.getType(), path.getMetadata());
    }

    public QDish(PathMetadata metadata) {
        super(Dish.class, metadata);
    }

}

