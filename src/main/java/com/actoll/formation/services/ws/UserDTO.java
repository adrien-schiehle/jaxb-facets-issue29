package com.actoll.formation.services.ws;

import javax.xml.bind.annotation.*;
import java.io.Serializable;

/**
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class UserDTO implements Serializable {

    @XmlAttribute
    private String login;

    @XmlAttribute
    private String pwd;

    @XmlAttribute
    @Facets(minInclusive="0", maxInclusive="100")
    private Integer age;

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

        UserDTO userDTO = (UserDTO) o;

        if (login != null ? !login.equals(userDTO.login) : userDTO.login != null) return false;
        if (pwd != null ? !pwd.equals(userDTO.pwd) : userDTO.pwd != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        return result;
    }
}
