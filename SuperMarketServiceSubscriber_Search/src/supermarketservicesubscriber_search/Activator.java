package supermarketservicesubscriber_search;

import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;
import java.util.Scanner;

import supermarketservicepublisher_search.SupermarketServiceSearch;

public class Activator implements BundleActivator {

	ServiceReference<?> serviceReference;
	private static BundleContext context;
	Scanner input = new Scanner(System.in);
	


	static BundleContext getContext() {
		return context;
	}

	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		serviceReference = context.getServiceReference(SupermarketServiceSearch.class.getName());
		SupermarketServiceSearch searchitems = (SupermarketServiceSearch) context.getService(serviceReference);
		
		System.out.println("Start Supermarket Service Consumer");
		System.out.println();

		System.out.println("================================================");
		System.out.println("                                                ");
		System.out.println("           * Wellcome to Online Super market *  ");
		System.out.println("                                                ");
		System.out.println("================================================");
		
		searchitems.SearchItems();
	}

	public void stop(BundleContext bundleContext) throws Exception {
//		Activator.context = null;
		System.out.println("Stop Super market Service Consumer");
		context.ungetService(serviceReference);
	}

}
