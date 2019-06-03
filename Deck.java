import java.util.*;

public class Deck extends CardStack
{
    public Deck()
    {
        super();
    }
    
    public void addCard(Card c)
    {
        super.addCard(c);
    }

    public boolean removeCard(Card c)
    {
        return super.removeCard(c);
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

    public Card deal()
    {
        return super.deal();
    }

    public Card randomDeal()
    {
        return super.randomDeal();
    }

    public void swap(int position1, int position2)
    {
        super.swap(position1, position2);
    }

    public Deck shuffle(Deck old)
    {
        int i=0;
        Deck newDeck = new Deck();
        while (i<old.getSize())
        {
            Card x = old.randomDeal();
            newDeck.addCard(x);
        }
        return newDeck;
    }

    public void makeDeck(Deck deck)
    {
        int i = 1;
        while (i < 12)
        {
            if (i== 1|| i==3 || i==4 || i==5)
            {
                for (int j=1; j<5; j++)
                {
                    Card card1 = new Card(i,j);
                    Card card2 = new Card(i,j);
                    Card card3 = new Card(i,j);
                    deck.addCard(card1);
                    deck.addCard(card2);
                    deck.addCard(card3);
                }
            }
            else if (i==2)
            {
                int j=1;
                while (j<13)
                {
                    Card wildCard = new Card(i,5);
                    deck.addCard(wildCard);
                    j++;
                }
            }
           else if (i==11)
            {
                int j=1;
                while(j<5)
                {
                    Card wildCard1 = new Card(i,j);
                    deck.addCard(wildCard1);
                    Card wildCard2 = new Card(i,j);
                    deck.addCard(wildCard2);
                    j++;
                }
            }
            else
            {
                for (int j=1; j<5; j++)
                {
                    Card card1 = new Card(i,j);
                    Card card2 = new Card(i,j);
                    deck.addCard(card1);
                    deck.addCard(card2);
                }
            }
            i++;
        }
    }

    public void clearDeck(Deck deck)
    {
        for (int i=0; i<deck.getSize();i++)
        {
            deck.removeCard(getCard(i));
        }
    }

    public String toString()
    {
        return super.toString();
    }

}