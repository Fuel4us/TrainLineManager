public class TypeOfTicket {

    private String type;
    private int num;

    public TypeOfTicket(String type) {
        this.type = type;
        returnNumber(type);
    }

    private void returnNumber(String type) {
        if (type.equalsIgnoreCase("z2")) num = 2;
        if (type.equalsIgnoreCase("z3")) num = 3;
        if (type.equalsIgnoreCase("z4")) num = 4;
        if (type.equalsIgnoreCase("z5")) num = 5;
        if (type.equalsIgnoreCase("z6")) num = 6;
        if (type.equalsIgnoreCase("z7")) num = 7;
        if (type.equalsIgnoreCase("z8")) num = 8;
        if (type.equalsIgnoreCase("z9")) num = 9;
    }

    public String getType() {
        return type;
    }

    public int getNum() {
        return num;
    }

    @Override
    public String toString() {
        return "TypeOfTicket{" +
                "type='" + type + '\'' +
                ", num=" + num +
                '}';
    }
}
