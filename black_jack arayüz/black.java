//BLACKJACK

import java.util.Random;
import java.util.Scanner;
public class black {
    public static void main(String[] args){
        GUI gui = new GUI();
        Scanner in = new Scanner(System.in);
        Integer a=1;
        Integer zero=0;
        Integer b=0;//I use this variable to find the sum of player's cards
        Integer sumPlayer=0;
        Integer sumDealer=0;
        String card=String.valueOf(a);
        String deck=card;
        System.out.println("Starting the game with the following deck:");
        String empty="";

        for(Integer ii=9;ii>0;ii--)
        { 
        for(Integer i=4;i>0;i--)     
        {
            card=String.valueOf(a);
            System.out.print(card);
            deck=empty+card;
            empty=deck;
        }
        a++;
        }  
        System.out.println("");
         //Buraya kadar deck yaratıldı
        
        Random rand = new Random();
        Integer randomChoice1=0;
        Integer randomChoice2=0;
        Integer randomChoice3=0;
        Integer randomChoice4=0;
        Integer index;
        String cardDeleted="";
        String playerRand="";
        

        System.out.println("Dealer is now dealing cards...");
        System.out.println("Player's hand:");
        for(Integer i=0;i<2;i++)//player's cart. Print both of them
        { 
            randomChoice1 = rand.nextInt(1,10);
            System.out.print(randomChoice1);
           // index = deck.indexOf(randomChoice1);
            deck=deck.replaceFirst(String.valueOf(randomChoice1),"");
            playerRand=empty+String.valueOf(randomChoice1);
            empty=String.valueOf(randomChoice1);
        }
        System.out.println("");
        for(Integer k=0;k<playerRand.length();k++)//player's sum
        {
            b=Character.getNumericValue(playerRand.charAt(k));
            sumPlayer=zero+b;
            zero=sumPlayer;
        }
System.out.println(sumPlayer);    //DELETE THIS   
System.out.println("");
                    
        System.out.println("");
        System.out.println("Dealer's hand:");
        
        randomChoice2 = rand.nextInt(1,10);
        System.out.print(randomChoice2);
        deck=deck.replaceFirst(String.valueOf(randomChoice2),"");
        randomChoice3 = rand.nextInt(1,10);
        deck=deck.replaceFirst(String.valueOf(randomChoice3),"");
        System.out.print("?"); 
        sumDealer=randomChoice2+randomChoice3;
        String DealerRand=String.valueOf(randomChoice2)+String.valueOf(randomChoice3);

        //GAME BEGİNS
        System.out.println("");
        System.out.println("Please enter your choice:");
        System.out.println("1) HIT");
        System.out.println("2) STAND");
        Integer choice1=in.nextInt();
        
        for(;choice1==1;)
        {
            System.out.println("Hit! Dealer is giving the player a card...");
            System.out.println("Player's hand:");
            randomChoice1 = rand.nextInt(1,10);
            deck=deck.replaceFirst(String.valueOf(randomChoice1),"");
            playerRand=playerRand+randomChoice1;
            System.out.print(playerRand);
            System.out.println("");
            zero=sumPlayer;
            sumPlayer=zero+randomChoice1;//player's sum
            System.out.println(sumPlayer); 
            if(sumPlayer<21)
            { 
            System.out.println("Please enter your choice:\n1) Hit\n2) Stand");
            choice1=in.nextInt();
            }
            if(sumPlayer>21)
            {
                System.out.println("Player scored over 21. Player lost!");
                choice1=3;
            } 
            if(sumPlayer==21)
            {
                System.out.println("Player scored 21. Player wins!");
                choice1=3;
            }
        }
    if(choice1==3)
    {
        System.out.println("");
    }
    if(choice1==2) //player stands. Dealer's turn
    { 
        System.out.println("Stand! Player's turn is now over. Player's hand sums to "+sumPlayer+".");
        System.out.println("");
        System.out.println("Dealer is drawing cards...\nDealer's hand:");
        for(;sumDealer<=sumPlayer;)
        {
            randomChoice4 = rand.nextInt(1,10);
            deck=deck.replaceFirst(String.valueOf(randomChoice4),"");
            DealerRand=DealerRand+randomChoice4;
            System.out.println(DealerRand);
            sumDealer=sumDealer+randomChoice4;
        }
        if(sumDealer==21)
        {
            System.out.println("Dealer scored 21. Dealer wins!");
        }
        if(sumDealer>21)
        {
            System.out.println("Dealer scored over 21. Dealer lost!");
        }
        if(sumDealer>sumPlayer && sumDealer<21)
        {
            System.out.println("Dealer scored more than player. Dealer wins!");
        }
    }
    System.out.println(deck+"  "+deck.length());
    in.close();
    }      
}

//KART SECİMLERİ DECK İCİNDEN DEGİL İNTERVALDEN YAPILDI

