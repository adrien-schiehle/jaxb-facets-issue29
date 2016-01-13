package com.actoll.formation.services;

import com.actoll.formation.CommonOperations;
import com.actoll.formation.UnitTestApplication;
import jdk.nashorn.internal.ir.annotations.Ignore;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration( classes = {UnitTestApplication.class} )
public class IdentificationServiceNoPwdTest {

    @Inject
    IdentificationServiceNoPwd test;

    @Inject
    CommonOperations dbOperations;

    private boolean init = false;

    @Before
    public void setUp() {

        if( ! init ) {
            dbOperations.reloadDatabase();
            init = true;
        }
    }

    @Transactional
    @Test
    public void testValidLogin() throws Exception {

        boolean result = test.isLoginAccepted("asc");
        Assert.assertEquals("asc should be accepted",true, result);
    }

    @Transactional
    @Test
    public void testInvalidLogin() throws Exception {

        boolean result = test.isLoginAccepted("ASC");
        Assert.assertEquals("ASC should be refused", false, result);
    }
}