package org.equinoxosgi.toast.dev.airbag;

/**
 * Created with IntelliJ IDEA.
 * User: mateuszjancy
 * Date: 10/20/13
 * Time: 5:17 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IAirbag {
    void addListener(AirbagListener airbagListener);

    void removeListener(AirbagListener airbagListener);

    void deploy();
}
