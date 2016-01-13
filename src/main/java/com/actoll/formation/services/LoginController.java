package com.actoll.formation.services;

import org.springframework.ui.Model;

/**
 */
public interface LoginController {

    String doLogin(String name, String pwd, Model model);
}
