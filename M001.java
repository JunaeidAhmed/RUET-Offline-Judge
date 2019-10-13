/*    In case of Java language, 
   the main class must be named as "M"+Problem ID */

import java.io.IOException;
import java.util.*;
public class M001 {
    public static void main(String[] args) throws IOException {
        Scanner in=new Scanner(System.in);
        int a,b;
        a=in.nextInt();
        b=in.nextInt();
        System.out.println("X = "+(a+b));
    }
}