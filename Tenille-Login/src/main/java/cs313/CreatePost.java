/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cs313;

import java.io.File;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.text.SimpleDateFormat;
import java.util.Date;
import model.FilePostHandler;
import model.Posts;

/**
 *
 * @author t2alaska
 */
@WebServlet(name = "CreatePost", urlPatterns = {"/CreatePost"})
public class CreatePost extends HttpServlet {

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
        try {
        String message = request.getParameter("message");
        
        if(!message.isEmpty()) {
            String date = new SimpleDateFormat("yyyy-MM-dd HH:mm").format(new Date());

            HttpSession session = request.getSession(true);
            String user = session.getAttribute("username").toString();

            Posts newPost = new Posts(user, date, message);

            // Declare output file location
            File file = new File(getServletContext().getRealPath("/") + "discussionList.txt");
            String fileName = file.toString();
        
            // If the file doesn't already exist, create a new one
            if(!file.exists()) {
                file.createNewFile();
            }

            FilePostHandler handler = new FilePostHandler(fileName);
            handler.addPost(newPost);
        
            response.sendRedirect("LoadPosts");
        } else {
            String errorMsg = "Message is required!";
            request.setAttribute("error", errorMsg);
            request.getRequestDispatcher("welcome.jsp").forward(request, response);
        }
        }catch (Exception e) {
             e.printStackTrace();
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
