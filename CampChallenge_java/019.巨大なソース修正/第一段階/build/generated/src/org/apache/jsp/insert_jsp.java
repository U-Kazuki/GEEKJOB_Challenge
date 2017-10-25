package org.apache.jsp;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import jums.UserDataBeans;
import javax.servlet.http.HttpSession;
import jums.JumsHelper;

public final class insert_jsp extends org.apache.jasper.runtime.HttpJspBase
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
      out.write("\n");

    HttpSession hs = request.getSession();
//    UserDataBeansのページを対象にしてsession変数hsを使いgetAttribute(セッションから情報を取り出し)ます。
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");

      out.write("\n");
      out.write("\n");
      out.write("<!DOCTYPE html>\n");
      out.write("<html>\n");
      out.write("    <head>\n");
      out.write("        <meta http-equiv=\"Content-Type\" content=\"text/html; charset=UTF-8\">\n");
      out.write("        <title>JUMS登録画面</title>\n");
      out.write("    </head>\n");
      out.write("    <body>\n");
      out.write("\n");
      out.write("    <form action = \"insertconfirm\" method = \"POST\">\n");
      out.write("        名前:\n");
      out.write("        <!--　if文でudbとnullが等しくなければture文を走らす。　-->\n");
      out.write("        <!--　userdatabeansのインスタンスを利用してgetNameを取得する。　-->\n");
      out.write("      　<!--フォームから送った値が帰って来た時、nullと等しくない(udbに値が入っている)ならば、udbからgetNameを取得しout.printの処理をする。-->\n");
      out.write("       <input type = \"text\" name = \"name\" value = \"");
 if(udb != null){ 
      out.print( udb.getName());
 } 
      out.write("\"> <br><br>\n");
      out.write("       \n");
      out.write("        生年月日:　\n");
      out.write("        <select name = \"year\">\n");
      out.write("            <!--　こっちのoption valueに何も記入しないのはプルダウンメニューの初期値に数字を入れないため　-->\n");
      out.write("            　　　　　　　<!--↓↓↓このハイフン線がホームでの初期値に当たります。-->\n");
      out.write("            <option value = \"\">----</option>\n");
      out.write("            ");
 for(int i = 1950; i <= 2010; i++)
 { 
      out.write("\n");
      out.write("            <!--　プルダウンメニューに表示する数字を決める変数i\n");
      out.write("            本来なら<option value = \"i\"></option>ですが、今回は<option value = \"i\">< = i></option>の形。\n");
      out.write("            理由としては、プルダウンメニューの範囲指定に使ってるっぽい。エラーは出ないけど数字が出ない状態になりました。　-->\n");
      out.write("            <!--< %% >JSPのページでJava又はHTMLを記述する場合に使うやつ、基本JSP記述がなければ今回みたいに取り込めれば細かく区切る必要もない模様？-->\n");
      out.write("            <option value = \"");
      out.print( i );
      out.write('"');
 if(udb == null || udb.getYear() == i){
 out.print("selected=\"selected\"");
}
      out.write(">\n");
      out.write("                ");
      out.print( i);
      out.write("</option>");
 } 
      out.write("\n");
      out.write("        </select>年\n");
      out.write("        \n");
      out.write("        <select name = \"month\">\n");
      out.write("            <option value = \"\">--</option>\n");
      out.write("            ");
 for(int i = 1; i <= 12; i++){ 
      out.write("\n");
      out.write("            ");
String m = String.valueOf(i);
            String u = String.valueOf(udb); 
      out.write("\n");
      out.write("            <!--　udbとnullが等しくなく、帰ってきた文字列と変数iの文字列が等しい。\n");
      out.write("            この2つの条件を満たしていた場合、getMonthに格納された値がセレクト(選択)された状態になる。　-->\n");
      out.write("            <option value = \"");
      out.print( i );
      out.write('"');
 if(i == udb.getMonth()){ 
      out.print( udb );
      out.write(" selected ");
 } 
      out.write('>');
      out.print( i);
      out.write("</option>\n");
      out.write("            ");
 } 
      out.write("\n");
      out.write("        </select>月\n");
      out.write("        \n");
      out.write("        <select name = \"day\">\n");
      out.write("                <option value = \"\">--</option>\n");
      out.write("            ");
 for(int i = 1; i <= 31; i++){ 
      out.write("\n");
      out.write("            ");
String d = String.valueOf(i);
            String u = String.valueOf(udb); 
      out.write("\n");
      out.write("            <!--　udbとnullが等しくない、かつ、for文の変数iに入っている値とudb.getDayに入っている値が等しいければture。　-->\n");
      out.write("            <option value=\"");
      out.print( i );
      out.write('"');
 if(u == d){
      out.print( udb.getDay() );
      out.write("selected");
 } 
      out.write(">\n");
      out.write("                ");
      out.print( i);
      out.write("</option>>");
 } 
      out.write(" \n");
      out.write("        </select>日\n");
      out.write("        <br><br>\n");
      out.write("\n");
      out.write("        種別:\n");
      out.write("        <br>\n");
      out.write("            <!--　udbとnullが等しくない、かつ、udb.getTypeとvalueが＝(等しい)ければcheckを記入。　-->\n");
      out.write("            <input type = \"radio\" name = \"type\" value = \"1\" ");
 if((udb != null) && udb.getType().equals("1")){ 
      out.write(" checked ");
 } 
      out.write(">エンジニア<br>\n");
      out.write("            <input type = \"radio\" name = \"type\" value = \"2\" ");
 if((udb != null) && udb.getType().equals("2")){ 
      out.write(" checked ");
 } 
      out.write(">営業<br>\n");
      out.write("            <input type = \"radio\" name = \"type\" value = \"3\" ");
 if((udb != null) && udb.getType().equals("3")){ 
      out.write(" checked ");
 } 
      out.write(">その他<br>\n");
      out.write("        <br>\n");
      out.write("        \n");
      out.write("        電話番号:\n");
      out.write("            <input type = \"text\" name = \"tell\" value = \"");
 if(udb != null){ 
      out.print( udb.getTell() );
 } 
      out.write("\" >\n");
      out.write("        <br><br>\n");
      out.write("\n");
      out.write("        自己紹介文\n");
      out.write("        <br>\n");
      out.write("        <textarea name = \"comment\" rows = 10 cols = 50 style = \"resize:none\" wrap = \"hard\">");
if(udb != null){
      out.print( udb.getComment());
 } 
      out.write("</textarea><br><br>\n");
      out.write("                \n");
      out.write("        <!-- Insert.javaにてマスターキーを作成したので、それを使ってスペアキーを作ります。\n");
      out.write("        session変数hsを使いgetAttribute(セッションの取得)します。マスターキーの符号(名前)がacで登録しているので\n");
      out.write("        取得するモノは(\"ac\")となります。\n");
      out.write("        マスターキーのページを通らないと符丁(値)が一致しないのでエラーページに飛ぶことになります。\n");
      out.write("        そもそもの起動はJavaファイル？からしか行なえませんがね。-->\n");
      out.write("        <input type = \"hidden\" name = \"ac\"  value = \"");
      out.print( hs.getAttribute("ac"));
      out.write("\">\n");
      out.write("        <input type = \"submit\" name = \"btnSubmit\" value = \"確認画面へ\">\n");
      out.write("    </form>\n");
      out.write("        <!--　トップページへ飛ぶJumsHelper.getInstance()が戻り値扱い。home()がURL扱いかな？(両方return付いてるけど…)　--> \n");
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
