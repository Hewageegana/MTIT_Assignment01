package supermarketservicesubscriber_purchaseitem;

import java.util.Scanner;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

import supermarketservicepublisher_purchaseitem.PurchaseItemService;

public class Activator implements BundleActivator {

	ServiceReference<?> serviceReference;
	private static BundleContext context;
	Scanner input = new Scanner(System.in);
	
	// Hardcode Usernames and Passwords
	String memberName = "member";
	String memberPW = "1111";
	String adminName = "admin";
	String adminPW = "0000";
	
	boolean isInValidUser = true;
	boolean isInvalidhoice = true;

	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		serviceReference = bundleContext.getServiceReference(PurchaseItemService.class.getName());
		PurchaseItemService purchaseItems = (PurchaseItemService) bundleContext.getService(serviceReference);
		
		System.out.println("Start Supermarket Service Subscriber - Purchase Item");
		System.out.println();

		System.out.println("================================================");
		System.out.println("                                                ");
		System.out.println("       * Wellcome To Online Supermarket *       ");
		System.out.println("                                                ");
		System.out.println("================================================");
		

		while(isInValidUser) {
			System.out.print("Enter Username: ");
			String username = input.next();
			System.out.print("Enter Password: ");
			String password = input.next();
			
			if (username.equals(memberName) && password.equals(memberPW)) {
				isInValidUser = false;
			}else {

				System.out.println("Incorrect Username Or Password!");
			}	
		}

		System.out.println("============================================");
		System.out.println("	          Member Services	       ");
		System.out.println("	          Purchase Items           ");
		System.out.println("============================================");
		
		purchaseItems.purchaseItem();
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		System.out.println("Stop Supermarket Service Consumer - Purchase Item");
		bundleContext.ungetService(serviceReference);
	}

}
