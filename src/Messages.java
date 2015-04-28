/**
* Messages.java
* 
* Purpose: 
* 
* @author fmeade
* @author jbrooks12
* @version April 2015
*/
public class Messages {
	
	public Messages() {

	}

	public void welcome() {
		System.out.println("Here you are tasked with collecting treasure and " + "\n"
						 + "making it to the final room. The explorer with the " + "\n"
						 + "highest value of treasures wins the game. The game " + "\n"
						 + "ends when all explorers make it to the final room.");
	}

	public void commandMenu() {
		System.out.println("Command Menu:" + "\n"
						+ "0. Quit" + "\n"
						+ "1. Move" + "\n"
						+ "2. Grab Treasure" + "\n"
						+ "3. Drop Treasure" + "\n");
		System.out.print("Please select a command: ");
	}

	public void moveMenu() {
		System.out.println("Move Menu:" + "\n");
	}

	public void grabTreasureMenu() {
		System.out.println("Select Treasure you would like to pick up:");
	}

	public void dropTreasureMenu() {
		System.out.println("Select Treasure you would like to drop:");
	}

	public void space() {
		System.out.println("\n");
	}
}