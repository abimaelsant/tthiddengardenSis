package tthiddengarden;

import java.util.Arrays;

public class Tthiddengarden {

    public static void main(String[] args) {
        String c = "1989-08-09";
        String[] d = c.split("-");
        c = d[2] + '/' + d[1] + "/" + d[0];
        System.out.println(c);
    }    
}
