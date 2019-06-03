public class Player {

	private String name;
	private int wins;
	private int losses;
	private int currentPoints;
	private int runningTotal;
	private int bonusPoints;
	private Hand hand;

	public Player(String name)  //Constructor
	{
		this.name = name;
		wins = 0;
		losses = 0;
		currentPoints = 0;
		runningTotal = 0;
		hand= new Hand();
	}

	public int getLosses() //gives access to losses
	{
		return this.losses;
	}

	public int getWins() //gives access to wins
	{
		return this.losses;
	}


	public String getName() //gives access to name
	{
		return name;
	}

	public void setName(String name) //sets player name to argument
	{
		this.name = name;
	}

	public void lost()
	{
		losses++;
	}

	public void won()
	{
		wins++;
	}

	public int getPoints()
	{
		return this.currentPoints;
	}

	public int getBonus()
	{
		return bonusPoints;
	}

	public int getTotalPoints()
	{
		return runningTotal;
	}

	public void setPoints(int points)
	{
		this.currentPoints = points;
		this.runningTotal+=points;
	}

	public void setBonus(int points)
	{
		this.bonusPoints += points;
	}

	public void addCard(Card c)
	{
		hand.addCard(c);
	}

	public Hand getHand()
	{
		return this.hand;
	}

	public String toString()
	{
		String result = "\n"+name+" running total: "+runningTotal+"\n"+
						"Wins: "+wins+"\nLosses: "+losses + "\nBonus points: " + bonusPoints;
		return result;
	}
}