package Week1.Person;

public class Employee extends Person {
    //Use protected when child needs to access fields
    protected String job;
    protected double salary;

    public Employee(String name, int age, String gender, String job, double salary) {
        //Every inheriting child constructor calls the parent class' constructor
        super(name, age, gender);
        this.job = job;
        this.salary = salary;
    }


}
