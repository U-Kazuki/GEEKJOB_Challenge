/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java15class;
import java.io.*;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collections;
import java.util.Random;
/**
 *
 * @author Guestnumber
 */
public class Java15_3_3 {
    public static void main(String[] args) throws IOException{
//紹介していないJAVAの標準クラスを利用して、処理を作成してください。
//講義では紹介されていないJAVAの標準クラスはたくさん存在します。
//１つJAVAの標準クラスを選び、実際にロジックを作成してみてください。
//また、この処理を作成するに当たり、下記を必ず実装してください。
//1. 処理の経過を書き込むログファイルを作成する。
//2. 処理の開始、終了のタイミングで、ログファイルに開始・終了の書き込みを行う。
//3. 書き込む内容は、「日時　状況（開始・終了）」の形式で書き込む。
//4. 最後に、ログファイルを読み込み、その内容を表示してください。
// File系の記述一式と時間の書き込み。開始の記述をして中に適当な計算式書いて終了の記述で閉じる。
// 最後にその計算がきちんと出来ているかFileプログラム経由で動けば完成？
//    Calendar cal = Calendar.getInstance();
    Date time = new Date();
    File fl = new File("logfile.txt");
    FileWriter fw = new FileWriter(fl);
    
    SimpleDateFormat sdf = new SimpleDateFormat("【yyyy年MM月dd日 HH時mm分ss秒】");
    //日付で習った感じで「開始」「終了」はfwで書き出す。
//    System.out.println(sdf.format(time) + "　開始");
    fw.write(sdf.format(time) + "開始" + "\n");
    
    
    String[] tenki = {"晴れ","雨","曇り","大雨","雹","霰","日本晴","台風"};
//    int[] rand = {11,22,33,44,55,66,77,88};
//    Random rand = new Random();
//    Integer index = rand.nextInt(tenki);
//    int ten = Integer.parseInt(tenki);
    int ix = (int)(Math.random() * tenki.length);
    String mix = (tenki[ix]);
//    for(int i = 0; i <= tenki.length; i++){
//    System.out.println(mix);
    fw.write(mix + "\n");
//    System.out.println(sdf.format(time) + "　終了");
    fw.write(sdf.format(time) + "終了" + "\n");
    fw.close();
    
    // 読み込み区分
    FileReader fr = new FileReader(fl);
    BufferedReader br= new BufferedReader(fr);
//    while(br.readLine() != null){
//    System.out.print(sdf.format(time) + br.readLine());
//    }
    String line = null;
    while((line = br.readLine()) != null) {
        System.out.println(line);
    }
/*    System.out.println(br.readLine());
    System.out.println(br.readLine());
    System.out.println(br.readLine());
*/    
//    fw.write(mix);
//    System.out.print(mix);
//    System.br.read();
//    String line = br.readLine();
//    while(line != null){
//        line = br.readLine();
//    }
//    fw.write(mix);
//    while(line = br.readLine() != null) {
//        
//    }
    br.close();
    }
}    

