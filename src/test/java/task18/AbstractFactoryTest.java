package task18;

import org.junit.Test;

import static org.junit.Assert.*;
import static task18.AbstractFactory.getFilmByLanguage;

/**
 * Created by Valerii Artemenko on 14.03.2017.
 */
public class AbstractFactoryTest {
    @Test
    public void getFilmByLanguageRU() throws Exception {
        FilmFactory filmFactory = getFilmByLanguage("RU");
        assertTrue(filmFactory instanceof RuFilmFactory);
    }
    @Test
    public void getFilmByLanguageEN() throws Exception {
        FilmFactory filmFactory = getFilmByLanguage("EN");
        assertTrue(filmFactory instanceof EnFilmFactory);
    }

    @Test (expected = RuntimeException.class)
    public void nonExistent(){
        FilmFactory filmFactory = getFilmByLanguage("Bla");
    }
}