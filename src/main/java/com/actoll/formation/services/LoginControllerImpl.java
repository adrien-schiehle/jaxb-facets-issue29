package com.actoll.formation.services;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.inject.Inject;

/**
 */
@Controller
public class LoginControllerImpl implements LoginController {

    @Inject
    protected IdentificationServiceChooser chooser;

    @Value("${identification.method}")
    private String method;

    @RequestMapping("/login")
    @Override
    public String doLogin( @RequestParam( value = "name", required = true ) String name,
                           @RequestParam( value = "pwd", required = false, defaultValue = "Actoll123") String pwd,
                           Model model) {

        IdentificationService choice = chooser.chooseService(method);
        return checkLogin( name, pwd, model, choice );
    }

    public String checkLogin( String name,String pwd, Model model, IdentificationService choice ) {

        boolean identified = choice.testLogin(name, pwd);

        model.addAttribute("name", name );
        model.addAttribute("identified", identified);

        return "hello";
    }
}
