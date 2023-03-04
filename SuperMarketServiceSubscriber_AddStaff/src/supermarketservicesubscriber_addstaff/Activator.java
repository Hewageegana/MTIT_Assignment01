package supermarketservicesubscriber_addstaff;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import supermarketservicepublisher_addstaff.AddEmployeeService;

public class Activator implements BundleActivator {

	ServiceReference<?> serviceReference;
	private static BundleContext context;
	Scanner input = new Scanner(System.in);
	
	// Hardcode Usernames and Passwords
	String memberName = "member";
	String memberPW = "1111";
	String adminName = "admin";
	String adminPW = "0000";

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		serviceReference = context.getServiceReference(AddEmployeeService.class.getName());
		AddEmployeeService addEmp = (AddEmployeeService) context.getService(serviceReference);
		
		System.out.println("Start Supermarket Service Subscriber");
		System.out.println();

		System.out.println("================================================");
		System.out.println("                                                ");
		System.out.println("       * Wellcome To Online Supermarket *       ");
		System.out.println("                                                ");
		System.out.println("================================================");
		

		System.out.print("Enter Username: ");
		String username = input.next();
		System.out.print("Enter Password: ");
		String password = input.next();
		
		if (username.equals(adminName) && password.equals(adminPW)) {
			System.out.println("============================================");
			System.out.println("	          Admin Services	       ");
			System.out.println("	  Add or Remove Employee   - Enter 1  ");
			System.out.println("============================================");

			System.out.print("Enter Service: ");
			int choice = input.nextInt();

			if (choice == 1) {
				addEmp.addEmployee();
				
			}else {
				System.out.println("Wrong Choice! Try Again");
			}

		} else {

			System.out.println("Incorrect Username Or Password!");
		}
	}

	public void stop(BundleContext bundleContext) throws Exception {
//		Activator.context = null;
		System.out.println("Stop Supermarket Service Consumer");
		context.ungetService(serviceReference);
	}

}
