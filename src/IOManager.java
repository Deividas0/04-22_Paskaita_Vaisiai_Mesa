import java.io.*;
import java.math.BigDecimal;
import java.math.RoundingMode;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IOManager {
    //Produktas produktas = new Produktas();
    CSVImportExportImpl CSVimpl = new CSVImportExportImpl();
    public String path = "C:/MokymoDarbai/Produktai.txt";
    BufferedWriter bw;
    BufferedReader br;
    List<Produktas> krepselis = new ArrayList<>();
    List<Produktas> spargalke = new ArrayList<>();

    public IOManager() throws IOException {
    }


    public void CSVImportExportImpl(List<Produktas> produktaiList) throws IOException {
        Scanner sc = new Scanner(System.in);
        bw = new BufferedWriter(new FileWriter(path, true));
        br = new BufferedReader(new FileReader(path));
        System.out.println("Pasirinkite veiksmą: ");
        System.out.println("1. Pridėti produktą prie sąrašo. ");
        System.out.println("2. Pašalinti produktą iš sąrašo. ");
        System.out.println("3. Patikrinti produktų sąrašą. ");
        System.out.println("4. Perkelti produktą į lentynąTXT.");
        System.out.println("5. Patikrinti lentynosTXT sąrašą.");
        System.out.println("6. Isidėti produktą į krepšelį.");
        System.out.println("7. Patikrinti prekių krepšelį.");

        switch (sc.nextInt()) {
            case 1:
                System.out.println("Pasirinkite produkto tipą: ");
                System.out.println("1. Vaisius || 2. Mėsa.");
                int prekesKodas = 0;
                String pavadinimas = null;
                double kaina = 0;
                LocalDate galiojimoData = null;
                switch (sc.nextInt()) {
                    case 1:
                        System.out.println("Įveskite prekės kodą: ");
                        prekesKodas = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Įveskite prekės pavadinimą: ");
                        pavadinimas = sc.nextLine();
                        System.out.println("Įveskite prekės kainą (0,00Eur): ");
                        kaina = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Prekę tinka vartoti iki: YYYY-MM-DD ");
                        galiojimoData = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        System.out.println("Ar vaisius yra ekologiškas?");
                        System.out.println("1. Taip || 2. Ne");
                        switch (sc.nextInt()) {
                            case 1:
                                produktaiList.add(new Vaisius(prekesKodas, pavadinimas, kaina, galiojimoData, true));
                                System.out.println("Produktas sėkmingai pridėtas prie sąrašo.");
                                System.out.println();
                                break;
                            case 2:
                                produktaiList.add(new Vaisius(prekesKodas, pavadinimas, kaina, galiojimoData, false));
                                System.out.println("Produktas sėkmingai pridėtas prie sąrašo.");
                                System.out.println();
                        }
                        CSVImportExportImpl(produktaiList);
                    case 2:
                        System.out.println("Įveskite prekės kodą: ");
                        prekesKodas = sc.nextInt();
                        sc.nextLine();
                        System.out.println("Įveskite prekės pavadinimą: ");
                        pavadinimas = sc.nextLine();
                        System.out.println("Įveskite prekės kainą (0,00Eur): ");
                        kaina = sc.nextDouble();
                        sc.nextLine();
                        System.out.println("Prekę tinka vartoti iki: YYYY-MM-DD ");
                        galiojimoData = LocalDate.parse(sc.nextLine(), DateTimeFormatter.ofPattern("yyyy-MM-dd"));
                        System.out.println("Įveskite mėsos rūšį: ");
                        String rusis = sc.nextLine();
                        System.out.println("Produktas sėkmingai pridėtas prie sąrašo.");
                        produktaiList.add(new Mėsa(prekesKodas, pavadinimas, kaina, galiojimoData, rusis));
                        break;
                }
                CSVImportExportImpl(produktaiList);
            case 2:
                System.out.println("Šiuo metu sąraše esantys produktai: ");
                int i = 1;
                for (Produktas a : produktaiList) {
                    System.out.println(i + ". Produkto ID: " + a);
                    i++;
                }
                System.out.println("Pasirinkite kurį produktą pašalinti iš sąrašo:  ");
                int delete = sc.nextInt();
                produktaiList.remove(delete - 1);
                System.out.println("Produktas sėkmingai pašalintas.");
                System.out.println("Likę produktai sąraše: ");
                for (Produktas a : produktaiList) {
                    System.out.println(i + ". Produkto ID: " + a);
                    i++;
                    System.out.println();
                    CSVImportExportImpl(produktaiList);
                }
            case 3:
                System.out.println("Produktų sąrašas: ");
                i = 1;
                for (Produktas a : produktaiList) {
                    System.out.println(i + ". Produkto ID: " + a);
                    i++;
                }


                System.out.println();
                CSVImportExportImpl(produktaiList);
            case 4:
                System.out.println("Pasirinkite produktą kurį norite perkelti į lentynąTXT: ");
                i = 1;
                for (Produktas a : produktaiList) {
                    System.out.println(i + ". Produkto ID: " + a);
                    i++;
                }
                try {
                    int pasirinkimas = sc.nextInt();
                    bw.write(produktaiList.get(pasirinkimas - 1).toCSV());
                    bw.newLine();
                    bw.flush();
                    produktaiList.remove(pasirinkimas - 1);
                } catch (Exception e) {
                    throw new RuntimeException(e);
                }
                System.out.println("Produktas sėkmingai perkeltas į lentyną.");
                CSVImportExportImpl(produktaiList);
            case 5:
                System.out.println("Šiuo metu lentynojeTXT yra šie produktai: ");
                String line;
                while ((line = br.readLine()) != null) {
                    System.out.println(line);
                    String[] lineValues = line.split(",");
                    lineValues = lineValues;
                }
                System.out.println();
                CSVImportExportImpl(produktaiList);
            case 6:
                spargalke = new ArrayList<>();
                System.out.println("Pasirinkite produkto ID kurį norite isidėti į krepšelį: ");
                while ((line = br.readLine()) != null) {
                    System.out.println("Produkto ID: " + line);
                    String[] lineValues = line.split(",");
                    if (lineValues[4].equalsIgnoreCase("true") || lineValues[4].equalsIgnoreCase("false")) {

                        spargalke.add(new Vaisius(Integer.parseInt(lineValues[0]), String.valueOf(lineValues[1]), Double.parseDouble(lineValues[2]), LocalDate.parse(lineValues[3]), Boolean.parseBoolean(lineValues[4])));
                    } else {
                        spargalke.add(new Mėsa(Integer.parseInt(lineValues[0]), String.valueOf(lineValues[1]), Double.parseDouble(lineValues[2]), LocalDate.parse(lineValues[3]), lineValues[4]));
                    }
                }
                int pasirinkimas = sc.nextInt();

                krepselis.add(spargalke.get(pasirinkimas - 1));  // issikelti objekta pagal ID priskirti jy kintamajam
                System.out.println();
                CSVImportExportImpl(produktaiList);
            case 7:
                System.out.println("Jūsų pirkinių krepšelyje esantys produktai: ");
                i = 1;
                double suma = 0;
                BigDecimal bd = null;
                for (Produktas a : krepselis) {
                    System.out.println(i + ". Produkto ID: " + a);
                    i++;
                    suma += a.getKaina();
                    bd = BigDecimal.valueOf(a.getKaina());
                    bd = bd.setScale(2, RoundingMode.UP);
                    bd = BigDecimal.valueOf(suma);
                }
                System.out.println();
                System.out.println("Bendra pirkinių suma: " + bd + "Eur. ");

        }
        System.out.println();
        CSVImportExportImpl(produktaiList);

    }
}





