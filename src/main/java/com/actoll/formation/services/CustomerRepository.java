package com.actoll.formation.services;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

/**
 */
public interface CustomerRepository extends JpaRepository<Customer, Long> {

    @Query("from Customer where login=:name")
    Customer findByLogin(@Param(value="name") String login);

    @Query("from Customer where login=:name and pwd=:pwd")
    Customer findByLoginAndPwd(@Param(value="name") String login, @Param(value="pwd") String pwd);
}
