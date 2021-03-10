/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.esic.dao;

import fr.esic.model.Person;
import fr.esic.model.Role;
import fr.esic.model.User;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ConseillerDao {

    public static void insertConseiller(User c) throws SQLException {
        String sql = "INSERT INTO utilisateur (login, mdp, idperson, idrole, statut) VALUES (?, ?, ?, 2, 1)";
        Connection connexion = AccessBd.getConnection();
        PreparedStatement prepare = connexion.prepareStatement(sql);
        prepare.setString(1, c.getLogin());
        prepare.setString(2, c.getMdp());
        prepare.setInt(3, c.getPerson().getId());
        prepare.execute();
    }

    public static List<User> getAllConseiller() throws SQLException {

        List<User> users = new ArrayList<>();

        String sql = "SELECT * FROM utilisateur u INNER JOIN person p ON p.idperson = u.idperson WHERE idrole=2";

        Connection connexion = AccessBd.getConnection();

        Statement requete = connexion.createStatement();

        ResultSet rs = requete.executeQuery(sql);
        while (rs.next()) {
            User u = new User();
            u.setId(rs.getInt("idutilisateur"));
            u.setLogin(rs.getString("login"));
            u.setMdp(rs.getString("mdp"));
            u.setStatut(rs.getInt("statut"));

            Person p = new Person();
            p.setId(rs.getInt("idperson"));
            p.setNom(rs.getString("nom"));
            p.setPrenom(rs.getString("prenom"));
            p.setSexe(rs.getString("sexe"));
            p.setTelephone(rs.getString("telephone"));
            p.setEmail(rs.getString("email"));
            p.setAddress(rs.getString("adresse"));
            p.setDateNaissance(rs.getString("dateNaissance"));
            u.setPerson(p);

            Role r = new Role();
            r.setId(rs.getInt("idrole"));
            u.setRole(r);

            users.add(u);
        }
        return users;
    }
    
    
    public static void UpdateConseiller(User u) throws SQLException {
        String sql = "UPDATE `utilisateur` SET login = ?, mdp = ? WHERE idperson = ?";

        Connection connexion = AccessBd.getConnection();
        PreparedStatement prepare = connexion.prepareStatement(sql);
        prepare.setString(1, u.getLogin());
        prepare.setString(2, u.getMdp());
        prepare.setInt(3, u.getPerson().getId());
        //System.out.println("id: " + u.getPerson().getId());
        prepare.execute();

    }


}
