package homework4.DZSpaceObject;

public final class SpaceUtils {

    private SpaceUtils() {
    }

    public static double forceOfGravitation(SpaceObject spaceObject1, SpaceObject spaceObject2, Integer distanceOfObjects) {
        return (double) (spaceObject1.getMass() + spaceObject2.getMass()) / distanceOfObjects;
    }

    public static boolean isStar(SpaceObject spaceObject) {
        return spaceObject instanceof Star;
    }
}
