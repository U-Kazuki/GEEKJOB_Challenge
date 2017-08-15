/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Random;

/**
 *
 * @author Guestnumber
 */
public class Dealer extends Human {
//初期処理でこのcardsに全てのトランプを持たせてください
    ArrayList<Integer> cards = new ArrayList<Integer>();
    // for文の入れ子処理で簡素な条件式に。
    // 後に、クラスの初期化ページを参考に初期化処理を実行．．．。
    public Dealer() {
        for (int i = 1; i < 5; i++) {  // ネスト処理
            for (int j = 1; j < 14; j++) { // iの処理【トランプの柄に相当】を4回行う
                // 上で行った4回の処理にjで求めた13の数字を入れる。【トランプの数字に相当】
                if (j < 10) {// 10より上の値を10として扱い、tureならそのまま、falseなら10を適用する。
                    cards.add(j);
                } else {
                    cards.add(10);
                }
                System.out.print(j);
            }
        }
    }
// deal公開メソッドを用意、Cardsからランダムで2枚をArrayListに返却。
    public ArrayList<Integer> deal(){
    ArrayList<Integer> dCard = new ArrayList<Integer>();
    Random rand = new Random();
    for(int i = 0; i < 2; i++){// 二枚引く
//    ArrayList<String> cards = cards.get[index];
    Integer index = rand.nextInt(cards.size());// 山札の要素数を取得しランダム処理にかける。
    dCard.add(cards.get(index));// ランダム処理を施した山札cardsをdCardに格納。
    }
    return dCard;
    }  
    //// hit公開メソッドを用意、Cardsからランダムで1枚をArrayListに返却。
    public ArrayList<Integer> hit(){
    ArrayList<Integer> array = new ArrayList<Integer>();
    Random rand = new Random();
    Integer index = rand.nextInt(cards.size());// 山札の要素数を取得しランダム処理にかける。
    // 複数枚取る訳では無いので、for等での計算処理は不要らしい。
    array.add(cards.get(index));// ランダム処理を施した山札cardsをarrayクラスのmyCardsに格納。
    return array;// 戻り値(Integer)はarray(整数扱いとして)に返却します。
    }
    
    @Override
    public int open(){// 公開されたopenメソッド
// openは、myCardsのカードの合計値を返却するように実装してください。
    int a = 0;
    for(int i = 0; i < myCards.size(); i++){// myCardsの要素数を取得し、一つづつ増やす。
        a = a + myCards.get(i);// myCardsに上記のfor文を取得し、変数aに足す。
    }
        return a;// 戻り値はa。
    }
    @Override
    public void setCard(ArrayList<Integer> al) {// 公開されたsetCard(整数を扱うArrayList型の変数al)
        for(int i = 0; i < al.size(); i++){// ArrayListの変数alの要素数を取得する。
        myCards.add(al.get(i));// myCardsに整数を扱うArrayList型の変数alに上記の計算を記述し、myCardsに追加する。
    }
}
    @Override
    public boolean checkSum(){// 公開された真偽値を求める変数checkSum()。
        if(open() <= 17)// 格納された値を17
        { return true; }
        else { return false; } 
    }
//    int num = 0;
//    for(int i = 0; i <= myCards.size(); i++){// setCardの記述が格納されている、myCardsの要素数の取得。
//        num =  num + myCards.get(i);// myCardsに上記のfor文を取得する。
//    }
//      int num = 0;
//      for(int i = 0; i <= open(); i++){
//          num = num + open();
//      }
    
    
    
    
    
    
    
    
//    @Override
//    public void myCards(){
//    }
//        System.out.println("iの値は"+i+"jの値は"+j);
//        public ArrayList<Integer> deal(){
//            ArrayList<Integer> dealcards = new ArrayList<Integer>();

//    int tora = 1;
//    for(int i = 0; i <= 12; i++){
//        cards.add(tora);
//        cards.add(tora);
//        cards.add(tora);
//        cards.add(tora);
    // 10以上の数字を10が16個表示（格納）されているif文を作成
//    if(tora > 10){
//        cards.get(tora = 10);
//    }
//        System.out.print(tora);
//        System.out.print(tora);
//        System.out.print(tora);
//        System.out.print(tora);
////        tora = tora + 1;
//        public static void deal{
//        int lol = tora;
//        Random rand = new Random();
//        Integer index = rand.nextInt(cards.get(lol));
//        cards.get(lol[index]);
//        }
//        public static abstract Collection{
//        Collection.shuffle(tora);
//        }
//    public hit
//3. まずはDealerクラスを完成させます。
//cardsというArrayListの変数を用意し、初期処理でこのcardsに全てのトランプを持たせてください。
//dealという公開メソッドを用意し、cardsからランダムで2枚のカードをArrayListにして返却してください。
//hitという公開メソッドを用意し、cardsからランダムで1枚のカードをArrayListにして返却してください。

}