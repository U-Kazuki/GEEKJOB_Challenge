/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;
import java.util.ArrayList;

/**
 *
 * @author Guestnumber
 */
public abstract class Human {
    public abstract int open();
    public abstract void setCard(ArrayList<Integer> al);
    public abstract boolean checkSum();
    ArrayList<Integer> myCards = new ArrayList();  
    }

//1. Humanという抽象クラスを作成し、以下を実装してください。
//openというabstractな公開メソッドを用意してください。
//setCardというArrayListを引数とした、abstractな公開メソッドを用意してください。
//checkSumというabstractな公開メソッドを用意してください。
//myCardsというArrayListの変数を用意してください。
       