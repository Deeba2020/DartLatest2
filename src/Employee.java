import java.awt.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Calendar;

public class Employee {

    int id;
    String name;
    String address;
    int birthday;
    int salary;


    //constructor
    public Employee(int id, String name, String address, int birthday, int salary) {
        this.id = id;
        this.name = name;
        this.address = address;
        this.birthday = birthday;
        this.salary = salary;
    }

    public Employee() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public int getBirthday() {
        return birthday;
    }

    public void setBirthday(int birthday) {
        this.birthday = birthday;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    //method for adding customer
    public void addCustomer(Customer newcustomer, ArrayList<Customer> customers) { //using Customer class , adding customer to arraylist
        customers.add(newcustomer); //to add customer
        System.out.println("New customer has been added");
    }


    //method for removing customer
    public void removeCustomer(int id, ArrayList<Customer> customers) { //remove by id of customer, find it from arraylist customer from DART

        for (int i = 0; i < customers.size(); i++) { //iterate through arraylist
            if (customers.get(i).getId() == id) { //get the id from customer arraylist
                customers.remove(customers.get(i)); //remove it from customer arraylist
                System.out.println("Customer with ID " + id + " removed");
                return;
            }
            System.out.println("Customer with the id not found");
        }
    }


    //method for adding game
    public void addGame(Item newgame, ArrayList<Item> items) { //Item class, Item arraylist from DART
        items.add(newgame); //add game to Item arraylist
        System.out.println("The game is added");
    }

    //method for removing game
    public void removeGame(int id, ArrayList<Item> ItemArrayList) { //to iterate through Item arraylist from DART
        for (int i = 0; i < ItemArrayList.size(); i++) { //to iterate through arraylist of Item
            if (ItemArrayList.get(i).getID() == id) { //condition to check if the id matched from Item class
                if(ItemArrayList.get(i) instanceof Game) { //condition to make sure the item we remove is game item
                    ItemArrayList.remove(ItemArrayList.get(i)); //remove it from arraylist
                    System.out.println("Game with ID " + id + " removed");
                    return;
                }
            }
            System.out.println("Game with the id not found");
        }
    }

    //method to view all games
    public void viewAllGames(ArrayList<Item> items) { //to view games from arraylist of Items in DART
        for (int i = 0; i < items.size(); i++) { //to iterate through the arraylist
            if (items.get(i) instanceof Game) //condition to make sure the Item is game
                System.out.println(items.get(i).toString());
        }
    }

    //method to view all customer
    public void viewAllCustomers(ArrayList<Customer> customers) { //to view customer from arraylist of customer in DART
        for (int i = 0; i < customers.size(); i++) { //to iterate through the arraylist
            System.out.println(customers.get(i).toString());
        }
    }

    //method for adding song
    public void addSong(Item newsong, ArrayList<Item> items) {  //to add dong to the Item arraylist from DART
        items.add(newsong); //add new song to Item arraylist
        System.out.println("The song is added");
    }

    //method for removing song
    public void removeSong(int id, ArrayList<Item> itemsArrayList) { //to remove song by ID from Item arraylist
        for (int i = 0; i < itemsArrayList.size(); i++) { //for loop to iterate through the arraylist
            if (itemsArrayList.get(i).getID() == id) { //condition to check id found in the arraylist
                if(itemsArrayList.get(i) instanceof Song) { //condition to check the Item is song
                    itemsArrayList.remove(itemsArrayList.get(i)); //remove it from the arraylist
                    System.out.println("Song with ID " + id + " removed");
                    return;
                }
            }
            System.out.println("Song with the id not found");
        }
    }


    //method for view all songs
    public void viewAllSongs(ArrayList<Item> items) { //view songs from item arraylist
        for (int i = 0; i < items.size(); i++) { //iterate through arraylist
            if(items.get(i) instanceof Song) { //condition to check the item is song
                System.out.println(items.get(i).toString());
            }
        }
    }
        public String toString () { //??

            int year = Calendar.getInstance().get(Calendar.YEAR);
            String employeestring = this.id + ":" + this.name + "-" + this.birthday + "(" + (year - this.birthday) + ") :" + this.salary + "SEK";
            return employeestring;
        }


        //method to approve customer membership by employee
    public void approveMemberships(ArrayList<Customer> membershipRequests, ArrayList<Customer> customers){
        for(int i = 0;i<membershipRequests.size();i++){ //to iterate through arraylist of membership requests

            System.out.println("---> Membership request");

            System.out.println(membershipRequests.get(i).toString()); //to print the membership requests from the arraylist
            int option = DartController.intInput("Enter 1 to accept, 2 to reject");// using dartcontroller int input method
            if(option == 1) {
                if (membershipRequests.get(i) instanceof Customer) { //to check if customer is not member already
                    for (int j = 0; j < customers.size(); j++) { //to iterate through the arraylist of customer
                        if (membershipRequests.get(i).getId() == customers.get(j).getId() && customers.get(i) instanceof Customer) { //to check
                            Customer silverMember = new SilverMember(customers.get(i).getId(), customers.get(i).getName()); //polymorphism?
                            customers.remove(customers.get(j)); //to remove it from customer arraylist
                            customers.add(silverMember); //to make customer to silver member
                            membershipRequests.remove(membershipRequests.get(i)); //to remove membership request from the array???
                            System.out.println("The membership request is approved by you");
                            break;
                        }
                    }
                } else if (membershipRequests.get(i) instanceof SilverMember) {
                    for (int j = 0; j < customers.size(); j++) {
                        if (membershipRequests.get(i).getId() == customers.get(j).getId() && customers.get(i) instanceof SilverMember) {
                            Customer goldMember = new GoldMember(customers.get(i).getId(), customers.get(i).getName());//polymorphism??
                            customers.remove(customers.get(j));
                            customers.add(goldMember);
                            membershipRequests.remove(membershipRequests.get(i));
                            System.out.println("The membership request is approved by you");
                            break;
                        }
                    }

                } else if (membershipRequests.get(i) instanceof GoldMember) {
                    for (int j = 0; j < customers.size(); j++) {
                        if (membershipRequests.get(i).getId() == customers.get(j).getId() && customers.get(i) instanceof GoldMember) {
                            Customer platinumMember = new PlatinumMember(customers.get(i).getId(), customers.get(i).getName()); //polymorphism??
                            customers.remove(customers.get(j));
                            customers.add(platinumMember);
                            membershipRequests.remove(membershipRequests.get(i));
                            System.out.println("The membership request is approved by you");
                            break;
                        }
                    }

                } else {
                    System.out.println("This customer is already a platinum member");
                }
            }
        }

    }

}
