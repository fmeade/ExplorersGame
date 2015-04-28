import java.util.*;
import java.sql.SQLException;

/**
* ExpGameDriver.java
* 
* Purpose: Driver for the Explorer's Game that obtains the username from the user and starts the database.
* 
* @author fmeade
* @author jbrooks12
* @version April 2015
*/
public class ExpGameDriver {

	/**
	 * Gets the username from the user and checks whether its in the database then runs game accordingly
	 */
	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);

		ExpDB expdb = new ExpDB("fmeade", "Catbags123"); // game database

		Explorer explorer; // current explorer


		/* Gets username from user */
		System.out.print("Welcome to the Explorer's Game! \n\n");
		System.out.print("Please enter a username: ");
			String username = scan.next();
		System.out.println("\n\n");


		/* Gets explorer from database */
		explorer = expdb.getExplorer(username);

		/* Checks whether they exist */
		if(explorer != null) {
			ExpGame game = new ExpGame(explorer, expdb);
			game.play();
		}
		else {
			System.out.println("ERROR: No Explorer found for " + username + "\n");
			System.out.print("Would you like to add one? y/n  ");
				char ans = scan.next().charAt(0);

			/* Creates explorer if requested */
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