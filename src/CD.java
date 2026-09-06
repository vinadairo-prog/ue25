public class CD extends Medium {
    private String artist;
    private int noOfSongs;
    private int time;
    private int price;

    public CD(String title, String comment, String artist, int noOfSongs, int time, int price) {
        super(title, comment);
        setArtist(artist);
        setNoOfSongs(noOfSongs);
        setTime(time);
        setPrice(price);
    }

    public String getArtist() { return artist; }
    public void setArtist(String artist) {
        if (artist != null && !artist.isBlank()) {
            this.artist = artist;
        } else {
            this.artist = "Unbekannter Künstler";
        }
    }

    public int getNoOfSongs() { return noOfSongs; }
    public void setNoOfSongs(int noOfSongs) {
        this.noOfSongs = (noOfSongs > 0) ? noOfSongs : 1;
    }

    public int getTime() { return time; }
    public void setTime(int time) {
        this.time = (time > 0) ? time : 0;
    }

    // ¡Ojo!  sobrescribiendo el getPrice() del padre.
    @Override
    public int getPrice() { return price; }
    public void setPrice(int price) {
        this.price = Math.max(price, 0); // *** qué es mayor price o 0 evitando negativos
    }

    // Sobrescribir el método playingTime() para que devuelva el tiempo real del CD
    @Override
    public int playingTime() {
        return this.time;
    }

    @Override
    public void showInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "CD [" + super.toString() + ", Artist=" + artist + ", Tracks=" + noOfSongs +
                ", Time=" + time + " min, Price=" + price + " EUR]";
    }
}