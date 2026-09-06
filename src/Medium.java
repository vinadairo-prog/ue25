public class Medium {
    private String title;
    private String comment;

    public Medium(String title, String comment) {
        setTitle(title);
        setComment(comment);
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        if (title != null && !title.isBlank()) {
            this.title = title;
        } else {
            this.title = "Unbekannter Titel";
        }
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        if (comment != null) {
            this.comment = comment;
        } else {
            this.comment = "";
        }
    }

    public int getPrice() {
        return 0; //OJO según instrucción
    }

    public int playingTime() {
        return 0;
    }

    public void showInfo() {
        // Porque cuando pasa un objeto (this) a println, Java busca y ejecuta el método toString() de ese objeto por detrás.
        System.out.println(this);
    }

    @Override
    public String toString() {
        return "Medium [Titel=" + title + ", Kommentar=" + comment + "]";
    }
}
