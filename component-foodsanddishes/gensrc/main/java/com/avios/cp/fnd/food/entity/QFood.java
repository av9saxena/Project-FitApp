package com.avios.cp.fnd.food.entity;

import static com.querydsl.core.types.PathMetadataFactory.*;

import com.querydsl.core.types.dsl.*;

import com.querydsl.core.types.PathMetadata;
import javax.annotation.Generated;
import com.querydsl.core.types.Path;


/**
 * QFood is a Querydsl query type for Food
 */
@Generated("com.querydsl.codegen.EntitySerializer")
public class QFood extends EntityPathBase<Food> {

    private static final long serialVersionUID = -1156234199L;

    public static final QFood food = new QFood("food");

    public final StringPath createdTimestamp = createString("createdTimestamp");

    public final StringPath estimatedCalories = createString("estimatedCalories");

    public final StringPath foodLargeDesc = createString("foodLargeDesc");

    public final StringPath foodName = createString("foodName");

    public final StringPath foodShortDesc = createString("foodShortDesc");

    public final StringPath nutr_carbs = createString("nutr_carbs");

    public final StringPath nutr_fats = createString("nutr_fats");

    public final StringPath nutr_others = createString("nutr_others");

    public final StringPath nutr_protein = createString("nutr_protein");

    public final NumberPath<Long> pk = createNumber("pk", Long.class);

    public final StringPath updatedTimestamp = createString("updatedTimestamp");

    public QFood(String variable) {
        super(Food.class, forVariable(variable));
    }

    public QFood(Path<? extends Food> path) {
        super(path.getType(), path.getMetadata());
    }

    public QFood(PathMetadata metadata) {
        super(Food.class, metadata);
    }

}

