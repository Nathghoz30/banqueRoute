/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package fr.esic.servlet;

import fr.esic.dao.UserDao;
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
 * @author polnareff
 */
@WebServlet(name = "ConnexionServlet", urlPatterns = {"/login"})
public class ConnexionServlet extends HttpServlet {
    
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet ConnexionServlet</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet ConnexionServlet at " + request.getContextPath() + "</h1>");
            out.println("</body>");
            out.println("</html>");
        }
    }
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        request.getRequestDispatcher("index.jsp").forward(request, response);
    }
    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String log = request.getParameter("login");
        String mdp = request.getParameter("mdp");
        
        try {
            
            User u = UserDao.getByLoginAndPassword(log, mdp);
           // int statut = u.getStatut();
            if (u != null) {
                request.getSession(true).setAttribute("user", u);
                // remettre en menuAdmin
                //this.getServletContext().getRequestDispatcher("/WEB-INF/menuAdmin.jsp").forward(request, response);

                switch (u.getRole().getId()) {
                    case 1:
                        this.getServletContext().getRequestDispatcher("/WEB-INF/homeAdmin.jsp").forward(request, response);
                        break;
                    case 2:
                        this.getServletContext().getRequestDispatcher("/WEB-INF/homeConseiller.jsp").forward(request, response);
                        break;
                    case 3:
                        this.getServletContext().getRequestDispatcher("/WEB-INF/menuClient.jsp").forward(request, response);
                        //response.sendRedirect("MenuClient");
                        break;
                    default:
                        break;
                }

                //response.sendRedirect("memos");
            } else {
                request.setAttribute("msg", "identifiants incorrects!!");
                this.getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
            }
            
        } catch (Exception e) {
            PrintWriter out = response.getWriter();
            out.println("err" + e.getMessage());
            
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
