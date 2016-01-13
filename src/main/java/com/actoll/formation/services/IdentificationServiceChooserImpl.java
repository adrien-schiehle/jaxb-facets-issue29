package com.actoll.formation.services;

import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import javax.inject.Inject;

/**
 */
@Service
public class IdentificationServiceChooserImpl implements IdentificationServiceChooser {


    private final static String METHOD_NO_PWD = "noPwd";

    @Inject
    @Qualifier("withPassword")
    private IdentificationService withPasswordService;

    @Inject
    @Qualifier("noPwd")
    private IdentificationService noPwdService;


    @Override
    public IdentificationService chooseService(String expr) {

        if( METHOD_NO_PWD.equals(expr) )
            return noPwdService;

        return withPasswordService;
    }
}
