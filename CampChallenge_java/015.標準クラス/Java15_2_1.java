/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java15class;

import java.nio.charset.Charset;

/**
 *
 * @author Guestnumber
 */
public class Java15_2_1 {
    public static void main(String[] args){
// 自分の氏名について、バイト数と文字数を取得して、表示してください。
    String byteA = "上原和希";
    System.out.println("文字数とバイト数は" + byteA.getBytes().length);
    System.out.println(byteA.length());
    }
}
