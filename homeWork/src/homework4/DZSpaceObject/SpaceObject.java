package homework4.DZSpaceObject;

public abstract class SpaceObject {

    final Integer mass;

    public SpaceObject(Integer mass) {
        this.mass = mass;
    }

    public abstract double getDiameter();

    public boolean isEqual(SpaceObject spaceObject) {
        return getMass().equals(spaceObject.getMass());
    }

    public Integer getMass() {
        return mass;
    }
}
