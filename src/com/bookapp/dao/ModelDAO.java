
/*Author @mallika
version 0.1
*/

package com.bookapp.dao;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;

public class ModelDAO {

	static Properties properties = new Properties();
	static Connection connection;

	public static Connection openConnection() throws SQLException {
		try {
			properties.load(new FileReader("jdbc.properties"));
		} catch (FileNotFoundException e1) {
			e1.printStackTrace();
		} catch (IOException e1) {
			e1.printStackTrace();

		}

		String url = (String) properties.get("driver");
		String userName = (String) properties.get("userName");
		String password = (String) properties.get("password");
		connection = null;

		try {
			Class.forName("com.mysql.cj.jdbc.Driver").newInstance();
			connection = DriverManager.getConnection(url, userName, password);
		} catch (InstantiationException | IllegalAccessException | ClassNotFoundException e) {
			e.printStackTrace();
		}
		return connection;
	}

	public static void closeConnection() {
		try {
			if (connection != null) {
				connection.close();
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}
