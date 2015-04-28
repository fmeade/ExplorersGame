import java.util.*;
import java.io.*;

/**
* ExpGame.java
* 
* Purpose: 
* 
* @author fmeade
* @author jbrooks12
* @version April 2015
*/
public class ExpGame {
	
	ExpDB expdb;
	Explorer explorer;

	Scanner scan;


	public ExpGame(Explorer _explorer, ExpDB _expdb) {
		explorer = _explorer;
		expdb = _expdb;

		scan = new Scanner(System.in);
	}

	public void play() {
		boolean done = false;

		Messages msg = new Messages();


		System.out.println("Welcome " + explorer.getName + ". ");
		msg.welcome();

		while(!done) {
			msg.commandMenu();
			String option = scan.next();
			msg.space();

			if(option.equals("0") || (option.toLowerCase()).equals("quit")) {
				done = true;
			}
			else if(option.equals("1") || (option.toLowerCase()).equals("move")) {
				msg.moveMenu();
			}
			else if(option.equals("2") || (option.toLowerCase()).equals("grab treasure")) {
				msg.grabTreasureMenu();
			}
			else if(option.equals("3") || (option.toLowerCase()).equals("drop treasure")) {
				msg.dropTreasureMenu();
			}
			else {
				System.out.println("Invalid input\n");
			}
		}
	}
}