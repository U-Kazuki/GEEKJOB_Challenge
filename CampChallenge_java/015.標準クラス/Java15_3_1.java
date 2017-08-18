/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Java15class;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 *
 * @author Guestnumber
 */
public class Java15_3_1 {
    public static void main(String[] args) throws IOException{
// ファイルに自己紹介を書き出し、保存してください。
    File fl = new File("text.txt");
    FileWriter fw = new FileWriter(fl);
    fw.write("上原和希です");
    fw.close();
    }
}
