import java.time.LocalDate;

public class Produktas {
    int prekesKodas;
    String pavadinimas;
    double kaina;
    LocalDate galiojimoData;

    public void produktas(int prekesKodas, String pavadinimas, double kaina, LocalDate galiojimoData){
        this.prekesKodas = prekesKodas;
        this.pavadinimas = pavadinimas;
        this.kaina = kaina;
        this.galiojimoData = galiojimoData;
    }
    public void produktas(){

    }

    public int getPrekesKodas() {return prekesKodas;}
    public String getPavadinimas() {return pavadinimas;}
    public double getKaina() {return kaina;}
    public LocalDate getGaliojimoData() {return galiojimoData;}

    public void setPrekesKodas(int prekesKodas) {this.prekesKodas = prekesKodas;}
    public void setPavadinimas(String pavadinimas) {this.pavadinimas = pavadinimas;}
    public void setKaina(double kaina) {this.kaina = kaina;}
    public void setGaliojimoData(LocalDate galiojimoData) {this.galiojimoData = galiojimoData;}

    @Override
    public String toString(){
        return getPrekesKodas() + " " + getPavadinimas() + " " + getKaina() + " " + getGaliojimoData();
    }
}
