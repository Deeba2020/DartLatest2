
import java.lang.reflect.Array;
import java.util.ArrayList;


//declaring attributes for customer class
public class Customer {

    int id;
    String name;
    int currentItemsRented;
    int credits;
    ArrayList<Message> inbox = new ArrayList<Message>(); //composition. creating obj. of arrayList for Message class. inorder customer to see all messages.


    //constructor to create and initialize obj.
    public Customer(String name, int id) { //do we need to pass arraylist for inbox here?
        this.name = name;
        this.id = id;
       currentItemsRented = 0; //since att start zero items rented
       credits = 0; //at start customer has zero credits
    }

    //getters and setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) { this.id = id; }


    ////////////////////////////////////////

    //method for sending message
    public void sendMessage(Customer recipient, Message message){ //??
        recipient.receiveMessage(message); //?
    }

    //method for viewMessage
    public void viewMessages(){
        for(int i = 0;i<inbox.size();i++){ //to iterate through inbox arraylist.
            if(inbox.get(i).isRead() == false){ //condition to check if the message is not read using isRead method in message class.
                System.out.println(inbox.get(i).toString()); //if message is not read print it using toString method in Message class.
                inbox.get(i).setRead(true); //after reading message to set is to read using setRead in message class.
            }
        }
    }

    //method for receiveMessage
    public void receiveMessage(Message message){
        inbox.add(message);
    }


    //method for renting game
    public void rentGame (Game game, int days){ //using Game class but wht is (game) ?
        if(game.getRentStatus().equals("Available")){  //to getrentstatus from constructor? by calling getter in Item class
            game.setRentStatus("Not available"); //to modify rentstatus from Item class once its rented
            int rent = game.getDailyRent()*days; //wht is game? obj? // to getDailyRent from Item Class.//and calc. dailyRent value.
            System.out.println("You have rented the game. The rent is "+rent); //to print calculated rent above
        }
        else{
            System.out.println("The game you want to rent is not available");
        }
    }

    //method for returnGame
    public void returnGame (Game game){ //calling Game class by creating game obj.?
        game.setRentStatus("Available"); // to modify setRentStatus in Item class after returned.
        System.out.println("You have successfully returned the game please rate the game");

    }

    //method for viewAllGames
    public void viewAllGames (ArrayList<Item> items){ //using arraylist for Items from dartController
            for(int i=0;i<items.size();i++){ //to go through indexes of arrayList , until reaches arraySize
                if(items.get(i) instanceof Game) //since arrayList of type generic so use instaceof to know which item we need
                    System.out.println(items.get(i).toString()); //to print toString from Item class.
            }
    }


    //method  customer to rent song
    public void rentSong (Song song, int days){
        if(song.getRentStatus().equals("Available")){
            song.setRentStatus("Not available");
            int rent = song.getDailyRent()*days;
            System.out.println("You have rented the song. The rent is "+rent);
        }
        else{
            System.out.println("The song you want to rent is not available");
        }
    }

    //method for customer to return song
    public void returnSong (Song song){
        song.setRentStatus("Available");
        System.out.println("You have successfully returned the song");
    }

    //method for customer to view the songs
    public void viewAllSongs (ArrayList<Item> items){
        for(int i=0;i<items.size();i++){
            if(items.get(i) instanceof Song)
                System.out.println(items.get(i).toString());
        }
    }

    //method for rating the song by customer
    public void rateSong(){

    }

    //method for search game using genre by customer
    public void searchGame(){

    }

    //method for search song using year by customer
    public void searchSong(){

    }

    //method for view sorted item for games according to rating
    public void sortedGames (){

    }

    //method for view sorted item for song according to rating
    public void sortedSong (){

    }

    //method for applyMembership
    public void applyMembership(ArrayList<Customer> membershipRequests){ //to access customer list in the arraylist of membership requests in DART class.
        if(this instanceof PlatinumMember){ //to check if already paltinum. //instanceof to know we refer back to which one in generic arraylist in DART.
            System.out.println("Invalid request - Already a platinum member");
        }
        else {
            membershipRequests.add(this); // ??
            if (this instanceof Customer) //??why instanceof?is it to check if customer is platinum...or normal customer?
                System.out.println("Your membership request is submitted. An employee will approve it");
            else if (this instanceof SilverMember) //same as above?
                System.out.println("Your upgrade request to Gold Member is submitted. Employee will approve it soon");
            else if (this instanceof GoldMember) //same as above?
                System.out.println("Your upgrade request to Platinum Member is submitted. Employee will approve it soon");
        }
    }

    //to print output in String for showing customer details and membership?
 public String toString (){
        String customerString = this.id+" : "+this.name + this.getClass(); //wht is getClass?
        return customerString;

    }
}
