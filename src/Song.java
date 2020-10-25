
//do we need to import arraylist here?
//child class of Item class
public class Song extends Item{

    String artist;
    int releaseYear;

    Song() {
        super();
    }

//constructor
    public Song(int ID, String title, String artist, int releaseYear, int dailyRent) {
        super(ID,title,dailyRent);
        this.artist = artist;
        this.releaseYear = releaseYear;
    }

    public String getArtist() {
        return artist;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public int getReleaseYear() {
        return releaseYear;
    }

    public void setReleaseYear(int releaseYear) {
        this.releaseYear = releaseYear;
    }


    //toString method to show while printing song album
    @Override
    public String toString() {
           return super.toString() + this.artist +"\n"+ this.releaseYear;
    }
}




