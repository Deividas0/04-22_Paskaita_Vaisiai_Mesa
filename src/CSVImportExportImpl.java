import java.util.List;

public class CSVImportExportImpl implements CSVImportExport {
    public String path = "C:/MokymoDarbai/autolistas.txt";
    //    public String outputFilePath = "C:/MokymoDarbai/autolistas.txt";
    //    FileReader fileReader = new FileReader(outputFilePath);
    //    BufferedReader bufferedReader = new BufferedReader(fileReader);


    @Override
    public void importuotiIsCSV(String path) {
                                                 // iš failo atspausdinti sąraša.
    }

    @Override
    public void eksportuotiICSV(List<Produktas> produktai, String path) {
                                                 //iš listo atgal į failą.
    }

    @Override
    public void pridetiProduktaICSV(Produktas produktas) {

    }

    @Override
    public void pašalintiProduktaIsCSV(Produktas produktas) {

    }
}
