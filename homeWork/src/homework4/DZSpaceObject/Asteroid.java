package homework4.DZSpaceObject;

public class Asteroid extends SpaceObject implements Dangerable {

    private final Integer lengthAsteroid;

    private final Integer widthAsteroid;

    public Asteroid(Integer mass, Integer lengthAsteroid, Integer widthAsteroid) {
        super(mass);
        this.lengthAsteroid = lengthAsteroid;
        this.widthAsteroid = widthAsteroid;
    }

    @Override
    public double getDiameter() {
        return (double) (getLengthAsteroid() + getWidthAsteroid()) / 2;
    }

    @Override
    public boolean dangerDestructionPlanet(Planet planet) {
        return this.getMass() > planet.getMass() / 5;
    }

    @Override
    public String toString() {
        return "Asteroid{" +
                "lengthAsteroid=" + lengthAsteroid +
                ", widthAsteroid=" + widthAsteroid +
                ", mass=" + mass +
                '}';
    }

    public Integer getLengthAsteroid() {
        return lengthAsteroid;
    }

    public Integer getWidthAsteroid() {
        return widthAsteroid;
    }
}
