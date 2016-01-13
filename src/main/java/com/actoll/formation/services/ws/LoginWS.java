package com.actoll.formation.services.ws;

import org.apache.cxf.annotations.SchemaValidation;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;
import javax.xml.bind.annotation.XmlElement;

/**
 */
@WebService
@SchemaValidation
public interface LoginWS {

    @WebMethod
    @WebResult(name = "response")
    String testLogin( @WebParam(name = "user")  @XmlElement(required=true)  LoginDTO user );


    @WebMethod
    @WebResult(name = "list")
    ListingResultDTO getAllUsers();

}
