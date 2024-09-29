package homework4.DZSpaceObject;

public enum Constants {
    INDEX_PLANET(206544.0),
    INDEX_SATELLITE(5469822.0),
    INDEX_TEMPERATURE_COMET(157.25),
    INDEX_STAR(15634.0),
    CONSTANTA_BOLCMAN(5.6686E-8);

    private final Double value;

    Constants(Double value) {
        this.value = value;
    }

    public Double getValue() {
        return value;
    }
}
