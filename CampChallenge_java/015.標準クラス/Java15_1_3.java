/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java15class;

import java.text.ParseException;
import java.util.Calendar;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Guestnumber
 */
public class Java15_1_3 {
    public static void main(String[] args) throws ParseException{
// 2016年11月4日 10時0分0秒のタイムスタンプを作成し、
// 「年-月-日 時:分:秒」で表示してください。
    Calendar cal = Calendar.getInstance();
    cal.set(2016,11,4,10,0,0);
    System.out.print(cal.get(Calendar.YEAR) + "年");
    System.out.print(cal.get(Calendar.MONTH) + "月");
    System.out.print(cal.get(Calendar.DAY_OF_MONTH) + "日");
    System.out.print(cal.get(Calendar.HOUR_OF_DAY) + "時");
    System.out.print(cal.get(Calendar.MINUTE) + "分");
    System.out.print(cal.get(Calendar.SECOND) + "秒");
    System.out.print(cal.getTime());
    }
}
