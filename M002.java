/*    In case of Java language, 
   the main class must be named as "M"+Problem ID */

import java.io.IOException;
import java.util.*;
public class M002 {
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in);
        double r;
        r=in.nextDouble();
        System.out.println("A="+(3.14159*r*r));
    }
}