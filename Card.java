import java.util.Random;

public class Card
{
    public final static int ONE = 1;
    public final static int TWO = 2;
    public final static int THREE = 3;
    public final static int FOUR = 4;
    public final static int FIVE = 5;
    public final static int SIX = 6;
    public final static int SEVEN = 7;
    public final static int EIGHT = 8;
    public final static int NINE = 9;
    public final static int TEN = 10;
    public final static int WILDNUMBER = 11;

    public final static int RED = 1;
    public final static int BLUE = 2;
    public final static int GREEN = 3;
    public final static int YELLOW = 4;
    public final static int WILDCOLOR = 5;

    private final static int NUM_VALUES = 11;
    private final static int NUM_COLORS = 5;

    protected int card, color;
    protected String cardName, colorName, choice;

    public Card(int cardValue, int colorValue)
    {
        card = cardValue;
        setCardName();

        color = colorValue;
        setColorName();
    }


    protected void setCardName()
    {
        switch (card)
        {
            case ONE:
            	cardName = "One";
            	break;
            case TWO:
            	cardName = "Two";
            	break;
            case THREE:
            	cardName = "Three";
            	break;
            case FOUR:
                cardName = "Four";
                break;
            case FIVE:
                cardName = "Five";
                break;
            case SIX:
                cardName = "Six";
                break;
            case SEVEN:
                cardName = "Seven";
                break;
            case EIGHT:
                cardName = "Eight";
                break;
            case NINE:
                cardName = "Nine";
                break;
            case TEN:
                cardName = "Ten";
                break;
            case WILDNUMBER:
                cardName = "Wild";
                break;
        }
    }

    protected void setColorName()
    {
        switch (color)
        {
            case RED:
                colorName = "Red";
                break;
            case BLUE:
                colorName = "Blue";
                break;
            case GREEN:
                colorName = "Green";
                break;
            case YELLOW:
                colorName = "Yellow";
                break;
            case WILDCOLOR:
                colorName = "WILD";
        }
    }

    public int getCard()
    {
        return card;
    }

    public int getColor()
    {
        return color;
    }

    public String getCardName()
    {
        return cardName;
    }

    public String getColorName()
    {
        return colorName;
    }

    public void setColor(int n)
    {
        color = n;
    }

    public String toString()
    {
        return colorName + " " + cardName;
    }
}
