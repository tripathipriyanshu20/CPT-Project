package Dependies_Zeline;
import java.sql.Connection;
import java.sql.DriverManager;
public class MySQL_Connector {
	public static Connection getConnection() {
		Connection con=null;
		try {
			//FOR LOCAL HOST*******
			con=DriverManager.getConnection("jdbc:mysql://localhost/evdatabase","root","");
			//FOR AWS RDS*********
			//con=DriverManager.getConnection("jdbc:mysql://mydb.ccuwrlp0dr76.ap-south-1.rds.amazonaws.com:3306/DATABASE_NAME?autoReconnect=true&useSSL=false","USERNAME","PASSWORD");
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return con;
	}
	public static void main(String args[]) {
		Connection con=getConnection();
		if(con==null) {
			System.out.println("Not Connected!");
		}
		else
			System.out.println("***Connected!***");	
	}
}

//@Author: Zeline Project Services

