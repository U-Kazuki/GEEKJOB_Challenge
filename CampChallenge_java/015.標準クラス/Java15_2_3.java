/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java15class;
import java.util.ArrayList;
/**
 *
 * @author Guestnumber
 */
public class Java15_2_3 {
    public static void main(String[] args){
// 以下の文章の「I」⇒「い」に、「U」⇒「う」に入れ替える処理を作成し、
// 結果を表示してください。「きょUはぴIえIちぴIのくみこみかんすU
// のがくしゅUをしてIます」
    String word = "きょUはぴIえIちぴIのくみこみかんすUのがくしゅUをしてIます";
    String lol = word.replace("U", "う");
    System.out.print(lol.replace("I", "い"));
    }
}
