package ie.atu.serialize;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import ie.atu.hotel.Employee;

public class EmployeeSerializer implements Serializable {
	private ArrayList<Employee> employees;
	
	private final String FILENAME = "employees.bin";	
	private File employeesFile;	
	
	// Default Constructor
	public EmployeeSerializer(){
		// Construct EmployeeList ArrayList
		employees = new ArrayList<Employee>();

		//Construct employeesFile and physically create the File
		employeesFile = new File(FILENAME);
		try {
			employeesFile.createNewFile();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	}	

	/////////////////////////////////////////////////////////////
	// Method Name : add()								              //
	// Return Type : void								              //
	// Parameters : None								                 //
	// Purpose : Reads one Employee record from the user       //
	//           and adds it to the ArrayList called employees //
	/////////////////////////////////////////////////////////////
	public void add(){ 
	    // Create an Employee object
		 Employee employee = new Employee();
 
       // TODO - Update add() so it checks if Cancel was clicked when reading Employee
       
		 // Read its details
		 if(employee.read() == true) {
			 // And add it to the employees ArrayList
			 employees.add(employee);	
		 }else{
			 //adding this because employeeNumber static was still incrementing after being cancelled
			 Employee.decrementEmployeeNumber();
		 }
	}

	///////////////////////////////////////////////////////
	// Method Name : list()						              //
	// Return Type : void					   	           //
	// Parameters : None						                 //
	// Purpose : Lists all Employee records in employees //
	///////////////////////////////////////////////////////		
	public void list(){
		String employeesToList="";

		if(!employees.isEmpty()) {
			// for every Employee object in employees
			for(Employee tmpEmployee : employees) {
				// add it to employeesToList and
				employeesToList+=tmpEmployee;
				// add a newline
				employeesToList+="\n";
			}
			
			// Display employeesToList in a messageDialog
		   JOptionPane.showMessageDialog(null, employeesToList, "EMPLOYEE LIST", JOptionPane.INFORMATION_MESSAGE);	
		}
		else
			// Display "No Employees stored..." in messageDialog
		   JOptionPane.showMessageDialog(null, "No Employees to list.", "EMPLOYEE LIST", JOptionPane.INFORMATION_MESSAGE);	
	}	

	////////////////////////////////////////////////////////////////
	// Method Name : view()									              //
	// Return Type : Employee								              //
	// Parameters : None								                    //
	// Purpose : Displays the required Employee record on screen  //
	//         : And returns it, or null if not found             //   
	////////////////////////////////////////////////////////////////	
	public Employee view(){
		String numberString = JOptionPane.showInputDialog("Enter Employee Number To Find:");
		if(numberString == null)//checking if the dialog was cancelled
			return null;
		int identifier;
		try {
			identifier = Integer.parseInt(numberString);
		} catch (NumberFormatException e) {
			System.out.println("Invalid Employee Number Entered.");
			return null;
		}
		for(Employee e:employees) {
			if(e.getNumber() == identifier) {
				System.out.print(e);
				JOptionPane.showMessageDialog(null, e);
				return e;
			}
		}
		System.out.print(identifier + " Not found");
		return null;
	    //JOptionPane.showMessageDialog(null, "view() method must be coded!", "NOT IMPLEMENTED", JOptionPane.INFORMATION_MESSAGE);					
	}
	
	///////////////////////////////////////////////////////////////////
	// Method Name : delete()							        	           //
	// Return Type : void								        	           //
	// Parameters : None									                    //
	// Purpose : Deletes the required Employee record from employees //
	///////////////////////////////////////////////////////////////////	
	public void delete(){
		Employee empToBeDeleted = this.view();
		if(empToBeDeleted != null) {
			employees.remove(empToBeDeleted);
		}
	}

	///////////////////////////////////////////////////////////////
	// Method Name : edit()			  					                //
	// Return Type : void								    	          //
	// Parameters : None								     	             //
	// Purpose : Edits the required Employee record in employees //
	///////////////////////////////////////////////////////////////	
	public void edit(){
		 Employee empToBeEdited = this.view();
		 if(empToBeEdited != null) {
			 empToBeEdited.read();
		 }
	}
	
	// This method will serialize the employees ArrayList when called, 
	// i.e. it will write employees to a file called employees.bin
	public void serializeEmployees(){
		try {
			FileOutputStream fos = new FileOutputStream(employeesFile);
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			oos.writeObject(employees);
			oos.close();
		}catch(Exception e) {
			System.out.print("Something went wrong");
		}
		 //JOptionPane.showMessageDialog(null, "You must write the code for the serializeEmployees() method.", "NOT IMPLEMENTED", JOptionPane.INFORMATION_MESSAGE);		
	}

	// This method will deserialize the Employees ArrayList when called, 
	// i.e. it will restore the employees ArrayList from the file employees.bin
	public void deserializeEmployees(){
		 ObjectInputStream is=null;
		
		 try {
			 // Deserialize the ArrayList...
			 FileInputStream fileStream = new FileInputStream(employeesFile);
				
			 is = new ObjectInputStream(fileStream);
						
			 employees = (ArrayList<Employee>)is.readObject();
			 Employee.setEmployeeNumber(employees.get(employees.size()-1).getNumber()+1);
          
          is.close();
		}
		catch(FileNotFoundException fNFE){
			 System.out.println("Cannot open file " + employeesFile.getName() + ".");
		}
		catch(IOException ioE){
			 System.out.println("Cannot read from " + employeesFile.getName() + ".");
		}
		catch(Exception e){
			 System.out.println("Cannot read from " + employeesFile.getName() + ".");
		}
	}
}
