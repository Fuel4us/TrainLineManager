public class Station {

    private String name;
    private int num;
    private String zone;

    public Station(String name, int num) {
        this.name = name;
        this.num = num;
    }

    public Station(Station other) {
        this.name = other.name;
        this.num = other.num;
    }

    public String getName() {
        return name;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "Station{" +
                "name='" + name + '\'' +
                ", num=" + num +
                '}';
    }
}
