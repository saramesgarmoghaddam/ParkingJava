package model;

public class Node {
    CarInformation car;
    Node next;

    public Node(CarInformation car){
        this.car = car;
        this.next = null;
    }
}
