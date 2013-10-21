package org.equinoxosgi.toast.dev.emergency;

import org.equinoxosgi.toast.dev.airbag.AirbagListener;
import org.equinoxosgi.toast.dev.airbag.IAirbag;
import org.equinoxosgi.toast.dev.gps.IGps;


/**
 * Created with IntelliJ IDEA.
 * User: mateuszjancy
 * Date: 10/19/13
 * Time: 5:09 PM
 * To change this template use File | Settings | File Templates.
 */
public class EmergencyMonitor implements AirbagListener {
    private IGps gps;
    private IAirbag airbag;

    public EmergencyMonitor(){
        System.out.println("EmergencyMonitor");
    }

    @Override
    public void deployed() {
        System.out.println(gps);
    }

    public void setGps(IGps gps) {
        this.gps = gps;
    }

    public void setAirbag(IAirbag airbag) {
        this.airbag = airbag;
    }

    public void startup(){
        airbag.addListener(this);
    }

    public void shutdown(){
        airbag.removeListener(this);
    }
}
