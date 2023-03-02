package supermarketserviceproducer_search;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

public class Activator implements BundleActivator {

	ServiceRegistration<?> publishServiceRegister;
	private static BundleContext context;

	static BundleContext getContext() {
		return context;
	}
	
	public void start(BundleContext bundleContext) throws Exception {
		Activator.context = bundleContext;
		System.out.println("Start Library Service Producer - Search");
		SupermarketServiceSearch search = new SupermarketServiceSearchIMPL();
		publishServiceRegister = context.registerService(SupermarketServiceSearch.class.getName(), search, null);
		
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		publishServiceRegister.unregister();
		System.out.println("Stop Library Service Producer - Search");
	}
}
