public enum Suit{

    Hearts("\u2661"),
    Spades("\u2660"),
    Diamonds("\u2662"),
    Clubs("\u2663");

    private final String suitText;

    private Suit(String suitText)
    {
        this.suitText = suitText;
    }

    public String getSuitText()
    {
        return suitText;
    }

    public static void main(String[] args) {
    }
}