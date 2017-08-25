/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
/**
 *
 * @author Guestnumber
 */
public class Java16_4_1Session extends HttpServlet {

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
        // 課題「クッキーの記録と表示」と同じ機能をセッションで作成してください。
        // 日付データを取得
        Date time = new Date();
        // 日付データのフォーマットを作成
        SimpleDateFormat sdf = new SimpleDateFormat("【yyyy年MM月dd日 HH時mm分ss秒】");  
        // オーダーセッションの取得。変数は" hs "。
        HttpSession hs = request.getSession();
        // セッションの登録【登録情報はDataと寿司】
        hs.setAttribute("Lastlogin", sdf.format(time));
        // セッションから情報を取得【Lastloginで紐付けしてる】
        String login = (String) hs.getAttribute("Lastlogin");
        // ここでも『if(!=)』を使う理由は、【" 多 分 "】初回訪問時にセッション又はクッキーがない場合の処理式だと思う。
        if(login != null){
            out.print(login);
        }
    }
    
//         HttpSession hs = request.getSession();
//         hs.setAttribute("Data", "寿司");
//         String lunch = (String) hs.getAttribute("Data");
//         out.print(lunch);
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
