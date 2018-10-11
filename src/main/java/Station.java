public class Station {

    private String name;
    private Zone zone;
    private int num;

    public Station(String name, Zone zone, int num) {
        this.name = name;
        this.zone = zone;
        this.num = num;
    }

    public Station(Station other) {
        this.name = other.name;
        this.zone = other.zone;
        this.num = other.num;
    }
}
