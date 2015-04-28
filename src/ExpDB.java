import java.sql.*;
/**
* ExpDB.java
* 
* Purpose: 
* 
* @author fmeade
* @author jbrooks12
* @version April 2015
*/
public class ExpDB {

	Connection connection = null;

	public ExpDB(String _username, String _password) {

		try {

			//DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());

			connection = DriverManager.getConnection("jdbc:oracle:thin:@Picard2.radford.edu:1521:itec2",
                                                     _username, _password);

		} catch (SQLException e) {
			System.err.println("ERROR: Could not connect to database. " + e);
		}
	}

	/*
	 * 
	 */ 
	public Explorer getExplorer(String _username) {
		Explorer explorer = null;

		String query = "SELECT * FROM Explorer "
							+ "WHERE username = " + _username + "'";

		try
		{
			Statement statement = connection.createStatement();
        	ResultSet resultSet = statement.executeQuery(query);

        	if (resultSet.next()) 
			{
				int id = resultSet.getInt("eid");
				String name = resultSet.getString("Name");
				explorer = new Explorer(id, name);
        	}

		} catch (SQLException e){
			System.err.println ("ERROR: Could not get explorer from database. \n" + e);
		}

		return explorer;
	}
	

	/*
	 *
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


	/*
	 *
	 */
	public int getConnRooms() {
		return 0;
	}


	/*
	 *
	 */
	public String getTreasureDesc() {
		return null;
	}


	/*
	 *
	 */
	public String getRoomDesc() {
		return null;
	}


	/*
	 *
	 */
	public String getExplorersTreasures() {
		return null;
	}


	/*
	 *
	 */
	public String getRoomTreasures() {
		return null;
	}


	/*
	 *
	 */
	public String makeTreasureList() {
		return null;
	}


	/*
	 *
	 */
	public int move() {
		return 0;
	}


	/*
	 *
	 */
	public void pickup() {
		
	}


	/*
	 *
	 */
	public void close() {
		
	}
	
}