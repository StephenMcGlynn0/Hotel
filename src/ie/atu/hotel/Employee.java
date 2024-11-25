package ie.atu.hotel;

import java.io.Serializable;

import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.JTextField;

public class Employee extends Person implements Payable, Serializable {
    //private Date dateOfBirth;
    //private Date startDate;
    private double salary;
    private int number;
    private static int employeeNumber = 10000;

    public Employee() {
        super();
        //this.dateOfBirth=new Date();
        //this.startDate=new Date();
        this.salary = 0;
        this.number = employeeNumber++;
    }

    public Employee(Name name, String phoneNumber, double salary) {
        super(name, phoneNumber);
        //this.dateOfBirth=birthDate;
        //this.startDate=startDate;
        this.salary = salary;
        this.number = employeeNumber++;
    }
    
    //made this static method to set the employeeNumber after reading in the arraylist
    public static void setEmployeeNumber(int num){
    	Employee.employeeNumber = num;
    }

    //made this static method to decrement the employeeNumber when someone presses cancel when adding employees
    public static void decrementEmployeeNumber(){
        Employee.employeeNumber--;
    }

    public static boolean checkEmployeeDetails(String[] stringChecks, String salary){
        //Created this method to make sure the fields arent left blank when editing or adding new employees
        for (String s: stringChecks) {
            if(s.trim().isEmpty()) {
                JOptionPane.showMessageDialog(null, "Invalid details, employee not added/edited", "ERROR", JOptionPane.ERROR_MESSAGE);
                return false;
            }
        }
        try{
            Double.parseDouble(salary);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Invalid details, employee not added/edited", "ERROR", JOptionPane.ERROR_MESSAGE);
            return false;
        }
        return true;

    }

    //	public Date getDateOfBirth() {
    //		return dateOfBirth;
    //	}
    //
    //	public void setDateOfBirth(Date dateOfBirth) {
    //		this.dateOfBirth = dateOfBirth;
    //	}
    //
    //	public Date getStartDate() {
    //		return startDate;
    //	}
    //
    //	public void setStartDate(Date startDate) {
    //		this.startDate = startDate;
    //	}

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
        if (!(obj instanceof Employee)) {
            return false;
        }
        Employee empToCompare = (Employee) obj;
        return super.equals(empToCompare) &&
            //empToCompare.dateOfBirth.equals(this.dateOfBirth) &&
            //empToCompare.startDate.equals(this.startDate) &&
            empToCompare.salary == this.salary &&
            empToCompare.number == this.number;
    }

    @Override
    public String toString() {
        return this.number + "\t" + this.name + "\t€" + this.salary;
    }

    //	@Override
    //	public void read() {
    //		Scanner scanner = new Scanner(System.in);
    //		super.read();
    //		System.out.println("Enter Date of Birth");
    //		this.dateOfBirth.read();
    //		System.out.println("Enter Start Date");
    //		this.startDate.read();
    //		System.out.print("Enter Salary:");
    //		this.salary = scanner.nextDouble();
    //		
    //		scanner.close();
    //	}

    // read() method using JOptionPane
    public boolean read() {
        //added default values to read so when we edit it starts with the current values
        JTextField txtFirstName = new JTextField(this.getName().getFirstName());
        JTextField txtSurname = new JTextField(this.getName().getSurname());
        JTextField txtPhoneNumber = new JTextField(this.getPhoneNumber());
        JTextField employeeNum = new JTextField(number + "");
        employeeNum.setEditable(false);
        JComboBox title = new JComboBox(new String[] {"Mr","Mrs","Miss"});
        JTextField salary = new JTextField(this.getSalary() + "");

        Object[] message = {
            "Employee Number:",
            employeeNum,
            "Title:",
            title,
            "First Name:",
            txtFirstName,
            "Surname",
            txtSurname,
            "Phone Number:",
            txtPhoneNumber,
            "Salary:",
            salary,
        };
        JDialog dialog = new JDialog();
        dialog.setAlwaysOnTop(true);
        int option = JOptionPane.showConfirmDialog(dialog, message,
            "ENTER EMPLOYEE DETAILS", JOptionPane.OK_CANCEL_OPTION);
        if (option == JOptionPane.OK_OPTION && checkEmployeeDetails(new String[]{txtFirstName.getText(), txtSurname.getText(), txtPhoneNumber.getText()}, salary.getText())) {
            this.name.setFirstName(txtFirstName.getText());
            this.name.setSurname(txtSurname.getText());
            this.name.setTitle(title.getSelectedItem().toString());
            this.phoneNumber = txtPhoneNumber.getText();
            this.salary = Double.parseDouble(salary.getText());
            return true;
        } else // CANCEL_OPTION
            return false;
    }

    @Override
    public double calculatePay(double taxPercentage) {
        return (salary / 12) - ((salary / 12) * (taxPercentage / 100));
    }

    @Override
    public double incrementSalary(double incrementAmount) {
        double newSalary = this.salary + incrementAmount;
        if (newSalary > 150000) {
            return this.salary;
        }
        this.salary = newSalary;
        return this.salary;
    }

}