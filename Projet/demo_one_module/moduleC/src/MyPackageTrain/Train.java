package MyPackageTrain;

public class Train {
    String model;
    int Annee;

    public Train(String model, int annee) {
        this.model = model;
        Annee = annee;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAnnee() {
        return Annee;
    }

    public void setAnnee(int annee) {
        Annee = annee;
    }

    @Override
    public String toString() {
        return model + " de " + Annee ;
    }
}

