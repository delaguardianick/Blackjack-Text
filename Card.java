public class Card {

    private Suit suit;
    private Face face;

    public Card(Face cardFace, Suit cardSuit)
    {
        this.face = cardFace;
        this.suit = cardSuit;
    }

    public Face getFace()
    {
        return face;
    }

    public Suit getSuit()
    {
        return suit;
    }

    public String toString()
    {
        return face + " of " + suit;
    }
}