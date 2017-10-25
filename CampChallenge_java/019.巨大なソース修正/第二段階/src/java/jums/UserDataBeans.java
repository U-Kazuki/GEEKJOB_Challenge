package jums;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 * ページで入出力されるユーザー情報を持ちまわるJavaBeans。DTOと違い画面表示系への結びつきが強い
 * DTOへの変換メソッド、入力チェックリストを出力するメソッドも準備されている←ちょっと仕事しすぎかも
 * @author hayashi-s
 */
public class UserDataBeans implements Serializable{
    private String name;
    private int year;
    private int month;
    private int day;
    private String tell;
    private int type;
    private String comment;
    
    public UserDataBeans(){
        // デフォルト値が設定されていたため、Birthdayでの振り分け時に値が使用されelse nullという結果に遷移していた？
        // [SearchResult.java]での年月日選択時に不具合が出たためコメントアウト中。
//        this.name = "";
//        this.year = 0;
//        this.month = 0;
//        this.day = 0;
//        this.tell = "";
//        this.type = 0;
//        this.comment= "";
    }
    
    public String getName() { return name; }
    public void setName(String name) {
        // 未入力の場合、空文字をセット
        if(name.trim().length()==0){ this.name = ""; }
        else{ this.name = name; }
    }

    public int getYear() { return year; }
    public void setYear(String year) {
        //初期選択状態の場合0をセット
        if(year.equals("")){ this.year = 0; }
        else{ this.year = Integer.parseInt(year); }
    }

    public int getMonth() { return month; }
    public void setMonth(String month) {
        if(month.equals("")){ this.month = 0; }
        else{ this.month = Integer.parseInt(month); }
    }

    public int getDay() { return day; }
    public void setDay(String day) {
        if(day.equals("")){ this.day = 0; }
        else{ this.day = Integer.parseInt(day); }
    }

    public String getTell() { return tell; }
    public void setTell(String tell) {
        if(tell.trim().length()==0){ this.tell = ""; }
        else{ this.tell = tell; }
    }

    public int getType() { return type; }
    public void setType(String type) {
        if(type == null){ this.type = 0; }
        else{ this.type = Integer.parseInt(type); }
    }

    public String getComment() { return comment; }
    public void setComment(String comment) {
        if(comment.trim().length()==0){ this.comment = ""; }
        else{ this.comment = comment; }
    }
    
    
    // [insertconfirm]で使用。未入力がないか確認。
    
    public ArrayList<String> chkproperties(){
        ArrayList<String> chkList = new ArrayList<String>();
            if(this.name.equals("")){ chkList.add("name"); }
            if(this.year == 0){ chkList.add("year"); }
            if(this.month == 0){ chkList.add("month"); }
            if(this.day == 0){ chkList.add("day"); }
            if(this.tell.equals("")){ chkList.add("tell"); }
            if(this.type == 0){ chkList.add("type"); }
            if(this.comment.equals("")){ chkList.add("comment"); }
        return chkList;
        
    }
        

    // UD2DTOMappingメソッドは[InsertResult.java]/[SearchResult.java]/[UpdateResulet.java]で使用されています。
    public void UD2DTOMapping(UserDataDTO udd){
        
        // UserDataBeansの値をUserDataDTOで使用するため同等の値を保持登録処理します。
        udd.setName(this.name);
        udd.setTell(this.tell);
        udd.setType(this.type);
        udd.setComment(this.comment);
        
// udbのyear,month,dayの値で一つでも0と等しくないならtureを選択。全て0と等しいならfalseを選択。
// カレンダーのオブジェクト(getInstance)名birthdayを生成。
        if(this.year != 0 || this.month != 0 || this.day != 0){
        Calendar birthday = Calendar.getInstance();
// udbのmonthかdayが0と等しいならtureを。
        if(this.month == 0 || this.day == 0){ birthday.set(this.year,0,1); 
// カレンダーオブジェクトにudbのyear,month-1,dayを登録。
        } else { birthday.set(this.year,(this.month)-1,this.day); }
        
// DTOのBirthdayに対して上記で分岐した年月日(birthday)と現在日時を登録。
        udd.setBirthday(birthday.getTime());
// 年月日の値が全て等しかった場合はBirthdayにはnull。
        } else { udd.setBirthday(null); }
    }
    
}
