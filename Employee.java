public class Employee{
    private String name;
    private String surname;
    private String dateOfBirth;
    private int employeeNum;
    private double salary;
    private String position; 
    private int reportsTo; 

    public Employee(String name, String surname, String dob, int empNum, double salary, String position){
        this.name = name; 
        this.surname = surname;
        this.dateOfBirth = dob;
        this.employeeNum = empNum; 
        this.salary = salary;
        this.position = position; 
    }
    public String getName(){
        return this.name;
    }
    public String getSurame(){
        return this.surname;
    }
    public String getDOB(){
        return this.dateOfBirth;
    }
    public int getEmployeeNumber(){
        return this.employeeNum;
    }
    public String getPosition(){
        return this.position;
    }
    public double getSalary(){
        return this.salary;
    }
    public int getManager(){
        return this.reportsTo;
    }

    public void setPosition(String position){
        this.position = position; 
    }
    public void setSupervisor(int supervisor){
        this.reportsTo = supervisor; 
    }
    public void setSalary(double salary){
        this.salary = salary; 
    }
    public void setManager(int reportsTo){
        this.reportsTo = reportsTo; 
    }
}