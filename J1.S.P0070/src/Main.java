import java.util.Locale;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author Ha Minh Nghia
 */
public class Main {

    public static Scanner sc = new Scanner(System.in);

    public static void main(String[] args) {
        Ebank e = new Ebank();
        Locale vietnamese = new Locale("Vi");
        Locale english = new Locale("En");
        String choice;
        do {
            System.out.println("1. Vietnamese");
            System.out.println("2. English");
            System.out.println("3. Exit");
            System.out.print("Please choice one option: ");
            choice = sc.nextLine();
            switch (choice) {
                case "1":
                    e.setLocate(vietnamese);
                    e.getAccount();
                    e.getPassword();
                    e.getCaptcha();
                    break;
                case "2":
                    e.setLocate(english);
                    e.getAccount();
                    e.getPassword();
                    e.getCaptcha();
                    break;
                case "3":
                    return;
                default:
                    System.out.println("Invalid input, please re-enter.");
            }
        } while (!choice.equals("3"));
        
    }
//    static int checkInputIntLimit(int min, int max, Locale language) {
//        while (true) {
//            try {
//                int result = Integer.parseInt(in.nextLine());
//                if (result < min || result > max) {
//                    throw new NumberFormatException();
//                }
//                return result;
//            } catch (NumberFormatException ex) {
//                getWordLanguage(language, "errorCheckInputIntLimit");
//                System.out.println();
//            }
//        }
//    }
}
