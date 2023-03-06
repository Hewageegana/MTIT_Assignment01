package supermarketservicepulisher_additems;

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
		System.out.println("Start Supermarket Service Publisher - Add Item");
		AddItemService addItem = new AddItemServiceImp();
		publishServiceRegister = context.registerService(AddItemService.class.getName(), addItem, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		publishServiceRegister.unregister();
		System.out.println("Stop Supermarket Service Publisher - Add Item");
	}

}
