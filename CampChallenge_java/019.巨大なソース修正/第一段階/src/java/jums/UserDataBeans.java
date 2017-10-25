/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package jums;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.Serializable;
/**
 *
 * @author Guestnumber
 */

// serializableすると下のoverrideがerrorを吐きます。

public class UserDataBeans extends HttpServlet{
//public class UserDataBeans implements Serializable {   
        private int ac;
        private String name;
        private int year;
        private int month;
        private int day;
        private String type;
        private String tell;
        private String comment;
        
        // 【　よくある質問から抜粋　】
// getter・setterはメソッドを利用して【主にprivate】フィールドへアクセスするときに作られるメソッド。
// getterとは、単にフィールドの中身を呼び出して返すだけの単純なメソッド。
// setterとは、単純にフィールドに値を代入するだけのメソッド。
        
        public UserDataBeans(){
            
        }

        public int getAc(){
            return ac;
        }
        public void setAc(){
            this.ac = ac;
        }
        
        public String getName(){
            return name;
        }
        public void setName(String name){
            this.name = name;
        }

        public int getYear(){
            return year;
        }
        public void setYear(int year){
            this.year = year;
        }
        
        public int getMonth(){
            return month;
        }
        public void setMonth(int month){
            this.month = month;
        }
        
        public int getDay(){
            return day;
        }
        public void setDay(int day){
            this.day = day;
        }
        
        public String getType(){
            return type;
        }
        public void setType(String type){
            this.type = type;
        }
        
        public String getTell(){
            return tell;
        }
        public void setTell(String tell){
            this.tell = tell;
        }
        
        public String getComment(){
            return comment;
        }
        public void setComment(String comment){
            this.comment = comment;
        }

    
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
