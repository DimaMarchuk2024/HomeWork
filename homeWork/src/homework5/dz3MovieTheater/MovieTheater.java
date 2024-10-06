package homework5.dz3MovieTheater;

import homework5.dz3MovieTheater.enumRepository.Genre;
import homework5.dz3MovieTheater.enumRepository.MonthProduction;

import java.util.*;

public class MovieTheater {
    private final Map<Integer, List<Film>> mapFilm = new TreeMap<>();

    public void addFilm(Film film) {
        if (!isAddFilmSuccess(film)) {
            System.out.println(film + " не добавлен, такой уже есть в кинотеатре");
        } else if (mapFilm.containsKey(film.getYearProduction())) {
            mapFilm.get(film.getYearProduction()).add(film);
        } else {
            List<Film> filmList = new ArrayList<>();
            filmList.add(film);
            mapFilm.put(film.getYearProduction(), filmList);
        }
    }

    public boolean isAddFilmSuccess(Film film) {
        for (Map.Entry<Integer, List<Film>> entry : mapFilm.entrySet()) {
            for (Film addFilm : entry.getValue()) {
                if (film.equals(addFilm)) {
                    return false;
                }
            }
        }
        return true;
    }

    public List<Film> getFilmByYear(Integer year) {
        if (!mapFilm.containsKey(year)) {
            return new ArrayList<>();
        } else {
            return mapFilm.get(year);
        }
    }

    public List<Film> getFilmByYearAndMonth(Integer year, MonthProduction month) {
        List<Film> resultList = new ArrayList<>();
        if (!mapFilm.containsKey(year)) {
            return new ArrayList<>();
        } else {
            List<Film> filmList = mapFilm.get(year);
            for (Film film : filmList) {
                if (film.getMonthProduction().equals(month)) {
                    resultList.add(film);
                }
            }
            return resultList;
        }
    }

    public List<Film> getFilmByGenre(Genre genre) {
        List<Film> resultList = new ArrayList<>();
        for (Map.Entry<Integer, List<Film>> entry : mapFilm.entrySet()) {
            for (Film film : entry.getValue()) {
                if (film.getGenre().equals(genre)) {
                    resultList.add(film);
                }
            }
        }
        return resultList;
    }

    public List<Film> getTop10Film() {
        List<Film> resultList = new ArrayList<>();
        for (List<Film> value : mapFilm.values()) {
            resultList.addAll(value);
        }
        resultList.sort((o1, o2) -> o2.getRating().compareTo(o1.getRating()));
        for (int i = 10; i < resultList.size(); i++) {
            resultList.remove(i);
            i--;
        }
        return resultList;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        MovieTheater that = (MovieTheater) o;
        return Objects.equals(mapFilm, that.mapFilm);
    }

    @Override
    public int hashCode() {
        return Objects.hash(mapFilm);
    }

    @Override
    public String toString() {
        return "MovieTheater{" +
                "mapFilm=" + mapFilm +
                '}';
    }

    public Map<Integer, List<Film>> getMapFilm() {
        return mapFilm;
    }
}
