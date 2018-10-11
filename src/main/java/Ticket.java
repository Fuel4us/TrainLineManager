public class Ticket {

    private int num;
    private TypeOfTicket type;

    public Ticket(int num, TypeOfTicket type) {
        this.num = num;
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public TypeOfTicket getType() {
        return type;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "num=" + num +
                ", type=" + type +
                '}';
    }
}
