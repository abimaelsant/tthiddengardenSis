package tthiddengarden;

public class Tthiddengarden {

    public static void main(String[] args) {
        String c = "05232688316";
        String c2 = "";
        for(int i = 0; i < c.length(); i++) {
            c2 += c.charAt(i);
            if(i == 2 || i == 5) c2 += ".";
            if(i == 8) c2 += "-";
        }
    }    
}
