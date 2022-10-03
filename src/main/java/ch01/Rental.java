package ch01;

public class Rental {
    Movie movie;    // 影片
    private int daysRented;  // 租期

    public Rental(Movie movie, int daysRented) {
        this.movie = movie;
        this.daysRented = daysRented;
    }

    public Movie getMovie() {
        return movie;
    }

    public void setMovie(Movie movie) {
        this.movie = movie;
    }

    public int getDaysRented() {
        return daysRented;
    }

    public void setDaysRented(int daysRented) {
        this.daysRented = daysRented;
    }

    int getFrequentRenterPoints() {
        return movie.price.getFrequentRenterPoints(daysRented);
    }

    double getCharge() {
        return movie.price.getCharge(daysRented);
    }
}
