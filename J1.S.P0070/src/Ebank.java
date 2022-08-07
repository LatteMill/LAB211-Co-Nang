
import java.util.Enumeration;
import java.util.Locale;
import java.util.Random;
import java.util.ResourceBundle;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Ha Minh Nghia
 */
public class Ebank {

    ResourceBundle words;
    Scanner scan = new Scanner(System.in);

    public void setLocate(Locale locale) {
        words = ResourceBundle.getBundle("language/" + locale);
    }

    public String checkAccountNumber(String accountNumber) {
        Pattern p = Pattern.compile("^[0-9]{10}$");
        Matcher m = p.matcher(accountNumber);
        if (m.find()) {
            return words.getString("Right.account");
        } else {
            return words.getString("Check.account");
        }
    }

    public void getAccount() {
        while (true) {
            System.out.print(words.getString("Account"));
            String accountNumber = scan.nextLine();
            String account = checkAccountNumber(accountNumber);
            if (account.equals(words.getString("Right.account"))) {
                System.out.println(account);
                break;
            } else {
                System.out.println(account);
                continue;
            }
        }
    }

    public String checkPassword(String password) {
        Pattern p = Pattern.compile("^(?=.*[A-Za-z])(?=.*\\d)[A-Za-z\\d]{8,31}$");
        Matcher m = p.matcher(password);
        if (m.find()) {
            return words.getString("Right.password");
        } else {
            return words.getString("Wrong.password");
        }
    }

    public void getPassword() {
        while (true) {
            System.out.print(words.getString("Password"));
            String password = scan.nextLine();
            String pass = checkPassword(password);
            if (pass.equals(words.getString("Right.password"))) {
                System.out.println(pass);
                break;
            } else {
                System.out.println(pass);
            }
        }
    }

    public String generateCaptcha() {
        char alphabet[] = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k',
            'l', 'm', 'n', 'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w',
            'x', 'y', 'z', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I',
            'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U',
            'V', 'W', 'X', 'Y', 'Z', '0', '1', '2', '3', '4', '5', '6',
            '7', '8', '9'};
        char index[] = new char[6];
        Random r = new Random();
        for (int i = 0; i < (index.length); i++) {
            int ran = r.nextInt(alphabet.length);
            index[i] = alphabet[ran];
        }
        System.out.println(index);
        return new String(index);
    }

    public String checkCaptcha(String captchaInput, String captchaGenerate) {
        if (captchaGenerate.contains(captchaInput) && !captchaInput.isEmpty()) {
            return words.getString("Right.capcha");
        } else {
            return words.getString("Wrong.capcha");
        }
    }

    public void getCaptcha() {
        System.out.print(words.getString("Capcha"));
        String captchaGenerate = generateCaptcha();
        while (true) {
            System.out.print(words.getString("CapchaInput"));
            String input = "";
            input = scan.nextLine();
            String result = checkCaptcha(input, captchaGenerate);
            if (result.equals(words.getString("Right.capcha"))) {
                System.out.println(result);
                break;
            } else {
                System.out.println(result);
            }
        }
    }

//    public void loginSystem(Locale locale) {
//        setLocate(locale);
//        getAccount();
//        getPassword();
//        getCaptcha();
//    }
}
