package jdbc_maven_wejm5;


import java.io.IOException;
import java.sql.SQLException;
import java.util.Scanner;

public class PersonMain {
	public static void main(String[] args) throws ClassNotFoundException, IOException, SQLException {
		Scanner scanner=new Scanner(System.in);
		
		PersonCRUD crud=new PersonCRUD();
		Person person=new Person();
		
		boolean condition=true;
		
		do {
		
		System.out.println("enter the choice \n1.save person \n2.update person \n3.delete person \n4.get person by id \n5.get all persons \n6.exit ");
		int choice=scanner.nextInt();
		switch (choice) {
		case 1:{
			System.out.println("enter the id");
			int id=scanner.nextInt();
			System.out.println("enter the name");
			String name=scanner.next();
			System.out.println("enter the phone");
			long phone=scanner.nextLong();
			
			person.setId(id);
			person.setName(name);
			person.setPhone(phone);
			crud.savePerson(person);
		}
			break;
		case 2:{
			System.out.println("enter the id");
			int id=scanner.nextInt();
			System.out.println("enter the name");
			String name=scanner.next();
			System.out.println("enter the phone");
			long phone=scanner.nextLong();
			
			person.setId(id);
			person.setName(name);
			person.setPhone(phone);
			crud.updatePerson(person);
		}
		
			break;
		case 3:{
			System.out.println("enter the id");
			int id=scanner.nextInt();
			crud.deletePerson(id);
		}
		break;
		case 4:{
			System.out.println("enter the id");
			int id=scanner.nextInt();
			crud.getPersonById(id);
		}
		break;
		case 5:{
			
			crud.getAllPersons();
		}
		break;
		default:{
			condition=false;
		}
		}
	}
			
			while(condition); 
		
		
	}
		}
	
	
    
    

		
	

