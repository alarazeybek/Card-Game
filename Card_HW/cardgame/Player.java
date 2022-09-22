package cardgame;

// Player - Simple card game player with name and hand of cards
// author:ALARA ZEYBEK
// date:17.02.2022
public class Player
{
    // properties
    String name;
    Cards hand;
    
    // constructors
    public Player( String name)
    {
        // ToDo
        this.name=name;
        this.hand= new Cards(false);
    }
    
    // methods
    public String getName()
    {
        return name;
    }
    
    public void add( Card c)
    {
        // ToDo
        this.hand.addTopCard(c);
    }
    
    public Card playCard()
    {
        // ToDo
        return this.hand.getTopCard();
    }
    
} // end class Player
