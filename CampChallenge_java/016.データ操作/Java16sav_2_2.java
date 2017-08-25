/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guestnumber
 */
public class Java16sav_2_2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    protected ArrayList<Integer> processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
//        response.setContentType("text/html");
        request.setCharacterEncoding("UTF-8");
        String rogic = request.getParameter("textname");
        int tip = Integer.parseInt(rogic);
        
        int one = 1;
        int two = 2;
        int three = 3;
        int five = 5;
        int seven = 7;
        
        out.print("フォームから来た値"+tip+"<br>");
        if(tip / one == 1){
            out.print(tip + "左は値　右は素数" + one + "<br>");
        }
        while(tip != 1){
            if(tip % two == 0){
                tip /= two;
                out.print(tip + "左は値　右は素数" + two + "<br>");
            } else if(tip % three == 0){
                tip /= three;
                out.print(tip + "左は値　右は素数" + three + "<br>");
            } else if(tip % five == 0){
                tip /= five;
                out.print(tip + "左は値　右は素数" + five + "<br>");
            } else if(tip % seven == 0){
                tip /= seven;
                out.print(tip + "左は値　右は素数" + seven + "<br>");
            } else {
                out.print("素数" + two + " | " + "余った値" + tip%two + " | " + "<br>");
                break;
            }
        }
        // 配列を使って２２が来た場合、元の値２２・素数２・あまり１１になるような結果が欲しい。
        
//        out.print(tip + "左は値　右は素数" + one + "<br>");
        
        // サイトのやつ簡易じゃない完成品っぽい
//        while(tip != 1){
//            if(tip % two == 0){
//                tip /= two;
//                out.print(tip + "左値　右素数" + two + "<br>");
//            } else {
//                    two++;
//            }
//        }
        }
        return null;
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
