package com.example;

import org.jooq.DSLContext;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;

@Singleton
public class TheRepository {
    private final DSLContext a;
    private final DSLContext b;

    @Inject
    public TheRepository(
            @Named("a") final DSLContext a, @Named("b") final DSLContext b) {
        this.a = a;
        this.b = b;
    }

    @com.citics.itst.sbl.tasks.dao.Transactional("a")
    public void createTableInA() {
        a.execute("create table testing_in_a (rid bigint not null auto_increment primary key, name varchar(20) not null)");
    }

    @com.citics.itst.sbl.tasks.dao.Transactional("b")
    public void createTableInB() {
        b.execute("create table testing_in_b (rid bigint not null auto_increment primary key, name varchar(20) not null)");
    }

    @com.citics.itst.sbl.tasks.dao.Transactional("b")
    public void doSomethingInTransaction() {
        b.execute("select rid from testing_in_b where rid > 0");
    }
}
