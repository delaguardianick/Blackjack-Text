public enum Face
{
    Ace(11), Deuce (2), Three (3),
    Four(4), Five(5), Six(6),
    Seven(7), Eight(8), Nine(9),
    Ten(10), Jack(10), Queen(10),
    King(10);

    private final int faceValue;
    private final int aceSecondValue = 11;

    private Face(int faceValue)
    {
        this.faceValue = faceValue;
    }

    public int getValue()
    {
        return faceValue;
    }
    
    public int getAceSecondValue()
    {
        return aceSecondValue;
    }

    public static void main(String[] args) {
    }
}