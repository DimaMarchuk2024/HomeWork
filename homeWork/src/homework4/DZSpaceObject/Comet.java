package homework4.DZSpaceObject;

public class Comet extends SpaceObject implements DetermineTemperatureComet {

    private final Integer lengthTail;

    public Comet(Integer mass, Integer lengthTail) {
        super(mass);
        this.lengthTail = lengthTail;
    }

    @Override
    public double getDiameter() {
        if (getLengthTail() > 300) {
            return 15.0;
        } else if (getLengthTail() > 150) {
            return 10.0;
        } else return 5.0;
    }

    @Override
    public double calculateTemperatureComet() {
        return getLengthTail() * Constants.INDEX_TEMPERATURE_COMET.getValue();
    }

    @Override
    public String toString() {
        return "Comet{" +
                "lengthTail=" + lengthTail +
                ", mass=" + mass +
                '}';
    }

    public Integer getLengthTail() {
        return lengthTail;
    }
}
