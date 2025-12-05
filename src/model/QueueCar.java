package model;

public class QueueCar {
    private Node head;
    private Node tail;
    private int size;
    
    public QueueCar(){
        this.head = null;
        this.tail = null;
        this.size = 0;
    }
    
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
    
    public CarInformation dequeue(){
        if(head == null){
            throw new IllegalStateException("Queue is empty!");
        }
        CarInformation car = head.car;
        head = head.next;
        if(head == null){
            tail = null;
        }
        size--;
        return car;
    }
    
    public CarInformation first(){
        if(head == null){
            throw new IllegalStateException("Queue is empty!");
        }
        return head.car;
    }
    
    public  boolean isEmpty(){
        return size == 0;
    }
    
    public int getSize(){
        return size;
    }
}

class Node{;
    CarInformation car;
    Node next;
    
    public Node(CarInformation car){
        this.car = car;
        this.next = null;
    }
}