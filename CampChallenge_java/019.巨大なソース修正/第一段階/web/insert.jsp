<%@page import="jums.UserDataBeans"%>
<%@page import="javax.servlet.http.HttpSession" %>
<%@page import="jums.JumsHelper" %>

<%
    HttpSession hs = request.getSession();
//    UserDataBeansのページを対象にしてsession変数hsを使いgetAttribute(セッションから情報を取り出し)ます。
    UserDataBeans udb = (UserDataBeans)hs.getAttribute("udb");
%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JUMS登録画面</title>
    </head>
    <body>

    <form action = "insertconfirm" method = "POST">
        名前:
        <!--　if文でudbとnullが等しくなければture文を走らす。　-->
        <!--　userdatabeansのインスタンスを利用してgetNameを取得する。　-->
      　<!--フォームから送った値が帰って来た時、nullと等しくない(udbに値が入っている)ならば、udbからgetNameを取得しout.printの処理をする。-->
       <input type = "text" name = "name" value = "<% if(udb != null){ %><%= udb.getName()%><% } %>"> <br><br>
       
        生年月日:　
        <select name = "year">
            <!--　こっちのoption valueに何も記入しないのはプルダウンメニューの初期値に数字を入れないため　-->
            　　　　　　　<!--↓↓↓このハイフン線がホームでの初期値に当たります。-->
            <option value = "">----</option>
            <% for(int i = 1950; i <= 2010; i++)%><% { %>
            <!--　プルダウンメニューに表示する数字を決める変数i
            本来なら<option value = "i"></option>ですが、今回は<option value = "i">< = i></option>の形。
            理由としては、プルダウンメニューの範囲指定に使ってるっぽい。エラーは出ないけど数字が出ない状態になりました。　-->
            <!--< %% >JSPのページでJava又はHTMLを記述する場合に使うやつ、基本JSP記述がなければ今回みたいに取り込めれば細かく区切る必要もない模様？-->
            <option value = "<%= i %>"<% if(udb != null && udb.getYear() == i){%><% out.print("selected=\"selected\"");%><%}%>>
                <%= i%></option><% } %>
        </select>年
        
        <select name = "month">
            <option value = "">--</option>
            <% for(int i = 1; i <= 12; i++){ %>
            <!--　udbとnullが等しくなく、帰ってきた文字列と変数iの文字列が等しい。
            この2つの条件を満たしていた場合、getMonthに格納された値がセレクト(選択)された状態になる。　-->
            <option value = "<%= i %>"<% if(udb != null && udb.getMonth() == i){ %> selected <% } %>><%= i%></option>
            <% } %>
        </select>月
        
        <select name = "day">
                <option value = "">--</option>
            <% for(int i = 1; i <= 31; i++){ %>
            <!--　udbとnullが等しくない、かつ、for文の変数iに入っている値とudb.getDayに入っている値が等しいければture。　-->
            <option value="<%= i %>"<% if(udb != null && udb.getDay() == i){%>selected<% } %>>
                <%= i%></option>><% } %> 
        </select>日
        <br><br>

        種別:
        <br>
            <!--　udbとnullが等しくない、かつ、udb.getTypeとvalueが＝(等しい)ければcheckを記入。　-->
            <input type = "radio" name = "type" value = "1" <% if((udb != null) && udb.getType().equals("1")){ %> checked <% } %>>エンジニア<br>
            <input type = "radio" name = "type" value = "2" <% if((udb != null) && udb.getType().equals("2")){ %> checked <% } %>>営業<br>
            <input type = "radio" name = "type" value = "3" <% if((udb != null) && udb.getType().equals("3")){ %> checked <% } %>>その他<br>
        <br>
        
        電話番号:
            <input type = "text" name = "tell" value = "<% if(udb != null){ %><%= udb.getTell() %><% } %>" >
        <br><br>

        自己紹介文
        <br>
        <textarea name = "comment" rows = 10 cols = 50 style = "resize:none" wrap = "hard"><%if(udb != null){%><%= udb.getComment()%><% } %></textarea><br><br>
                
        <!-- Insert.javaにてマスターキーを作成したので、それを使ってスペアキーを作ります。
        session変数hsを使いgetAttribute(セッションの取得)します。マスターキーの符号(名前)がacで登録しているので
        取得するモノは("ac")となります。
        マスターキーのページを通らないと符丁(値)が一致しないのでエラーページに飛ぶことになります。
        そもそもの起動はJavaファイル？からしか行なえませんがね。-->
        <input type = "hidden" name = "ac"  value = "<%= hs.getAttribute("ac")%>">
        <input type = "submit" name = "btnSubmit" value = "確認画面へ">
    </form>
        <!--　トップページへ飛ぶJumsHelper.getInstance()が戻り値扱い。home()がURL扱いかな？(両方return付いてるけど…)　--> 
        <br>
        <%=JumsHelper.getInstance().home()%>
    </body>
</html>
