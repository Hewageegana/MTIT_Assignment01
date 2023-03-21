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
		double sal = 0;
		int empage = 0;
		boolean ageValid = true;
		boolean salValid = true;
		
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
					System.out.print("Enter employee DOB: ");
					DOB = in.readLine();
					while(ageValid) {
						try {
							System.out.print("Enter employee age: ");
							empage = Integer.valueOf(in.readLine());
							ageValid = false;
						}
						catch(NumberFormatException e) {
							ageValid = true;
							System.out.println("Invalid Age...");
						}	
					}
					
					while(salValid) {
						try {
							System.out.println("Enter employee basic salary: ");
							sal = Double.valueOf(in.readLine());
							salValid = false;
						}
						catch(NumberFormatException e) {
							salValid = true;
							System.out.println("Invalid Salary Value...");
						}	
					}

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
						System.out.println(" Employee Successfully Registered to the system!");
						System.out.println("-----------------------------------------------");
						System.out.println();
						System.out.println("\t\t\t\t---------------- Employee List ------------------- ");
						System.out.println();
						System.out.println("------------------- ------------------- ------------------- ------------------- ------------------- ------------------- ");
						System.out.println("Employee ID \t  First Name \t  Last Name \t Address \t NIC \t\t DOB \t\t Age  \t\t Salary ");
						System.out.println("------------------- ------------------- ------------------- ------------------- ------------------- ------------------- ");
						System.out.println();
						
						for (Employee emp : eployeeList) {
							
							
							System.out.println(emp.getEmpID() + "\t\t  " +  emp.getEmpFirstName() + "\t  " + emp.getEmpLastName()  + "\t " +emp.getEmpAddress()+ "\t " +emp.getEmpNIC()+ "\t " + emp.getEmpDOB()+ "\t " + String.valueOf(emp.getAge())+ "\t\t" + String.valueOf(emp.getSalary()));
							System.out.println();
							
//							System.out.println("  Employee ID : " + emp.getEmpID());
//							System.out.println("  Employee First Name : " + emp.getEmpFirstName());
//							System.out.println("  Employee Last Name : " + emp.getEmpLastName());
//							System.out.println("  Address :  " + emp.getEmpAddress());
//							System.out.println("  NIC :      " + emp.getEmpNIC());
//							System.out.println("  DOB :      " + emp.getEmpDOB());
//							System.out.println("  Salary :    " + String.valueOf(emp.getSalary()));
//							System.out.println("  Age :      " + String.valueOf(emp.getAge()));
							
							
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
