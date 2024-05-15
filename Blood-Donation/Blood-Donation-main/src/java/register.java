/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.awt.HeadlessException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.sql.DriverManager;
import java.sql.SQLException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

/**
 *
 * @author hp
 */
@WebServlet(urlPatterns = {"/register"})
public class register extends HttpServlet {

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
        
        Connection conn;
        Statement stmt;
        String sql = "";
        String post, name, branch, year, gender, bloodgroup, bloodbank, address;
        long rollno, mobileno;
        post = request.getParameter("post");
        name = request.getParameter("name");
//        rollno = Long.parseLong(request.getParameter("rollno"));
        rollno = 1234;
        branch = request.getParameter("branch");
        year = request.getParameter("year");
        gender = request.getParameter("gender");
        bloodbank = request.getParameter("bloodbank");
        bloodgroup = request.getParameter("bloodgroup");
        mobileno = Long.parseLong(request.getParameter("mobileno"));
        address = request.getParameter("address");
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/blooddonation", "root", "hirdhya0306");
            stmt = conn.createStatement();
            if("student".equals(post)) {
                sql = "insert into registration(post, name, rollno, branch, year, gender, bloodgroup, mobileno, address, bloodbank) values ('" + post + "','" + name + "'," + rollno + ",'" + branch + "','" + year + "','" + gender + "','" + bloodgroup + "'," + mobileno + ",'" + address + "','" + bloodbank + "');";
            } else {
                sql = "insert into registration(post, name, gender, bloodgroup, mobileno, address, bloodbank) values ('" + post + "','" + name + "','" + gender + "','" + bloodgroup + "'," + mobileno + ",'" + address + "','" + bloodbank + "');";
            }
            stmt.executeUpdate(sql);
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Successful Message</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1><center>Record Added Successfully!</center><h1>");
                out.println("</body>");
               out.println("</html>");
            }
        } catch(HeadlessException | ClassNotFoundException | SQLException e) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Error Message</title>");            
                out.println("</head>");
                out.println("<body>");
                out.println("<h1><center>Some Error Occured!</center><h1>");
                out.println("</body>");
               out.println("</html>");
            }
            JOptionPane.showMessageDialog(null, e);
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
