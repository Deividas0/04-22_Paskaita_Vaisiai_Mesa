import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Produktas> produktaiList = new ArrayList<>();
        IOManager ioManager = new IOManager();
        ioManager.CSVImportExportImpl(produktaiList);
    }
}