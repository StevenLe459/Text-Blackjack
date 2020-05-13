import java.util.ArrayList;
import java.util.Collections;

public class Deck
{
	public static final int NUMFACES = 13;
	public static final int NUMSUITS = 4;
	public static final int NUMCARDS = 52;

	public static final String SUITS[] = {"CLUBS","SPADES","DIAMONDS","HEARTS"};

	private int topCardIndex;
	private ArrayList<Card> stackOfCards;

	public Deck()
	{
		//initialize data - stackOfCards - topCardIndex
		stackOfCards = new ArrayList<Card>();
		//loop through suits
		for (int i = 1; i <= NUMFACES; i++) {
			//loop through faces
			for (int j = 0; j < NUMSUITS; j++) {
				//add in a new card
				stackOfCards.add(new BlackJackCard(i, SUITS[j]));
			}
		}
		topCardIndex = NUMCARDS - 1;
	}

	public Deck(int n) {
		stackOfCards = new ArrayList<Card>();
		for (int k = 1; k <= n; k++) {
			for (int i = 1; i <= NUMFACES; i++) {
				//loop through faces
				for (int j = 0; j < NUMSUITS; j++) {
					//add in a new card
					stackOfCards.add(new BlackJackCard(i, SUITS[j]));
				}
			}
		}
		topCardIndex = (NUMCARDS * n) - 1;
	}

	//modifiers
   public void shuffle ()
	{
		//shuffle the deck
		Collections.shuffle(stackOfCards);
		//reset variables as needed
		topCardIndex = NUMCARDS - 1;
	}

   //accessors
	public int size ()
	{
		return NUMCARDS;
	}

	public int numCardsLeft()
	{
		return topCardIndex + 1;
	}

	public Card nextCard()
	{
		return stackOfCards.get(topCardIndex--);
	}

	public String toString()
	{
		return stackOfCards + "   topCardIndex = " + topCardIndex;
	} 
}