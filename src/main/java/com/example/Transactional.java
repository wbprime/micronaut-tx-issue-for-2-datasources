package com.citics.itst.sbl.tasks.dao;

import io.micronaut.context.annotation.AliasFor;
import io.micronaut.transaction.TransactionDefinition;
import io.micronaut.transaction.annotation.TransactionalAdvice;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Target({ElementType.METHOD, ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@TransactionalAdvice
public @interface Transactional {
  @AliasFor(annotation = TransactionalAdvice.class, member = "value")
  String value();

  @AliasFor(annotation = TransactionalAdvice.class, member = "readOnly")
  boolean readOnly() default false;

  @AliasFor(annotation = TransactionalAdvice.class, member = "propagation")
  TransactionDefinition.Propagation propagation() default TransactionDefinition.Propagation.REQUIRED;

  @AliasFor(annotation = TransactionalAdvice.class, member = "noRollbackFor")
  Class[] dontRollbackOn() default {};
}
