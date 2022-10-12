package be.ucll.favorietefilms;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.List;
import java.util.Scanner;

@SpringBootApplication
public class FavorieteFilmsApplication {
    public static void main(String[] args) {
        SpringApplication.run(FavorieteFilmsApplication.class, args);
    }}

        /*  Lijn 17 t.e.m. 19 commenten + lij 21 t.e.m. 141 uncommenten
            Dit zorgt voor een 'console-application' dat gegevens kan toevoegen in de databank.*/


//    private static FilmRepository filmRepository = new FilmRepository();
//
//    public static void main(String[] args) {
//        boolean stop = false;
//
//        do {
//            System.out.println();
//            System.out.println("Beheer films:");
//            System.out.println("================");
//            System.out.println("a) Film toevoegen");
//            System.out.println("b) Lijst van films");
//            System.out.println("c) Films opzoeken d.m.v. titel");
//            System.out.println("d) Film wijzigen");
////            System.out.println("e) Film verwijderen");
//            System.out.println("z) Stop");
//            System.out.print("Keuze: ");
//            String keuze = new Scanner(System.in).nextLine();
//
//            switch (keuze) {
//                case "a":
//                    System.out.println();
//                    System.out.println("Film toevoegen:");
//                    System.out.println("==================");
//                    System.out.print("Titel: ");
//                    String titleInsert = new Scanner(System.in).nextLine();
//                    System.out.print("Publicatiejaar: ");
//                    int yearInsert = new Scanner(System.in).nextInt();
//                    System.out.print("Persoonlijke score (0-10): ");
//                    int scoreInsert = new Scanner(System.in).nextInt();
//                    while (scoreInsert < 0 || scoreInsert > 10){
//                        System.out.println("Score moet tussen 0 en 10 zitten! Probeer opnieuw:");
//                        scoreInsert = new Scanner(System.in).nextInt();
//                    }
//                    System.out.print("Review: ");
//                    String reviewInsert = new Scanner(System.in).nextLine();
//                    boolean hasRowBeenInserted = filmRepository.insert(titleInsert, yearInsert, scoreInsert, reviewInsert);
//                    if (hasRowBeenInserted) {
//                        System.out.println("Film toegevoegd!");
//                    } else {
//                        System.out.println("Deze film kon NIET worden toegevoegd.");
//                    }
//                    break;
//
//                case "b":
//                    System.out.println();
//                    System.out.println("Lijst van films:");
//                    System.out.println("===================");
//                    List<String> allFilms = filmRepository.getAllFilms();
//                    allFilms.forEach(x -> System.out.println(x));
//                    break;
//
//                case "c":
//                    System.out.println();
//                    System.out.println("Films opzoeken d.m.v. titel:");
//                    System.out.println("=====================================================");
//                    List<String> allFilmsBy;
//                    String titleSearch = "";
//                    do {
//                        System.out.print("Titel: ");
//                        titleSearch = new Scanner(System.in).nextLine();
//                    } while (titleSearch.isBlank());
//                    allFilmsBy = filmRepository.getByTitle(titleSearch);
//                    allFilmsBy.forEach(x -> System.out.println(x));
//                    break;
//
//                case "d":
//                    System.out.println();
//                    System.out.println("Film wijzigen:");
//                    System.out.println("=================");
//                    System.out.print("Titel: ");
//                    String titleUpdate = new Scanner(System.in).nextLine();
//                    System.out.print("Publicatiejaar: ");
//                    int yearUpdate = new Scanner(System.in).nextInt();
//                    System.out.print("Persoonlijke score (0-10): ");
//                    int scoreUpdate = new Scanner(System.in).nextInt();
//                    while (scoreUpdate < 0 || scoreUpdate > 10){
//                        System.out.println("Score moet tussen 0 en 10 zitten! Probeer opnieuw:");
//                        scoreUpdate = new Scanner(System.in).nextInt();
//                    }
//                    System.out.print("Review: ");
//                    String reviewUpdate = new Scanner(System.in).nextLine();
//                    boolean hasRowBeenUpdated = filmRepository.update(/*Long.valueOf(idToBeUpdated), */titleUpdate, yearUpdate, scoreUpdate, reviewUpdate);
//                    if (hasRowBeenUpdated) {
//                        System.out.println("Wijzigen gelukt!");
//                    } else {
//                        System.out.println("Wijzigen NIET gelukt!");
//                    }
//                    break;
//
////                case "e":
////                    System.out.println();
////                    System.out.println("Films verwijderen:");
////                    System.out.println("====================");
////                    String idToBeDeleted = "";
////                    do {
////                        System.out.print("ID: ");
////                        idToBeDeleted = new Scanner(System.in).nextLine();
////                    } while (!isIdValid(idToBeDeleted));
////                    boolean hasRowBeenDeleted = filmRepository.delete(Long.valueOf(idToBeDeleted));
////                    if (hasRowBeenDeleted) {
////                        System.out.println("Verwijderen gelukt!");
////                    } else {
////                        System.out.println("Verwijderen NIET gelukt!");
////                    }
////                    break;
//
//                case "z":
//                    stop = true;
//                    break;
//                default:
//                    System.out.println();
//                    System.out.println("Keuze bestaat niet!");
//                    break;
//            }
//        } while (!stop);
//    }
//}