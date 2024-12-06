public class Employees implements Employee{
    String name;
    String lastName;
    String grade = "employee";

    public Employees(String lastName, String name) {
        this.lastName = lastName;
        this.name = name;
    }

    @Override
    public void showdetail() {
        System.out.println("Name: " + name+ " LastName: " + lastName + " Grade: " + grade);
    }
}
