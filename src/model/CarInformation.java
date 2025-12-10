package model;
import java.time.LocalDateTime;
public class CarInformation {
    private String plateNumber;
    private LocalDateTime entryTime;
    //پیچیدگی زمانی: O(1)
    public CarInformation(String plateNumber , LocalDateTime entryTime){
        this.plateNumber = plateNumber;
        this.entryTime = entryTime;
    }
    //پیچیدگی زمانی: O(1)
    public String getPlateNumber(){
        return plateNumber;
    }
    //پیچیدگی زمانی: O(1)
    public LocalDateTime getEntryTime(){
        return entryTime;
    }
    //پیچیدگی زمانی: O(1)
    public String toString(){
        return "plate number='" + plateNumber + '\'' + ", entry time=" + entryTime;
    }
}
