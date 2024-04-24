import java.time.LocalDate;

public class Vaisius extends Produktas{
    boolean arEkologiskas;

    public Vaisius(int prekesKodas, String pavadinimas, double kaina, LocalDate galiojimoData, boolean arEkologiskas){
        this.prekesKodas = prekesKodas;
        this.pavadinimas = pavadinimas;
        this.kaina = kaina;
        this.galiojimoData = galiojimoData;
        this.arEkologiskas = arEkologiskas;
    }


    public boolean getArEkologiskas() {return arEkologiskas;}
    public void setArEkologiskas(boolean arEkologiskas) {this.arEkologiskas = arEkologiskas;}

    @Override
    public String toString(){
        return getPrekesKodas() + " " + getPavadinimas() + " " + getKaina() + " " + getGaliojimoData() + " " + arEkologiskas;
    }

    public String toCSV(){
        return getPrekesKodas() + "," + getPavadinimas() + "," + getKaina() + "," + getGaliojimoData() + "," + arEkologiskas;
    }
}
