import java.util.ArrayList;
import java.util.Scanner;
import java.util.Map;
import java.util.HashMap;

public class BlackJack {
	private ArrayList<Player> players;
	private Dealer dealer;
	private Map<String, String> results;
	private Map<String, Integer> money;
	private Map<String, Integer> bets;
	
	public BlackJack() {
		players = new ArrayList<Player>();
		dealer = new Dealer(4);
		results = new HashMap<String, String>();
		money = new HashMap<String, Integer>();
		bets = new HashMap<String, Integer>();
	}

	public void playGame() {
		Scanner keyboard = new Scanner(System.in);
		char answer;
		System.out.println("Lets Play BlackJack!");
		System.out.println("Press ENTER to continue.");
		keyboard.nextLine();
		System.out.print("How many players will there be (not including the dealer)?: ");
		int numPlayers = keyboard.nextInt();
		keyboard.nextLine();
		for (int i = 1; i <= numPlayers; i++) {
			System.out.print("What is the name of Player " + Integer.toString(i) + "?: ");
			String temp = keyboard.nextLine().trim();
			players.add(new Player(temp));
		}
		for (Player p : players) {
			money.put(p.getName(), 1000);
		}
		do {
			dealer.resetHand();
			for (int r = 0; r < players.size(); r++) {
				players.get(r).resetHand();
			}
			bets.clear();
			results.clear();
			System.out.println("Time to place bets!");
			System.out.println("Press ENTER to continue.");
			keyboard.nextLine();
			for (Player p : players) {
				System.out.println(p.getName() + "\'s current funds: " + money.get(p.getName()));
			}
			for (Player p : players) {
				System.out.print("What is your bet, " + p.getName() + "?: ");
				int gamble = keyboard.nextInt();
				keyboard.nextLine();
				bets.put(p.getName(), gamble);
			}
			System.out.println("Time to shuffle and deal!");
			System.out.println("Press ENTER to continue.");
			keyboard.nextLine();
			dealer.shuffle();
			dealer.addCardToHand(dealer.deal());
			dealer.addCardToHand(dealer.deal());
			System.out.println("Dealer's exposed card: " + ((dealer.getHand()).get(0)).toString());
			for (int j = 0; j < players.size(); j++) {
				players.get(j).addCardToHand(dealer.deal());
				players.get(j).addCardToHand(dealer.deal());
				System.out.println(players.get(j).getName() + "'s hand: " + ((players.get(j)).getHand()).toString());
			}
			System.out.println("Lets play!");
			System.out.println("Press ENTER to continue.");
			keyboard.nextLine();
			if (dealer.getHandValue() == 21) {
				System.out.println("Dealer had blackjack!");
				System.out.println("Press ENTER to continue.");
				keyboard.nextLine();
				for (int k = 0; k < players.size(); k++) {
					int val = players.get(k).getHandValue();
					if (val == 21) {
						results.put(players.get(k).getName(), "Both the dealer and " + players.get(k).getName() + 
						"had blackjack. It is a push.");
					}
					else {
						results.put(players.get(k).getName(), "Dealer had blackjack while " + players.get(k).getName() + 
						" did not.");
						int b = bets.get(players.get(k).getName());
						money.replace(players.get(k).getName(), money.get(players.get(k).getName()) - b);
					}
				}
			}
			else {
				for (Player p : players) {
					if (p.getHandValue() == 21) {
						System.out.println(p.getName() + " had blackjack!");
						System.out.println("Press ENTER to continue.");
						keyboard.nextLine();
					}
					else {
						System.out.println(p.getName() + ", it's your turn!");
						System.out.println("Press ENTER to continue.");
						keyboard.nextLine();
						while (p.hit() && p.getHandValue() <= 21) {
							p.addCardToHand(dealer.deal());
							System.out.println(p.getHand().toString());
						}
					}
				}
				System.out.println("It's the dealer's turn!");
				System.out.println("Press ENTER to continue.");
				System.out.println("Dealer's hand: " + dealer.getHand().toString());
				keyboard.nextLine();
				while (dealer.hit()) {
					dealer.addCardToHand(dealer.deal());
					System.out.println(dealer.getHand().toString());
				}
				for (Player p : players) {
					int bb = bets.get(p.getName());
					if (p.getHandValue() == 21) {
						results.put(p.getName(), p.getName() + " had blackjack!");
						money.replace(p.getName(), money.get(p.getName()) + (bb * 2));
					}
					else if (p.getHandValue() < 21 && dealer.getHandValue() > 21) {
						results.put(p.getName(), "Dealer busted and " + p.getName() + " did not!");
						money.replace(p.getName(), money.get(p.getName()) + bb);
					}
					else if (p.getHandValue() > 21) {
						results.put(p.getName(), p.getName() + " busted!");
						money.replace(p.getName(), money.get(p.getName()) - bb);
					}
					else if (p.getHandValue() < dealer.getHandValue()) {
						results.put(p.getName(), p.getName() + "\'s hand had a lower value than that of the dealer!");
						money.replace(p.getName(), money.get(p.getName()) - bb);
					}
					else if (p.getHandValue() > dealer.getHandValue()) {
						results.put(p.getName(), p.getName() + "\'s hand had a higher value than that of the dealer!");
						money.replace(p.getName(), money.get(p.getName()) + bb);
					}
					else if (p.getHandValue() == dealer.getHandValue()) {
						results.put(p.getName(), p.getName() + "and the dealer had the same hand value! It\'s a push!");
					}
				}
			}
			for (String r : results.values()) {
				System.out.println(r);
			}
			for (Player p : players) {
				System.out.println(p.getName() + "\'s current funds: " + money.get(p.getName()));
			}
			System.out.print("Would you like to play again? (y/n): ");
			answer = keyboard.nextLine().charAt(0);
		} while(answer == 'y');
		keyboard.close();
	}
	
	public static void main(String[] args) {
		Scanner k = new Scanner(System.in);
		BlackJack game = new BlackJack();
		game.playGame();
		System.out.println("Thanks for playing!");
		System.out.println("Press ENTER to terminate the program.");
		k.nextLine();
		k.close();
	}
}