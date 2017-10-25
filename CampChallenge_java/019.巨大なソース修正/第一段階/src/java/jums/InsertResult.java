package jums;

import java.io.IOException;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import jums.UserDataBeans;


/**
 * insertresultと対応するサーブレット
 * フォームから入力された値をセッション経由で受け取り、データベースにinsertする
 * 直接アクセスした場合はerror.jspに振り分け
 * @author hayashi-s
 */
public class InsertResult extends HttpServlet {

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
        
        
        try{
            //セッションスタート
            HttpSession session = request.getSession();
            String accesschk = request.getParameter("ac");
            if(accesschk == null || (Integer)session.getAttribute("ac") != Integer.parseInt(accesschk)){
                throw new Exception("不正なアクセスです。");
            }
            
            //ユーザー情報に対応したJavaBeansオブジェクトに格納していく
            // UserDataDTOの情報を持ったuserdata変数を作成。
            UserDataDTO userdata = new UserDataDTO();
            
            UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");
            
            userdata.setName(udb.getName());
                // Calendarクラスの作成にはgetInstance()メソッドを使用します。
            Calendar birthday = Calendar.getInstance();
                // Calendarクラスの特徴として月の値だけ0～11の値が初期値？として設定されています。
                // なので、きちんと値が反映されるようにコードに-1を追加しましょう。
            birthday.set(udb.getYear(),udb.getMonth()-1,udb.getDay());
                // 年月日が格納されたbirthdayをDTOのBirthdayに格納しましょう。
            userdata.setBirthday(birthday.getTime()); 
                // TypeはValueの値を文字列として扱ってきましたが、ここらでint型に変換します。
                // 理由はデータベースへの登録の型をint型でしているためです。
            userdata.setType(Integer.parseInt((String)udb.getType()));
            userdata.setTell(udb.getTell());
            userdata.setComment(udb.getComment());
            
            //DBへデータの挿入
            // UserDateDAOにてミリ秒単位の管理を行いつつ、メソッドとしてuserdataの値を渡している。
            // 遷移ページの記述。insert(UserDateDTO ud)があるので、メソッドとして値を渡してるのかな？
            // 渡している内容はuserdataに格納されている値全件。
            UserDataDAO .getInstance().insert(userdata);
            
            request.getRequestDispatcher("insertresult.jsp").forward(request, response);
        }catch(Exception e){
            //データ挿入に失敗したらエラーページにエラー文を渡して表示
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
