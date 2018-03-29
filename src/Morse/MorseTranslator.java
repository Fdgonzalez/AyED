package Morse;

import java.util.Scanner;

public class MorseTranslator {
    /* B) Hacer el traductor al revés, del código Morse a texto. */

    public static String morseToText(String morse){
        StringBuilder temp;
        StringBuilder result = new StringBuilder();
        for(int i=0;i<morse.length(); ){
            temp = new StringBuilder();
            while(i<morse.length() && morse.charAt(i) != ' '){// character ends
                temp.append(morse.charAt(i++));
            }
            result.append(toText(temp.toString()));// append character
            if(i<morse.length() && morse.charAt(i++) == ' ' && morse.charAt(i) == ' ') {
                result.append(" ");
                i++;
            }
        }
        return result.toString().trim();
    }

    /* A) Programar un traductor de texto a código Morse. ¿Alcanza con dos símbolos o
    deberíamos agregar otros? */
    // No alcanza con dos simbolos (punto y linea) ya que se necesita un tercer simbolo (espacio) para codificar los silencios

    public static String textToMorse(String text){
        Scanner sc = new Scanner(text); //default scanner uses whitespace as the delimiter so it should separate the text into words
        StringBuilder sb = new StringBuilder();
        while(sc.hasNext()) {
            sb.append(toMorse(sc.next()));// append next word's morse code
            sb.append(" "); // each word is separated by a bigger silence (two white spaces)
        }
        return sb.toString().trim();
    }

    private static String toText(String morse) {
        switch (morse){
            case ".-" : return "A";
            case "-..." : return "B";
            case "-.-." : return "C";
            case "----" : return "CH";
            case "-.." : return "D";
            case "." : return "E";
            case "..-." : return "F";
            case "--." : return "G";
            case "...." : return "H";
            case ".." : return "I";
            case ".---" : return "J";
            case "-.-" : return "K";
            case ".-.." : return "L";
            case "--" : return "M";
            case "-." : return "N";
            case "--.--" : return "Ñ";
            case "---" : return "O";
            case ".--." : return "P";
            case "--.-" : return "Q";
            case ".-." : return "R";
            case "..." : return "S";
            case "-" : return "T";
            case "..-" : return "U";
            case "...-" : return "V";
            case ".--" : return "W";
            case "-..-" : return "X";
            case "-.--" : return "Y";
            case "--.." : return "Z";
            case "-----" : return "0";
            case ".----" : return "1";
            case "..---" : return "2";
            case "...--" : return "3";
            case "....-" : return "4";
            case "....." : return "5";
            case "-...." : return "6";
            case "--..." : return "7";
            case "---.." : return "8";
            case "----." : return "9";
            case ".-.-.-" : return ".";
            case "--..--" : return ",";
            case "..--.." : return "?";
            case ".-..-." : return "\"";
            default: return "";
        }
    }
    public static String toMorse(String input){//Convert one word to a morse code string
        String text = input.toUpperCase();
        StringBuilder sb = new StringBuilder();
        String temp;
        for(int i=0;i<text.length();i++){
            if(text.charAt(i) == 'C' && text.charAt(i+1) == 'H') {
                sb.append(toMorseChar("CH")); // CH is a special case because there is no ascii for CH
                i++;
            }
            else
                sb.append(toMorseChar("" + text.charAt(i)));

            sb.append(" ");// each character is separated by a small silence
        }
        return sb.toString();
    }
    public static String toMorseChar(String text){
        switch (text){
            case "A" : return ".-";
            case "B" : return "-...";
            case "C" : return "-.-.";
            case "CH" : return "----";
            case "D" : return "-..";
            case "E" : return ".";
            case "F" : return "..-.";
            case "G" : return "--.";
            case "H" : return "....";
            case "I" : return "..";
            case "J" : return ".---";
            case "K" : return "-.-";
            case "L" : return ".-..";
            case "M" : return "--";
            case "N" : return "-.";
            case "Ñ" : return "--.--";
            case "O" : return "---";
            case "P" : return ".--.";
            case "Q" : return "--.-";
            case "R" : return ".-.";
            case "S" : return "...";
            case "T" : return "-";
            case "U" : return "..-";
            case "V" : return "...-";
            case "W" : return ".--";
            case "X" : return "-..-";
            case "Y" : return "-.--";
            case "Z" : return "--..";
            case "0" : return "-----";
            case "1" : return ".----";
            case "2" : return "..---";
            case "3" : return "...--";
            case "4" : return "....-";
            case "5" : return ".....";
            case "6" : return "-....";
            case "7" : return "--...";
            case "8" : return "---..";
            case "9" : return "----.";
            case "." : return ".-.-.-";
            case "," : return "--..--";
            case "?" : return "..--..";
            case "\"" : return ".-..-.";
            default: return "";
        }
    }
}
