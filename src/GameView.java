import java.util.*;
import java.sql.SQLException;

/**
* GameView.java
* 
* Purpose: 
* 
* @author fmeade
* @author jbrooks12
* @version April 2015
*/
public class GameView {
	
	Scanner scan;

	ExpDB expdb;

	Explorer explorer;

	public GameView() {
		scan = new Scanner(System.in);

		expdb = new ExpDB("fmeade", "Catbags123");
	}
	public void run() {
		System.out.print("Welcome to the Explorer's Game! \n\n");
		System.out.print("Please enter a username: ");
			String username = scan.next();
		System.out.println("\n\n");

		explorer = expdb.getExplorer(username);

		if(explorer != null) {
			ExpGame game = new ExpGame(explorer, expdb);
			game.play();
		}
		else {
			System.out.println("ERROR: No Explorer found for " + username + "\n");
			System.out.print("Would you like to add one? y/n  ");
				char ans = scan.next().charAt(0);

			if(ans == 'y' || ans == 'Y') {
				// add an Explorer then start game
			}
			else if(ans == 'n' || ans == 'N') {
				System.out.println("Thank you for stopping in.");
			}
			else {
				System.out.println("ERROR: Please restart application.");
			}
		}

		expdb.close();
	}

}