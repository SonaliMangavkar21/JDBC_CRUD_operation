package jdbc_maven_wejm5;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Properties;



public class PersonCRUD {
	
	public Connection getConnection() throws IOException, ClassNotFoundException, SQLException {
	FileInputStream fileInputStream=new FileInputStream("configure.properties");
	Properties properties=new Properties();
	properties.load(fileInputStream);
	
	Class.forName(properties.getProperty("className"));
	Connection connection=DriverManager.getConnection(properties.getProperty("url"),properties.getProperty("user"),properties.getProperty("password"));
	return connection;
	
	}

public void savePerson(Person person) throws SQLException, ClassNotFoundException, IOException {
	Connection connection=getConnection();
	PreparedStatement preparedStatement=connection.prepareStatement("INSERT INTO PERSON VALUES(?,?,?)");
	preparedStatement.setInt(1, person.getId());
	preparedStatement.setString(2, person.getName());
	preparedStatement.setLong(3, person.getPhone());
	int count=preparedStatement.executeUpdate();
	if(count==1) {
		System.out.println("inserted");
		
	}else {
		System.out.println("not inserted");
	}
	connection.close();

	}



public void updatePerson(Person person) throws ClassNotFoundException, IOException, SQLException {
	 Connection connection=getConnection();
	 PreparedStatement preparedStatement=connection.prepareStatement("UPDATE PERSON SET NAME=?,PHONE=? WHERE ID=?");
	 preparedStatement.setString(1, person.getName());
	 preparedStatement.setLong(2, person.getPhone());
	 preparedStatement.setInt(3, person.getId());
	 int count=preparedStatement.executeUpdate();
	 if (count==1) {
		 System.out.println("updated");
	 }else {
		 System.out.println("not updated");
	 }
	 connection.close();
	 
}

public void deletePerson(int id) throws ClassNotFoundException, IOException, SQLException {
	 Connection connection=getConnection();
	 PreparedStatement preparedStatement=connection.prepareStatement("DELETE FROM PERSON WHERE ID=?");
	 preparedStatement.setInt(1,id);
	 int count=preparedStatement.executeUpdate();
	 if (count==1) {
		 System.out.println("deleted");
	 }else {
		 System.out.println("not deleted");
	 }
	 connection.close();

}

public void getPersonById(int id) throws ClassNotFoundException, IOException, SQLException  {
	 Connection connection=getConnection();
	 PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM PERSON WHERE ID=?");
	 preparedStatement.setInt(1,id);
	ResultSet resultset=preparedStatement.executeQuery();
	while(resultset.next()) {
		System.out.println(resultset.getInt(1));
		System.out.println(resultset.getString("name"));
		System.out.println(resultset.getLong(3));
		
	}
	 connection.close();
}


public void getAllPersons() throws ClassNotFoundException, IOException, SQLException   {
	 Connection connection=getConnection();
	 PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM PERSON ");
	ResultSet resultset=preparedStatement.executeQuery();
	while(resultset.next()) {
		System.out.println(resultset.getInt(1));
		System.out.println(resultset.getString("name"));
		System.out.println(resultset.getLong(3));
		
	}
	 connection.close();
}
}