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

    public String showHand(String nickname)
    {
            String playerHand = "";
            for (Card card : hand)
            {
                if  (hand.size() > 0)
                {
                    playerHand += "\n" + card.toString();
                }
                
            }
            return nickname + ": " + playerHand;
    }

    
    public static void main(String[] args) {
        
    
    }
}