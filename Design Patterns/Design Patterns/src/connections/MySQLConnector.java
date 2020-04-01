package connections;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/*
 * Class MySQLConnector  is to establish a connection
 * between the client program querying and retrieving information
 * from database.
 * @author Kim Jang Wong
 * Date: 19 March 2020
 */

public class MySQLConnector {

	/** Defines the MySQL driver connection with it properties. */

	// host: 52.50.23.197
	// port: 3306
	// user: cctstudent
	// password: Pass1234!
	// database: world
	//private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";

	private static final String URL = "jdbc:mysql://52.50.23.197:3306/world?user=cctstudent&password=Pass1234!";

	/**
	 * Get the database connection
	 * @return the connection object
	 * @throws the SQLException
	 */
	public static Connection getConnection() {
		Connection connection = null;
		try {
			// @param the URL of the MySQL database
			//Class.forName(JDBC_DRIVER);
			connection = DriverManager.getConnection(URL);
		}
		catch(SQLException se) {
			throw new RuntimeException(se);
		}
		return connection;
	}

	/** --- Don't close the connection yet it won't work if rerun the connection ---
	public void close() {
		try {
			if(conn != null) {
				conn.close();
			}
			if(pstmt != null) {
				pstmt.close();
			}
			} catch(SQLException se) {
				se.printStackTrace();
			}
	}
	 */

}
