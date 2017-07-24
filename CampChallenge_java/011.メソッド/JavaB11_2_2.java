/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JavaNo11Test;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guestnumber
 */
public class JavaB11_2_2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    void test(int kake0,int kake1,boolean hantei, PrintWriter pw){
        int sum = 0;
        sum = kake0 * kake1;
        if(hantei == true){
            sum *= sum;   // sum = sum * sum
        }
        pw.print(sum);
    }
    
    void test(int kake0, PrintWriter pw){
        test(kake0, 5,false, pw);
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JavaB11_2_2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet JavaB11_2_2 at " + request.getContextPath() + "</h1>");
            // 1.3つの引数を持ち、渡された数値で掛け算をするメソッドを作成します。
            // メソッドは、1つ目の引数と2つ目の引数を掛け算し、
                // 3つ目の引数がtrueの場合は結果を2乗させて下さい。
            // また、2つ目の引数は5、3つ目の引数はfalseを
                // デフォルト値として設定して下さい。
            // 2.作成したメソッドを呼び出し、結果を表示して下さい。
            test(5,out);

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
