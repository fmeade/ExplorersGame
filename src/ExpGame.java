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


		System.out.println("Welcome " + explorer.getName + ". ");
		System.out.println("Here you are tasked with collecting treasure and " + "\n"
						 + "making it to the final room. The explorer with the " + "\n"
						 + "highest value of treasures wins the game. The game " + "\n"
						 + "ends when all explorers make it to the final room.");


		while(!done) {

			System.out.println("Command Menu:" + "\n"
						+ "0. Quit" + "\n"
						+ "1. Move" + "\n"
						+ "2. Grab Treasure" + "\n"
						+ "3. Drop Treasure" + "\n");
			System.out.print("Please select a command: ");


			String option = scan.next();
			System.out.println("\n");
			

			if(option.equals("0") || (option.toLowerCase()).equals("quit")) {
				done = true;
			}
			else if(option.equals("1") || (option.toLowerCase()).equals("move")) {
				System.out.println("Move Menu:" + "\n");

				// list of connected rooms

				System.out.print("Please select a room (0 to cancel): ");

				option = scan.next();
				System.out.println("\n");

				if(option.equals("0")) {

				}
				else {
					// process selected room
				}
			}
			else if(option.equals("2") || (option.toLowerCase()).equals("grab treasure")) {
				//list of treasures in room

				System.out.println("Select Treasure you would like to pick up (0 to cancel):");
			}
			else if(option.equals("3") || (option.toLowerCase()).equals("drop treasure")) {
				// list of treasures in bag

				System.out.println("Select Treasure you would like to drop (0 to cancel):");
			}
			else {
				System.out.println("Invalid input\n");
			}
		}
	}
}