// done with Sai Nikhil Chanda
import java.time.LocalDate;

public class Wedding {
    Couple couple;
    LocalDate weddingDate;
    String location;

    public Wedding(Couple couple, LocalDate weddingDate, String location){
        this.couple = couple;
        this.weddingDate = weddingDate;
        this.location = location;

    }

    public Couple getCouple(){return couple;}
    public LocalDate getWeddingDate(){return weddingDate;}
    public String getLocation(){return location;}

}
