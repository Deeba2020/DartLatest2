import java.util.ArrayList;

//child class of Item class
public class Game extends Item{

    String genre;

    Game(){
        super();

    }

    //constructor
    public Game(int ID, String title, String genre, int dailyrent) {
        super(ID,title,dailyrent);
        this.genre = genre; //since genre is not common attribute
    }


    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }


//do we have override here?
    public String toString(){

        String gameString = this.ID + ":" +this.title+"("+this.genre+")."+this.dailyRent+". Status: "+this.rentStatus;

        return gameString;
    }


}

