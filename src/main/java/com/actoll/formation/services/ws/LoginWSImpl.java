package com.actoll.formation.services.ws;

import com.actoll.formation.services.Customer;
import com.actoll.formation.services.IdentificationService;
import com.actoll.formation.services.IdentificationServiceWithPassword;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;

import javax.inject.Inject;
import javax.jws.WebService;
import java.util.ArrayList;
import java.util.List;

@WebService( endpointInterface = "com.actoll.formation.services.ws.LoginWS")
public class LoginWSImpl implements LoginWS {

    @Qualifier("withPassword")
    //@Qualifier("noPwd")
    @Inject
    IdentificationService service;


    @Override
    public String testLogin( LoginDTO user )
    {
        boolean identified = service.testLogin(user.getLogin(), user.getPwd());

        return "Identified ? " + identified;
    }

    @Override
    public ListingResultDTO getAllUsers() {
        List<Customer> customers = service.getAllUsers();
        return createListingResult(customers);


    }

    /**
     * Build the 'SOAP' response from the customer taken from database
     * @param customers database response
     * @return the 'SOAP' response
     */
    private ListingResultDTO createListingResult(List<Customer> customers) {
        // Build the response
        ListingResultDTO result = new ListingResultDTO();
        result.setNb(customers.size());

        List<UserDTO> users = new ArrayList<>();
        for( Customer customer : customers ) {
            UserDTO user = new UserDTO();
            user.setLogin(customer.getLogin());
            user.setPwd(customer.getPwd());
            users.add(user);
        }
        result.setUsers(users);

        return result;
    }


}
