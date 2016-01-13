package com.actoll.formation.services;

import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Implementation bateau du service n'acceptant que l'utilisateur 'dummy'
 */
@Service("noPwd")
public class IdentificationServiceNoPwd implements IdentificationService {

    @Inject
    CustomerRepository repo;

    public void setRepo(CustomerRepository repo) {
        this.repo = repo;
    }

    @Override
    public boolean testLogin( String login, String mdp ) {

        return isLoginAccepted(login);
    }

    @Override
    public List<Customer> getAllUsers() {
        return repo.findAll();
    }

    public boolean isLoginAccepted(String login) {

        Customer customer = repo.findByLogin(login);
        return customer != null;
    }
}


