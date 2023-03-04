package supermarketservicepublisher_addstaff;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class AddEmployeeIMPL implements AddEmployeeService{

	public void addEmployee() {
		String answer;
		String ID;
		String FirstName;
		String LastName;
		String Address;
		String NIC;
		String DOB;
		double sal;
		int empage;
		
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		
		ArrayList<Employee> eployeeList = new ArrayList<>();
		
		System.out.println();
		System.out.println("Welcome To Supermarket - Admin");
		System.out.println("!Enter Blank To Exit!");
		System.out.println("---------------------------------------------------");
		System.out.println();
		
		try {
			while(true) {
				System.out.print("Enter A to Add employee R to Remove employee: ");
				answer = in.readLine();
				System.out.println();
				if (answer.equalsIgnoreCase("A")) {
					System.out.println();
					System.out.println("---- Employee Details ---- ");
					System.out.println();
					System.out.print("Enter employee ID: ");
					ID = in.readLine();
					System.out.print("Enter first name: ");
					FirstName = in.readLine();
					System.out.print("Enter last name: ");
					LastName = in.readLine();	
					System.out.print("Enter employee address: ");
					Address = in.readLine();
					System.out.print("Enter Employee NIC: ");
					NIC = in.readLine();
					System.out.println("Enter employee DOB: ");
					DOB = in.readLine();
					System.out.println("Enter employee basic salary: ");
					sal = Double.valueOf(in.readLine());
					System.out.println("Enter employee age: ");
					empage = Integer.valueOf(in.readLine());
					System.out.println();
					
					if (FirstName.isEmpty() || LastName.isEmpty() || ID.isEmpty() || String.valueOf(sal).isEmpty() || String.valueOf(empage).isEmpty() || empage <= 20 || NIC.isEmpty() || Address.isEmpty() ) {
						System.out.println();
						System.out.println("-----------------------------------------------");
						System.out.println("                Have A Good Day!               ");
						System.out.println("-----------------------------------------------");
						System.out.println();
						break;
					} else {
						eployeeList.add(new Employee(ID, FirstName, LastName, Address, NIC, DOB, sal, empage));

					}
					

					if (eployeeList.size() > 0) {
						System.out.println();
						System.out.println("---------------- Employee List ------------------- ");
						System.out.println();
						for (Employee emp : eployeeList) {
							System.out.println("  Employee ID : " + emp.empID);
							System.out.println("  Employee First Name : " + emp.getEmpFirstName());
							System.out.println("  Employee Last Name : " + emp.getEmpLastName());
							System.out.println("  Address :  " + emp.getEmpAddress());
							System.out.println("  NIC :      " + emp.getEmpNIC());
							System.out.println("  DOB :      " + emp.getEmpDOB());
							System.out.println("  Salary :    " + String.valueOf(emp.getSalary()));
							System.out.println("  Age :      " + String.valueOf(emp.getAge()));
							
							
							
							System.out.println("  Successfully Added!");
							System.out.println("-----------------------------------------------");
							System.out.println();
						}
					} else {
						System.out.println();
						System.out.println("No Employees in the List");
						System.out.println();
						break;
					}
					
				} else if (answer.equalsIgnoreCase("R")) {
					System.out.println("Enter Employee ID to remove: ");
					String empidSet = " ";
					empidSet = in.readLine();
					System.out.println();
					if (empidSet.length() > 0) {
						for (int i = 0; i < eployeeList.size(); i++) {
							if (empidSet.equals(eployeeList.get(i).getEmpID())) {
								eployeeList.remove(i);
								System.out.println();
								System.out.println("-----------------------------------------------");
								System.out.println("              Succusfully Removed              ");
								System.out.println("-----------------------------------------------");
								System.out.println();
							} else {
								System.out.println();
								System.out.println("Employee Not Found");
								System.out.println();
							}

						}

					} else {
						System.out.println();
						System.out.println("-----------------------------------------------");
						System.out.println("                Have A Good Day!               ");
						System.out.println("-----------------------------------------------");
						break;
					}
				} else {
					System.out.println();
					System.out.println("-----------------------------------------------");
					System.out.println("                Have A Good Day!               ");
					System.out.println("-----------------------------------------------");
					break;
				}
			}
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
