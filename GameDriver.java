import java.util.*;
import java.awt.*;
import java.lang.*;

public class GameDriver
{
    private static Deck deck = new Deck(); //creates deckHand centerPile = new Hand();
    private static Hand centerPile = new Hand();
    private static Hand discardPile = new Hand();
    private static boolean flag = true;
    public static void main(String[] args)
    {
        boolean playing = true;
        Scanner sc = new Scanner(System.in); //creates scanner object
        
        System.out.println("---------------LETS PLAY DOS ! --------------");
        System.out.println("|                                           |");
        System.out.println("|                                           |");
        System.out.println("|                                           |");
        System.out.println("|                                           |");
        System.out.println("---------------------------------------------");
        System.out.print("Enter anything when you're ready to play.");
        String x = sc.nextLine();

        deck.makeDeck(deck); //fills the deck
        System.out.println("HERE IS THE DECK : ");
        System.out.println(deck);
        deck = deck.shuffle(deck); //shuffles the deck
        System.out.println("\nHERE IS THE SHUFFLED DECK : ");
        System.out.println(deck);
        
        System.out.print("Enter name of Player1: ");
        String name = sc.nextLine();
        Player player1 = new Player(name);
        System.out.print("Enter name of Player2: ");
        name = sc.nextLine();
        Player player2 = new Player(name);
        System.out.print("Enter name of Player3: ");
        name = sc.nextLine();
        Player player3 = new Player(name);

        System.out.println("Welcome all players!" + player1 + player2 + player3);

        //deals cards into player hands and into center pile
        for (int i=0; i<7; i++)
        {
            player1.addCard(deck.deal()); 
            player2.addCard(deck.deal());
            player3.addCard(deck.deal());
        }
        centerPile.addCard(deck.deal());
        centerPile.addCard(deck.deal());

        while (playing)
        {
            play(player1,player2,player3);
            play(player2,player1,player3);
            play(player3,player2,player1);
            playing = checkWin(deck,player1,player2,player3);
        }


        sc.close();
    }



    public static boolean checkWin(Deck deck,Player player1,Player player2,Player player3)
    {
        if (player1.getTotalPoints()==5)
        {
            System.out.println("\nCongragulations " + player1.getName() + " You win!");
            player1.won();
            return false;
        }
        else if (player2.getTotalPoints()==5)
        {
            System.out.println("\nCongragulations " + player2.getName() + " You win!");
            player2.won();
            return false;
        }
        else if (player3.getTotalPoints()==5)
        {
            System.out.println("\nCongragulations " + player3.getName() + " You win!");
            player3.won();
            return false;
        }
        else if (player1.getHand().getSize()==0)
        {
            System.out.println("\nCongragulations " + player1.getName() + " You win!");
            player1.won();
            return false;
        }
        else if (player2.getHand().getSize()==0)
        {
            System.out.println("\nCongragulations " + player2.getName() + " You win!");
            player2.won();
            return false;
        }
        else if (player3.getHand().getSize()==0)
        {
            System.out.println("\nCongragulations " + player3.getName() + " You win!");
            player3.won();
            return false;
        }
        else if (!deck.empty())
        {
            if (player1.getTotalPoints() > player2.getTotalPoints() && player1.getTotalPoints() > player3.getTotalPoints())
            {
                System.out.println("\nCongragulations " + player1.getName() + " You win!");
                player1.won();
                return false;
            }
            else if (player2.getTotalPoints() > player1.getTotalPoints() && player2.getTotalPoints() > player3.getTotalPoints())
            {
                System.out.println("\nCongragulations " + player2.getName() + " You win!");
                player2.won();
                return false;
            }
            else if (player3.getTotalPoints() > player2.getTotalPoints() && player3.getTotalPoints() > player1.getTotalPoints())
            {
                System.out.println("\nCongragulations " + player3.getName() + " You win!");
                player3.won();
                return false;
            }
            else
            {
                System.out.println("\nIts a tie!");
                return false;
            }
        }
        return true;
    }
    
