import java.util.*;

class Employee implements Comparable<Employee>{
    int id;
    String name;
    String department;
    double salary;
    Employee(int id, String name, String department, double salary){
        this.id =id;
        this.department = department;
        this.salary = salary;
        this.name = name;
    }
    public String toString(){
        return id + " " + name +  " "+ department + " " + salary; 
    }
    public int compareTo(Employee em){
        return Double.compare(em.salary, this.salary);
    }
    static class departmentNameSalaryComparator implements Comparator<Employee>{
        public int compare(Employee e1, Employee e2){
            int cmp = e1.department.compareTo(e2.department);
            if (cmp != 0) return cmp;
            cmp = e1.name.compareTo(e2.name);
            if (cmp !=0) return cmp;
            return Double.compare(e1.salary, e2.salary);
        }
    }
}
public class Employeee {
    public static void main(String[] args){
        List <Employee> employeeList =  new ArrayList<>();
        employeeList.add(new Employee(1,"Ritik","Sales",32000));
        employeeList.add(new Employee(2,"Shravak","IT",32000));
        employeeList.add(new Employee(3,"Chanchal", "Teaching", 20000));
        employeeList.add(new Employee(4,"Kuldeep", "Hr",25000));

        employeeList.sort(new Employee.departmentNameSalaryComparator());
        System.out.println("Sorted by Department, Name, Salary:");
        Iterator<Employee> it = employeeList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
        Collections.sort(employeeList);
        System.out.println("Sorted by Salary Descending:");
        it  = employeeList.iterator();
        while(it.hasNext()){
            System.out.println(it.next());
        }
    }
}