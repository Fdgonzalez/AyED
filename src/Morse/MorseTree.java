package Morse;

public class MorseTree {
    private Node root;
    public MorseTree(){
        root = new Node();
        root.character = "ERROR";
        fillTree();
    }
    public void fillTree(){
        insert("A",".-");
        insert("B","-...");
        insert("C", "-.-.");
        insert("CH", "----");
        insert("D","-..");
        insert("E",".");
        insert("F","..-.");
        insert("G","--.");
        insert("H","....");
        insert("I", "..");
        insert("J",".---");
        insert("K","-.-");
        insert("L",".-..");
        insert("M","--");
        insert("N","-.");
        insert("Ñ","--.--");
        insert("O","---");
        insert("P",".--.");
        insert("Q","--.-");
        insert("R",".-.");
        insert("S","...");
        insert("T","-");
        insert("U","..-");
        insert("V","...-");
        insert("W",".--");
        insert("X","-..-");
        insert("Y","-.--");
        insert("Z","--..");
        insert("0","-----");
        insert("1",".----");
        insert("2","..---");
        insert("3","...--");
        insert("4","....-");
        insert("5",".....");
        insert("6","-....");
        insert("7","--...");
        insert("8","---..");
        insert("9","----.");
        insert(".",".-.-.-");
        insert(",","--..--");
        insert("?","..--..");
        insert("\"",".-..-.");
    }
    private Node getReference(String code){
        Node pointer = root;
        for(int i=0;i<code.length();i++){ // create necessary nodes and set pointer to the node we want to set the char to
            if(code.charAt(i) == '.'){
                if(pointer.dot == null)
                    pointer.dot = new Node();
                pointer = pointer.dot;
            }
            else if(code.charAt(i) == '-'){
                if (pointer.dash == null)
                    pointer.dash = new Node();
                pointer = pointer.dash;
            }
        }
        return pointer;
    }
    public String get(String code){
        return getReference(code).character;
    }
    public void insert(String character, String code){
        getReference(code).character = character;
    }
    private static class Node{
        String character;
        Node dot;
        Node dash;
        public Node( ){
        }
    }
}
