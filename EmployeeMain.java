import java.util.*;
public class EmployeeMain{
    private static EmployeeNode<Employee> top;

 public static void main(String [] args){
    Scanner in = new Scanner(System.in);
    boolean run = true;
    while(run){
    System.out.println("Good day, what would you like to do? (select a number) \n [1] Add New employee \n [2] Search an Employee \n [3] Delete An Employee \n [4] View Organisation Hierarchy \n [5] Quit");
    int option = in.nextInt();
    switch(option){
        case 1:
            addEmployee();
        case 2:
            deleteEmployee();
        case 3:
            findEmployee();
        case 4:
            showHierarchy();
        case 5: 
            run = false;
    }
}
   
 }

 public static void addEmployee(){
    Scanner in = new Scanner(System.in);
    System.out.println("Enter Employee Name");
    String name = in.nextLine();

    System.out.println("Enter Employee Surname");
    String surname = in.nextLine();

    System.out.println("Enter Employee date of birth in format dd/mm/yyyy");
    String dob = in.nextLine();

    System.out.println("Enter Employee Number");
    int eNum = in.nextInt();

    System.out.println("Enter Employee's Role/position");
    String pos = in.nextLine();

    System.out.println("Enter Employee Salary");
    double sal = in.nextDouble();

    System.out.println("Enter Employee Supervisor's Employee number (enter 0 if employee has no supervisor)");
    int supervisor = in.nextInt();
    if(supervisor == 0){
        Employee root = new Employee(name, surname, dob, eNum, sal, pos);
        top = new EmployeeNode<Employee>(root);
    }
    else{
        Employee newEmployee = new Employee(name, surname, dob, eNum, sal, pos);
        newEmployee.setSupervisor(supervisor);
        EmployeeNode<Employee> manager = search(supervisor, top);
        manager.addSubordinate(newEmployee);
    }
  

 }
public static String findEmployee(){
    return "name";
}
public static void deleteEmployee(){
}
public static void showHierarchy(){
}


 public static EmployeeNode<Employee> search (int empNumber, EmployeeNode<Employee> root) {
    final Queue<EmployeeNode<Employee>> employeeQueue = new LinkedList<EmployeeNode<Employee>>();
    employeeQueue.add(top);
    while (!employeeQueue.isEmpty()) {
        final EmployeeNode<Employee> node = employeeQueue.poll();
        Employee e = node.data;
        int empNum = e.getEmployeeNumber();
        if (empNum == empNumber){
            return node;
        }
        for (EmployeeNode<Employee> current : node.subordinates) {
            Employee curr = current.data;
            int eNum = curr.getEmployeeNumber();
            if (eNum == empNumber){
                return node;
            }
            else if (current.isManager()) {
                employeeQueue.add(current);
            }
        }
    }
    return null;
}
 
 
}