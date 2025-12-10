package model;

public class Parking {
    private StackCar[] stacks;
    private int n;
    private int m;
    
    //پیچیدگی زمانی : O(n)
    public Parking(int n , int m){
        this.n = n;
        this.m = m;
        stacks= new StackCar[n];
        for(int i = 0 ; i < n ; i++){
            stacks[i] = new StackCar(m);
        }
    }
    //پیچیدگی زمانی : O(n)
    public void parkFirstAvailableStack(QueueCar queue){
        CarInformation car = queue.dequeue();
        if(car == null){
            //throw new IllegalStateException("No car in queue!");
            System.out.println("No car in queue!");
            return;
        }
        for(int i = 0 ; i < n ; i++){
            if(!stacks[i].isFull()){
                stacks[i].push(car);
                System.out.println("Car parked in stack " + i);
                return;
            }
        }
        System.out.println("Parking is full!");
    }
    //پیپیدگی زمانی: O(n)
    public void parkInSpecifiedStack(QueueCar queue , int stackNumber){
        if(stackNumber < 0 || stackNumber >= n){
            //throw new IllegalStateException("Invalid stack number!");
            System.out.println("Invalid stack number!");
            return;
        }
        CarInformation car = queue.dequeue();
        if(car == null){
            //throw new IllegalStateException("No car in queue!");
            System.out.println("No car in queue!");
            return;
        }
        if(stacks[stackNumber].isFull()){
            //throw new IllegalStateException("Stack " + stackNumber + " is full!");
            System.out.println("Stack " + stackNumber + " is full!");
            return;
        }
        else{
            stacks[stackNumber].push(car);
            System.out.println("Car parked in stack" + stackNumber);
        }
    }
    //پیچیدگی زمانی: O(n)
    public CarInformation removeCar(int stackNumber , String plateNumber){
        if(stackNumber < 0 || stackNumber >= n){
            //throw new IllegalStateException("Invalid stack number!");
            System.out.println("Invalid stack number!");
            return null;
        }
        StackCar stack = stacks[stackNumber];
        if(stack.isEmpty()){
            //throw new IllegalStateException("Stack " + stackNumber + " is empty!");
            System.out.println("Stack " + stackNumber + " is empty!");
            return null; 
        }
        if(stack.top().getPlateNumber().equals(plateNumber)){
            return stack.pop();
        }
        else{
            //throw new IllegalStateException("Car is not at the top of stack " + stackNumber + ". Cannot remove!");
            System.out.println("Car is not at the top of stack " + stackNumber + ". Cannot remove!");
            return null;
        }
    }
    //پیچیدگی زمانی: O(m*n)
    public void moveCar(int i , int j){
        if(i < 0 || j > 0 || i >= n || j >= n){
            //throw new IllegalStateException("Invalid stack numbers!");
            System.out.println("Invalid stack numbers!");
            return;
        }
        while(!stacks[i].isEmpty()){
            CarInformation car = stacks[i].pop();
            boolean parked = false;
            for(int k = j ; k < n ; k++){
                if(!stacks[k].isFull()){
                    stacks[k].push(car);
                    parked = true;
                    break;
                }
            }
            if(!parked){
                //throw new IllegalStateException("No space available for car" + car.getPlateNumber());
                System.out.println("No space available for car" + car.getPlateNumber());
                return;
            }
        }
        //throw new IllegalStateException("Stack " + i + "is now empty!");
        System.out.println("Stack " + i + "is now empty!");
    }
    //پیچیدگی زمانی: O(n*m)
    public String find(String plateNumber){
       for(int i = 0 ; i < n ; i++){
           StackCar stack = stacks[i];
           Node current = stack.getTop();
           int position = 0;
           while(current != null){
               if(current.car.getPlateNumber().equals(plateNumber)){
                   return "Car found in stack " + i + " at position " + position;
               }
               current = current.next;
               position++;
           }
       }
       return "Car with plate " + plateNumber + " not found in any stack!";
    }
    //پیچیدگی زمانی: O(mlogm)
    public boolean sortStack(int stackNumber){
        if(stackNumber < 0 || stackNumber >= n){
            //throw new IllegalStateException("Invalid stack number!");
            System.out.println("Invalid stack number!");
            return false;
        }
        StackCar stack = stacks[stackNumber];
        if(stack.isEmpty()){
            //throw new IllegalStateException("Stack " + stackNumber + " is empty!");
            System.out.println("Stack " + stackNumber + " is empty!");
            return false;
        }
        Node sortedHead = mergeSort(stack.getTop());
        stack.setTop(sortedHead);
        return true;
    }
    //پیچیدگی زمانی: O(mlogm)
    public Node mergeSort(Node head){
        if(head == null ||  head.next == null){
            return head;
        }
        Node slow = head;
        Node fast = head;
        Node prev = null;
        while(fast != null && fast.next != null){
            prev = slow;
            slow = slow.next;
            fast = fast.next.next;
        }
        if(prev != null){
            prev.next = null;
        }
        Node mid = slow;
        Node left = mergeSort(head);
        Node right = mergeSort(mid);
        return merge(left , right);
    }
    //پیچیدگی زمانی: O(m)
    public Node merge(Node left , Node right){
        if(left == null){
            return right;
        }
        if(right == null){
            return left;
        }
        if(left.car.getPlateNumber().compareTo(right.car.getPlateNumber()) <= 0){
            left.next = merge(left.next , right);
            return left;
        }
        else{
            right.next = merge(left , right.next);
            return right;
        }
    }
}
