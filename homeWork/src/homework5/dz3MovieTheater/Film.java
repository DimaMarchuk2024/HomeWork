package homework5.dz3MovieTheater;

import homework5.dz3MovieTheater.enumRepository.Genre;
import homework5.dz3MovieTheater.enumRepository.MonthProduction;

import java.util.Comparator;
import java.util.Objects;

public class Film implements Comparator<Film> {
    private final Integer id;
    private final Integer yearProduction;
    private final MonthProduction monthProduction;
    private final Genre genre;
    private final Double rating;

    public Film(Integer id, Integer yearProduction, MonthProduction monthProduction, Genre genre, Double rating) {
        this.id = id;
        this.yearProduction = yearProduction;
        this.monthProduction = monthProduction;
        this.genre = genre;
        this.rating = rating;
    }

    @Override
    public int compare(Film o1, Film o2) {
        return (int) (o2.getRating() - o1.getRating());
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Film film = (Film) o;
        return Objects.equals(id, film.id) && Objects.equals(yearProduction, film.yearProduction) && monthProduction == film.monthProduction && genre == film.genre && Objects.equals(rating, film.rating);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, yearProduction, monthProduction, genre, rating);
    }

    @Override
    public String toString() {
        return "Film{" +
                "id=" + id +
                ", yearProduction=" + yearProduction +
                ", monthProduction=" + monthProduction +
                ", genre=" + genre +
                ", rating=" + rating +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public Integer getYearProduction() {
        return yearProduction;
    }

    public MonthProduction getMonthProduction() {
        return monthProduction;
    }

    public Genre getGenre() {
        return genre;
    }

    public Double getRating() {
        return rating;
    }
}
