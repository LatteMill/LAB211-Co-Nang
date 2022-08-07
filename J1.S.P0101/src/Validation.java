
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author Ha Minh Nghia
 */
public class Validation {

    Scanner in = new Scanner(System.in);

    public int checkInt(int min, int max) {
        while (true) {
            try {
                int result = Integer.parseInt(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input.");
                System.out.print("Enter again: ");
            }
        }
    }

    public String checkInputString() {
        while (true) {
            String result = in.nextLine().trim();
            if (result.isEmpty()) {
                System.err.println("Not empty");
                System.out.print("Enter again: ");
            } else {
                return result;
            }
        }
    }

    public double checkDouble(double min, double max) {
        while (true) {
            try {
                double result = Double.parseDouble(in.nextLine().trim());
                if (result < min || result > max) {
                    throw new NumberFormatException();
                }
                return result;
            } catch (NumberFormatException e) {
                System.err.println("Invalid input.");
                System.out.print("Enter again: ");
            }
        }
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
                int h =  year1 - year; 
                if (h < 16) {
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

    public String checkSex() {
        while (true) {
            String sex = checkInputString();
            if (sex.equalsIgnoreCase("Male") || sex.equalsIgnoreCase("Female") || sex.equalsIgnoreCase("Other")) {
                return sex;
            } else {
                System.err.println("Please input Male or Female or Other");
                System.out.print("Enter again: ");
                continue;
            }
        }
    }

    public boolean checkIdUpdate(ArrayList<Employee> ls, Employee e, int id) {
        if (id == e.getId()) {
            return true;
        } else {
            for (Employee employee : ls) {
                if (id == employee.getId()) {
                    return false;
                }
            }
            return true;
        }
    }

    public boolean checkIdExist(ArrayList<Employee> ls, int id) {
        for (Employee employee : ls) {
            if (id == employee.getId()) {
                return false;
            }
        }
        return true;
    }

    public String checkEmail() {
        Pattern p = Pattern.compile("^[a-zA-Z0-9_!#$%&’*+/=?`{|}~^.-]+@[a-zA-Z0-9.-]+$");
        while (true) {
            String email = checkInputString();
            Matcher m = p.matcher(email);
            if (m.find()) {
                return email;
            } else {
                System.out.println("Wrong format");
                System.out.print("Please re-enter: ");
                continue;
            }
        }
    }

    public String checkPhoneNumber() {
        Pattern p = Pattern.compile("^[0-9]{10}$");
        while (true) {
            String phone = checkInputString();
            Matcher m = p.matcher(phone);
            if (m.find()) {
                return phone;
            } else {
                System.out.println("Wrong format");
                System.out.print("Please re-enter: ");
                continue;
            }
        }
    }

    public boolean checkEmployeeExist(ArrayList<Employee> ls, String name, String phone,
            String email, String address, String dob, String sex, String agency, double salary) {
        int size = ls.size();
        for (Employee employee : ls) {
            if (name.equalsIgnoreCase(employee.getName())
                    && phone.equalsIgnoreCase(employee.getPhone())
                    && email.equalsIgnoreCase(employee.getEmail())
                    && address.equalsIgnoreCase(employee.getAddress())
                    && dob.equalsIgnoreCase(employee.getDob())
                    && sex.equalsIgnoreCase(employee.getSex())
                    && agency.equalsIgnoreCase(employee.getAgency())
                    && salary == employee.getSalary()) {
                return false;
            }
        }
        return true;
    }

    public boolean checkChangeInfomation(Employee employee, int id, String name, String phone,
            String email, String address, String dob, String sex, String agency, double salary) {
        if (id == employee.getId()
                && name.equalsIgnoreCase(employee.getName())
                && phone.equalsIgnoreCase(employee.getPhone())
                && email.equalsIgnoreCase(employee.getEmail())
                && address.equalsIgnoreCase(employee.getAddress())
                && dob.equalsIgnoreCase(employee.getDob())
                && sex.equalsIgnoreCase(employee.getSex())
                && agency.equalsIgnoreCase(employee.getAgency())
                && salary == employee.getSalary()) {          
            return false;
        }
        return true;
    }
}
