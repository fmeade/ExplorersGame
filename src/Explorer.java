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
	
	private String name;
	private String username;

	public Explorer() {

	}
	public Explorer(String _name, String _username) {
		name = _name;
		username = _username;
	}

	public String getName() {
		return name;
	}
	public void setName(String _name) {
		name = _name;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String _username) {
		username = _username;
	}


}