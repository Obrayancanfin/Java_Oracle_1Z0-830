public class Mammal extends Animal {

    public Mammal(int id, String name, String species) {
        super(id, name, species);
    }

    @Override
    String getDetail() {
        return "id :"+this.getId()+" name :"+this.getName()+"species :"+this.getSpecies();
    }

}
