import java.util.ArrayList;

public class MediaLibrary {
    private ArrayList<Medium> media;

    public MediaLibrary() {
        this.media = new ArrayList<>();
    }

    /*public void addMedium(Medium medium) {
        if (medium != null && !media.contains(medium)) {
            media.add(medium);
        }
    }*/

    public void addMedium(Medium medium) throws MediaLibraryException { // 1. Validar al añadir un medio
        if (medium == null) {
            throw new MediaLibraryException("Fehler: Das Medium darf nicht null sein!");
        }
        if (media.contains(medium)) {
            throw new MediaLibraryException("Fehler: Das Medium '" + medium.getTitle() + "' ist bereits vorhanden!");
        }
        media.add(medium);
    }

    /*public void removeMedium(Medium medium) {
        if (medium != null && media.contains(medium)) {
            media.remove(medium);
        }
    }*/

    public void removeMedium(Medium medium) throws MediaLibraryException {// 2. Validar al eliminar un medio
        if (medium == null) {
            throw new MediaLibraryException("Fehler: Das zu entfernende Medium darf nicht null sein!");
        }
        if (!media.contains(medium)) {
            throw new MediaLibraryException("Fehler: Das Medium '" + medium.getTitle() + "' existiert nicht in der Bibliothek!");
        }
        media.remove(medium);
    }

    public ArrayList<Medium> removeMedia(ArrayList<Medium> mediaToRemove) throws MediaLibraryException {
        if (mediaToRemove == null || mediaToRemove.isEmpty()) {
            throw new MediaLibraryException("Fehler: Die Liste der zu entfernenden Medien ist leer oder null!");
        }

        ArrayList<Medium> notFoundMedia = new ArrayList<>();
        for (Medium m : mediaToRemove) {// Crear la lista a devolver con elementos que NO se encontraron
            if (!this.media.contains(m)) {// Si la biblioteca NO contiene el medio a borrar...
                notFoundMedia.add(m);// se guarda
            }
        }
        this.media.removeAll(mediaToRemove);
        return notFoundMedia;
    }

    public void showInfo() {
        System.out.println("--- Media Library Info ---");
        for (Medium m : media) {
            m.showInfo(); // polimorfismo, llamando a los showInfo de CD o DVD
        }
    }

    public int playingTime() {
        int totalTime = 0;
        for (Medium m : media) {
            totalTime += m.playingTime();
        }
        return totalTime;
    }

    public int moneyValue() {
        int totalValue = 0;
        for (Medium m : media) {
            totalValue += m.getPrice();
        }
        return totalValue;
    }
}