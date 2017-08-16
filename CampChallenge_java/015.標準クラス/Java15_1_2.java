/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java15class;
import java.util.Calendar;

/**
 *
 * @author Guestnumber
 */
public class Java15_1_2 {
    public static void main(String[] args){
    //現在の日時を「年-月-日 時:分:秒」で表示してください。
    Calendar cal = Calendar.getInstance();
    System.out.println(cal.getTime().toString());
    System.out.print(cal.get(Calendar.YEAR) + "年");
    System.out.print(cal.get(Calendar.MONTH) + 1 + "月");
    System.out.print(cal.get(Calendar.DAY_OF_MONTH) + "日");
    System.out.print(cal.get(Calendar.HOUR_OF_DAY) + "時");
    System.out.print(cal.get(Calendar.MINUTE) + "分");
    System.out.print(cal.get(Calendar.SECOND) + "秒");
    }
}
