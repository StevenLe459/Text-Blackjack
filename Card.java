public abstract class Card
{
	public static final String FACES[] = {"ZERO","ACE","TWO","THREE","FOUR",
			"FIVE","SIX","SEVEN","EIGHT","NINE","TEN","JACK","QUEEN","KING"};

	private String suit;
	private int face;

  	//constructors
  	public Card() {
  		face = 0;
  		suit = "Joker";
  	}

  	public Card(int f) {
  		face = f;
  		suit = "Joker";
  	}

  	public Card(String s) {
  		face = 0;
  		suit = s;
  	}

	public Card(int f, String s) {
		face = f;
		suit = s;
	}

	// modifiers
	public void setFace(int f) {
		face = f;
	}

	public void setSuit(String s) {
		suit = s;
	}

  	//accessors
	public int getFace() {
		return face;
	}

	public String getSuit() {
		return suit;
	}

	//abstract method
  	public abstract int getValue();

  	//equals method specific to Card class
	public boolean equals(Object obj) {
		if (obj == null) {
			return false;
		}
		if (this.getClass() != obj.getClass()) {
			return false;
		}
		if (this.face != ((Card)obj).getFace()) {
			return false;
		}
		if (!this.suit.equals(((Card)obj).getSuit())) {
			return false;
		}
		return true;
	}

  	//toString
  	public String toString() {
  		return FACES[this.face] + " of " + this.suit;
  	}
 }