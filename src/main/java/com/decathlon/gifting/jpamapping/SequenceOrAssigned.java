package com.decathlon.gifting.jpamapping;

import org.hibernate.annotations.IdGeneratorType;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.ElementType.METHOD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

@IdGeneratorType( SequenceOrAssignedGenerator.class )
@Target( { METHOD, FIELD } )
@Retention( RUNTIME )
public @interface SequenceOrAssigned {
    String name();

    String sequenceName();

    int allocationSize();
}