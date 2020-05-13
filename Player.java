import java.util.Scanner;

public class Player extends AbstractPlayer {
	public Player() {
		super();
	}
	
	public Player(String s) {
		super(s);
	}

	public boolean hit() {
		Scanner keyboard = new Scanner(System.in);
		System.out.print("Would you like to hit(h) or stand(s)?: ");
		char answer = keyboard.nextLine().charAt(0);
		keyboard.close();
		return answer == 'h';
	}
}