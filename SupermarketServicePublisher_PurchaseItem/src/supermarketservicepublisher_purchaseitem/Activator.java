package supermarketservicepublisher_purchaseitem;

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
		System.out.println("Start Supermarket Service Publisher - Purchase Item");
		PurchaseItemService purchaseItem = new PurchaseItemServiceImp();
		publishServiceRegister = context.registerService(PurchaseItemService.class.getName(), purchaseItem, null);
	}

	public void stop(BundleContext bundleContext) throws Exception {
		Activator.context = null;
		publishServiceRegister.unregister();
		System.out.println("Start Supermarket Service Publisher - Purchase Item");
	}

}
