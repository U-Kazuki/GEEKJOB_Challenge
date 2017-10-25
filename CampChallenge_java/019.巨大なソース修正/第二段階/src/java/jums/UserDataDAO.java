package jums;

import base.DBManager;
import static java.lang.System.out;
import java.sql.PreparedStatement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import javax.servlet.http.HttpSession;

/**
 * ユーザー情報を格納するテーブルに対しての操作処理を包括する
 * DB接続系はDBManagerクラスに一任
 * 基本的にはやりたい1種類の動作に対して1メソッド
 * @author hayashi-s
 */
public class UserDataDAO {
    
    //インスタンスオブジェクトを返却させてコードの簡略化
    public static UserDataDAO getInstance(){ return new UserDataDAO(); }
    
    /**
     * データの挿入処理を行う。現在時刻は挿入直前に生成
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     */
    public void insert(UserDataDTO ud) throws SQLException{
        // データベースとの接続をする時に必要なConnectionさん。
        Connection con = null;
        // preparedstatementとは、引数で受け取ったSQL文の？パラメーターの設定や、SQL文を実行するクラスです。
        PreparedStatement st = null;
        try{
            // conはDBManagerでドライバの入力・データベース接続等が戻り値として入った状態になっています。
            // DBManagerにcon変数を取得することでデータベースへのアクセス権がてにはいります。
            con = DBManager.getConnection();
            // SQLの？パラメに対して設定する事と、実行する文がコレ。
            st =  con.prepareStatement("INSERT INTO user_t(name,birthday,tell,type,comment,newDate) VALUES(?,?,?,?,?,?)");
                st.setString(1, ud.getName());
                st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
                st.setString(3, ud.getTell());
                st.setInt(4, ud.getType());
                st.setString(5, ud.getComment());
                st.setTimestamp(6, new Timestamp(System.currentTimeMillis()));
            // insert文を書き込みを行うコード。
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
    
    /**
     * データの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public List<UserDataDTO> search(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        
        try{
            con = DBManager.getConnection();
            // 文字列型の変数sqlにuser_tのテーブル実行文を入れる。
            String sql = "SELECT * FROM user_t";
            boolean flag = false;
            
            if (!ud.getName().equals("")){
                // 例【A LIKE '%XXX%' （Aは「XXX」を含む。部分一致）】名前の部分一致で使用するコードです。
                sql += " WHERE name like ?";// select * from user_t where name like ?
                flag = true;
            }// 一つ目ののif文が終了。
            
            // DTO変数udのBirthdayとnullが等しくない場合。
            if (ud.getBirthday() != null){
                // 変数flagが否定した場合はtrue式で始める。
                if(!flag){
                    // user_tデーブルの年月日から部分一致した値を抽出する。
                    sql += " WHERE birthday like ?";// select * from user_t where birthday like ?　と同義。
                    flag = true;
                // 論理演算子AND。【両方のオペランドがtureならture…(抜粋)】この場合の両方ってbirthdayと何？？？
                // user_tテーブルのbirthday項目が部分ではなく完全に一致したならば？…かなぁ・・・・
                } else { sql += " AND birthday like ?"; }// select * from user_t and birthday like ?　と同義。
            }// 二つ目のif文が終了。
            
            // DTO変数Typeが0と等しくない場合ture式で。
            if (ud.getType() != 0){
                // DTO変数flagを否定する時にture式。
                if(!flag){ 
                    sql += " WHERE type like ?";// select * from user_t where type like ?
                    flag = true;
                } else { sql += " AND type like ?"; }// select * from user_t and type like ?
            }   // 三つ目のif文が終了。
                        
            //　修正点として検索条件が何も入力されていない時の全件表示のif文を記述。
            if(ud.getName().equals("") && ud.getBirthday() == null && ud.getType() == 0){
                st = con.prepareStatement(sql);
                rs = st.executeQuery();
            
                
            } else {
            // 名前 年月日 種別に値があった場合は、sql(select*from user_t)に接続して、ud.(部分一致)を？に対応して当てはめる。 
                if(!(ud.getName().equals("")) && ud.getBirthday() != null && ud.getType() != 0){
                st = con.prepareStatement(sql);
                    st.setString(1, "%"+ud.getName()+"%");
                    st.setString(2, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                    st.setString(3, "%"+ ud.getType() +"%");
                    
            // 名前と("") && 年月日と("")が等しくない場合。
            } else if(!(ud.getName().equals("")) && ud.getBirthday() != null){
                st = con.prepareStatement(sql);
                    st.setString(1, "%"+ud.getName()+"%");
                    st.setString(2, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                    
            // 名前と("") && 種別と0が等しくない場合。
            } else if(!(ud.getName().equals("")) && ud.getType() != 0){
                st = con.prepareStatement(sql);
                    st.setString(1, "%"+ud.getName()+"%");
                    st.setString(2, "%"+ ud.getType() +"%");
                    
            // birthdayと("") && type == 0が等しくない場合。
            } else if(ud.getBirthday() != null && ud.getType() != 0){
                st = con.prepareStatement(sql);
                    st.setString(1, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                    st.setString(2, "%"+ ud.getType() +"%");
                    
            // nameと("")が等しくない場合。
            } else if(!(ud.getName().equals(""))){
                st = con.prepareStatement(sql);
                    st.setString(1, "%"+ud.getName()+"%");
                    
            // birthdayと("")が等しくない場合。
            } else if(ud.getBirthday() != null){
                st = con.prepareStatement(sql);
                    st.setString(1, "%"+ new SimpleDateFormat("yyyy").format(ud.getBirthday())+"%");
                    
            // type == 0が等しくない場合。
            } else if(ud.getType() != 0){
                st = con.prepareStatement(sql);
                    st.setString(1, "%"+ ud.getType() +"%");
            }
        rs = st.executeQuery();
    }
            
            // ArrayListを作成しますが、作成目的はretrunからの格納が目当てです。
            List<UserDataDTO> udd = new ArrayList<UserDataDTO>();
            // while文で有るだけ回します。
            while(rs.next()){
                // UserDataDTOのインスタンスを新しく作成します。
                UserDataDTO resultUd = new UserDataDTO();
                // （）内の値は上記で作成した変数を通してDTOから取得しています。
                    resultUd.setUserID(rs.getInt("userID"));
                    resultUd.setName(rs.getString("name"));
                    resultUd.setBirthday(rs.getDate("birthday"));
                    resultUd.setTell(rs.getString("tell"));
                    resultUd.setType(rs.getInt("type"));
                    resultUd.setComment(rs.getString("comment"));
                    resultUd.setNewDate(rs.getTimestamp("newDate"));
                udd.add(resultUd);
            }
            System.out.println("search completed");
            
            return udd;
            
        } catch(SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        } finally {
            if(con != null){ con.close(); }
            st.close();
            rs.close();
        }
    }
    
    /**
     * ユーザーIDによる1件のデータの検索処理を行う。
     * @param ud 対応したデータを保持しているJavaBeans
     * @throws SQLException 呼び出し元にcatchさせるためにスロー 
     * @return 検索結果
     */
    public UserDataDTO searchByID(UserDataDTO ud) throws SQLException{
        Connection con = null;
        PreparedStatement st = null;
        try{
            con = DBManager.getConnection();
            
            String sql = "SELECT * FROM user_t WHERE userID = ?";
            
            st =  con.prepareStatement(sql);
            st.setInt(1, ud.getUserID());
            
            ResultSet rs = st.executeQuery();
            

            // 今回は全件ではなく一件なのでwhile文は使わない。
            rs.next();
            UserDataDTO resultUd = new UserDataDTO();
                resultUd.setUserID(rs.getInt(1));
                resultUd.setName(rs.getString(2));
                resultUd.setBirthday(rs.getDate(3));
                resultUd.setTell(rs.getString(4));
                resultUd.setType(rs.getInt(5));
                resultUd.setComment(rs.getString(6));
                resultUd.setNewDate(rs.getTimestamp(7));
            System.out.println("searchByID completed");
            return resultUd;

        } catch(SQLException e) {
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){ con.close(); }
            st.close();
        }
    }

    // 削除する時には削除した値は返さなくてもいいからvoid処理を行う。
    // deleteメソッドで削除した後に別途登録した値を取り出す（sessionみたいな処理）は基本NG。
    // それを行うならselectで取得した値→一部削除→取得した値から別途値の取り出し（登録）等を行う。
    public void delete(UserDataDTO ud) throws SQLException, ParseException{
        Connection con = null;
        try{
            con = DBManager.getConnection();

            String sql =  "delete from user_t where userID = ?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setInt(1, ud.getUserID());
                
                st.executeUpdate();
                st.close();
                
        }catch(SQLException e){
            System.out.println(e.getMessage());
            throw new SQLException(e);
        }finally{
            if(con != null){ con.close(); }
        }
    }
    
    public void update(UserDataDTO ud) throws SQLException, ParseException{
        Connection con = null;
        try{
            con = DBManager.getConnection();
            String sql =  "update user_t set name = ?, birthday = ?, tell = ?, type = ?, comment = ?, newDate = ? where userID = ?";
                PreparedStatement st = con.prepareStatement(sql);
                st.setString(1, ud.getName());
                st.setDate(2, new java.sql.Date(ud.getBirthday().getTime()));//指定のタイムスタンプ値からSQL格納用のDATE型に変更
                st.setString(3, ud.getTell());
                st.setInt(4, ud.getType());
                st.setString(5, ud.getComment());
                
                st.setTimestamp(6, new java.sql.Timestamp(ud.getNewDate().getTime()));
                st.setInt(7, ud.getUserID());
                
            // sql updateの実行文。
            st.executeUpdate();
            // prepareStatementを閉じる。
            st.close();
            
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

