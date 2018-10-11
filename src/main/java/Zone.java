public class Zone {

    private String name;
    private Station station;

    public Zone(String name, Station station) {
        this.name = name;
        this.station = station;
    }

    public String getName() {
        return name;
    }

    public Station getStation() {
        return station;
    }

    @Override
    public String toString() {
        return "Zone{" +
                "name='" + name + '\'' +
                ", station=" + station +
                '}';
    }
}
