package cardgame;

import java.util.ArrayList;
// Cardgame
// author:
// date:
public class CardGame
{
    // properties
    Cards             fullPack;
    ArrayList<Player> players;
    ScoreCard         scoreCard;
    Cards[]           cardsOnTable;
    int               roundNo;
    int               turnOfPlayer; //first player's turn should be 0th turn
    
    
    // constructors
    public CardGame( Player p1, Player p2, Player p3, Player p4)
    {
        // ToDo
        
        this.roundNo=0;
        this.turnOfPlayer=1;
        this.scoreCard=new ScoreCard(4);
        players = new ArrayList<>();
        this.cardsOnTable= new Cards[52];
        for(int i =0;i<52;i++){
            this.cardsOnTable[i]=new Cards(false);
        }
        this.players.add(p1);
        this.players.add(p2);
        this.players.add(p3);
        this.players.add(p4);
        this.fullPack = new Cards(true); //distributing the deck
        int i = 0;
        int bound = 13;
        for(int p = 0; p<players.size();p++){ 
            while( i< bound){
                players.get(p).add(fullPack.cards[i]);
                i++;
            }
            bound=bound+13;
        }
    }
    
    // methods
    public boolean playTurn( Player p, Card c)
    {
        // Todo 
        if(this.isTurnOf(p)){ 
            turnOfPlayer++;
            this.cardsOnTable[roundNo].addTopCard(c);
            p.add(this.fullPack.getTopCard()); 
            //System.out.println(p.playCard());
            this.isTurnOf(p);
            return true;
        }
        return false;
    }
    public void modifyTheScore(){ //incrementing score of the round's winner by 1
        
        Card maxOfRound = this.cardsOnTable[roundNo].cards[0];
        int winnerOfRound=2;
        for(int i =0;i<4;i++){
            if(this.cardsOnTable[roundNo].cards[i].compareTo(maxOfRound)!=-1){
                winnerOfRound = i;
                maxOfRound=this.cardsOnTable[roundNo].cards[i];
            }
        }
        scoreCard.update(winnerOfRound, 1);
    }
    
    public boolean isTurnOf( Player p) 
    {
        // ToDo
        if(turnOfPlayer==5){
            modifyTheScore();
            roundNo++;
            turnOfPlayer=1;
        }
        if(players.get(turnOfPlayer-1)==p){
            return true;
        }
        else{ 
        return false;
        }
    }
    
    public boolean isGameOver()
    {
        // ToDo
        if(this.fullPack.valid==0){
            return true;
        }
        return false;
    }
    
    public int getScore( int playerNumber)
    {
        // ToDo
        return this.scoreCard.getScore(playerNumber);
    }

    public ScoreCard getsc(){
        return scoreCard;
    }
    
    public String getName( int playerNumber)
    {
        // ToDo
        return players.get(playerNumber-1).getName();
    }
    
    public int getRoundNo()
    {
        // ToDo
        return this.roundNo;
    }
    
    public int getTurnOfPlayerNo()
    {
        // ToDo
        return this.turnOfPlayer;
    }
    
    public Player[] getWinners()
    {
        // ToDo
        scoreCard.getWinners();
        Player[] pList = new Player[4];
        for(int i=0;i<4;i++){
            pList[i]=players.get(scoreCard.playerArray[i]);
        }
        return pList;
    }
    
    public String showScoreCard()
    {
        return scoreCard.toString();
    }
    
}