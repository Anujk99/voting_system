/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;
import javax.servlet.ServletContext;
/**
 *
 * @author a
 */
@WebServlet(name = "polldata", urlPatterns = {"/polldata"})
public class polldata extends HttpServlet {

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
        String c1=request.getParameter("c1");
        String p1=request.getParameter("p1");
        String c2=request.getParameter("c2");
        String p2=request.getParameter("p2");
        String c3=request.getParameter("c3");
        String p3=request.getParameter("p3");
        ServletContext sc=request.getServletContext();
        int id=(Integer)sc.getAttribute("id");
        try {
			boolean st = false;
                        String tname="e"+id;
			Class.forName("org.sqlite.JDBC");
			Connection conn = DriverManager
					.getConnection("jdbc:sqlite:F:/vote/vote.db");
                    
                            PreparedStatement st1= conn.prepareStatement("insert into "+tname+" values(?,?,?,?)");
                            st1.setInt(1, 1);
                            st1.setString(2,c1);
                            st1.setString(3,p1); 
                            st1.setInt(4, 0);
                            
                            st1.execute();
                             st1= conn.prepareStatement("insert into "+tname+" values(?,?,?,?)");
                             st1.setInt(1, 2);
                            st1.setString(2,c2);
                            st1.setString(3,p2);   
                            st1.setInt(4, 0);
                            st1.execute();
                             st1= conn.prepareStatement("insert into "+tname+" values(?,?,?,?)");
                             st1.setInt(1, 3);
                            st1.setString(2,c3);
                            st1.setString(3,p3);  
                            st1.setInt(4, 0);
                            st1.execute();
                        
                           response.sendRedirect("createpoll.jsp");
			
			
		} catch (Exception e) {
			System.out.println(e);
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
