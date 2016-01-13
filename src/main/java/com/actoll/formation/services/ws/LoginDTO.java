package com.actoll.formation.services.ws;

import javax.xml.bind.annotation.Facets;
import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlAttribute;
import java.io.Serializable;

/**
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class LoginDTO implements Serializable {

    @XmlAttribute( required=true )
    @Facets(pattern = "[a-zA-Z0-9]*")
    private String login;

    @XmlAttribute( required=true )
    private String pwd;

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

        LoginDTO loginDTO = (LoginDTO) o;

        if (login != null ? !login.equals(loginDTO.login) : loginDTO.login != null) return false;
        return !(pwd != null ? !pwd.equals(loginDTO.pwd) : loginDTO.pwd != null);

    }

    @Override
    public int hashCode() {
        int result = login != null ? login.hashCode() : 0;
        result = 31 * result + (pwd != null ? pwd.hashCode() : 0);
        return result;
    }
}
