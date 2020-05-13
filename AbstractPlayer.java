import java.util.ArrayList;

public abstract class AbstractPlayer implements Playerable {
   private ArrayList<Card> hand;
   private int winCount;
   private String name;

   //constructors
   public AbstractPlayer() {
      hand = new ArrayList<Card>();
      winCount = 0;
      name = "Anonymous";
   }
   
   public AbstractPlayer(String s) {
      hand = new ArrayList<Card>();
      winCount = 0;
      name = s;
   }

   public void addCardToHand(Card temp) {
      hand.add(temp);
   }

   public void resetHand() {
      hand.clear();
   }

   public abstract boolean hit();

   public void setWinCount(int numwins) {
      winCount = numwins;
   }

   public int getWinCount() {
      return winCount;
   }

   public int getHandSize() { 
      return hand.size(); 
   }

   public ArrayList<Card> getHand() {
      return hand;
   }

   public int getHandValue() {
      //great example of polymorphism
      int total = 0;
      for (Card c : hand) {
         total += c.getValue();
      }
      return total;
   }

   public String getName() {
      return name;
   }

   public String toString() {
      return getName() + "\'s hand: " + hand.toString() + " \nNumber of wins: " + winCount;
   }
}