import java.util.Scanner;
/**
 *
 * @author Estudiante
 */
public class Entrada {
    private static Scanner input = new Scanner(System.in);
    
    public static int readInt(String mss){
        System.out.println(mss);
        return input.nextInt();
    }
      public static String readText(String mss){
        System.out.println(mss);
        return input.nextLine();
    }
}
