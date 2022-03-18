package models;

public class Movies {

    private String nameMovie;

    private String genre;

    public Movies(final String nameMovie) {
        this.nameMovie = nameMovie;
    }

    public Movies() {

    }

    public String getNameMovie() {
        return nameMovie;
    }

    public void setNameMovie(final String nameMovie) {
        this.nameMovie = nameMovie;
    }
    public String getGenre() {
        return genre;
    }

    public void setGenre(final String genre) {
        this.genre = genre;
    }

}
