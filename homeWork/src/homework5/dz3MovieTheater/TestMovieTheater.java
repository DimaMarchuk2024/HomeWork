package homework5.dz3MovieTheater;

import homework5.dz3MovieTheater.enumRepository.Genre;
import homework5.dz3MovieTheater.enumRepository.MonthProduction;

import java.util.List;
import java.util.Map;

/**
 * Даны 2 класса:
 * - Фильм с 5-ю полями: Уникальный Целочисленный идентификатор (id), Год издания, Месяц издания, Жанр и Рейтинг;
 * - Кинотеатр, где есть всего лишь одно единственное поле: отсортированный ассоциативный массив,
 * где ключом является год издания, а значением - все фильмы, выпустившиеся в этом году.
 * Добавить функционал в кинотеатр таким образом, чтобы можно было:
 * - добавлять в него новый фильм
 * - получить все фильмы по переданному году
 * - получить все фильмы по переданному году и месяцу
 * - получить все фильмы по переданному жанру
 * - получать ТОП-10 фильмов отсортированные по Рейтингу в порядке убывания
 * Учесть следующее:
 * - в кинотеатре фильмы должны храниться в порядке их добавления в него
 * (т.е. предусмотреть порядок значения ассоциативного массива)
 * - не должен добавляться фильм, если такой уже есть в кинотеатре
 * Продемонстрировать работу кинотеатра в отдельном классе.
 */
public class TestMovieTheater {

    public static void main(String[] args) {

        MovieTheater movieTheater = new MovieTheater();

        addFilmInMovieTheater(movieTheater);
        System.out.println("Добавленные фильмы в кинотеатр по годам: ");
        printMovieTheater(movieTheater);

        System.out.println();

        List<Film> filmByYear = movieTheater.getFilmByYear(1985);
        System.out.println("Фильмы за 1985 год: ");
        printFilmByYear(filmByYear);

        System.out.println();

        List<Film> filmByYearAndMonth = movieTheater.getFilmByYearAndMonth(1975, MonthProduction.MAY);
        System.out.println("Фильмы, произведенные в " + MonthProduction.MAY + " 1975 года: ");
        printFilmByYearAndMonth(filmByYearAndMonth);

        System.out.println();

        List<Film> filmByGenre = movieTheater.getFilmByGenre(Genre.COMEDY);
        System.out.println("Фильмы в жанре " + Genre.COMEDY);
        printFilmByGenre(filmByGenre);

        System.out.println();

        List<Film> top10Film = movieTheater.getTop10Film();
        System.out.println("Топ 10 фильмов кинотеатра по рейтингу:");
        printTop10Film(top10Film);
    }

    private static void addFilmInMovieTheater(MovieTheater movieTheater) {
        movieTheater.addFilm(new Film(6, 1985, MonthProduction.MARCH, Genre.DRAMA, 8.2));
        movieTheater.addFilm(new Film(7, 1980, MonthProduction.MAY, Genre.DRAMA, 5.9));
        movieTheater.addFilm(new Film(8, 1980, MonthProduction.DECEMBER, Genre.COMEDY, 7.0));
        movieTheater.addFilm(new Film(9, 1985, MonthProduction.APRIL, Genre.HORROR, 6.1));
        movieTheater.addFilm(new Film(10, 1985, MonthProduction.MARCH, Genre.DOCUMENTARY, 8.3));
        movieTheater.addFilm(new Film(11, 1975, MonthProduction.JANUARY, Genre.DOCUMENTARY, 7.7));
        movieTheater.addFilm(new Film(12, 1975, MonthProduction.MAY, Genre.HORROR, 5.8));
        movieTheater.addFilm(new Film(1, 1975, MonthProduction.APRIL, Genre.COMEDY, 6.8));
        movieTheater.addFilm(new Film(2, 1975, MonthProduction.MAY, Genre.COMEDY, 7.8));
        movieTheater.addFilm(new Film(3, 1980, MonthProduction.JULY, Genre.DRAMA, 5.6));
        movieTheater.addFilm(new Film(4, 1980, MonthProduction.AUGUST, Genre.ACTION, 7.2));
        movieTheater.addFilm(new Film(5, 1985, MonthProduction.JANUARY, Genre.ACTION, 8.1));
        movieTheater.addFilm(new Film(4, 1980, MonthProduction.AUGUST, Genre.ACTION, 7.2));
    }

    private static void printMovieTheater(MovieTheater movieTheater) {
        Map<Integer, List<Film>> mapFilm = movieTheater.getMapFilm();
        for (Map.Entry<Integer, List<Film>> entry : mapFilm.entrySet()) {
            System.out.println(entry.getKey() + "=" + entry.getValue());
        }
    }

    private static void printFilmByYear(List<Film> filmByYear) {
        for (Film film : filmByYear) {
            System.out.println(film);
        }
    }

    private static void printFilmByYearAndMonth(List<Film> filmByYearAndMonth) {
        for (Film film : filmByYearAndMonth) {
            System.out.println(film);
        }
    }

    private static void printFilmByGenre(List<Film> filmByGenre) {
        for (Film film : filmByGenre) {
            System.out.println(film);
        }
    }

    private static void printTop10Film(List<Film> top10Film) {
        int count = 0;
        for (Film film : top10Film) {
            count++;
            System.out.println(count + " : " + film);
        }
    }
}



