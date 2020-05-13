public class BlackJackCard extends Card
{
	//constructors
	public BlackJackCard() {
		super();
	}

	public BlackJackCard(int f, String s) {
		super(f, s);
	}

	public int getValue() {
		//enables you to build the value for the game into the card
		//this makes writing the whole program a little easier
		if (getFace() >= 2 && getFace() <= 10) {
			return getFace();
		}

		else if (getFace() >= 11 && getFace() <= 13) {
			return 10;
		}

		else if (getFace() == 1) {
			return 11;
		}

	  return 0;
	}  	
}