import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        MediaLibrary bibliothek = new MediaLibrary();

        CD cd1 = new CD("Lungs", "Debut album", "Florence and the Machine", 13, 46, 15);

        System.out.println(" 1. TEST EXCEPTION HANDLING \n");

        // PRUEBA 1: Añadir elemento correctamente
        try {
            bibliothek.addMedium(cd1);
            System.out.println("CD erfolgreich hinzugefügt: " + cd1.getTitle());
        } catch (MediaLibraryException e) {
            System.err.println("Gefangene Exception: " + e.getMessage());
        }

        // PRUEBA 2: Intentar añadir el MISMO elemento (Debe lanzar la excepción)
        try {
            System.out.println("\nVersuche, 'Lungs' erneut einzufügen...");
            bibliothek.addMedium(cd1);
        } catch (MediaLibraryException e) {
            System.err.println("Gefangene Exception: " + e.getMessage());
        }

        // PRUEBA 3: Intentar añadir un objeto null (Debe lanzar la excepción)
        try {
            System.out.println("\nVersuche, 'null' einzufügen...");
            bibliothek.addMedium(null);
        } catch (MediaLibraryException e) {
            System.err.println("Gefangene Exception: " + e.getMessage());
        }

        // PRUEBA 4: Intentar borrar un medio que NO está en la biblioteca
        try {
            CD cdDesconocido = new CD("Unbekannt", "", "Künstler", 10, 30, 10);
            System.out.println("\nVersuche, unbekanntes Medium zu löschen...");
            bibliothek.removeMedium(cdDesconocido);
        } catch (MediaLibraryException e) {
            System.err.println("Gefangene Exception: " + e.getMessage());
        }

        System.out.println("\n--- Exception-Tests erfolgreich. Das Programm läuft normal weiter! ---\n");

        System.out.println(" 2. TEST MEDIALIBRARY OPERATIONEN \n");

        CD cd2 = new CD("Born to Die", "Deluxe", "Lana Del Rey", 15, 60, 18);
        CD cd3 = new CD("Narrow", "EP", "Soap&Skin", 8, 32, 12);

        DVD dvd1 = new DVD("Nosferatu", "Stummfilm Klassiker", "F.W. Murnau", 94, true, 20);
        DVD dvd2 = new DVD("Der Teufel trägt Prada", "Komödie", "David Frankel", 109, false, 10);
        DVD dvd3 = new DVD("Frankenstein", "Horror Klassiker", "James Whale", 71, true, 15);

        // Añadir los demás elementos envolviéndolos en try-catch
        // (cd1 ya está en la biblioteca desde la Prueba 1)
        try {
            bibliothek.addMedium(cd2);
            bibliothek.addMedium(cd3);
            bibliothek.addMedium(dvd1);
            bibliothek.addMedium(dvd2);
        } catch (MediaLibraryException e) {
            System.err.println("Fehler beim Hinzufügen: " + e.getMessage());
        }

        // Mostrar información general de la biblioteca
        bibliothek.showInfo();

        // Calcular totales (Polimorfismo en acción)
        System.out.println("\nGesamte Spielzeit: " + bibliothek.playingTime() + " Minuten");
        System.out.println("Gesamter Wert: " + bibliothek.moneyValue() + " EUR");

        // Borrar un medio individual
        try {
            System.out.println("\nEntferne DVD 'Der Teufel trägt Prada'...");
            bibliothek.removeMedium(dvd2);
            System.out.println("Neuer Wert nach dem Löschen: " + bibliothek.moneyValue() + " EUR");
        } catch (MediaLibraryException e) {
            System.err.println("Fehler beim Löschen: " + e.getMessage());
        }

        // Borrar una lista de medios
        try {
            System.out.println("\nVersuche, eine Liste von Medien zu entfernen...");
            ArrayList<Medium> toRemoveList = new ArrayList<>();
            toRemoveList.add(cd1);  // Sí está en la biblioteca
            toRemoveList.add(dvd3); // NO está en la biblioteca (nunca se añadió)

            ArrayList<Medium> notFound = bibliothek.removeMedia(toRemoveList);

            System.out.println("\nMedien, die nicht in der Bibliothek gefunden wurden:");
            for (Medium m : notFound) {
                System.out.println("- " + m.getTitle()); // Imprime Frankenstein
            }
        } catch (MediaLibraryException e) {
            System.err.println("Fehler beim Entfernen der Liste: " + e.getMessage());
        }
    }
}