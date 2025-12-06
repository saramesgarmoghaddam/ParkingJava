package model;

public class Parking {
    private StackCar[] stacks;
    private int n;
    private int m;
    
    public Parking(int n , int m){
        this.n = n;
        this.m = m;
        stacks= new StackCar[n];
        for(int i = 0 ; i < n ; i++){
            stacks[i] = new StackCar(m);
        }
    }
    
    public void parkFirstAvailableStack(QueueCar queue){
        CarInformation car = queue.dequeue();
        if(car == null){
            throw new IllegalStateException("No car in queue!");
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
    
    public void parkInSpecifiedStack(QueueCar queue , int stackNumber){
        if(stackNumber < 0 || stackNumber >= n){
            throw new IllegalStateException("Invalid stack number!");
        }
        CarInformation car = queue.dequeue();
        if(car == null){
            throw new IllegalStateException("No car in queue!");
        }
        if(stacks[stackNumber].isFull()){
            throw new IllegalStateException("Stack " + stackNumber + " is full!");
        }
        else{
            stacks[stackNumber].push(car);
            System.out.println("Car parked in stack" + stackNumber);
        }
    }
    
    public CarInformation removeCar(int stackNumber , String plateNumber){
        if(stackNumber < 0 || stackNumber >= n){
            throw new IllegalStateException("Invalid stack number!");
        }
        StackCar stack = stacks[stackNumber];
        if(stack.isEmpty()){
            throw new IllegalStateException("Stack " + stackNumber + " is empty!");
        }
        if(stack.peek().getPlateNumber().equals(plateNumber)){
            return stack.pop();
        }
        else{
            throw new IllegalStateException("Car is not at the top of stack " + stackNumber + ". Cannot remove!");
        }
    }
    
    public void moveCar(int i , int j){
        if(i < 0 || j > 0 || i >= n || j >= n){
            throw new IllegalStateException("Invalid stack numbers!");
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
                throw new IllegalStateException("No space available for car" + car.getPlateNumber());
            }
        }
        throw new IllegalStateException("Stack " + i + "is now empty!");
    }
}
