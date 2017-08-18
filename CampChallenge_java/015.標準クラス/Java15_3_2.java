/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java15class;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Guestnumber
 */
public class Java15_3_2 {
    public static void main(String[] args) throws IOException{
// ファイルから自己紹介を読み出し、表示してください。
    File fl = new File("text.txt");
    FileWriter fw = new FileWriter(fl);
    fw.write("上原和希です");
    fw.close();
    
    FileReader fr = new FileReader(fl);
    BufferedReader br = new BufferedReader(fr);
    System.out.println(br.readLine());
    br.close();
    }
}
