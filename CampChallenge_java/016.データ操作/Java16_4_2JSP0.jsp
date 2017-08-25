<%-- 
    Document   : Java16_4_2JSP0
    Created on : 2017/08/23, 17:35:21
    Author     : Guestnumber
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <%
//            response.setContentType("text/html");
            request.setCharacterEncoding("UTF-8");
            // セッションを登録する。
            HttpSession hsn = request.getSession();
            // 後にnullで遭った場合に使う変数を用意。
            String n = "";
            String g = "";
            String a = "";
            // セッションに登録した情報を取得し、nullと等しいかチェックする。
            if (hsn.getAttribute("name") != null) {
            // 等しくなかった場合、帰ってきたname（属性値）を登録したセッション変数で取得し変数nに入れる。
            // 以下のif文に同様の記述を行う。
                n = (String) hsn.getAttribute("name");
            }
            // 変数a セッション変数hsn  sex（属性値）
            if (hsn.getAttribute("sex") != null) {
                g = (String) hsn.getAttribute("sex");
            }
            // 変数a セッション変数hsn  hobby（属性値）
            if (hsn.getAttribute("hobby") != null) {
                a = (String) hsn.getAttribute("hobby");
            }
        %>
        <!-- actionにて紐付けするページを記入。 -->
        <form action = "./Java16_4_2JSP.jsp" method = "post">
            <p>名前</p>
            <!-- valueで使っている演算子？ははJava言語を扱うため？に必要な演算子？です。 -->
            <input type = "text" name = "textname" value = "<%=n%>">
            <p>性別</p>
            男<input type = "radio" name = "gender" value = "男" 
                    <%
                    // 帰ってきた変数gはvalue="男"と等しいか。
                        if (g.equals("男")) {%>
                    <!-- 等しいならcheckを返しましょう。 -->    
                    checked = "checked"
                    <% }
                    %> >
            女<input type = "radio" name = "gender" value = "女"
                    <%
                    // 上記に同じで、gと"女"は等しいか？
                        if (g.equals("女")) {
                    // 等しいならcheckを返しましょう。
                            out.print("checked");
                        }%> >

            <p>趣味</p>
            <!-- textareaはvalueを持たないので、この場合はtextareaに挟む形で記述しましょう。 -->
            <textarea name = "area" cols = "50" rows = "10"><%=a%></textarea>

            <p>
                <input type = "submit" name = "sub" value = "送信">
                <input type = "reset" name = "re" value = "取消">
            </p>
        </form>
    </body>
</html>
