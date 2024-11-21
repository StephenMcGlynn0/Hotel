package ie.atu.testers;

import java.util.ArrayList;

import ie.atu.hotel.Date;
import ie.atu.hotel.Employee;
import ie.atu.hotel.Name;

public class EmployeeTester {

	public static void main(String[] args) {
		ArrayList<Employee> employees = new ArrayList<Employee>();
		Employee emp1 = new Employee(new Name("Ms", "Faye", "McGuire"),"087 1234567",24000.0);
		Employee emp2 = new Employee(new Name("Mr", "Ben", "Carson"),"086 1234567", 42000.0);
		Employee emp3 = new Employee(new Name("Ms", "Mark", "Logan"),"087 9876543",28000.0);
		//Employee madraMor = new Employee();
		//madraMor.read();
		
		employees.add(emp1);
		employees.add(emp2);
		employees.add(emp3);
		//employees.add(madraMor);
		
		System.out.println("LIST OF EMPLOYEES");
		for(Employee e:employees) {
			System.out.println(e);
		}
		
		for(Employee e:employees) {
			if(e.getSalary() < 30000) {
				e.incrementSalary(1000);
			}
		}
		
		System.out.println("\nLIST OF EMPLOYEES AFTER INCREMENT");
		for(Employee e:employees) {
			System.out.println(e);
		}
		
		System.out.println("\nEMPLOYEES TAKE HOME PAY");
		for(Employee e:employees) {
			int percent = 20;
			if(e.getSalary() > 35000) {
				percent=40;
			}
			System.out.println(e.getNumber() + "\t" + e.getName() + "\t" + String.format("%.2f",e.calculatePay(percent)));
		}

	}

}
