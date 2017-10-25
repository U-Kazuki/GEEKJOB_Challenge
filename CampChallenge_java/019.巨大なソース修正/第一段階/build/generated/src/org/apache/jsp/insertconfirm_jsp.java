package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jums.UserDataBeans;
import javax.servlet.http.HttpSession;
import jums.JumsHelper;

public final class insertconfirm_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent {

  private static final JspFactory _jspxFactory = JspFactory.getDefaultFactory();

  private static java.util.List<String> _jspx_dependants;

  private org.glassfish.jsp.api.ResourceInjector _jspx_resourceInjector;

  public java.util.List<String> getDependants() {
    return _jspx_dependants;
  }

  public void _jspService(HttpServletRequest request, HttpServletResponse response)
        throws java.io.IOException, ServletException {

    PageContext pageContext = null;
    HttpSession session = null;
    ServletContext application = null;
    ServletConfig config = null;
    JspWriter out = null;
    Object page = this;
    JspWriter _jspx_out = null;
    PageContext _jspx_page_context = null;

    try {
      response.setContentType("text/html;charset=UTF-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;
      _jspx_resourceInjector = (org.glassfish.jsp.api.ResourceInjector) application.getAttribute("com.sun.appserv.jsp.resource.injector");

      out.write("\n");
      out.write("\n");
      out.write("\n");

    HttpSession hs = request.getSession();
    UserDataBeans udb = (UserDataBeans)session.getAttribute("udb");


      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JUMS登録確認画面</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("        <!--　フォームから送られてきた値は既にセッションへの格納を行っております。なのでgetParameterではありません。-->\n");
      out.write("        <!--　フォームから送られてきたあらゆる値が空文字と等しくなかった場合、true(登録コード)を実行する。\n");
      out.write("        逆に、送られてきた値に空文字と等しくなる(未入力)場合があれば、false(エラー文)を実行する。　-->\n");
      out.write("        \n");
      out.write("        <!--　年月日とコメントにてerror抜け確認　-->\n");
      out.write("        ");
 if(!(udb.getName().equals("")) && udb.getYear() != 0 && udb.getMonth() != 0 && udb.getDay() != 0  
                && !(udb.getType().equals("")) && !(udb.getTell().equals("")) && !(udb.getComment().equals(""))){
      out.write(" \n");
      out.write("                \n");
      out.write("        <h1>登録確認</h1>\n");
      out.write("        名前:");
      out.print( udb.getName() );
      out.write("<br>\n");
      out.write("        生年月日:");
      out.print( udb.getYear()+"年"+udb.getMonth()+"月"+udb.getDay()+"日");
      out.write("<br>\n");
      out.write("        種別:");
 if(udb.getType().equals("1")){
      out.write(" エンジニア ");
}
      out.write("\n");
      out.write("             ");
 if(udb.getType().equals("2")){
      out.write(" 営業 ");
}
      out.write("\n");
      out.write("             ");
 if(udb.getType().equals("3")){
      out.write(" その他 ");
}
      out.write("\n");
      out.write("        <br>\n");
      out.write("        電話番号:");
      out.print( udb.getTell());
      out.write("<br>\n");
      out.write("        自己紹介:");
      out.print( udb.getComment());
      out.write("<br>\n");
      out.write("        上記の内容で登録します。よろしいですか？\n");
      out.write("        \n");
      out.write("        <form action=\"insertresult\" method=\"POST\">\n");
      out.write("            <!--　スペアキーの記述文。　-->             \n");
      out.write("            <input type=\"hidden\" name = \"ac\" value = \"");
      out.print( hs.getAttribute("ac"));
      out.write("\" >\n");
      out.write("            <input type=\"submit\" name=\"yes\" value=\"はい\">\n");
      out.write("        </form>\n");
      out.write("    ");
 }else{ 
      out.write("<h1>入力が不完全です</h1>\n");
      out.write("        <!--　if文false。送られてきた値に『空文字』又は『0』と等しい値があった場合、\n");
      out.write("        どのコードが等しかったのかを見つけるif文。　-->\n");
      out.write("        ");
if(udb.getName().equals("")){
            out.print("nameの記述がありません。");
        } else if(udb.getYear() == 0){
            out.print("yearの記述がありません。");
        } else if(udb.getMonth() == 0){
            out.print("monthの記述がありません。");
        } else if(udb.getDay() == 0){
            out.print("dayの記述がありません。");
        } else if(udb.getType().equals("")){
            out.print("typeの記述がありません。");
        } else if(udb.getTell().equals("")){
            out.print("tellの記述がありません。");
        } else if(udb.getComment().equals("")){
            out.print("commentの記述がありません。");
        } else {
            out.print("想定外のエラーが発生しました。もう一度ご確認ください。");
        }
        
      out.write("\n");
      out.write("    ");
 } 
      out.write("\n");
      out.write("        <form action=\"insert.jsp\" method=\"POST\">\n");
      out.write("            <input type=\"submit\" name=\"no\" value=\"登録画面に戻る\">\n");
      out.write("        </form>\n");
      out.write("        \n");
      out.write("        <br>\n");
      out.write("        ");
      out.print(JumsHelper.getInstance().home());
      out.write("\n");
      out.write("    </body>\n");
      out.write("</html>\n");
    } catch (Throwable t) {
      if (!(t instanceof SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          out.clearBuffer();
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}
