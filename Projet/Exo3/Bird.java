public class Bird extends Animal {

    private String canFly;

    public Bird( String name, String species, String canFly) {
        super(name, species);
        this.canFly = canFly;
    }

    @Override
    String getDetail() {
        return "id :"+this.getId()+" name :"+this.getName()+"species :"+this.getSpecies();
    }


    public String getCanFly() {
        return canFly;
    }

    public void setCanFly(String canFly) {
        this.canFly = canFly;
    }
    public void isCanFly() {
        System.out.println("l'oiseau peut voler : " + this.canFly);
    }
}
