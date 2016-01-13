package com.actoll.formation.services;

import mockit.Mock;
import mockit.MockUp;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.ui.ExtendedModelMap;
import org.springframework.ui.Model;

import java.util.function.Predicate;

public class LoginControllerImplTest {

    private LoginControllerImpl test;

    @Before
    public void setUp() throws Exception {

        test = new LoginControllerImpl();
    }

    private void mockChooser(Predicate<String> predicate ) {

        IdentificationService service = new IdentificationServiceMock(predicate).getMockInstance();
        test.chooser = new IdentificationServiceChooserMock(service).getMockInstance();
    }


    @Test
    public void doLogin_OK() throws Exception {

        Model model = new ExtendedModelMap();

        mockChooser(  (login) -> {return true;} );
        String view = test.doLogin("asc", "pwd", model);

        Assert.assertEquals("Wrong view", "hello", view);
        Assert.assertEquals("Wrong name attribute", "asc", model.asMap().get("name"));
        Assert.assertEquals("Wrong identified attribute", true,  model.asMap().get("identified"));
    }



    @Test
    public void doLogin_serviceTakenIntoAccount() throws Exception {

        Model model = new ExtendedModelMap();
        mockChooser(  (login) -> {return login.equals("asc");} );

        test.doLogin("asc", "pwd", model);
        Assert.assertEquals("asc should be ok", true,  model.asMap().get("identified"));

        test.doLogin("api", "pwd", model);
        Assert.assertEquals("api should be ko", false,  model.asMap().get("identified"));
    }


    /**
     * Classe permettant de mocker les appels au bean IdentificationServiceChooser
     */
    private class IdentificationServiceChooserMock extends MockUp<IdentificationServiceChooser> {

        private IdentificationService choice;

        public IdentificationServiceChooserMock( IdentificationService choice ) {
            this.choice = choice;
        }

        @Mock
        IdentificationService chooseService(String expr) {
            return choice;
        }
    }


    private class IdentificationServiceMock extends  MockUp<IdentificationService> {

        Predicate<String> predicate;

        public IdentificationServiceMock( Predicate<String> predicate ) {
            this.predicate = predicate;
        }

        @Mock
        boolean testLogin( String login, String mdp ) { return predicate.test(login); }

    }
}