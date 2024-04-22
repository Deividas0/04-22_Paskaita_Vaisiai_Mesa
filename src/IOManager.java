import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class IOManager {
    //Produktas produktas = new Produktas();
    CSVImportExportImpl CSVimpl = new CSVImportExportImpl();


    public void CSVImportExportImpl(List<Produktas> produktaiList) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Pasirinkite veiksmą: ");
        System.out.println("1. Pridėti produktą prie sąrašo. ");
        System.out.println("2. Pašalinti produktą iš sąrašo. ");
        System.out.println("3. Patikrinti produktų sąrašą. ");

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
        }


    }

}
