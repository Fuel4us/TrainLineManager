public class Line {


    public DoublyLinkedList<Station> doublyLinkedList = new DoublyLinkedList<>();

    public Line(DoublyLinkedList<Station> doublyLinkedList) {
        this.doublyLinkedList = doublyLinkedList;
    }

    public DoublyLinkedList<Station> getDoublyLinkedList() {
        return doublyLinkedList;
    }

    @Override
    public String toString() {
        return "Line{" +
                "doublyLinkedList=" + doublyLinkedList +
                '}';
    }
}
