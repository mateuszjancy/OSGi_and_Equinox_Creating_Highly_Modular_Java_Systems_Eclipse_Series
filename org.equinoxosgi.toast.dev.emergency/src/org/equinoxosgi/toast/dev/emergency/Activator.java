package org.equinoxosgi.toast.dev.emergency;

import org.equinoxosgi.toast.dev.airbag.IAirbag;
import org.equinoxosgi.toast.dev.gps.IGps;
import org.osgi.framework.BundleActivator;
import org.osgi.framework.BundleContext;
import org.osgi.framework.ServiceReference;

/**
 * Created with IntelliJ IDEA.
 * User: mateuszjancy
 * Date: 10/20/13
 * Time: 2:31 PM
 * To change this template use File | Settings | File Templates.
 */
public class Activator implements BundleActivator {
    IGps gps;
    ServiceReference gpsRef;

    IAirbag airbag;
    ServiceReference airbagRef;

    EmergencyMonitor emergencyMonitor;

    @Override
    public void start(BundleContext bundleContext) throws Exception {

        System.out.println("Starting...");

        emergencyMonitor = new EmergencyMonitor();

        gpsRef = bundleContext.getServiceReference(IGps.class.getName());
        airbagRef = bundleContext.getServiceReference(IAirbag.class.getName());

        if(!notNull(gpsRef, airbagRef)){
            return;
        }

        gps =(IGps) bundleContext.getService(gpsRef);
        airbag = (IAirbag) bundleContext.getService(airbagRef);

        if(!notNull(gps, airbag)){
            return;
        }

        emergencyMonitor.setAirbag(airbag);
        emergencyMonitor.setGps(gps);
        emergencyMonitor.startup();
    }

    @Override
    public void stop(BundleContext bundleContext) throws Exception {
        //System.out.println("stop");
        emergencyMonitor.shoutdown();
        boolean valid;
        valid = (notNull(gpsRef))? bundleContext.ungetService(gpsRef): false;
        valid = (notNull(airbagRef))? bundleContext.ungetService(airbagRef): false;
    }

    private static <T>boolean notNull(T... t){
        for(T i : t) {
            if(i==null){
                System.out.println("Unable to load");
                return false;
            }
        }

        return true;
    }
}
