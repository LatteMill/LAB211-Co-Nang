
import static com.sun.org.apache.xalan.internal.lib.ExsltDatetime.date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.Date;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ha Minh Nghia
 */
public class Test {

    Scanner in = new Scanner(System.in);

    public static void main(String[] args) {
        Test t = new Test();
        System.out.println("Enter date: ");
        String a = t.checkDate();
        System.out.println(a);
//        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
//        Date date = new Date();
//        String dateFormat = formatter.format(date);
//        System.out.println(dateFormat);
    }

    public String checkDate() {
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        Date date = new Date();
        String time = dateFormat.format(date);
        String[] a = time.split("-");
        String b = a[a.length - 1];
        int year1 = Integer.parseInt(b);
        String text = "";
        while (true) {
            try {
                text = in.nextLine();
                dateFormat.parse(text.trim());
                String[] words = text.split("-");
                String t = words[words.length - 1];
                int year = Integer.parseInt(t);
                if (year > 2005) {
                    System.out.print("Please enter again: ");
                    continue;
                }
            } catch (Exception e) {
                System.out.print("Please enter again: ");
                continue;
            }
            break;
        }
        return text;
    }

}
