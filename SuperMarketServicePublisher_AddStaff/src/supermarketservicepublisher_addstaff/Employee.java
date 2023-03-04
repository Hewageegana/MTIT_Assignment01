package supermarketservicepublisher_addstaff;

public class Employee {
	
	String empID;
	String empFirstName;
	String empLastName;
	String EmpAddress;
	String empNIC;
	String empDOB;
	double salary;
	int age;
	
	public Employee(String empID, String empFirstName, String empLastName, String empAddress, String empNIC,
			String empDOB, double salary, int age) {
		super();
		this.empID = empID;
		this.empFirstName = empFirstName;
		this.empLastName = empLastName;
		EmpAddress = empAddress;
		this.empNIC = empNIC;
		this.empDOB = empDOB;
		this.salary = salary;
		this.age = age;
	}

	public String getEmpID() {
		return empID;
	}

	public void setEmpID(String empID) {
		this.empID = empID;
	}

	public String getEmpFirstName() {
		return empFirstName;
	}

	public void setEmpFirstName(String empFirstName) {
		this.empFirstName = empFirstName;
	}

	public String getEmpLastName() {
		return empLastName;
	}

	public void setEmpLastName(String empLastName) {
		this.empLastName = empLastName;
	}

	public String getEmpAddress() {
		return EmpAddress;
	}

	public void setEmpAddress(String empAddress) {
		EmpAddress = empAddress;
	}

	public String getEmpNIC() {
		return empNIC;
	}

	public void setEmpNIC(String empNIC) {
		this.empNIC = empNIC;
	}

	public String getEmpDOB() {
		return empDOB;
	}

	public void setEmpDOB(String empDOB) {
		this.empDOB = empDOB;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
	
	
}
