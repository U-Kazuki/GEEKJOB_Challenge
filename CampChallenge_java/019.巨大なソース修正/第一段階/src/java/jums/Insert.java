package jums;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Random;

/**
 * insert.jspと対応するサーブレット
 * @author hayashi-s
 */
public class Insert extends HttpServlet {

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
        

        HttpSession session = request.getSession();
        // 他にも直リンクのやり方はあるそうですが、今回はこのページでマスターキーを作成する手順で直リンク対策を行なっていきます。
        // sessionで名前ac、値(int) (Math.random() * 1000)を作成する理由は、マスターキーの符号はacであり、このページで作る数字(0～1000のランダム生成)が符丁のようなものである。
        // なので、他のページを直リンクで見ようとした場合、マスターキーと同じ符号を取得せず、マスターキーと同じ符丁ではないため、トライ＆キャッチにてエラーが返されます。
        // 又、マスターキーは作っただけでは意味がなく、スペアキーは取得しなければ意味が無いので、記載漏れに注意されたし。
        // 後、いたずら防止でWEB-INF直下にJSPファイル？は全て置いとくのが吉である。
        session.setAttribute("ac", (int) (Math.random() * 1000));
        request.getRequestDispatcher("./insert.jsp").forward(request, response);   
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
