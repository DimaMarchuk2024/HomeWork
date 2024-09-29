package homework4.DZSpaceObject;

public class Planet extends SpaceObject implements Speedable {

    private final Integer orbitalPeriod;
    private final Integer distanceFromSun;
    private final Integer angle;
    private final Integer periodOfRotation;

    public Planet(Integer mass, Integer orbitalPeriod, Integer distanceFromSun, Integer angle, Integer periodOfRotation) {
        super(mass);
        this.orbitalPeriod = orbitalPeriod;
        this.distanceFromSun = distanceFromSun;
        this.angle = angle;
        this.periodOfRotation = periodOfRotation;
    }

    @Override
    public double getDiameter() {
        return (double) (getAngle() * getDistanceFromSun()) / Constants.INDEX_PLANET.getValue();
    }

    @Override
    public double getSpeedRotation() {
        return (double) getOrbitalPeriod() * getPeriodOfRotation() / getDistanceFromSun();
    }

    @Override
    public String toString() {
        return "Planet{" +
                "orbitalPeriod=" + orbitalPeriod +
                ", distanceFromSun=" + distanceFromSun +
                ", angle=" + angle +
                ", periodOfRotation=" + periodOfRotation +
                ", mass=" + mass +
                '}';
    }

    public Integer getOrbitalPeriod() {
        return orbitalPeriod;
    }

    public Integer getDistanceFromSun() {
        return distanceFromSun;
    }

    public Integer getAngle() {
        return angle;
    }

    public Integer getPeriodOfRotation() {
        return periodOfRotation;
    }
}
