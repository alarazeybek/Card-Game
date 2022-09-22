import java.util.Scanner;
import cardgame.*;
public class PlayerTest{
    public static void main(String[] args) {
    Player p1 = new Player("Alara");
    Player p2 = new Player("Can");
    Player p3 = new Player("Dilara");
    Player p4 = new Player("Emin");
    Cards pack = new Cards(true);
    ScoreCard sc = new ScoreCard(4);
    p1.add(pack.getTopCard());;
    sc.update(0, p1.playCard().getCardNo());
    System.out.println(sc);
    System.out.println(p2.getName());
    }
    
}