package com.example;

import io.micronaut.transaction.annotation.TransactionalAdvice;

import javax.inject.Inject;
import javax.inject.Named;
import javax.inject.Singleton;
import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

@Singleton
public class TheRepository {
    private final DataSource a;
    private final DataSource b;

    @Inject
    public TheRepository(
            @Named("a") final DataSource a, @Named("b") final DataSource b) {
        this.a = a;
        this.b = b;
    }

    @com.citics.itst.sbl.tasks.dao.Transactional("a")
    public void createTableInA() {
        final DataSource ds = a;
        try (final Connection c = ds.getConnection(); final Statement stmp = c.createStatement()) {
            stmp.execute("create table testing_in_a (rid bigint not null auto_increment primary key, name varchar(20) not null)");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @com.citics.itst.sbl.tasks.dao.Transactional("b")
    public void createTableInB() {
        final DataSource ds = b;
        try (final Connection c = ds.getConnection(); final Statement stmp = c.createStatement()) {
            stmp.execute("create table testing_in_b (rid bigint not null auto_increment primary key, name varchar(20) not null)");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    @TransactionalAdvice(transactionManager = "b")
    public void doSomethingInTransaction() {
        final DataSource ds = b;
        try (final Connection c = ds.getConnection(); final Statement stmp = c.createStatement()) {
            stmp.execute("select rid from testing_in_b where rid > 0");
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
