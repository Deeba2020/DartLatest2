public class SilverMember extends Customer{

    //to inherit name and id from parent class Customer
    public SilverMember(int id, String name) {
        super(name,id);
    }

    @Override //override rentGame method from parent class Customer
    public void rentGame (Game game, int days){

        if(game.getRentStatus().equals("Available") && currentItemsRented <3){ //to check currentItemsRented from customer class.
            game.setRentStatus("Not available"); //to modify rentStatus from Item class once rented

            //to check for case where customer has credit
            if(credits<5) {    //credit from customer class
                double rent = game.getDailyRent() * days; //using game obj from Game class, getdailyrent from Item class.
                double discount = (0.1) * rent; //impl. discount for silvermember
                rent = rent - discount;
                System.out.println("You have rented the game. The rent is "+rent);
            }
            else{
                //pay with credit
                credits = credits - 5; //to deduct credit from customer class
                System.out.println("You paid with credits");
            }

            currentItemsRented = currentItemsRented + 1; //currentItemRented from customer class to accumulate the items rented
        }
        else if(game.rentStatus.equals("Not available")){ //rentStatus from Item class
            System.out.println("The game you want to rent is not available");
        }
        else{
            System.out.println("You have already rented 3 Items and cannot rent more");
        }
    }
    @Override //override returnGame method from customer class
    public void returnGame (Game game){
        game.setRentStatus("Available"); //game from Game class, rentstatus from Item class
        credits = credits + 1; //credits from customer class to collect credits
        System.out.println("You have successfully returned the game please rate the game");

    }
    @Override //override rentSong from customer class
    public void rentSong (Song song, int days){

        if(song.getRentStatus().equals("Available") && currentItemsRented <3){
            song.setRentStatus("Not available");

            if(credits<5) {
                double rent = song.getDailyRent() * days;
                double discount = (0.1) * rent;
                rent = rent - discount;
                System.out.println("You have rented the song. The rent is "+rent);
            }
            else{
                credits = credits - 5;
                System.out.println("You paid with credits");
            }

            currentItemsRented = currentItemsRented + 1;
        }
        else if(song.rentStatus.equals("Not available")){
            System.out.println("The song you want to rent is not available");
        }
        else{
            System.out.println("You have already rented 3 Items and cannot rent more");
        }
    }
    @Override //override returnsong from customer class
    public void returnSong (Song song){
        song.setRentStatus("Available"); //song from Song class, rentstatus from Item class
        credits = credits + 1;
        System.out.println("You have successfully returned the song please rate the game");

    }
}
