package model;

public class QueueCar {
    private Node head;
    private Node tail;
    private int size;
    //پیچیدگی زمانی: O(1)
    public QueueCar(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    //پیچیدگی زمانی: O(1)
    public void enqueue(CarInformation car){
        Node newNode = new Node(car);
        if(head == null){
            head = tail = newNode;
        }
        else{
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }
    //پیچیدگی زمانی: O(1)
    public CarInformation dequeue(){
        if(head == null){
            //throw new IllegalStateException("Queue is empty!");
            System.out.println("Queue is empty!");
        }
        CarInformation car = head.car;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return car;
    }
    //پیچیدگی زمانی:O(1)
    public CarInformation first(){
        if(head == null){
            //throw new IllegalStateException("Queue is empty!");
            System.out.println("Queue is empty!");
        }
        return head.car;
    }
    //پیچیدگی زمانی: O(1)
    public  boolean isEmpty(){
        return size == 0;
    }
    //پیچیدگی زمانی: O(1)
    public int getSize(){
        return size;
    }
}
