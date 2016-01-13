package com.actoll.formation.services;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Implementation bateau du service n'acceptant que l'utilisateur 'dummy'
 */
@Service("withPassword")
public class IdentificationServiceWithPassword implements IdentificationService {

    @Inject
    CustomerRepository repo;

    @Override
    public boolean testLogin( String login, String mdp ) {
        return isLoginAccepted(login, mdp);
    }

    public boolean isLoginAccepted(String login, String pwd) {

        Customer customer = repo.findByLoginAndPwd(login, pwd);
        return customer != null;
    }

    @Override
    public List<Customer> getAllUsers() {
        return repo.findAll();
    }
}


