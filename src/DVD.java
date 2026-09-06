public class DVD extends Medium {
    private String director;
    private int length;
    private boolean features;
    private int price;

    public DVD(String title, String comment, String director, int length, boolean features, int price) {
        super(title, comment);
        setDirector(director);
        setLength(length);
        setFeatures(features);
        setPrice(price);
    }

    public String getDirector() { return director; }
    public void setDirector(String director) {
        if (director != null && !director.isBlank()) {
            this.director = director;
        } else {
            this.director = "Unbekannter Regisseur";
        }
    }

    public int getLength() { return length; }
    public void setLength(int length) {
        this.length = (length > 0) ? length : 0;
    }

    public boolean isFeatures() { return features; }
    public void setFeatures(boolean features) {
        this.features = features;
    }

    @Override
    public int getPrice() { return price; }
    public void setPrice(int price) {
        this.price = Math.max(price, 0);
    }

    // Sobrescribe método playingTime()
    @Override
    public int playingTime() {
        return this.length;
    }

    @Override
    public void showInfo() {
        System.out.println(this);
    }

    @Override
    public String toString() {
        String extras = features ? "Ja" : "Nein";
        return "DVD [" + super.toString() + ", Director=" + director +
                ", Length=" + length + " min, Extras=" + extras + ", Price=" + price + " EUR]";
    }
}