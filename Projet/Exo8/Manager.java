public class Manager implements Employee{
    private String name;
    private String lastName;

    public Manager(String nom, String lastName) {
        this.name = nom;
        this.lastName = lastName;
    }

    @Override
    public void showdetail() {
        String grade = "manager";
        System.out.println("Name: " + this.name+ " Lastname: " + this.lastName + " Grade: " + grade);
    }
}
