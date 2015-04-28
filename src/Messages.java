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

	public void commandMenu() {
		System.out.println("Command Menu:" + "\n"
						+ "1. Move" + "\n"
						+ "2. Grab Treasure" + "\n"
						+ "3. Drop Treasure" + "\n");
	}

	public void moveMenu() {
		System.out.println("Move Menu:" + "\n"
						+ "1."); // List of connected rooms
	}

	public void grabTreasureMenu() {
		System.out.println("Select Treasure you would like to pick up:" + "\n"
						+ "1."); // List of treasure in current room
	}

	public void dropTreasureMenu() {
		System.out.println("Select Treasure you would like to drop:" + "\n"
						+ "1."); // List of treasure in bag
	}
}