package task18;

/**
 * Created by Valerii Artemenko on 07.03.2017.
 */
public class AbstractFactory {
    public static void main(String[] args) {

        FilmFactory filmFactory = getFilmByLanguage("EN");
        Film film = filmFactory.getFilm();
        film.soundFilm();
        film.textSubtitles();
    }

    protected static FilmFactory getFilmByLanguage(String language) {
        switch (language) {
            case "RU":
                return new RuFilmFactory();
            case "EN":
                return new EnFilmFactory();
            default:
                throw new RuntimeException("Unsupported language!");
        }
    }
}

interface Film {
    void soundFilm();

    void textSubtitles();
}

interface FilmFactory {
    Film getFilm();
}

class RuFilm implements Film {
    @Override
    public void soundFilm() {
        System.out.println("Озвучка фильма на Русском языке");
    }

    @Override
    public void textSubtitles() {
        System.out.println("Субтитры фильма на русском");
    }
}

class EnFilm implements Film {
    @Override
    public void soundFilm() {
        System.out.println("sound film in English");
    }

    @Override
    public void textSubtitles() {
        System.out.println("subtitle film in English");
    }
}

class RuFilmFactory implements FilmFactory {
    @Override
    public Film getFilm() {
        return new RuFilm();
    }
}

class EnFilmFactory implements FilmFactory {
    @Override
    public Film getFilm() {
        return new EnFilm();
    }
}