package Week1;


import Week1.Person.*;

public class Inheritance {

    //Object Methods
    //  @Override
    //  public String toString()
    //  public boolean equals(Object o)
    //      Overload -> public boolean equals (String s)
    //
    //  Anything the parent/super class has the child/sub class also has.
    //      -Used to reduce code. Prevents redundant code
    //
    public static void main(String[] args) {
        FullTime ft = new FullTime("Sean", 98, "male", "professor", 5000, "none");
        System.out.println(ft.getName());
        System.out.println(ft.getSalary());

        Person p = new Employee("Sean", 98, "male", "professor", 5000);
    }
}
