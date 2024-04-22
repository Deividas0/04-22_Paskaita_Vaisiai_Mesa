import java.time.LocalDate;

public class Mėsa extends Produktas{
    String rusis;

    public Mėsa(int prekesKodas, String pavadinimas, double kaina, LocalDate galiojimoData, String rusis){
        this.prekesKodas = prekesKodas;
        this.pavadinimas = pavadinimas;
        this.kaina = kaina;
        this.galiojimoData = galiojimoData;
        this.rusis = rusis;
    }
    public String getRusis() {return rusis;}
    public void setRusis(String rusis) {this.rusis = rusis;}

    @Override
    public String toString(){
        return getPrekesKodas() + " " + getPavadinimas() + " " + getKaina() + " " + getGaliojimoData() + " " + rusis;
    }
    private String toCSV(){
        return getPrekesKodas() + "," + getPavadinimas() + "," + getKaina() + "," + getGaliojimoData() + "," + rusis;
    }
}
