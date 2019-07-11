import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Deck 
{
    private final ArrayList<Card> cards;

    public Deck()
    {
        cards = new ArrayList<Card>();
        for (Suit suit : Suit.values())
        {
            for (Face face : Face.values())
            {
                cards.add(new Card(face,suit));
            }
        }
    }

    public void shuffle()
    {
        Collections.shuffle(cards);
    }

    public Card draw()
    {
        return cards.remove(0);
    }

    public String showDeck()
    {
        String remainingCards = "";
        for (Card card : cards)
        {
            remainingCards += card.toString() + "\n";
        }
        return remainingCards;
    }
}