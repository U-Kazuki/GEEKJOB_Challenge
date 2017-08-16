/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java15class;

import java.text.ParseException;
import java.util.Date;
import java.util.Calendar;
import java.text.SimpleDateFormat;
/**
 *
 * @author Guestnumber
 */
public class Java15_1 {
    public static void main(String[] args) throws ParseException{
// 2016年1月1日 0時0分0秒のタイムスタンプを作成し、表示してください。
        String date = "20160101 00:00:00";
        SimpleDateFormat sdf = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        Date formatDate = sdf.parse(date);
        System.out.println(formatDate );//日付
        System.out.println(formatDate.getTime());//タイムスタンプ（ミリ秒）
        
//        Calendar a = Calendar.getInstance();
//        a.set(2016,0,1,00,00,00);
//        System.out.print(a.getTime());
        
        }
    }

