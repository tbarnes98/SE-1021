package Week1.Person;

public class FullTime extends Employee{
    private String benefits;

    public FullTime(String name, int age, String gender, String job, double salary, String benefits) {
        super(name, age, gender, job, salary);
        this.benefits = benefits;

    }

    public double getSalary() {
        return super.salary;
    }
}
