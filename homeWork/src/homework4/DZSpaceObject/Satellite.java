package homework4.DZSpaceObject;

public class Satellite extends Planet {

    private final Integer distanceFromPlanet;

    public Satellite(Integer mass, Integer orbitalPeriod, Integer distanceFromSun
            , Integer angle, Integer periodOfRotation, Integer distanceFromPlanet) {

        super(mass, orbitalPeriod, distanceFromSun, angle, periodOfRotation);
        this.distanceFromPlanet = distanceFromPlanet;
    }

    @Override
    public double getDiameter() {
        return super.getDiameter() * getDistanceFromPlanet() * getAngle() / Constants.INDEX_SATELLITE.getValue();
    }

    @Override
    public double getSpeedRotation() {
        return super.getSpeedRotation() * getDistanceFromPlanet();
    }


    @Override
    public String toString() {
        return "Satellite{" +
                "distanceFromPlanet=" + distanceFromPlanet +
                ", mass=" + mass +
                '}';
    }

    public Integer getDistanceFromPlanet() {
        return distanceFromPlanet;
    }


}

