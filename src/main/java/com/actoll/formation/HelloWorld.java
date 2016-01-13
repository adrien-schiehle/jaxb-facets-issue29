package com.actoll.formation;


import com.actoll.formation.services.Customer;
import com.actoll.formation.services.CustomerRepository;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;

import java.util.Arrays;
import java.util.Comparator;

/**
 */
@SpringBootApplication
public class HelloWorld {


    public static void main(String[] args) {

        ApplicationContext ctx = SpringApplication.run(HelloWorld.class, args);

        listBeans(ctx);
        initCustomerTable(ctx);
    }

    private static void listBeans(ApplicationContext ctx) {

        String[] beanNames = ctx.getBeanDefinitionNames();
        // Methode sans lambda
        /*
        Arrays.sort(beanNames, new Comparator<String>() {
            @Override
            public int compare(String bean1, String bean2) {
                return bean1.length() - bean2.length();
            }
        });
        */

        // Methode avec lambda
        Arrays.sort(beanNames, (bean1, bean2) -> { return bean2.length() - bean1.length(); } );

    for (String beanName : beanNames) {
        System.out.println(beanName);
    }
}

    protected static void initCustomerTable(ApplicationContext ctx) {

        // Ajouter de données dans la base en mémoire H2
        CustomerRepository custRepo = ctx.getBean(CustomerRepository.class);

        Customer cust = new Customer();
        cust.setLogin("asc");
        cust.setPwd("actoll123");
        custRepo.save(cust);

        cust = new Customer();
        cust.setLogin("mmo");
        cust.setPwd("ACTOLL321");
        custRepo.save(cust);

        cust = new Customer();
        cust.setLogin("jva");
        cust.setPwd("123AcToLl");
        custRepo.save(cust);
    }

}
