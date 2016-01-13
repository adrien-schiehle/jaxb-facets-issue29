package com.actoll.formation.services.ws;

import com.actoll.formation.CommonOperations;
import com.actoll.formation.UnitTestApplication;
import com.actoll.formation.services.Customer;
import com.actoll.formation.services.CustomerRepository;
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
public class LoginWSImplTest {

    @Inject
    private LoginWSImpl test;

    @Inject
    CommonOperations dbOperations;

    @Test
    public void loginTest_ko() {

        dbOperations.reloadDatabase();

        LoginDTO login = new LoginDTO();
        login.setLogin("asc");
        login.setPwd("xxxx");
        String result = test.testLogin(login);
        Assert.assertEquals("Should have been rejected", "Identified ? false", result);
    }

    @Test
    public void loginTest_ok() {

        dbOperations.reloadDatabase();

        LoginDTO login = new LoginDTO();
        login.setLogin("asc");
        login.setPwd("123456");
        String result = test.testLogin(login);
        Assert.assertEquals("Should have been accepted", "Identified ? true", result);
    }
}
