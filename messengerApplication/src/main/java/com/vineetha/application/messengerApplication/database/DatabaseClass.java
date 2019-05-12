package com.vineetha.application.messengerApplication.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import com.vineetha.application.messengerApplication.model.Message;
import com.vineetha.application.messengerApplication.model.Profile;

public class DatabaseClass {

	private static Map<Long, Message> messages = new HashMap<>();
	private static Map<String, Profile> profiles = new HashMap<>();

	
	
	public static Map<Long,Message> getMessages() throws SQLException{
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
		
		Connection con=DriverManager.getConnection(  
		"jdbc:oracle:thin:@localhost:1521:xe","learning","learning");  
		              
		PreparedStatement ps=con.prepareStatement("select * from messages");  
		ResultSet rs=ps.executeQuery();  
		rs.next();//now on 1st r
		}
		catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return messages;  
	}
	
	public static Map<String, Profile> getProfiles(){
		return profiles;
	}
	
}
 