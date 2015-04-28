/**
* Room.java
* 
* Purpose: 
* 
* @author fmeade
* @author jbrooks12
* @version April 2015
*/
public class Room {
	
	private int rid;
	private String name;
	private String descr;

	public Room() {

	}
	public Room(int _rid, String _name, String _descr) {
		rid = _rid;
		name = _name;
		descr = _descr;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return rid + ". " + name + "-- " + descr;
	}

}