/**
* Explorer.java
* 
* Purpose: 
* 
* @author fmeade
* @author jbrooks12
* @version April 2015
*/
public class Explorer {
	
	private int id;
	private String name;

	public Explorer() {

	}

	public Explorer(int _id, String _name) {
		id = _id;
		name = _name;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}
	public void setName(String _name) {
		name = _name;
	}

	public String toString() {
		return "Explorer: " + name + "\n";
	}


}