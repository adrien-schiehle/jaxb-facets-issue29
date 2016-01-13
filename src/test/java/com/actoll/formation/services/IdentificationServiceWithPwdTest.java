package com.actoll.formation.services;

import com.actoll.formation.CommonOperations;
import com.actoll.formation.UnitTestApplication;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.inject.Inject;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration( classes = {UnitTestApplication.class} )
public class IdentificationServiceWithPwdTest {

    @Inject
    IdentificationServiceWithPassword test;

    @Inject
    CommonOperations dbOperations;

    @Test
    public void testValidLoginAndPwd() throws Exception {

        dbOperations.reloadDatabase();
        boolean result = test.isLoginAccepted("asc", "123456");
        Assert.assertEquals("asc should be accepted",true, result);
    }

    @Test
    public void testValidLoginWrongPwd() throws Exception {

        dbOperations.reloadDatabase();
        boolean result = test.isLoginAccepted("asc", "xxxxxx");
        Assert.assertEquals("asc should be refused",false, result);
    }

    @Test
    public void testInvalidLogin() throws Exception {

        dbOperations.reloadDatabase();
        boolean result = test.isLoginAccepted("ASC", "xxxxx");
        Assert.assertEquals("ASC should be refused", false, result);
    }
}