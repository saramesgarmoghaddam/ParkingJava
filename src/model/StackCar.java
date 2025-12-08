package model;

public class StackCar {
    private Node top;
    private int size;
    private int capacity;
    
    public StackCar(int capacity){
        this.top = null;
        this.size = 0;
        this.capacity = capacity;
    }
    
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
    
    public CarInformation top(){
        if(top ==  null){
            //throw new IllegalStateException("stack is empty!");
            System.out.println("stack is empty!");
            return null;
        }
        return top.car;
    }
    
    public Node getTop(){
        return top;
    }

    public void setTop(Node newTop) {
        this.top = newTop;
    }
    
    public boolean isEmpty(){
        return size == 0;
    }
    
    public boolean isFull(){
        return size == capacity;
    }
    
    public int getSize(){
        return size;
    }
}
