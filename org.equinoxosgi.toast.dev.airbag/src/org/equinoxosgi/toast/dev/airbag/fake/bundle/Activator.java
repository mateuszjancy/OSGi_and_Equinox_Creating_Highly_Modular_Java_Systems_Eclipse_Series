package org.equinoxosgi.toast.dev.airbag.fake.bundle;

import org.equinoxosgi.toast.dev.airbag.IAirbag;
import org.equinoxosgi.toast.dev.airbag.fake.FakeAirbag;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceRegistration;

/**
 * Created with IntelliJ IDEA.
 * User: mateuszjancy
 * Date: 10/20/13
 * Time: 5:22 PM
 * To change this template use File | Settings | File Templates.
 */
public class Activator implements BundleActivator {

    private ServiceRegistration registration;
    private FakeAirbag fakeAirbag;

    @Override
    public void start(BundleContext context) throws Exception {
        fakeAirbag = new FakeAirbag();
        fakeAirbag.startup();
        context.registerService(IAirbag.class.getName(), fakeAirbag, null);
    }

    @Override
    public void stop(BundleContext context) throws Exception {
        fakeAirbag.shutdown();
        registration.unregister();
    }
}
