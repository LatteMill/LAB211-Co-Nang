/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 *
 * @author Ha Minh Nghia
 */
public class Manager {

    Validation v = new Validation();
    static ArrayList<Employee> ls = new ArrayList<>();

    public void menu() {
        System.out.println("1.	Add employees");
        System.out.println("2.	Update employees");
        System.out.println("3.	Remove employees");
        System.out.println("4.	Search employees");
        System.out.println("5.	Sort employees by salary");
        System.out.println("6.	Exit");
        System.out.print("Enter your choice: ");
        int choice = v.checkInt(1, 6);       
        switch (choice) {
            case 1:
                addEmployee();
                break;
            case 2:
                updateEmployee();
                break;

            case 3:
                removeEmployee();
                break;
            case 4:
                find();
                break;
            case 5:
                sort();
                break;
            case 6:
                System.exit(0);
        }

    }

    public void addEmployee() {
        while (true) {
            System.out.print("Enter id: ");
            int id = v.checkInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
            if (!v.checkIdExist(ls, id)) {
                System.err.println("Id has exist. Pleas re-input.");
                continue;
            }
            System.out.print("Enter first name: ");
            String firstName = v.checkInputString();
            System.out.print("Enter last name: ");
            String lastName = v.checkInputString();
            String name = firstName + " " + lastName;
            System.out.print("Enter phone number: ");
            String phone = v.checkPhoneNumber();
            System.out.print("Enter email: ");
            String email = v.checkEmail();
            System.out.print("Enter address: ");
            String address = v.checkInputString();
            System.out.print("Enter date of birth: ");
            String dob = v.checkDate();
            System.out.print("Enter sex: ");
            String sex = v.checkSex();
            System.out.print("Enter salary: ");
            Double salary = v.checkDouble(Double.MIN_VALUE, Double.MAX_VALUE);
            System.out.print("Enter agency: ");
            String agency = v.checkInputString();
            if (v.checkEmployeeExist(ls, name, phone,
                    email, address, dob, sex, agency, salary)) {
                ls.add(new Employee(id, firstName, lastName, phone, email, address, dob, sex, salary, agency));
                System.out.println("Add employee success.");
                return;
            }
            System.err.println("Duplicate, please re-input.");

        }
    }

    public ArrayList<Employee> findById(int id) {
        ArrayList<Employee> getEmployeeById = new ArrayList<>();
        for (Employee e : ls) {
            if (id == e.getId()) {
                getEmployeeById.add(e);
            }
        }
        return getEmployeeById;
    }

    public void updateEmployee() {
        if (ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.print("Enter ID to find: ");
        int id = v.checkInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        ArrayList<Employee> listEmployee = findById(id);
        if (listEmployee.isEmpty()) {
            System.err.println("Not found employee.");
            return;
        } else {
            Employee e = listEmployee.get(0);
            while (true) {
                System.out.print("Enter update ID: ");
                int idNew = v.checkInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
                if (!v.checkIdUpdate(ls, e, idNew)) {
                    System.err.println("Id has exist. Pleas re-input.");
                    continue;
                }
                System.out.print("Enter update first name: ");
                String firstName = v.checkInputString();
                System.out.print("Enter update last name: ");
                String lastName = v.checkInputString();
                String name = firstName + " " + lastName;
                System.out.print("Enter update phone number: ");
                String phone = v.checkPhoneNumber();
                System.out.print("Enter update email: ");
                String email = v.checkEmail();
                System.out.print("Enter update address: ");
                String address = v.checkInputString();
                System.out.print("Enter update date of birth: ");
                String dob = v.checkDate();
                System.out.print("Enter update sex: ");
                String sex = v.checkSex();
                System.out.print("Enter update salary: ");
                Double salary = v.checkDouble(Double.MIN_VALUE, Double.MAX_VALUE);
                System.out.print("Enter update agency: ");
                String agency = v.checkInputString();
                if (!v.checkChangeInfomation(e, id, name, phone, email, address, dob, sex, agency, salary)) {
                    System.err.println("Nothing change.");
                }
                if (v.checkEmployeeExist(ls, name, phone, email, address, dob, sex, agency, salary)) {
                    System.out.println("Update employee success.");
                    e.setId(id);
                    e.setFirstName(firstName);
                    e.setLastName(lastName);
                    e.setPhone(phone);
                    e.setEmail(email);
                    e.setAddress(address);
                    e.setDob(dob);
                    e.setSex(sex);
                    e.setAgency(agency);
                }
                if (!v.checkEmployeeExist(ls, name, phone, email, address, dob, sex, agency, salary)) {
                    System.err.println("Duplicate");
                }
                return;
            }
        }
    }

    public void removeEmployee() {
        if (ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.print("Enter ID to find: ");
        int id = v.checkInt(Integer.MIN_VALUE, Integer.MAX_VALUE);
        ArrayList<Employee> listEmployee = findById(id);
        if (listEmployee.isEmpty()) {
            System.err.println("Not found employee.");
            return;
        } else {
            Employee e = listEmployee.get(0);
            System.err.println("Delete success.");
            ls.remove(e);
            return;
        }
    }

    ArrayList<Employee> findByName() {
        Scanner sc = new Scanner(System.in);
        ArrayList<Employee> listEmployeeByName = new ArrayList<>();
        System.out.print("Enter name to search: ");
        String name = sc.nextLine();
        for (Employee e : ls) {
            if (e.getName().toLowerCase().contains(name.toLowerCase())) {
                listEmployeeByName.add(e);
            }
        }
        return listEmployeeByName;
    }

    public void find() {
        if (ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        ArrayList<Employee> listEmployeeFindByName = findByName();
        if (listEmployeeFindByName.isEmpty()) {
            System.err.println("Not exist.");
        } else {
            System.out.printf("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n", "ID", "First name", "Last Name", "Phone",
                    "Email", "Address", "Date of birth", "Sex", "Salary", "Agency");
            for (Employee e : listEmployeeFindByName) {
                e.print();
            }
        }
    }

    public void sort() {
        if (ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        Collections.sort(ls);
        System.out.printf("%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s|%-15s\n", "ID", "First name", "Last Name", "Phone",
                    "Email", "Address", "Date of birth", "Sex", "Salary", "Agency");
        for (Employee e : ls) {
            e.print();

        }
    }
}
