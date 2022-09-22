package cardgame;

// ScoreCard - Maintains one integer score per player, for any number of players
//             Caution: invalid playernumbers result in run-time exception!
// author:ALARA ZEYBEK
// date:17.02.2022
public class ScoreCard
{
    // properties
    int[] scores;
    public int[] playerArray = {0,1,2,3};

    // constructors
    public ScoreCard( int noOfPlayers)
    {
        scores = new int[noOfPlayers];
        
        // init all scores to zero
        for ( int i = 0; i < scores.length; i++)
            scores[i] = 0;
    }
    
    // methods
    public int getScore( int playerNo)
    {
        return scores[playerNo];
    }
    
    public void update( int playerNo, int amount)
    {
        scores[playerNo] += amount;
    }
    
    public String toString()
    {
        String s;
        s = "\n"
            + "_____________\n"
            + "\nPlayer\tScore\n"
            + "_____________\n";
        
        for ( int playerNo = 0; playerNo < scores.length; playerNo++)
        {
            s = s + playerNo + "\t" + scores[playerNo] + "\n";
        }
        
        s += "_____________\n";
        return s;
    }
    
    public int[] getWinners()
    {
        // ToDo
        int max = scores[0];
        int maxPlayer = playerArray[0];
        for(int index = 0;index<scores.length;index++){ 
            for(int a = index+1; a < scores.length; a++){
                if(scores[a]>= scores[index]){
                    max=scores[a];
                    maxPlayer = playerArray[a];
                    scores[a]=scores[index];
                    playerArray[a] = playerArray[index];
                    scores[index]=max;
                    playerArray[index] = maxPlayer;
                }
            } 
            } 
        return scores;
    }
    
} // end class ScoreCard
