/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java15class;
import java.text.ParseException;
import java.util.Date;
import java.text.SimpleDateFormat;

/**
 *
 * @author Guestnumber
 */
public class Java15_1_4 {
    public static void main(String[] args) throws ParseException{
//2015年1月1日 0時0分0秒と2015年12月31日 23時59分59秒の差（ミリ秒）を表示してください。   
    String sin = "20150101 00:00:00";
    String matu = "20151231 23:59:59";
    SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
    Date sinDate = sdf.parse(sin);
    Date matuDate = sdf.parse(matu);
    System.out.print(matuDate.getTime() - sinDate.getTime());
//    System.out.print(formatDate1.getTime());
    
    }
}
