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
import java.util.ArrayList;

/**
 *
 * @author Guestnumber
 */
public class JavaD11_4_2 extends HttpServlet {

    /**
     * Processes requests for both HTTP <code>GET</code> and <code>POST</code>
     * methods.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
// 課題「引数、戻り値1」の3人分のプロフィールのうち、1人だけ住所の値をnullで
// 定義し、ループ処理で全員分のプロフィールをid以外表示する処理を作成してください。
// この際、nullになっているデータはcontinueで飛ばしながら表示してください。
    
    public String[] data(String id){
        // 1人だけ住所の値をnullで表記
        // ループ処理で全員分のプロフをid以外表示する処理
        // nullになっているデータはcontinueで飛ばしながら表示する。
        String[] data0 = {"1","名前","生年月日",null};
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
            out.println("<title>Servlet JavaD11_4_2</title>");            
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Servlet JavaD11_4_2 at " + request.getContextPath() + "</h1>");
            
            // for文で三回処理。3人分のプロフィールをArrayListに格納
            ArrayList<String[]> al = new ArrayList<String[]>();
            for(int i = 1; i <= 3; i++){
                String n = String.valueOf(i);
                //ArrayListに１～３人目の配列を格納
                al.add(data(n));
//                String prof[] = data(n); // data()={"人物のID","名前","生年月日","住所"}
//                out.print(data(n));
            }
            //alの中身を表示　拡張for使って表示する。
            for(int j = 0; j < al.size(); j++){
                //配列取得
                String[] pro = al.get(j); //{"2","名前","生年月日","住所"};
//                out.print(pro+"<br>");
                  
                for(int lol = 1; lol < pro.length; lol++){
                    if(pro[lol] == null){
                        continue;
                    }
                    out.print(pro[lol]);
                    out.print("<br>");
                }
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
