package ie.atu.hotel;

import java.util.Scanner;

public class Employee extends Person implements Payable{
	private Date dateOfBirth;
	private Date startDate;
	private double salary;
	private int number;
	private static int employeeNumber = 10000;
	
	public Employee() {
		super();
		this.dateOfBirth=new Date();
		this.startDate=new Date();
		this.salary=0;
		this.number = employeeNumber++;
	}
	
	public Employee(Name name, String phoneNumber,Date birthDate, Date startDate, double salary) {
		super(name, phoneNumber);
		this.dateOfBirth=birthDate;
		this.startDate=startDate;
		this.salary=salary;
		this.number = employeeNumber++;
	}

	public Date getDateOfBirth() {
		return dateOfBirth;
	}

	public void setDateOfBirth(Date dateOfBirth) {
		this.dateOfBirth = dateOfBirth;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}
	
	public int getNumber() {
		return number;
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Employee)) {
			return false;
		}
		Employee empToCompare = (Employee) obj;
		return super.equals(empToCompare) &&
				empToCompare.dateOfBirth.equals(this.dateOfBirth) &&
				empToCompare.startDate.equals(this.startDate) &&
				empToCompare.salary == this.salary &&
				empToCompare.number == this.number;
	}
	
	@Override
	public String toString() {
		return this.number + "\t" + this.name + "\t€" + this.salary;
	}
	
	@Override
	public void read() {
		Scanner scanner = new Scanner(System.in);
		super.read();
		System.out.println("Enter Date of Birth");
		this.dateOfBirth.read();
		System.out.println("Enter Start Date");
		this.startDate.read();
		System.out.print("Enter Salary:");
		this.salary = scanner.nextDouble();
		
		scanner.close();
		
	}

	@Override
	public double calculatePay(double taxPercentage) {
		return (salary/12)-((salary/12) * (taxPercentage/100));
	}

	@Override
	public double incrementSalary(double incrementAmount) {
		double newSalary = this.salary+incrementAmount;
		if (newSalary > 150000) {
			return this.salary;
		}
		this.salary = newSalary;
		return this.salary;
	}
	
	
	
	
}