    public static void play(Player player1, Player player2, Player player3) {

        Scanner sc = new Scanner(System.in);
        ArrayList<ArrayList<Card>> singleMatches = new ArrayList<ArrayList<Card>>();
        ArrayList<ArrayList<ArrayList<Card>>> doubleMatches = new ArrayList<ArrayList<ArrayList<Card>>>();
        ArrayList<Card[]> singles = new ArrayList<>();
        ArrayList<Card[]> doubles = new ArrayList<>();
        int allSingles = 0;
        int allDoubles = 0;

        System.out.println("\nCENTER PILE:" + centerPile);
        System.out.println("\nDISCARD PILE:" + discardPile+"\n");    
        System.out.println("It is " + player1.getName() + "'s turn.");
        System.out.println("This is your hand: " + player1.getHand());

        //gets single matches
        for (int i = 0; i < centerPile.getSize(); i++)
        {
            ArrayList<Card> total = player1.getHand().getSingleMatches(centerPile.getCard(i));
            singleMatches.add(total);
            allSingles+=total.size();
        }

        //get double matches
        for(int i = 0; i < centerPile.getSize(); i++)
        {
            ArrayList<ArrayList<Card>> total = player1.getHand().getDoubleMatches(centerPile.getCard(i));
            doubleMatches.add(total);
            allDoubles+=total.size();
        }

        //displays all possible moves that user can make
        if ((allSingles + allDoubles) > 0)
        {
            int x = 0;
            if (allSingles > 0)
            {
                for (int i = 0; i < centerPile.getSize(); i++)
                {
                    for(int j = 0; j < player1.getHand().getSingleMatches(centerPile.getCard(i)).size(); j++)
                    {
                        String display = "" + x + ": ";
                        display += singleMatches.get(i).get(j) + " single matches ->";
                        display += centerPile.getCard(i) ;
                        System.out.println(display);
                        Card[] twoCards = new Card[2];
                        twoCards[0] = centerPile.getCard(i);
                        twoCards[1] = singleMatches.get(i).get(j);
                        singles.add(twoCards);
                        x++;
                    }
                }
            }
            if (allDoubles > 0)
            {
                for (int i = 0; i < centerPile.getSize(); i++)
                {
                    for(int j = 0; j < player1.getHand().getDoubleMatches(centerPile.getCard(i)).size(); j++)
                    {
                        String display = "" + x + ": ";
                        display += doubleMatches.get(i).get(j) + " double matches ->";
                        display += centerPile.getCard(i);
                        System.out.println(display);
                        Card[] threeCards = new Card[3];
                        threeCards[0] = centerPile.getCard(i);
                        threeCards[1] = doubleMatches.get(i).get(j).get(0);
                        threeCards[2] = doubleMatches.get(i).get(j).get(1);
                        doubles.add(threeCards);
                        x++;
                    }
                }
            }

            int input = -1;
            while(input < 0 || input > x-1)
            {
                System.out.print("Input the index of the card you want to play: ");
                String temp = sc.next();
                //catches invalid inputs
                try
                {
                    input = Integer.parseInt(temp);
                }
                catch (NumberFormatException e)
                {
                    input = -1;
                    System.out.println("ERROR INDEX OUT OF RANGE. Please input a valid one.");
                }
            }


            Card[] pickedCards;
            if(input < allSingles) {
                pickedCards = singles.get(input);
                player1.getHand().removeCard(pickedCards[1]);
                centerPile.addCard(pickedCards[1]);
            }
            else {
                pickedCards = doubles.get(input - allSingles);
                player1.getHand().removeCard(pickedCards[1]);
                player1.getHand().removeCard(pickedCards[2]);
                centerPile.addCard(pickedCards[1]);
                centerPile.addCard(pickedCards[2]);
            }

            System.out.println("\nCenter Pile: " + centerPile);
            System.out.println("\nDiscard Pile: " + discardPile+"\n");

            //If color bonus, than it awards extra point
            if (pickedCards[0].getColor() == pickedCards[1].getColor() || pickedCards[0].getColor() == 5|| pickedCards[1].getColor() == 5)
            {
                if(pickedCards.length == 2)
                {
                    System.out.println("Color match bonus!");
                    player1.setPoints(1);
                    flag = false;
                    System.out.println("Earned 1 extra point!");
                    if(player1.getHand().getSize() > 0)
                    {
                        for(int i = 0; i < player1.getHand().getSize(); i++)
                        {
                            System.out.println("" + i + ": " + player1.getHand().getCard(i));
                        }
                        int index = -1;
                        while(index < 0 || index > player1.getHand().getSize()-1)
                        {
                            System.out.print("Input the index of the card you wish to put in the center pile: ");
                            String temp = sc.next();
                            try
                            {
                                index = Integer.parseInt(temp);
                            }
                            catch (NumberFormatException e)
                            {
                                index = -1;
                                System.out.println("ERROR INDEX OUT OF RANGE. Please input a valid one.");
                            }
                        }
                        Card nextCard = player1.getHand().getCard(index);
                        player1.getHand().removeCard(nextCard);
                        centerPile.addCard(nextCard);
                        System.out.println(nextCard.toString() + " has been added to the center pile.");
                    }
                }
                
                if(pickedCards.length == 3)
                {
                    if(pickedCards[0].getColor() == pickedCards[2].getColor() || pickedCards[2].getColor() == 5)
                    {
                        System.out.println("Color match bonus!");
                        player1.setPoints(1);
                        flag = false;
                        System.out.println("Earned 1 extra point!");
                        if(player1.getHand().getSize() > 0)
                        {

                            for(int i = 0; i < player1.getHand().getSize(); i++)
                            {
                                System.out.println(player1.getHand().getCard(i));
                            }
                            int index = -1;
                            while(index < 0 || index > player1.getHand().getSize()-1)
                            {
                                System.out.print("Input the index of the card you wish to put in the center pile: ");
                                String temp = sc.next();
                                try
                                {
                                    index = Integer.parseInt(temp);
                                }
                                catch (NumberFormatException e)
                                {
                                    index = -1;
                                    System.out.println("ERROR INDEX OUT OF RANGE. Please input a valid one");
                                }
                            }
                            Card nextCard = player1.getHand().getCard(index);
                            player1.getHand().removeCard(nextCard);
                            centerPile.addCard(nextCard);
                            System.out.println(nextCard.toString() + " has been put into the center pile.");
                        }
                        //Makes players draw extra cards after color match
                        if(player2.getHand().getSize() > 0)
                        {
                            player2.getHand().addCard(deck.deal());
                        }
                        if(player3.getHand().getSize() > 0)
                        {
                            player3.getHand().addCard(deck.deal());
                        }
                    }
                }
            }

            //takes cards to discard pile
            centerPile.removeCard(pickedCards[0]);
            centerPile.removeCard(pickedCards[1]);
            discardPile.addCard(pickedCards[0]);
            discardPile.addCard(pickedCards[1]);
            if(pickedCards.length == 3) {
                centerPile.removeCard(pickedCards[2]);
                discardPile.addCard(pickedCards[2]);
            }

            //adds a card if color bonus didn't add card yet
            if (!flag)
            {
                Card nextCard = deck.deal();
                centerPile.addCard(nextCard);
                System.out.println("Added " + nextCard.toString() + " to the center pile.");
                
            }
            
            //always makes sure there are 2+ cards in the middle
            if (centerPile.getSize() < 2)
            {
                Card nextCard = deck.deal();
                centerPile.addCard(nextCard);
                System.out.println("Added " + nextCard.toString() + " to the center pile.");
            }


        }

        else
        {
            System.out.println("You have no matches! Draw a card and add a random card to the center pile.");
            Card cardDealt = deck.deal();
            player1.addCard(cardDealt);
            System.out.println("You drew " + cardDealt);
            Card nextCard = player1.getHand().randomDeal();
            centerPile.addCard(nextCard);
            System.out.println(nextCard + " was added to the center pile.");
        }

    }

   
}