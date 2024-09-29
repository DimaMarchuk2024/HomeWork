package homework4.DZSpaceObject;

import static java.lang.Math.PI;
import static java.lang.Math.pow;

public class Star extends SpaceObject implements DetermineLuminosityStar {
    private final Integer temperaturePhotosphere;
    private final Integer distanceFromEarth;
    private final Integer angle;

    public Star(Integer mass, Integer temperaturePhotosphere, Integer distanceFromEarth, Integer angle) {
        super(mass);
        this.temperaturePhotosphere = temperaturePhotosphere;
        this.distanceFromEarth = distanceFromEarth;
        this.angle = angle;
    }

    @Override
    public double getDiameter() {
        return (double) (getAngle() * getDistanceFromEarth()) / Constants.INDEX_STAR.getValue();
    }

    @Override
    public double getLuminosityStar() {
        return PI * getDiameter() * getDiameter() * Constants.CONSTANTA_BOLCMAN.getValue() * pow(getTemperaturePhotosphere(), 4.0);
    }

    @Override
    public String toString() {
        return "Star{" +
                "temperaturePhotosphere=" + temperaturePhotosphere +
                ", distanceFromEarth=" + distanceFromEarth +
                ", angle=" + angle +
                ", mass=" + mass +
                '}';
    }

    public Integer getTemperaturePhotosphere() {
        return temperaturePhotosphere;
    }

    public Integer getDistanceFromEarth() {
        return distanceFromEarth;
    }

    public Integer getAngle() {
        return angle;
    }
}

