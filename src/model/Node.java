package model;

public class Node {
    CarInformation car;
    Node next;
    //پیچیدگی زمانی: O(1)
    public Node(CarInformation car){
        this.car = car;
        this.next = null;
    }
}
