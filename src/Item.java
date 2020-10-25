import java.util.ArrayList; //to get arraylist from DART

//super class for Game and Song Class
//common variables for game and song
public class Item {

    int ID;
    String title;
    int dailyRent;
    String rentStatus;
    ArrayList<Double> ratings = new ArrayList<Double>(); //since Item can contain rating
    ArrayList<String> reviews = new ArrayList<String>(); //since Item can contain review


    //constructor
    Item(int ID, String title, int dailyrent){
        this.ID = ID;
        this.title = title;
        this.dailyRent = dailyrent;
        this.rentStatus = "Available";
    }

    //empty constructor for?
    public Item() {

    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getDailyRent() {
        return dailyRent;
    }

    public void setDailyRent(int dailyRent) {
        this.dailyRent = dailyRent;
    }

    public String getRentStatus() {
        return rentStatus;
    }

    public void setRentStatus(String rentStatus) {
        this.rentStatus = rentStatus;
    }

    @Override //override from?
    public String toString() {
        return "Item{" +
                "ID=" + ID +
                ", title='" + title + '\'' +
                ", dailyRent=" + dailyRent +
                ", rentStatus='" + rentStatus + '\'' +
                ", ratings=" + ratings +
                ", reviews=" + reviews +
                '}';
    }
}
