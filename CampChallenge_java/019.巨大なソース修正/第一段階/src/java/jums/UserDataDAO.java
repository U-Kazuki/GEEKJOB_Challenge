package jums;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
import base.DBManager;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){
        return new UserDataDAO();
    }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    // InsertResult.java内にメソッドinsert(userdata)という記述有り。
    // userdataはUserDateDTOの変数なのでメソッドとして型が同じと言うことで、対応可能です。
    // なので、udはuserdataに入っている値を全て使うことが出来ます。
    // だからかな？セッションの作成が出来なかったりBeansやDTOのコードにエラーが走るのは…。
    public void insert(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            // データベースとの連動した記述は此処ではなく、ソースパッケージ内のbaseの中にあります。
            // そこでデータベースとのやり取り(ドライバの取得とデータベースのパス設定等)がされています。
            // 此処のこの記述はbase内のDBManagerに接続するための記述です。
            con = DBManager.getConnection();
            // 接続の記述は上で書いたので、後は通常通りデータベースを扱うだけです。
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate)VALUES(?,?,?,?,?,?)");
            // セッションとuserdataの作成が出来ないですが、insertのメソッドがありますのでそちらを使ってDTOメソッドを使っていきます。
            st.setString(1, ud.getName());
            // Date型でDate変数にud.getBirthdayとタイムスタンプを格納する。
            // udはメソッドinsert(UserDateDTO ud)の引数っぽい。セッション作成不可だったので代用した。そしたらいけた。
            Date birthday = new Date(ud.getBirthday().getTime());
            // INSERTの2番めの?に先ほど作成したDateの変数を置く。
            st.setDate(2, birthday);//指定のタイムスタンプ値からSQL格納用のDATE型に変更
            st.setString(3, ud.getTell());
            st.setInt(4, ud.getType());
            st.setString(5, ud.getComment());
            st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            // 今回の扱いはinsertなのでUpdateで締めです。
            st.executeUpdate();
            System.out.println("insert completed");
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){
                con.close();
            }
        }

    }
}
