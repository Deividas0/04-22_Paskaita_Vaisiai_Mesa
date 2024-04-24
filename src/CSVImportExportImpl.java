import java.util.List;

public class CSVImportExportImpl implements CSVImportExport {
    public String path = "C:/MokymoDarbai/autolistas.txt";


    @Override
    public void importuotiIsCSV(String path) {
                                                 // iš lentynos perkelti į sandelį.
    }

    @Override
    public void eksportuotiICSV(List<Produktas> produktai, String path) {
                                                 //iš sandėlio į lentyną.
    }

    @Override
    public void pridetiProduktaICSV(Produktas produktas) {

    }

    @Override
    public void pašalintiProduktaIsCSV(Produktas produktas) {

    }
}
