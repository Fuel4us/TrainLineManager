public class Trip {

    private Ticket ticket;
    private int originStation;
    private int finalStation;

    public Trip(Ticket ticket, int originStation, int finalStation) {
        this.ticket = ticket;
        this.originStation = originStation;
        this.finalStation = finalStation;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public int getOriginStation() {
        return originStation;
    }

    public int getFinalStation() {
        return finalStation;
    }

    @Override
    public String toString() {
        return "Trip{" +
                "ticket=" + ticket +
                ", originStation=" + originStation +
                ", finalStation=" + finalStation +
                '}';
    }
}
