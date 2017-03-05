/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs313;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintWriter;
import java.util.Scanner;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author t2alaska
 */
@WebServlet(name = "Login", urlPatterns = {"/Login"})
public class Login extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    String uname; // "sunshine";
    String pword; // "password";
    String fileName = "password.txt";

    public void loadFromFileString(String str) {
        String[] checkPassword = str.split(",");
        uname = checkPassword[0];
        pword = checkPassword[1];

    }

    public boolean checkLoginDetails(String username, String password) {
        try {
            String root = getServletContext().getRealPath("/");
            Scanner fileIn = null;

            fileIn = new Scanner(new File(root + "/WEB-INF/password.txt"));            
            while (fileIn.hasNextLine()) {
            String aline = fileIn.nextLine();           

            String[] fields = aline.split(",");
            if (fields.length == 2) {
                uname = fields[0];
                pword = fields[1];
            } else {
            }
            if (username.equals(uname) && password.equals(pword))                 
               return true;
            }
            fileIn.close();
        } //catch (IOException e) {
        catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (PrintWriter out = response.getWriter()) {

            // Get username and password from form                
            String name = request.getParameter("username");
            String password = request.getParameter("password");

            // create error message
//            String loginFail = "You entered an invalid username and/or password. Try again.";

            // Check that username and password from form match username and password
            // if it authenticates, display welcome screen
            if (name != null && password != null && checkLoginDetails(name,password)) {
                request.getSession().setAttribute("username", name);
                response.sendRedirect("welcome.jsp");

                // If it does not authenticate, display error message/page                  
            } else {
//                request.getSession().setAttribute("loginStatus", loginFail);
                response.sendRedirect("LoginError.jsp");
            }

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
        processRequest(request, response);
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
