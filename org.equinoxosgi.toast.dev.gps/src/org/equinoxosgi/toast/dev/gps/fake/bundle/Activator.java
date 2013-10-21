package org.equinoxosgi.toast.dev.gps.fake.bundle;

import org.equinoxosgi.toast.dev.gps.IGps;
import org.equinoxosgi.toast.dev.gps.fake.FakeGps;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * Created with IntelliJ IDEA.
 * User: mateuszjancy
 * Date: 10/20/13
 * Time: 5:08 PM
 * To change this template use File | Settings | File Templates.
 */
public class Activator implements BundleActivator {

    private ServiceRegistration registration;

    @Override
    public void start(BundleContext context) throws Exception {
        FakeGps gps = new FakeGps();
        registration = context.registerService(IGps.class.getName(), gps, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        registration.unregister();
    }
}
