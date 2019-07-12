import java.util.ArrayList;

public class Player 
{
    private final ArrayList<Card> hand;
    private final String name;

    public Player(String name)
    {
        this.name = name;
        hand = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public String giveCard(Card card)
    {
        hand.add(card);
        return card.toString();
    }

    public int getSum()
    {
        int handSum = 0;
        for (Card card : hand)
        {
            handSum += card.getFace().getValue();
         
        }
        return handSum;
    }

    public String showHand(Boolean cheat)
    {
            String playerHand = "";
            for (Card card : hand)
            {
                    playerHand += "\n" + card.toString();
            }
            if (cheat == true)
            {
                playerHand += "\n" + ("(" + this.getSum() + ")");
            }
            return this.name + ": " + playerHand;
    }
    
    public String checkCheat(Boolean bool)
    {
        String sum = "";
        if (bool == true)
        {
           sum =  ("(" + this.getSum() + ")") ;
        }
        return sum;
    }
    
}