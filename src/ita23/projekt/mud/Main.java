package ita23.projekt.mud;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;

public class Main {
	
	public static void main(String[] args) throws Exception{
		Class.forName("org.sqlite.JDBC");
		Connection con = DriverManager.getConnection("jdbc:sqlite:test.db");
		Statement stm = con.createStatement();
//		stm.executeUpdate("Create Table Bottler(" +
//				"name TEXT, " +
//				"age INTEGER " +
//				")");
		PreparedStatement pre = con.prepareStatement("insert into Bottler values (?,?);");
		pre.setString(1, "Rafa");
		pre.setInt(2, 18);
		
		
		con.setAutoCommit(false);
		pre.execute();
		con.setAutoCommit(true);
		
		ResultSet res = stm.executeQuery("SELECT * FROM Bottler");
		while (res.next()){
			System.out.println("Name: "+res.getString(1));
			System.out.println("Alter: "+res.getInt(2));
			System.out.println("----");
		}
		
		res.close();
		con.close();
	}

}
