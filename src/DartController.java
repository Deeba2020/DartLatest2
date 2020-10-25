import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class DartController {

     //creating ob of arraylist (for different class) to store customers,games,employees in array. (Composition)
    ArrayList<Customer> customers = new ArrayList<Customer>(); //(Composition)
    ArrayList<Item> items = new ArrayList<Item>(); // generic arraylist for both game/song (Composition)
    ArrayList<Employee> employees = new ArrayList<Employee>(); //(Composition)
    ArrayList<Customer> membershipRequests = new ArrayList<Customer>(); //generic arraylist for gold/silver/platinum (Composition)

    //method for string input
    public static String stringInput(String Message){
        Scanner input = new Scanner (System.in);
        System.out.println(Message);
        String userInput = input.nextLine();
        return userInput;
    }

    //method for integer input
    public static int intInput(String Message) {
        Scanner input = new Scanner(System.in);
        System.out.println(Message);
        int userInput = input.nextInt();
        input.nextLine();
        return userInput;
    }

    //method for main menu
    public void  mainMenu(){
        System.out.println("Main Menu");
        System.out.println("Welcome to DART, your good old game rental system. The competition has no steam to keep up! ");
        System.out.println("Please specify your role by entering one of the options given:");
        System.out.println("1. Enter “M” for Manager");
        System.out.println("2. Enter “E” for Employee");
        System.out.println("3. Enter “C” for Customer");
        System.out.println("4. Enter “X” to exit system");
    }

    //method for manager menu
    public void  managerMenu() {
        System.out.println("Manager Screen - Type one of the options below:");
        System.out.println("1. Add an employee");
        System.out.println("2. Remove an employee");
        System.out.println("3. View all employees");
        System.out.println("4. Return to Main Menu");
    }

//method for employee menu

    public void  employeeMenu() {
        System.out.println("Employee Screen - Type one of the options below:");
        System.out.println("1. Register a game");
        System.out.println("2. Remove a game");
        System.out.println("3. Register a customer");
        System.out.println("4. Remove a customer");
        System.out.println("5. Show total rent profit");
        System.out.println("6. View all games");
        System.out.println("7. View all customers");
        System.out.println("8. Register a song");
        System.out.println("9. Remove a song");
        System.out.println("10. View all songs");
        System.out.println("11. View and approve membership requests");
        System.out.println("12. Return to Main Menu");
    }

//method for customer menu
    public void  customerMenu() {
        System.out.println(" Customer Screen - Type one of the options below:");
        System.out.println("1. Rent a game");
        System.out.println("2. Return a game");
        System.out.println("3. View all games");
        System.out.println("4. Rent a song");
        System.out.println("5. Return a song");
        System.out.println("6. View all songs");
        System.out.println("7. Apply or upgrade membership");
        System.out.println("8. Send a message");
        System.out.println("9. View all messages");
        System.out.println("10. Return to Main Menu");
    }

    //method for main
    public void DartMain(){
        mainMenu(); //main menu method
        String input =  stringInput(""); //user to enter input the choice
        while(!input.equals("X")){ //to evaluate cond. ..execute // cond. to check the input not x
            switch (input){  //for different option
                case "M":{
                    String password = stringInput("Please enter password");
                    if(password.equals("admin1234")){ //check cond. for password
                        managerMenu(); //calling manager menu method
                        Manager m = new Manager(); //create obj for class manager to use its related method //declare reference=create obj and tie them together
                        int option = intInput("");
                        if(option ==1) { //if option 1
                            int Id = intInput("Please enter the id of the new employee");
                            String name = stringInput ("Please enter the name of the new employee");
                            String address = stringInput ("Please enter the address of the new employee");
                            int birthYear = intInput("Please enter the birth year of the new employee");
                            int salary = intInput("Please enter the salary of the new employee");
                            Employee e = new Employee(Id ,name ,address,birthYear,salary); //creating obj of class employee to access its constructor
                            m.addEmployee(e,employees); //using addEmployee method from manager class

                        }
                        else if(option ==2){ //option 2 to remove employee
                            int ID = intInput("Enter the ID of employee you want to remove:");
                            m.removeEmployee(ID,employees); //remove employee method from manager class
                        }
                        else if (option == 3){ //option 3 to view employee
                            m.viewAllEmployee(employees);
                        }
                        else {
                        }
                        break; //to come out of loop
                    }
                }
                case "E":{ //for employee menu
                    String password = stringInput("Please enter password");
                    if(password.equals("password123")) {
                        employeeMenu(); //employee menu method
                        Employee e = new Employee(); //declare reference=create obj and tie them together
                        int option = intInput(""); //to enter int option
                        if (option == 1) { //to add new game

                            int Id = intInput("Please enter the id of the new game");
                            String title = stringInput("Please enter the name of the new game");
                            String genre = stringInput("Please enter the genre of the new game");
                            int dailyRent = intInput("Please enter the daily rent of the new game");
                            Item a = new Game(Id, title, genre, dailyRent); //Super class reference, sub-class object type = Polymorphism allows type reference to be matched to type of obj.
                            e.addGame(a, items);//employee to add game, e employee obj. addgame method in employee
                        }
                        else if (option == 2) { //to remove game by employee
                            int ID = intInput("Enter the ID of game you want to remove:");
                            e.removeGame(ID, items); //obj of employee and remove game method
                        }
                        else if (option == 3) { //to add new customer
                            int id = intInput("Please enter the id of the new customer");
                            String name = stringInput("Please enter the name of the new customer");
                            Customer c = new Customer(name, id); //declare reference=create obj and tie them together
                            e.addCustomer(c, customers); //employee obj, addcustomer method, add to customer arraylist
                        }
                        else if (option == 4) { //employee to remove customer
                            int ID = intInput("Enter the ID of customer you want to remove:");
                            e.removeCustomer(ID, customers); //employee obj , remove customer method , remove it from customer arraylist

                        }
                        else if (option == 5) {

                        }
                        else if (option == 6) { //employee to view all games from items arraylist
                            e.viewAllGames(items);
                        }
                        else if (option == 7) { //employee to view all customer
                            e.viewAllCustomers(customers);
                        }
                        else if (option == 8) { //employee to add new song

                            int ID = intInput("Please enter the id of the new song");
                            String title = stringInput("Please enter the name of the new song");
                            String artist = stringInput("Please enter the artist of the new song");
                            int releaseYear = intInput("Please enter the release year of the new song");
                            int dailyRent = intInput("Please enter the daily rent of the new song");
                            Item s = new Song (ID ,title ,artist ,releaseYear,dailyRent); //Polymorphism
                            e.addSong(s, items);
                        }

                        else if (option == 9) { //employee to remove song
                            int ID = intInput("Enter the ID of song you want to remove:");
                            e.removeSong(ID, items);
                        }
                        else if (option == 10) { //employee to view all songs
                            e.viewAllSongs(items);
                        }
                        else if (option == 11) { //employee to approve customer membership requests
                            e.approveMemberships(membershipRequests, customers);
                        }


                        else {

                        }
                        break; //to come out of the loop
                    }
                }


                case "C":{  //customer menu
                    int customerID = intInput("Please enter your ID");

                    Customer c = null; //to check if customer not registered to come out of the loop
                    for(int i=0;i<customers.size();i++){
                        if(customers.get(i).getId() == customerID){
                            c = customers.get(i);
                            break;
                        }
                    }

                    if(c != null){ //if customer already registered then show customer menu

                        customerMenu();
                        int option = intInput("");
                        if(option ==1) { //option 1 customer to rent a game
                            int id = intInput("Please enter the id of the game you wish to rent");
                            for(int i = 0;i<items.size();i++){ //to iterate through the arraylist of item
                                if(items.get(i).getID() == id && items.get(i) instanceof Game){ //make sure the item is game
                                    int days= intInput("How many days do you want the game to rent for");
                                    c.rentGame((Game) items.get(i),days); //customer to rent game
                                }
                            }
                        }
                        else if(option ==2){ //customer to return a game
                            int id = intInput("Please enter the id of the game you wish to return");
                            for(int i = 0;i<items.size();i++){
                                if(items.get(i).getID() == id && items.get(i) instanceof Game){
                                    c.returnGame((Game) items.get(i));
                                }
                            }
                        }
                        else if (option ==3) { //customer to view all games
                            c.viewAllGames(items);

                        }

                        else if(option ==4) { //customer to rent a song
                            int id = intInput("Please enter the id of the song you wish to rent");
                            for(int i = 0;i< items.size();i++){
                                if(items.get(i).getID() == id && items.get(i) instanceof Song){
                                    int days= intInput("How many days do you want the song to rent for");
                                    c.rentSong( (Song) items.get(i),days);
                                }
                            }
                        }

                        else if(option ==5){ //customer to return a song
                            int id = intInput("Please enter the id of the song you wish to return");
                            for(int i = 0;i<items.size();i++){
                                if(items.get(i).getID() == id && items.get(i)instanceof Song){
                                    c.returnSong((Song) items.get(i));
                                }
                            }
                        }

                        else if (option ==6){ //customer to view all songs
                            c.viewAllSongs(items);
                        }
                        else if (option ==7){ //customer to apply for membership
                            c.applyMembership(membershipRequests);
                        }
                        else if(option ==8){ //customer to send the message
                            int recieverID = intInput("Enter the ID of the recipient");
                            for(int k=0;k<customers.size();k++){
                                if(customers.get(k).getId() == recieverID){
                                    String content = stringInput("Please enter the message");
                                    Message newMessage = new Message(c,content);
                                    c.sendMessage(customers.get(k),newMessage);
                                }
                            }
                        }
                        else if(option == 9){
                                c.viewMessages();
                        }
                    }
                    else{
                        System.out.println("Customer with entered ID not found");
                    }
                    break;
                }
            }
            mainMenu();
            input = stringInput("");
        }


    }

    public static void main(String[] args) {

        DartController obj = new DartController();
        obj.DartMain();
    }
}