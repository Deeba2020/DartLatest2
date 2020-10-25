import java.util.ArrayList;

public class Manager {

    //method
    public void addEmployee (Employee newemployee , ArrayList<Employee>employees){
        employees.add(newemployee);
        System.out.println("New employee has been added");
    }



    //method
    public void viewAllEmployee (ArrayList<Employee> employees) {
        for (int i = 0; i < employees.size(); i++) {
            System.out.println(employees.get(i).toString());
        }
    }

    //method
    public void removeEmployee (int id, ArrayList<Employee> employees){
        for(int i=0;i<employees.size();i++){
            if(employees.get(i).getId() == id){
                employees.remove(employees.get(i));
                System.out.println("Employee with ID "+id+" removed");
                return;
            }
        }
        System.out.println("Employee with the id not found");
    }


}
