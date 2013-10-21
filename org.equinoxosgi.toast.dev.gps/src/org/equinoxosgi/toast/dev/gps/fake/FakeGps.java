package org.equinoxosgi.toast.dev.gps.fake;

import org.equinoxosgi.toast.dev.gps.IGps;

/**
 * Created with IntelliJ IDEA.
 * User: mateuszjancy
 * Date: 10/19/13
 * Time: 5:03 PM
 * To change this template use File | Settings | File Templates.
 */
public class FakeGps implements IGps {
    private int heading = 90;
    private int latitude = 3776999;
    private int longtitude = -12244694;
    private int speed = 50;

    public FakeGps(){
        System.out.println("GPS...");
    }

    @Override
    public int getHeading() {
        return heading;
    }

    @Override
    public int getLatitude() {
        return latitude;
    }

    @Override
    public int getLongtitude() {
        return longtitude;
    }

    @Override
    public int getSpeed() {
        return speed;
    }

    @Override
    public String toString() {
        return new StringBuilder("FakeGps: ")
                        .append("heading").append(heading)
                        .append("|latitude").append(latitude)
                        .append("|longtitude").append(longtitude)
                        .append("|speed").append(speed)
                    .toString();
    }
}
