import java.util.List;

public interface CSVImportExport {

    void importuotiIsCSV(String path);
    void eksportuotiICSV(List<Produktas> produktai, String path);
    void pridetiProduktaICSV(Produktas produktas);
    void pašalintiProduktaIsCSV(Produktas produktas);
}
