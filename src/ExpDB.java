import java.sql.*;
/**
* ExpDB.java
* 
* Purpose: Creates connection to database and makes query calls to database
* 
* @author fmeade
* @author jbrooks12
* @version April 2015
*/
public class ExpDB {

	Connection connection;

	/**
	 * Establishes connection to database
	 */
	public ExpDB(String _username, String _password) {

		try {

			//DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			connection = DriverManager.getConnection("jdbc:oracle:thin:@Picard2.radford.edu:1521:itec2",
                                                     _username, _password);

		} catch (SQLException e) {
			System.err.println("ERROR: Could not connect to database. " + e);
		}
	}

	// /**
	//  * Gets Explorer data from Explorers table in the database
	//  */ 
	// public Explorer getExplorer(String _username) {
	// 	Explorer explorer;

	// 	String query = "SELECT * FROM Explorer "
	// 						+ "WHERE username = " + _username + "'";

	// 	try
	// 	{
	// 		Statement statement = connection.createStatement();
 //        	ResultSet resultSet = statement.executeQuery(query);

 //        	if (resultSet.next()) 
	// 		{
	// 			int id = resultSet.getInt("eid");
	// 			String name = resultSet.getString("Name");
	// 			explorer = new Explorer(id, name);
 //        	}

	// 	} catch (SQLException e){
	// 		System.err.println ("ERROR: Could not get explorer from database. \n" + e);
	// 	}

	// 	return explorer;
	// }
	

	/**
	 * Gets the current room that the Explorer is in
	 */
	public int getCurrRoom(int _eID) {
		
		int roomNum = -1;

		String query = "SELECT Room_Num FROM Explorer" 
							+ "WHERE eid = '" + _eID + "'";

		try {

			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);
			
			if (resultSet.next()) {

				roomNum = resultSet.getInt("Room_Num");
			}

		} catch(SQLException e) {
			System.err.println ("Error: could not find User current room in the database. \n" + e);
		}

		return roomNum; 
	}


	/**
	 * Gets rooms connected to the current room
	 */
	public String getConnRooms(int _currRoom) {
		String connRooms = "No Connected Rooms";

		String query = "SELECT connrid FROM Connected_Rooms WHERE rid = " + _currRoom + " ";

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			connRooms = makeRoomList(resultSet);


		} catch (SQLException e) {
			System.err.println("ERROR: Cannot obtain connected Room list " + e);
		}
		
		return connRooms;
	}


	/**
	 * Makes a string of the connected rooms
	 */
	public String makeRoomList(ResultSet _resultSet) {
		String roomList = "\n";

		int rid = 0;
		String name = "";
		String descr = "";
		Room room = null;

		try {

			while(_resultSet.next()) {

				rid = _resultSet.getInt("rid");
				name = _resultSet.getString("Name");
				descr = _resultSet.getString("Descr");

				room = new Room(rid, name, descr);

				roomList = roomList + room.toString() + "\n";
			}

		} catch (SQLException e) {
			System.err.println("ERROR: Could not load Connected Rooms " + e);
		}

		return roomList;
	}


	/**
	 * Updates Explorers current room
	 */
	public void move(int _nextRoom, int _eid) {

		String query = "UPDATE Explorer SET Room_Num = " + _nextRoom + " WHERE eid = " + _eid + " ";

		try{

			Statement statement = connection.createStatement();
			statement.executeUpdate(query);

		} catch(SQLException e) {
			System.err.println ("ERROR: cannot move the explorer. \n" + e);
		}
	}


	/**
	 *
	 */
	public String getExpTreasures(int _eid) {
		String treasure = "No Treasure in Bag";

		String query = "SELECT tid FROM Explorer_Treasure WHERE eid = " + _eid + " ";

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			treasure = makeTreasureList(resultSet);


		} catch (SQLException e) {
			System.err.println("ERROR: Cannot obtain connected Room list. " + e);
		}
		
		return treasure;
	}


	/**
	 *
	 */
	public String getRoomTreasures(int _currRoom) {
		String treasure = "No Treasure in Room";

		String query = "SELECT tid FROM Room_Treasure WHERE rid = " + _currRoom + " ";

		try {
			Statement statement = connection.createStatement();
			ResultSet resultSet = statement.executeQuery(query);

			treasure = makeTreasureList(resultSet);


		} catch (SQLException e) {
			System.err.println("ERROR: Cannot obtain connected Room list. " + e);
		}
		
		return treasure;
	}


	/**
	 *
	 */
	public String makeTreasureList(ResultSet _resultSet) {
		String treasureList = "\n";

		int tid = 0;
	 	String name = "";
 		String descr = "";
	 	int value = 0;
	 	double weight = 0.0;

		Treasure treasure = null;
		

		try {

			while(_resultSet.next()) {

				tid = _resultSet.getInt("tid");
				name = _resultSet.getString("Name");
				descr = _resultSet.getString("Descr");
				value = _resultSet.getInt("Value");
				weight = _resultSet.getDouble("Weight");
				

				treasure = new Treasure(tid, name, descr, value, weight);

				treasureList = treasureList + treasure.toString() + "\n";
			}

		} catch (SQLException e) {
			System.err.println("ERROR: Could not load Treasures. " + e);
		}

		return treasureList;
	}


	/**
	 *
	 */
	public void pickup(int _eid, int _tid) {

		String query = "INSERT INTO Explorer_Treasure (eid, tid) VALUES (" + _eid + ", " + _tid +") ";

		try{

			Statement statement = connection.createStatement();
			statement.executeInsert(query);

		} catch(SQLException e) {
			System.err.println ("ERROR: cannot pick up the treasure. \n" + e);
		}
	}


	/**
	 *
	 */
	public void remove(int _tid, int _rid) {
		String query = "DELETE FROM Room_Treasure (rid, tid) VALUES (" + _rid + ", " + _tid + ") ";

		try{

			Statement statement = connection.createStatement();
			statement.executeDelete(query);

		} catch(SQLException e) {
			System.err.println ("ERROR: cannot remove the treasure from the room. \n" + e);
		}
	}


	/**
	 *
	 */
	public void drop(int _tid, int _eid) {
		String query = "DELETE FROM Explorer_Treasure (eid, tid) VALUES (" + _eid + ", " + _tid + ") ";

		try{

			Statement statement = connection.createStatement();
			statement.executeDelete(query);

		} catch(SQLException e) {
			System.err.println ("ERROR: cannot drop the treasure. \n" + e);
		}
	}


	/**
	 *
	 */
	public void close() {
		try
		{
			connection.close(); 
		} catch (SQLException e) {
			System.out.println ("ERROR: Could not close db connection. \n" + e);
		}
	}
	
}