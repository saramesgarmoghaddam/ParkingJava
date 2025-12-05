package model;
import java.time.LocalDateTime;
public class CarInformation {
    private String plateNumber;
    private LocalDateTime entryTime;
    
    public CarInformation(String plateNumber , LocalDateTime entryTime){
        this.plateNumber = plateNumber;
        this.entryTime = entryTime;
    }
    
    public String getPlateNumber(){
        return plateNumber;
    }
    
    public LocalDateTime getEntryTime(){
        return entryTime;
    }
    
    public String toString(){
        return "plate number='" + plateNumber + '\'' + ", entry time=" + entryTime;
    }
}
