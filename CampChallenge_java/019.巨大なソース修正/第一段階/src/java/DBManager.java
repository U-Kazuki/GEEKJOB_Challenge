/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guestnumber
 */
public class DBManager extends HttpServlet {

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
            throws ServletException, IOException, SQLException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            Connection con = null;
            PreparedStatement ps = null;
            PreparedStatement ups = null;
            ResultSet ts = null;
            
            try{
                // jdbcドライバをロードする式。
                Class.forName("com.mysql.jdbc.Driver").newInstance();
                    out.print("ドライバのロードに成功しました。" + "<br>");
            // DBへのコネクション（紐付け）を作成。
                con = DriverManager.getConnection("jdbc:mysql://localhost:3306/Challenge_db","GEEKJOB","password");
                    out.print("データベースの接続に成功しました。" + "<br>");
            } catch(ClassNotFoundException e){
                out.println("ClassNotFountException:" + e.getMessage());
            } catch(SQLException e){
                out.println("Exception:" + e.getMessage());
            } catch(Exception e){
                out.println("Exception:" + e.getMessage());
            } finally{
                try{
                    if(con != null){
                        con.close();
                        out.println("データベース切断に成功しました。");
                    } else {
                        out.println("コネクションがありません。");
                    }
                }catch(SQLException e){
                    out.println("SQLException:" + e.getMessage());
                }
            }
            ps = con.prepareStatement("select * from user_t");
            ts = ps.executeQuery();
            
            ups = con.prepareStatement("insert into from user_t(userID,name,birthday,tell,type,comment,newDate)values(?,?,?,?,?,?,?)");
                int id = Integer.parseInt(request.getParameter("userID"));
                String name = request.getParameter("name");
                String birthday = request.getParameter("name");
                String tell = request.getParameter("tell");
                int type = Integer.parseInt(request.getParameter("type"));
                String comment = request.getParameter("comment");
                String newdate = request.getParameter("newDate");
                    ups.setInt(1,id);
                    ups.setString(2, name);
                    ups.setString(3,birthday);
                    ups.setString(4, tell);
                    ups.setInt(5, type);
                    ups.setString(6,comment);
                    ups.setString(7, newdate);
            con.close();
            ps.close();
            ups.close();
            ts.close();
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        try {
            processRequest(request, response);
        } catch (SQLException ex) {
            Logger.getLogger(DBManager.class.getName()).log(Level.SEVERE, null, ex);
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
