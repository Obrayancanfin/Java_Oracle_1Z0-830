public class Main {
    public static void main(String[] args) {
        Employee employee1 = new Employees("Jean","tallus");
        Employee employee2 = new Employees("Jean","Cérien");

        Manager manager = new Manager("Thomas","Toketchup");
        Manager manager1 = new Manager("Thom","Egerie");

        manager.showdetail();
        manager1.showdetail();
        employee1.showdetail();
        manager1.showdetail();
    }
}
