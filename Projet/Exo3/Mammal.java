public class Mammal extends Animal {

    public Mammal(int id, String name, String species) {
        super(name, species);
    }

    @Override
    String getDetail() {
        return "id :"+this.getId()+" name :"+this.getName()+"species :"+this.getSpecies();
    }

}
