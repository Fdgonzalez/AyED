package Morse;

import org.junit.Test;

import static org.junit.Assert.*;

public class MorseTranslatorTest {

    @Test
    public void morseToText() {
        MorseTranslator translator = new MorseTranslator();
        assertEquals(".... --- .-.. .-  -- ..- -. -.. ---", translator.textToMorse("HOLA MUNDO"));
    }

    @Test
    public void textToMorse() {
        MorseTranslator translator = new MorseTranslator();
        assertEquals("HOLA MUNDO", translator.morseToText(".... --- .-.. .-  -- ..- -. -.. ---"));
    }
}