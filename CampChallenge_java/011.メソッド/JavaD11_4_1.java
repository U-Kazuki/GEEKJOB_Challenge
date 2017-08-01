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
public class JavaD11_4_1 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
// 引数が１つのメソッドを作成してください。
// メソッドの中の処理は、３人分のプロフィール（項目は戻り値2と同様）を作成し、
// 引数として渡された値と同じIDを持つ人物のプロフィールを返却する様にしてください。
// それ以降は課題「戻り値2」と同じ処理にしてください。
    public String[] data(String id){
        //idと配列の０番目を比較して一致する配列を返却
        String[] data0 = {"1","名前","生年月日","住所"};
        String[] data1 = {"2","名前","生年月日","住所"};
        String[] data2 = {"3","名前","生年月日","住所"};
        if(id.equals(data0[0])){
            return data0;
        } else if(id.equals(data1[0])){
            return data1;
        } else if(id.equals(data2[0])){
            return data2;
        }
        return null;
    }
    protected void processRequest(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            /* TODO output your page here. You may use following sample code. */
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<title>Servlet JavaD11_4_1</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet JavaD11_4_1 at " + request.getContextPath() + "</h1>");
            String prof[] = data("3");  // data()={"人物のID","名前","生年月日","住所"}と同じ意味になるらしい。
            // 拡張for文で簡素に実行できる…らしい
            // ↓結果これになった。
            for(int i = 0; i < prof.length; i++){
                out.print(prof[i]);
            }
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
