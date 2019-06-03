import java.util.*;

public class CardStack
{
    private ArrayList<Card> stack;

    public CardStack()
    {
        stack = new ArrayList<Card>();
    }

    public void addCard(Card c)
    {
        stack.add(c);
    }

    public Card deal()
    {
        if (stack.size() > 0) {
            return stack.remove(0);
        } else {
            return null;
        }
    }

    public Card randomDeal()
    {
        Random generator = new Random();
        int index = generator.nextInt(stack.size());

        if (stack.size() > 0) {
            return stack.remove(index);
        } else {
            return null;
        }       
    }

    public boolean removeCard(Card c)
    {
        return stack.remove(c);
    }

    public Card getCard(int i)
    {
        if(stack.size()>i) {
            return stack.get(i);
        }
        return null;
    }

    public int getSize()
    {
        return stack.size();
    }

    public boolean hasMoreCards()
    {
        return (stack.size() > 0);
    }

    public void swap(int position1, int position2)
    {
        Card temp;  
        temp = stack.get(position1);
        stack.set(position1, stack.get(position2));
        stack.set(position2, temp);
    }

    public String toString()
    {
        String result = "";
        for(int i=0; i<stack.size(); i++)
        {
            result+="["+stack.get(i).toString()+"] ";
        }
        return result;
    }

}
