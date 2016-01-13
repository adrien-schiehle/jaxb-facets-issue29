package com.actoll.formation.services;

import java.util.List;

/**
 * Service permettant de gérant l'identification d'un utilisateur
 */
public interface IdentificationService {

    /**
     * Permet de verifier un login utilisateur
     * @param login : Le user voulant s'identifer
     * @param mdp : Son mot de passe (en clair biensur...)
     * @return TRUE si l'idenfication est valide.
     */
    boolean testLogin( String login, String mdp );

    /**
     * Récupère la liste de tous les utilisateurs enregistrés en base
     * @return La liste en question.
     */
    List<Customer> getAllUsers();
}
