package jums;

import java.io.IOException;
import java.io.PrintWriter;
import java.text.SimpleDateFormat;
import java.util.Date;
import static java.util.Date.parse;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author hayashi-s
 */
public class UpdateResult extends HttpServlet {

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
        PrintWriter out = response.getWriter();
        /* TODO output your page here. You may use following sample code. */
        request.setCharacterEncoding("UTF-8");//リクエストパラメータの文字コードをUTF-8に変更

        try {
            
            HttpSession hs = request.getSession();
            
            // 不正アクセス禁止コード。
            String accesschk = request.getParameter("ac");
            if(accesschk ==null || (Integer)hs.getAttribute("ac")!=Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです");
            }
            
            // 新規でudbインスタンスを作成する。
            UserDataBeans udb = new UserDataBeans();
            // udbに格納する値。【フォームからなのでprameterで取得】
            // 変換【Birthday】以外の値も送るのは、デフォルト値が返ってくると更新する値が０と空白だらけに…
                udb.setName(request.getParameter("name"));
                udb.setYear(request.getParameter("year"));
                udb.setMonth(request.getParameter("month"));
                udb.setDay(request.getParameter("day"));
                udb.setTell(request.getParameter("tell"));
                udb.setType(request.getParameter("type"));
                udb.setComment(request.getParameter("comment"));
            
            hs.setAttribute("udb",udb);
            
            //DTOオブジェクトにマッピング。DB専用のパラメータに変換
            UserDataDTO searchData = (UserDataDTO)hs.getAttribute("resultData");
            // UD2DTOMappingで年月日をBirthdayに纏める為に使用。[UserDataBeans]
            udb.UD2DTOMapping(searchData);
            
            // 上記で処理した値がDAOのupdateメソッドにsearchDataとして対応しています。
            // 処理の順序が値が入っている右からの様に感じるけれど、左から右に処理が動きsearchDataに完了した値が入ります。
            UserDataDAO.getInstance().update(searchData);
            // 処理された値をセッションの名前として右に入れ、左には属性値として対応する値を書き加える。
            hs.setAttribute("resultData", searchData);
            
            request.getRequestDispatcher("/updateresult.jsp").forward(request, response);

        }catch(Exception e){
            //何らかの理由で失敗したらエラーページにエラー文を渡して表示。想定は不正なアクセスとDBエラー
            request.setAttribute("error", e.getMessage());
            request.getRequestDispatcher("/error.jsp").forward(request, response);
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
