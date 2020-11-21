package com.example;

import org.jooq.DSLContext;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.transaction.Transactional;

@Singleton
public class TheRepository {
    private final DSLContext a;
    private final DSLContext b;

    @Inject
    public TheRepository(@Named("a") final DSLContext a, @Named("b") final DSLContext b) {
        this.a = a;
        this.b = b;
    }

    public void createTableInA() {
        a.execute("create table testing_in_a (rid bigint not null auto_increment primary key, name varchar(20) not null)");
    }

    @Transactional
    public void doSomethingInTransaction() {
        a.execute("select rid from testing_in_a wher rid > 0");
    }
}
