package task18;

/**
 * Created by Valerii Artemenko on 07.03.2017.
 *
 * Предоставляет интерфейс для создания семейств взаимосвязанных
 * или взаимозависимых объектов, не специфицируя их конкретных классов.
 */
public class AbstractFactory {
    public static void main(String[] args) {

        Film war = new War();

        SesionFilm film = new SesionFilm(war,Languages.EN);
        System.out.println(film);


//        FilmFactory filmFactory = getFilmByLanguage("EN");
//        Film film = filmFactory.getFilm();
//        film.soundFilm();
//        film.textSubtitles();
    }

//    protected static FilmFactory getFilmByLanguage(String language) {
//        switch (language) {
//            case "RU":
//                return new RuFilmFactory();
//            case "EN":
//                return new EnFilmFactory();
//            default:
//                throw new RuntimeException("Unsupported language!");
//        }
//    }
}

class SesionFilm{
    Film film;
    Subtitles subtitles;
    Soundtrack soundtrack;

    public SesionFilm(Film film, Languages language) {
        this.film = film;
        setSoundtrack(language);
    }

    public void setSoundtrack(Languages language) {
        FilmFactory filmFactory;
        if( language == Languages.EN){
            filmFactory = new EnFilmFactory();
            this.soundtrack = filmFactory.getSoundtrack(this.film,language);
            this.subtitles = filmFactory.getSubtitles(this.film,language);
        }
        else if( language == Languages.RU){
            filmFactory = new RuFilmFactory();
            this.soundtrack = filmFactory.getSoundtrack(this.film,language);
            this.subtitles = filmFactory.getSubtitles(this.film,language);
        }
    }

    public void setSubtitles(Languages languages) {
        setSoundtrack(languages);
    }

    public String toString() {
        StringBuilder output = new StringBuilder();

        output.append(this.film + "\n");
        output.append(this.soundtrack + "\n");
        output.append(this.subtitles + "\n");
        return output.toString();
    }
}


enum Languages{
    EN("English"),RU("Russion");

    String language;

    private Languages(String language) {
        this.language = language;
    }

    public String getLanguage() {
        return language;
    }
}

/**
 * Product Film
 */
abstract class Film {
    String name;

    public Film(String name) {
        this.name = name;
    }

    public String toString() {
        return this.name;
    }
}

/**
 * Abstract Factory
 */
interface FilmFactory {
    Soundtrack getSoundtrack(Film film, Languages language);
    Subtitles getSubtitles(Film film, Languages language);
}

/**
 * Product Film @name:War
 */
class War extends Film {

    private static final String NAME = "War";

    public War() {
        super(NAME);
    }
}

/**
 * Product Film @name: Spiderman
 */
class Spiderman extends Film {
    private static final String NAME = "Spiderman";

    public Spiderman() {
        super(NAME);
    }
}

/**
 * Factory for ruFilm
 */
class RuFilmFactory implements FilmFactory {

    public Soundtrack getSoundtrack(Film film, Languages language) {
        return new RuSoundtrack(film);
    }

    public Subtitles getSubtitles(Film film, Languages language) {
        return new RuSubtitles(film);
    }
}

/**
 * Factory for ruFilm
 */
class EnFilmFactory implements FilmFactory {
    public Soundtrack getSoundtrack(Film film, Languages language) {
        return new EnSoundtrack(film);
    }

    public Subtitles getSubtitles(Film film, Languages language) {
        return new EnSubtitles(film);
    }
}

abstract class Soundtrack {
    Film film;
    Languages language;

    public Soundtrack(Film film, Languages language) {
        this.film = film;
        this.language = language;
    }

    public String toString() {
        return language.getLanguage() + " soundtrack to film " + film;
    }


}

class EnSoundtrack extends Soundtrack {
    private static final Languages LANGUAGE = Languages.EN;

    public EnSoundtrack(Film film) {
        super(film, LANGUAGE);
    }
}

class RuSoundtrack extends Soundtrack {
    private static final Languages LANGUAGE = Languages.RU;

    public RuSoundtrack(Film film) {
        super(film, LANGUAGE);
    }
}

abstract class Subtitles {
    Film film;
    Languages language;

    public Subtitles(Film film, Languages language) {
        this.film = film;
        this.language = language;
    }

    public String toString() {
        return language.getLanguage() + " subtitles to film " + film;
    }
}

class EnSubtitles extends Subtitles {
    private static final Languages LANGUAGE = Languages.EN;

    public EnSubtitles(Film film) {
        super(film, LANGUAGE);
    }
}

class RuSubtitles extends Subtitles {
    private static final Languages LANGUAGE = Languages.RU;

    public RuSubtitles(Film film) {
        super(film, LANGUAGE);
    }
}