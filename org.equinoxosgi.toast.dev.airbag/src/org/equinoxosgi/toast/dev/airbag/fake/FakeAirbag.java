package org.equinoxosgi.toast.dev.airbag.fake;

import org.eclipse.core.runtime.IProgressMonitor;
import org.eclipse.core.runtime.IStatus;
import org.eclipse.core.runtime.Status;
import org.eclipse.core.runtime.jobs.Job;
import org.equinoxosgi.toast.dev.airbag.AirbagListener;
import org.equinoxosgi.toast.dev.airbag.IAirbag;


import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: mateuszjancy
 * Date: 10/19/13
 * Time: 5:06 PM
 * To change this template use File | Settings | File Templates.
 */
public class FakeAirbag implements IAirbag {
    List<AirbagListener> listeners;

    Job job;

    boolean running;

    public FakeAirbag() {
        this.listeners = new ArrayList<AirbagListener>();
    }

    @Override
    public synchronized void addListener(AirbagListener airbagListener){
        listeners.add(airbagListener);
    }

    @Override
    public synchronized void removeListener(AirbagListener airbagListener){
        listeners.remove(airbagListener);
    }

    @Override
    public synchronized void deploy(){
        for(AirbagListener airbagListener : listeners){
            airbagListener.deployed();
        }
    }

    public synchronized void shutdown(){
        running = false;
        job.cancel();

        try{
            job.join();
        }catch (InterruptedException e){

        }
    }

    public synchronized void startup(){
        running = true;

        job = new Job("Fake Airbag") {
            @Override
            protected IStatus run(IProgressMonitor monitor) {
                deploy();
                if (running) {
                    schedule(DELAY);
                }

                return Status.OK_STATUS;
            }
        };

        job.schedule(DELAY);
    }

    private static final int DELAY = 5;
}
