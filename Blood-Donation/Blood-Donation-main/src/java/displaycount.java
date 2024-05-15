/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/JSP_Servlet/Servlet.java to edit this template
 */

import java.awt.HeadlessException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
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
@WebServlet(urlPatterns = { "/displaycount" })
public class displaycount extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");

        Connection conn;
        Statement stmt;
        ResultSet rs;
        int registerationCount = 0;
        int donationCount = 0;
//        String path = "https://mlnsss.org/wp-content/uploads/2018/11/Mukand-Logo.png";
        String path = "mukand.png";
        String bgPath = "bg2.jpg";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/blooddonation", "root", "hirdhya0306");
            stmt = conn.createStatement();
            String sql = "SELECT COUNT(mobileno) FROM registration";
            rs = stmt.executeQuery(sql);
            rs.next();
            registerationCount = rs.getInt(1);
            sql = "SELECT SUM(donated) FROM registration";
            rs = stmt.executeQuery(sql);
            rs.next();
            donationCount = rs.getInt(1);
            try (PrintWriter out = response.getWriter()) {
                // out.println("<!DOCTYPE html>");
                // out.println("<html>");
                // out.println("<head>");
                // out.println("<title>Displaying Registeration Details</title>");
                // out.println("</head>");
                // out.println("<body>");
                // out.println("<br><br><center><u><h1>NUMBER OF REGISTERATIONS: </u><br>" +
                // registerationCount + "<h1></center><br><br>");
                // out.println("<center><u><h1>NUMBER OF DONATIONS: </u><br>" + donationCount +
                // "<h1></center>");
                // out.println("</body>");
                // out.println("</html>");

                // out.println("<!DOCTYPE html>\n" +
                // "<html lang=\"en\">\n" +
                // " <head>\n" +
                // " <meta charset=\"UTF-8\" />\n" +
                // " <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\"
                // />\n" +
                // " <title>Registeration Details</title>\n" +
                // " <style>\n" +
                // " .counter-container-wrapper {\n" +
                // " display: flex;\n" +
                // " justify-content: center; /* Center horizontally */\n" +
                // " }\n" +
                // "\n" +
                // " .counter-container {\n" +
                // " display: flex;\n" +
                // " flex-direction: column; /* Stack elements vertically */\n" +
                // " align-items: center; /* Center horizontally */\n" +
                // " justify-content: center; /* Center vertically */\n" +
                // " margin: 10px;\n" +
                // " padding: 20px; /* Adjust padding as needed */\n" +
                // " border: 1px solid #ccc;\n" +
                // " border-radius: 5px;\n" +
                // " width: 300px;\n" +
                // " height: 300px;\n" +
                // " background-color: #f5f5f5;\n" +
                // " }\n" +
                // "\n" +
                // " .center-label-wrapper {\n" +
                // " margin-bottom: 10px; /* Adjust as needed */\n" +
                // " text-align: center; /* Center label horizontally */\n" +
                // " }\n" +
                // "\n" +
                // " label {\n" +
                // " font-weight: bold;\n" +
                // " font-size: 24px; /* Increased font size */\n" +
                // " color: #333;\n" +
                // " }\n" +
                // "\n" +
                // " .counter-value {\n" +
                // " font-weight: bold;\n" +
                // " font-size: 120px; /* Three times larger font size */\n" +
                // " color: #333;\n" +
                // " display: flex;\n" +
                // " justify-content: center; /* Center number horizontally */\n" +
                // " align-items: center; /* Center number vertically */\n" +
                // " }\n" +
                // " #hh {\n" +
                // " font-weight: bold;\n" +
                // " font-size: 120px;\n" +
                // " }\n" +
                // " </style>\n" +
                // " </head>\n" +
                // " <body>\n" +
                // " <center>\n" +
                // " <h1 id=\"hh\">BLOOD DONATION</h1>\n" +
                // " </center>\n" +
                // " <br />\n" +
                // " <div class=\"counter-container-wrapper\">\n" +
                // " <div class=\"counter-container\">\n" +
                // " <div class=\"center-label-wrapper\">\n" +
                // " <label for=\"counter1\">Register:</label>\n" +
                // " </div>\n" +
                // " <span class=\"counter-value\"
                // id=\"counter-value1\">"+registerationCount+"</span>\n" +
                // " </div>\n" +
                // "\n" +
                // " <div class=\"counter-container\">\n" +
                // " <div class=\"center-label-wrapper\">\n" +
                // " <label for=\"counter2\">Donated:</label>\n" +
                // " </div>\n" +
                // " <span class=\"counter-value\"
                // id=\"counter-value2\">"+donationCount+"</span>\n" +
                // " </div>\n" +
                // " </div>\n" +
                // " </body>\n" +
                // "</html>");

                out.println("<!DOCTYPE html>\n" +
                        "<html lang=\"en\">\n" +
                        "<head>\n" +
                        "  <meta charset=\"UTF-8\">\n" +
                        "  <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n" +
                        "  <title>Blood Donation</title>\n" +
                        "  <link rel=\"stylesheet\" href=\"\">\n" +
                        "  <style>\n" +
                        "    body {\n" +
                        // " background-image: linear-gradient(red, white);\n" +
                        // " background-image: url("+bg.jpg+");\n" +
                        "      background-image: url("+bgPath+");\n" +
                        "      background-repeat: no-repeat;\n" +
                        "      background-size: 100%;\n" +
                        // " height: 100%;\n" +
                        "    }\n" +
                        "    .counter-container-wrapper {\n" +
                        "    display: flex;\n" +
                        "    justify-content: center; /* Center horizontally */\n" +
                        "  }\n" +
                        "  \n" +
                        "  .counter-container {\n" +
                        "    display: flex;\n" +
                        "    flex-direction: column; /* Stack elements vertically */\n" +
                        "    align-items: center; /* Center horizontally */\n" +
                        "    justify-content: center; /* Center vertically */\n" +
                        "    margin: 10px;\n" +
                        "    padding: 20px; /* Adjust padding as needed */\n" +
                        "    border: 1px solid black;\n" +
                        "    border-radius: 5px;\n" +
                        "    width: 300px;\n" +
                        "    height: 300px;\n" +
                        "    /* background-color: #f5f5f5; */\n" +
                        "  }\n" +"  \n" +
                        "  .center-label-wrapper {\n" +
                        "    margin-bottom: 10px; /* Adjust as needed */\n" +
                        "    text-align: center; /* Center label horizontally */\n" +
                        "  }\n" +"  \n" +
                        "  label {\n" +
                        "    font-weight: bold;\n" +
                        "    font-size: 24px; /* Increased font size */\n" +
                        "    color: #333;\n" +
                        "  }\n" +"  \n" +
                        "  .counter-value {\n" +
                        "    font-weight: bold;\n" +
                        "    font-size: 120px; /* Three times larger font size */\n" +
                        "    color: black;\n" +
                        "    display: flex;\n" +
                        "    justify-content: center; /* Center number horizontally */\n" +
                        "    align-items: center; /* Center number vertically */\n" +
                        "  }\n" +"  #hh{\n" +
                        "    font-weight: bold;\n" +
                        "    font-size: 120px;\n" +
                        "  }\n" +
                        "  \n" +
                        "\n" +"  </style>\n" +
                        "\n" +"</head>\n" +
                        "<body>\n" +
                        "  \n" +
                        "\n" +"  <table>\n" +
                        "      <tr>\n" +
                        "        <td>\n" +"&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;<img style=\"background: none; \" width=\"250px\"; src=\""
                        + path + "\">\n" +
                        "        </td>\n" +
                        "        <td>\n" +
                        "          <h1 style=\"font-size: 100px;color: black;\">&nbsp;&nbsp;&nbsp;BLOOD DONATION</h1><br>\n"
                        +"</td>\n" +
                        "      </tr>\n" +
                        "  </table>\n" +
                        "  <div class=\"counter-container-wrapper\">\n" +
                        "    <div class=\"counter-container\">\n" +
                        "      <div class=\"center-label-wrapper\">\n" +
                        "        <label for=\"counter1\" style=\"color: black; font-size: 30px;\">Register:</label>\n" +
                        "      </div>\n" +
                        "      <span class=\"counter-value\" id=\"counter-value1\">" + registerationCount + "</span>\n"
                        +
                        "    </div>\n" +
                        "\n" +
                        "    <div class=\"counter-container\">\n" +
                        "      <div class=\"center-label-wrapper\">\n" +
                        "        <label for=\"counter2\" style=\"color: black;font-size: 30px;\">Donated:</label>\n" +
                        "      </div>\n" +
                        "      <span class=\"counter-value\" id=\"counter-value2\">" + donationCount + "</span>\n" +
                        "    </div>\n" +
                        "  </div>\n" +
                        "\n" +
                        "</body>\n" +
                        "</html>");

            }
        } catch (HeadlessException | ClassNotFoundException | SQLException e) {
            try (PrintWriter out = response.getWriter()) {
                out.println("<!DOCTYPE html>");
                out.println("<html>");
                out.println("<head>");
                out.println("<title>Error Message</title>");
                out.println("</head>");
                out.println("<body>");
                out.println("<h1>Some Error Occured!<h1>");
                out.println("</body>");
                out.println("</html>");
            }
            JOptionPane.showMessageDialog(null, e);
        }
    }

    // <editor-fold defaultstate="collapsed" desc="HttpServlet methods. Click on the
    // + sign on the left to edit the code.">
    /**
     * Handles the HTTP <code>GET</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        processRequest(request, response);
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request  servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException      if an I/O error occurs
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
