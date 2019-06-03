import java.util.ArrayList;
import java.util.Scanner;

public class Hand extends Deck
{
    public  Hand()
    {
        super();
    }
    public void addCard(Card c)
    {
        super.addCard(c);
    }

    public void addhand(Hand possible)
    {
        for (int i = 0; i < possible.getSize(); i++) 
        {
            super.addCard(possible.getCard(i));
        }
    }

    public boolean removeCard(Card c)
    {
        return super.removeCard(c);
    }

    public void resetHand()
    {
        for (int i = 0; i < this.getSize(); i++) 
        {
            this.removeCard(this.getCard(i));
        }
    }

    public Card getCard(int i)
    {
        return super.getCard(i);
    }

    public int getSize()
    {
        return super.getSize();
    }

    public boolean empty()
    {
        return super.hasMoreCards();
    }

    public void swap(int position1, int position2)
    {
        super.swap(position1, position2);
    }

    public ArrayList<Card> getSingleMatches(Card centerCard)
    {
       ArrayList<Card> singles = new ArrayList<>();
        for (int i = 0; i < this.getSize(); i++) 
        {
            if (this.getCard(i).getCard()==centerCard.getCard())
            {
                singles.add(this.getCard(i));
            }
        }
        return singles;
    }

    public ArrayList<ArrayList<Card>> getDoubleMatches(Card c)
    {
        ArrayList<ArrayList<Card>> doubles = new ArrayList<ArrayList<Card>>();
        ArrayList<Card> valid = new ArrayList<Card>();
        for (int i=0; i < this.getSize(); i++) 
        {
            if(c.getCard() > this.getCard(i).getCard() && this.getCard(i).getCard() > 0 || c.getCard() == 0)
                {
                    valid.add(this.getCard(i));
                }
        }

        for (int i=0; i < valid.size(); i++) {
            for (int j=i+1; j < valid.size(); j++) {
                int cardSum = this.getCard(i).getCard() + this.getCard(j).getCard();
                if (c.getCard() == cardSum || (c.getCard() == 0 && cardSum < 11))
                {
                    ArrayList<Card> pair = new ArrayList<Card>();
                    pair.add(this.getCard(i));
                    pair.add(this.getCard(j));
                    doubles.add(pair);
                }
            }
        }
        return doubles;
    }

    public String toString()
    {
        return super.toString();
    }

}
