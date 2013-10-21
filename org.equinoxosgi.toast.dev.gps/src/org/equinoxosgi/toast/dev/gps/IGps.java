package org.equinoxosgi.toast.dev.gps;

/**
 * Created with IntelliJ IDEA.
 * User: mateuszjancy
 * Date: 10/20/13
 * Time: 5:02 PM
 * To change this template use File | Settings | File Templates.
 */
public interface IGps {
    int getHeading();

    int getLatitude();

    int getLongtitude();

    int getSpeed();
}
