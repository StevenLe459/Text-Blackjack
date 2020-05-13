//define Dealer class here
public class Dealer extends AbstractPlayer {
	//instance variable - Deck
	private Deck stack;
	
	//constructors
	public Dealer() {
		super("Dealer");
		stack = new Deck();
	}

	public Dealer(int n) {
		super("Dealer");
		stack = new Deck(n);
	}
	
	//method to shuffle
	public void shuffle() {
		stack.shuffle();
	}
	
	//method to deal a card
	public Card deal() {
		return stack.nextCard();
	}
	
	//hit method goes here
	public boolean hit() {
		return getHandValue() < 17;
	}
}