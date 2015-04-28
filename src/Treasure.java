/**
* Treasure.java
* 
* Purpose: 
* 
* @author fmeade
* @author jbrooks12
* @version April 2015
*/
public class Treasure {

	private int id;
	private String name;
	private String descr;
	private int value;
	private double weight;

	public Treasure(int _id, String _name, String _descr, int _value, double _weight) {
		id = _id;
		name = _name;
		descr = _descr;
		value = _value;
		weight = _weight;
	}

	public int getID() {
		return id;
	}

	public String getName() {
		return name;
	}

	public String toString() {
		return name + " -- " + descr + "\n" 
		+ "value: " + value + "\n" 
		+ "weight: " + weight + "\n";
	}
}