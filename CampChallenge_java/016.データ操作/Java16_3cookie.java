/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Guestnumber
 */
public class Java16_3cookie extends HttpServlet {

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
// クッキーに現在時刻を記録し、次にアクセスした際に、前回記録した日時を表示してください。
        // 日付データを取得
        Date time = new Date();
        // 日付データのフォーマットを作成
        SimpleDateFormat sdf = new SimpleDateFormat("【yyyy年MM月dd日 HH時mm分ss秒】");  
        // 日付データの表示
        out.print(sdf.format(time));
        // クッキーに名前と値を付ける
        Cookie cookie = new Cookie("Lastlogin", sdf.format(time));
        // クッキーに情報を反映
        response.addCookie(cookie);
        // クッキーの情報を取得し、利用したい情報を探す
        Cookie[] cs = request.getCookies();
        // csとnullが等しくない場合
        if(cs != null)
            // for文でcsの要素数を取得し1づつ増やす
            for(int i = 0; i < cs.length; i++){
                // cs[i]を取得し、クッキーデータ（"Lastlogin"）と等しかったら表示
                if(cs[i].getName().equals("Lastlogin")){
                    out.print("最後のログインは" + cs[i].getValue());
                    break; // 計算式終了
                }
            }
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
