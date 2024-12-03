public abstract class Animal {
    int id ;
    String name ;
    String species ;

    public Animal(String name, String species) {
        this.id = ZooManager.animalsList.size()+1;
        this.name = name;
        this.species = species;
        ZooManager.animalsList.add(this);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    abstract String getDetail();
}
