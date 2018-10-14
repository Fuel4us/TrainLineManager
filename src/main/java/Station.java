public class Station {

    private String name;
    private int num;
    private String zone;

    public Station(String name, int num, String zone) {
        this.name = name;
        this.num = num;
        this.zone = zone;
    }

    public Station(Station other) {
        this.name = other.name;
        this.num = other.num;
        this.zone = other.zone;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }
    
    public String getZone() {
        return zone;
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
