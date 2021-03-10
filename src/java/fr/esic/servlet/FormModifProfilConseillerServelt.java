/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.esic.servlet;

import fr.esic.dao.ConseillerDao;
import fr.esic.dao.PersonDao;
import fr.esic.model.Person;
import fr.esic.model.User;
import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Nathan Ghozlan
 */
@WebServlet(name = "FormModifProfilConseillerServelt", urlPatterns = {"/FormModifConseiller"})
public class FormModifProfilConseillerServelt extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet FormModifProfilConseillerServelt</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet FormModifProfilConseillerServelt at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        //processRequest(request, response);

        
        String idperson = request.getParameter("idperson");
        int id = Integer.parseInt(idperson);
        
        String nom = request.getParameter("nom");
        String prenom = request.getParameter("prenom");

        String telephone = request.getParameter("telephone");
        String sexe = request.getParameter("sexe");
        String dateNaiss = request.getParameter("dateNaissance");
        String email = request.getParameter("email");
        String adresse = request.getParameter("adresse");

        String login = request.getParameter("login");
        String password = request.getParameter("mdp");

        Person p = new Person(nom, prenom, telephone, sexe, dateNaiss, email, adresse);

        p.setId(id);
        
        try {
            /* int lastId = UserDao.insertPerson(u);
            u.setIdPerson(lastId);
            u.setLogin(login);
            u.setPassword(password);*/

            PersonDao.UpdatePerson(p);

            Person pe = PersonDao.getPersonByEmail(email);
            //Person pe = PersonDao.getPersonById(id);
            //System.out.println("person: " + pe);
            //System.out.println("id: " + id);

            User c = new User(login, password, pe);

            ConseillerDao.UpdateConseiller(c);

            request.getRequestDispatcher("AccueilServlet").forward(request, response);
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("Exception :" + e.getMessage());
        }
    }

    /**
     * Returns a short description of the servlet.
     *
     * @return a String containing servlet description
     */
    @Override
    public String getServletInfo() {
        return "Short description";
    }// </editor-fold>

}
