package football;

import java.util.Scanner;

public class PlayerDemo2 {
	public static void main(String[] args) {
		Player[] myPlayers;
		
		Scanner input = new Scanner(System.in);
		System.out.print("How many players would you like to create? ");
		int numPlayers = input.nextInt(); 
		
		System.out.println("OK.  Creating " + numPlayers + " players.");
		myPlayers = new Player[numPlayers];
		
		String name, positionStr;
		Player.Position position;
		for (int i=0; i<numPlayers; i++) {
			System.out.print("Please enter the name for player " + (i+1) + ": ");
			input.nextLine(); // discard newline character from previous call to nextInt() or next()
			name = input.nextLine();
			System.out.print("What position does this player play? " +
							"(" + Player.getValidPositionsStr() + ")");
			positionStr = input.next();
			position = Player.Position.valueOf(positionStr);
			myPlayers[i] = new Player(name, position);
		}
		
		System.out.println("\nDisplaying information on all players");
		for (int i=0; i<numPlayers; i++) {
			myPlayers[i].displayPlayerInfo();
		}
	}
}