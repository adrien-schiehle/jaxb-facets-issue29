package com.actoll.formation.services.ws;

import javax.xml.bind.annotation.*;
import java.io.Serializable;
import java.util.List;

/**
 */
@XmlAccessorType(XmlAccessType.FIELD)
public class ListingResultDTO implements Serializable {

    @XmlAttribute
    private int nb;

    @XmlElement( name = "user" )
    List<UserDTO> users;

    public int getNb() {
        return nb;
    }

    public void setNb(int nb) {
        this.nb = nb;
    }

    public List<UserDTO> getUsers() {
        return users;
    }

    public void setUsers(List<UserDTO> users) {
        this.users = users;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        ListingResultDTO that = (ListingResultDTO) o;

        if (nb != that.nb) return false;
        if (users != null ? !users.equals(that.users) : that.users != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = nb;
        result = 31 * result + (users != null ? users.hashCode() : 0);
        return result;
    }
}
