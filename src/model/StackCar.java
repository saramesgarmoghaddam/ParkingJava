package model;

public class StackCar {
    private Node top;
    private int size;
    private int capacity;
    // پیچیدگی زمانی: O(1)
    public StackCar(int capacity){
        this.top = null;
        this.size = 0;
        this.capacity = capacity;
    }
    //پیچیدگی زمانی: O(1)
    public void push(CarInformation car){
        if(size == capacity){
            //throw new IllegalStateException("Stack is full!");
            System.out.println("Stack is full!");
            return;
        }
        Node newNode = new Node(car);
        newNode.next = top;
        top = newNode;
        size++;
    }
    //پیچیدگی زمانی: O(1)
    public  CarInformation pop(){
        if(top == null){
            //throw new IllegalStateException("stack is empty!");
            System.out.println("stack is empty!");
            return null;
        }
        CarInformation car = top.car;
        top = top.next;
        size--;
        return car;
    }
    //پیچیدگی زمانی: O(1)
    public CarInformation top(){
        if(top ==  null){
            //throw new IllegalStateException("stack is empty!");
            System.out.println("stack is empty!");
            return null;
        }
        return top.car;
    }
    //پیچیدگی زمانی: O(1)
    public Node getTop(){
        return top;
    }
    //پیچیدگی زمانی: O(1)
    public void setTop(Node newTop) {
        this.top = newTop;
    }
    //پیچیدگی زمانی: O(1)
    public boolean isEmpty(){
        return size == 0;
    }
    //پیچیدگی زمانی: O(1)
    public boolean isFull(){
        return size == capacity;
    }
    //پیچیدگی زمانی: O(1)
    public int getSize(){
        return size;
    }
}
