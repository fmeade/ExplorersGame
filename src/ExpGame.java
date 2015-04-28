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


		System.out.println("Welcome " + explorer.getName() + ". ");
		System.out.println("Here you are tasked with collecting treasure and " + "\n"
						 + "making it to the final room. The explorer with the " + "\n"
						 + "highest value of treasures wins the game. The game " + "\n"
						 + "ends when all explorers make it to the final room.");



		while(!done) {

			/*
			 * Prints Main Menu
			 */
			System.out.println("Command Menu:" + "\n"
						+ "0. Quit" + "\n"
						+ "1. Move" + "\n"
						+ "2. Grab Treasure" + "\n"
						+ "3. Drop Treasure" + "\n");
			System.out.print("Please select a command: ");


			/* 
			 * Gets users option
			 */
			String option = scan.next();
			System.out.println("\n");



			/*
			 * Processes users choice
			 */
			if(option.equals("0") || (option.toLowerCase()).equals("quit")) {
				System.out.print("Are you sure? (y/n) ");
					option = scan.next();

					if(option.charAt(0) == 'y') {
						done = true;
					}
			}
			/*
			 * If selected Move
			 */
			else if(option.equals("1") || (option.toLowerCase()).equals("move")) {
				System.out.println("Move Menu:" + "\n");

				/* Prints list of connected rooms */
				System.out.println(expdb.getConnRooms(expdb.getCurrRoom(explorer.getID())));

				System.out.print("Please select a room (0 to cancel): ");
					option = scan.next();

				System.out.println("\n");

				if(option.equals("0")) {
					// do nothing
				}
				else {
					/* Processes the move */
					try {
						expdb.move(option.parseInt(), explorer.getID());

					} catch (Exception e) {
						System.err.println("ERROR: not a valid room number. " + e);
					}
				}
			}
			/*
			 * Handles picking up treasure
			 */
			else if(option.equals("2") || (option.toLowerCase()).equals("grab treasure")) {

				/* Prints list of treasures in current room */
				System.out.println(expdb.getRoomTreasures(expdb.getCurrRoom(explorer.getID()));

				System.out.print("Select Treasure you would like to pick up (0 to cancel): ");
					option = scan.next();

				System.out.println("\n");



				if(option.equals("0")) {
					// do nothing
				}
				else {
					/* Processes the pickup */
					try {
						expdb.pickup(option.parseInt(), explorer.getID());
						expdb.remove(option.parseInt(), getCurrRoom(explorer.getID()));

					} catch (Exception e) {
						System.err.println("ERROR: not a valid treasure. " + e);
					}
				}
			}
			/*
			 *
			 */
			else if(option.equals("3") || (option.toLowerCase()).equals("drop treasure")) {
				/* Prints list of treasures in Explorers bag */
				System.out.println(expdb.getExpTreasures(explorer.getID());

				System.out.print("Select Treasure you would like to drop (0 to cancel): ");
					option = scan.next();

				System.out.println("\n");


				if(option.equals("0")) {
					// do nothing
				}
				else {
					/* Processes the pickup */
					try {
						expdb.drop(option.parseInt(), explorer.getID());

					} catch (Exception e) {
						System.err.println("ERROR: not a valid treasure. " + e);
					}
				}
			}
			else {
				System.out.println("Invalid input\n");
			}
		}
	}
}