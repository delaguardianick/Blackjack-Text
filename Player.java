import java.util.ArrayList;

import javax.lang.model.util.ElementScanner6;

public class Player 
{
    //init
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

    //Adds card parameter to ArrayList hand (player's current cards)
    public String giveCard(Card card)
    {
        hand.add(card);
        return card.toString();
    }
    
    //Loops through hand array and prints every card. If cheat is on, shows total sum of hand too
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

    //Checks if hand has an Ace and a card with value 10 (10,J,Q,K). If both true, is blackjack
    //Only used for 21's in Blackjack.java
    public Boolean isBlackjack()
    {
        Boolean hasAce = false;
        Boolean has10 = false;
        Boolean blackjack = false;

        for (Card card : hand)
        {
            if (card.getFace() == Face.Ace)
            {
                hasAce = true;
            }
            else if (card.getFace().getValue() == 10)
           {
               has10 = true;
           } 
        }

        if (hasAce && has10)
        {
            blackjack = true;
        }
        return blackjack;
    }
    
    public int getSum()
    {
        int numOfAces = 0;
        int handSum = 0;
        for (Card card : hand)
        {
            if (card.getFace() == Face.Ace)
            {
                numOfAces ++;
            }
                handSum += card.getFace().getValue();
        }

        //Checking Aces
        if (handSum > 21 && numOfAces == 1)
        {
            handSum -= 10;
        }
        else if (handSum > 21 && numOfAces > 1)
        {
            handSum -= 10 * (numOfAces - 1);
        }
        return handSum;
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