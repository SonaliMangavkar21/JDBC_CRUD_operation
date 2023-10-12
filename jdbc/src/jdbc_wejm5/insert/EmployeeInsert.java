package jdbc_wejm5.insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class EmployeeInsert {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		
//		Load or register the driver
		Class.forName("com.mysql.cj.jdbc.Driver");
		
//		Establish Connection
		Connection connection=DriverManager.getConnection("jdbc:mysql://localhost:3306/employeedb","root","root");
		
//		create statement
		Statement statement=connection.createStatement();
		
		
//		execute statement
		statement.execute("INSERT INTO EMPLOYEE VALUES('1','RAM',2345678901,'PUNE'),('2','RAMESH',2345678991,'PUNE'),('3','RAJESH',2345678901,'PUNE'),('4','RAKESH',2345600901,'PUNE')");
		
//		close connection
		connection.close();
	}

}
