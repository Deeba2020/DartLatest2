
//child class of customer class
public class GoldMember extends Customer {  //inheritance

    public GoldMember(int id, String name) {
        super(name,id);
    } //super for calling constructor of parent class instead this //instance of superclass

    @Override
    public void rentGame (Game game, int days){
        if(game.getRentStatus().equals("available") && currentItemsRented <5){
            game.setRentStatus("not available");

            if(credits<5) {
                double rent = game.getDailyRent() * days;
                double discount = (0.15) * rent;
                rent = rent - discount;
                System.out.println("You have rented the game. The rent is "+rent);
            }
            else{
                credits = credits - 5;
            }


            currentItemsRented = currentItemsRented + 1;
        }
        else if(game.rentStatus.equals("not available")){
            System.out.println("The game you want to rent is not available");
        }
        else{
            System.out.println("You have already rented 3 Items and cannot rent more");
        }
    }
    @Override
    public void returnGame (Game game){
        game.setRentStatus("available");
        credits = credits + 2;
        System.out.println("You have successfully returned the game please rate the game");

    }
}
