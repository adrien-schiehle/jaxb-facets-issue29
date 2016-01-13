package com.actoll.formation;

import com.ninja_squad.dbsetup.DbSetup;
import com.ninja_squad.dbsetup.destination.DataSourceDestination;
import com.ninja_squad.dbsetup.operation.Operation;
import org.h2.jdbcx.JdbcDataSource;
import org.springframework.beans.factory.annotation.Value;

import java.util.ArrayList;
import java.util.List;

import static com.ninja_squad.dbsetup.Operations.*;

/**
 * Common requests for DbSetup calls
 */
public class CommonOperations {

    @Value("${spring.datasource.url}")
    private String datasourceUrl;

    @Value("${spring.datasource.username}")
    private String datasourceLogin;

    @Value("${spring.datasource.password}")
    private String datasourcePwd;

    private Operation REF_LOGINS = insertInto("ASC_CUSTOMER")
            .columns("ID", "LOGIN", "PASSWORD")
            .values(1, "asc", "123456")
            .values(2, "api", "23456")
            .values(3, "rbi", "3456")
            .values(4, "cre", "456")
            .build();

    private Operation INSERT_REFERENCE_DATA = sequenceOf( REF_LOGINS );

    private Operation DELETE_ALL = deleteAllFrom("ASC_CUSTOMER");

    public void reloadDatabase() {
        reloadDatabase(new ArrayList<Operation>(),
                       new ArrayList<Operation>());
    }

    public void reloadDatabase( List<Operation> priorDelete, List<Operation> afterInsert ) {

        List<Operation> allActions = new ArrayList<>();
        allActions.addAll(priorDelete);
        allActions.add(DELETE_ALL);
        allActions.add(INSERT_REFERENCE_DATA);
        allActions.addAll(afterInsert);

        Operation allOps = sequenceOf(allActions);

        DbSetup dbSetup = new DbSetup(getDestination(), allOps);
        dbSetup.launch();
    }

    private DataSourceDestination getDestination() {

        JdbcDataSource datasource = new JdbcDataSource();
        datasource.setURL(datasourceUrl);
        datasource.setUser(datasourceLogin);
        datasource.setPassword(datasourcePwd);
        return new DataSourceDestination(datasource);
    }
}
