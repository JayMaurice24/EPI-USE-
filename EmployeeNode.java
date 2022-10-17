import java.util.*;

public class EmployeeNode<T>{

	public Employee data;
	public EmployeeNode<T> supervisor;
	public List<EmployeeNode<T>> subordinates;

	private List<EmployeeNode<T>> elementsIndex;

	public EmployeeNode(Employee emp) {
		this.data = emp;
		this.subordinates = new LinkedList<EmployeeNode<T>>();
		this.elementsIndex = new LinkedList<EmployeeNode<T>>();
		this.elementsIndex.add(this);
	}

	public EmployeeNode<T> addSubordinate(Employee newSub) {
		EmployeeNode<T> sub = new EmployeeNode<T>(newSub);
		sub.supervisor = this;
		this.subordinates.add(sub);
		return sub;
	}
    public boolean isManager() {
        if (subordinates.size() > 0){
            return true;
        }
        else{
            return false;
        }
	}
    public boolean isRoot() {
		return supervisor == null;
	}
}