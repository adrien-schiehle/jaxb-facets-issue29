package com.actoll.formation.services;

import javax.persistence.*;

/**
 */
@Entity
@SequenceGenerator(name = "SEQ_ASC_CUSTOMER", sequenceName = "SEQ_ASC_CUSTOMER", allocationSize = 1)
@Table( name="ASC_CUSTOMER", schema = "EMMA" )
public class Customer {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_ASC_CUSTOMER")
    @Column(name = "ID")
    private Long id;

    @Column(name = "LOGIN", nullable = false, unique = true)
    private String login;

    @Column(name = "PASSWORD", nullable = true)
    private String pwd;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Customer customer = (Customer) o;

        if (id != null ? !id.equals(customer.id) : customer.id != null) return false;
        if (login != null ? !login.equals(customer.login) : customer.login != null) return false;
        if (pwd != null ? !pwd.equals(customer.pwd) : customer.pwd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (login != null ? login.hashCode() : 0);
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        return result;
    }
}
