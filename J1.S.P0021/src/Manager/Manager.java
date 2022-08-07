package Manager;

import java.util.ArrayList;
import java.util.Collections;


public class Manager {

    public void menu() {
        System.out.println(" 1.	Create");
        System.out.println(" 2.	Find and Sort");
        System.out.println(" 3.	Update/Delete");
        System.out.println(" 4.	Report");
        System.out.println(" 5.	Exit");
        System.out.print(" Enter your choice: ");
    }
    Validation v = new Validation();
    
    public void createStudent(int count) {
        if (count > 10) {
            System.out.print("Do you want to continue (Y/N): ");
            if (!v.checkInputYN()) {
                return;
            }
        }
        while (true) {
            
            System.out.print("Enter id: ");
            String id = v.checkInputString();
            System.out.print("Enter name student: ");
            String name = v.checkInputString();
            if (!v.checkIdExist(Main.ls, id, name)) {
                System.err.println("Id has exist student. Pleas re-input.");
                continue;
            }
            System.out.print("Enter semester: ");
            String semester = v.checkSemester();
            System.out.print("Enter name course: ");
            String course = v.checkInputCourse();
            if (v.checkStudentExist(Main.ls, id, name, semester, course)) {
                Main.ls.add(new Student(id, name, semester, course));
                Main.count++;
                System.out.println("Add student success.");
                return;
            }
            
            System.err.println("Duplicate.");

        }
    }

    public void findAndSort() {
        if (Main.ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        ArrayList<Student> listStudentFindByName = findByName();
        if (listStudentFindByName.isEmpty()) {
            System.err.println("Not exist.");
        } else {
            Collections.sort(listStudentFindByName, Collections.reverseOrder());
            System.out.printf("%-15s%-15s%-15s\n", "Student name", "semester", "Course Name");
            for (Student student : listStudentFindByName) {
                student.print();
            }
        }
    }

    ArrayList<Student> findByName() {
        ArrayList<Student> listStudentFindByName = new ArrayList<>();
        System.out.print("Enter name to search: ");
        String name = v.checkInputString();
        for (Student student : Main.ls) {
            if (student.getStudentName().toLowerCase().contains(name.toLowerCase())) {
                listStudentFindByName.add(student);
            }
        }
        return listStudentFindByName;
    }
  
    public void updateOrDelete(int count) {
        if (Main.ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        System.out.print("Enter id: ");
        String id = v.checkInputString();
        ArrayList<Student> listStudentFindByName = findById(id);
        if (listStudentFindByName.isEmpty()) {
            System.err.println("Not found student.");
            return;
        } else {
            while(true) {
            Student student = chooseStudent(listStudentFindByName);
            System.out.print("Do you want to update (U) or delete (D) student: ");
            if (v.checkInputUD()) {
                System.out.print("Enter id: ");
                String idStudent = v.checkInputString();
                System.out.print("Enter name student: ");
                String name = v.checkInputString();
                if (!v.checkIdExist(Main.ls, id, name)) {
                System.err.println("Id has exist student. Pleas re-input.");
                continue;
                }
                System.out.print("Enter semester: ");
                String semester = v.checkInputString();
                System.out.print("Enter name course: ");
                String course = v.checkInputCourse();
                //check user change or not
                if (!v.checkChangeInfomation(student, id, name, semester, course)) {
                    System.err.println("Nothing change.");
                }
                if (v.checkStudentExist(Main.ls, id, name, semester, course)) {
                    System.err.println("Update success.");
                    student.setId(idStudent);
                    student.setStudentName(name);
                    student.setSemester(semester);
                    student.setCourseName(course);
                    
                }
                return;
            } else {
                System.err.println("Delete success.");
                Main.ls.remove(student);
                Main.count--;
                
                return;
            }
            }
        }
    }

    public Student chooseStudent(ArrayList<Student> listStudentFindByName) {
        System.out.println("List student found: ");
        int count = 1;
        System.out.printf("%-10s%-15s%-15s%-15s\n", "Number", "Student name",
                "semester", "Course Name");
        for (Student student : listStudentFindByName) {
            System.out.printf("%-10d%-15s%-15s%-15s\n", count,
                    student.getStudentName(), student.getSemester(),
                    student.getCourseName());
            count++;
        }
        System.out.print("Enter number student to update or delete: ");
        int choice = v.checkInputIntLimit(1, listStudentFindByName.size());
        return listStudentFindByName.get(choice - 1);
    }

    public ArrayList<Student> findById(String id) {
        ArrayList<Student> getListStudentById = new ArrayList<>();
        for (Student student : Main.ls) {
            if (id.equalsIgnoreCase(student.getId())) {
                getListStudentById.add(student);
            }
        }
        return getListStudentById;
    }

    public void report() {
        if (Main.ls.isEmpty()) {
            System.err.println("List empty.");
            return;
        }
        ArrayList<Report> lr = new ArrayList<>();
        int size = Main.ls.size();
        for (int i = 0; i < size; i++) {
            
            for (Student student : Main.ls) {
                int total = 0;
                String id = student.getId();
                String courseName = student.getCourseName();
                String studentName = student.getStudentName();
                for (Student studentCountTotal : Main.ls) {
                    if (id.equalsIgnoreCase(studentCountTotal.getId())
                            && studentName.equalsIgnoreCase(studentCountTotal.getStudentName())
                            && courseName.equalsIgnoreCase(studentCountTotal.getCourseName())) {
                        total++;
                    }
                }
                if (v.checkReportExist(lr, studentName,
                        courseName, total)) {
                    lr.add(new Report(studentName, courseName, total));
                }
            }
        }
        for (int i = 0; i < lr.size(); i++) {
            System.out.printf("%-15s|%-10s|%-5d\n", lr.get(i).getStudentName(),
                    lr.get(i).getCourseName(), lr.get(i).getTotalCourse());
        }
    }
}
