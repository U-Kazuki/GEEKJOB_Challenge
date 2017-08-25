<%-- 
    Document   : Java16_4_2JSP
    Created on : 2017/08/23, 14:46:44
    Author     : Guestnumber
--%>


<%@page import="java.io.PrintWriter"%>
<%@page import="java.util.Date"%>
<%@page import="java.util.Date"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>

        <%
//        // 入力された名前・性別・趣味を記憶し、次にアクセスした際に
//            // 記録されたデータを初期値として表示してください。
            response.setContentType("text/html");
            request.setCharacterEncoding("UTF-8");
            // フォームから送られてきたやつがStringの変数に置換される。
            String n = request.getParameter("textname");
            String g = request.getParameter("gender");
            String h = request.getParameter("area");
            // セッションを登録する為の変数
            HttpSession hs = request.getSession();
            // セッションに情報を登録する記述。
            hs.setAttribute("name", n);
            hs.setAttribute("sex", g);
            hs.setAttribute("hobby", h);
            // セッションに登録した情報を取得する。
            String id = (String) hs.getAttribute("name");
            String dna = (String) hs.getAttribute("sex");
            String hby = (String) hs.getAttribute("hobby");
            
            out.print("登録した名前" + id + "<br>");
            out.print("選ばれた性別" + dna + "<br>");
            out.print("趣味は？" + hby);
            
        %>
                            <form action = "./Java16_4_2JSP0.jsp" method = "post">
              <input type = "submit" name = "sub1" value = "戻る">
            </form>
    </body>
</html>
