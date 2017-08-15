/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BlackJack;

import java.util.ArrayList;
import java.util.Random;

/**
 *
 * @author Guestnumber
 */
//DealerとUser両方に必要な処理を実装し、完成させます。
//setCardは、ArrayListで受けたカード情報をmyCardsに追加するように実装してください。
//checkSumは、myCardsを確認し、まだカードが必要ならtrue、必要無ければfalseを返却するように実装してください。
//openは、myCardsのカードの合計値を返却するように実装してください。
public class user extends Human{
    @Override// cardsで作成した山札のメソッドがopen()を経由してmyCardsに入っている状態。
    public int open() {        
// openは、myCardsのカードの合計値を返却するように実装してください。
    int a = 0;
    for(int i = 0; i < myCards.size(); i++){
        a = a + myCards.get(i);
    }
        return a;
    }
    @Override// 
// setCardは、ArrayListで受けたカード情報をmyCardsに追加するように実装してください。
// myCardsにArrayList変数のsetCardに入った値を格納するそういった動きを実装してください。
    public void setCard(ArrayList<Integer> al) {
//        int setCard = 0;
//        myCards.add(setCard);
        for(int i = 0; i < al.size(); i++){
        myCards.add(al.get(i));
    }
}
    @Override
//checkSumは、myCardsを確認し、まだカードが必要ならtrue、必要無ければfalseを返却するように実装してください。
    public boolean checkSum(){
    if(open() <= 16)// 格納された値を17
        { return true; }
        else { return false; } 
    }
}
//    Random rand = new Random();
//    Integer index = rand.nextInt(cards.size());
//    if(myCards.add(cards.get(index)))
//        if(myCards.get(num) >= 17)
//        { return true; }
//        else { return false; } 
//    }
    