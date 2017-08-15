/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.Random;
/**
 *
 * @author Guestnumber
 */
public class BlackJack extends HttpServlet{
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
            
// これからの流れ。まず、インスタンツ化した状態でお互い2枚の手札を用意します。
// 二枚引いた状態で21に満たない場合の更なるドローメソッドを記述します。
// その記述を経た上でお互いの手札で勝負します。
    Dealer del = new Dealer();
    user use = new user();
        
    del.setCard(del.deal());// 山札から二枚とってsetCardに2枚のカードを格納する
    out.print("ディーラー側" + del.myCards+"<br>");// 格納されたカードを表示させる。
    
    while(del.checkSum()){// whileを使う理由は無限ループの特性を利用して既定の数まで特定の行動をとり続ける事を行うためで&ある？
        del.setCard(del.hit());// +1枚引いてsetCardに格納する。
        out.print("ディーラー側" + del.myCards + "<br>");//hit含めdel.myCardsに入っているカードの数字が表示される
    }
    
    use.setCard(del.deal());// del.deal()からカードを2枚貰い"use".setCardに格納する
    out.print("ユーザー側" + use.myCards+"<br>");
    
    while(use.checkSum()){
        use.setCard(del.hit());
        out.print("ユーザー側" + use.myCards + "<br>");
    }
    
    int usetotal = use.open();// 数値の合計を表示させよ
    int deltotal = del.open();// 数値の合計を表示させよ
    
    if(use.open() == del.open() || use.open() >= 21 && del.open() >= 21){
            out.print("　両　者　引　き　分　け　で　す　");
    } else if(use.open() == 21 || del.open() == 21){
            switch(use.open()){
                case 21:
                out.print("ユーザーが" + "☆ ブラック・ジャック ☆");
            }
            switch(del.open()){
                case 21:
                out.print("ディーラーが" + "☆ ブラック・ジャック ☆");
            }
    } else if(use.open() >= 21 || del.open() >= 21){
        if(usetotal >= 21){
            out.print("合計【" + usetotal + "】点" + "<br>" + "ユーザーがバーストしました。");
        } else {
            out.print("合計【" + deltotal + "】点" + "<br>" + "ディーラーがバーストしました。");
        }
    } else if(use.open() >= del.open()){
            out.print("合計【" + usetotal + "】点" + "<br>" + "ユーザーの勝利");
    } else {
            out.print("合計【" + deltotal + "】点" + "<br>" + "ディーラーの勝利");
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
}
