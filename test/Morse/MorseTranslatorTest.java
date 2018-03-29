package Morse;

import org.junit.Test;

import static org.junit.Assert.*;

public class MorseTranslatorTest {

    @Test
    public void morseToText() {
        assertEquals(".... --- .-.. .-  -- ..- -. -.. ---", MorseTranslator.textToMorse("HOLA MUNDO"));
    }

    @Test
    public void textToMorse() {
        assertEquals("HOLA MUNDO", MorseTranslator.morseToText(".... --- .-.. .-  -- ..- -. -.. ---"));
    }
}