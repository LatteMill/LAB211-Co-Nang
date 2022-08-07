package Manager;

import java.util.ArrayList;


public class Main {
    
    static int count = 10;
    static ArrayList<Student> ls = new ArrayList<>();
    public static void main(String[] args) {
        
        Validation validation = new Validation();
        ls.add(new Student("1", "Pham Ngoc Hoa", "Spring-20", "java"));
        ls.add(new Student("2", "Do Quang Hiep", "Summer-19", ".net"));
        ls.add(new Student("3", "Nguyen Xuan Cuong", "Spring-21", "c/c++"));
        ls.add(new Student("3", "Nguyen Xuan Cuong", "Fall-19", "java"));
        ls.add(new Student("4", "Ha Minh Nghia", "Summer-20", ".net"));
        ls.add(new Student("5", "Ha Huy Hieu", "Fall-20", ".net"));
        ls.add(new Student("3", "Nguyen Xuan Cuong", "Fall-20", "c/c++"));
        ls.add(new Student("2", "Do Quang Hiep", "Summer-21", "Java"));
        ls.add(new Student("5", "Ha Huy Hieu", "Summer-19", "c/c++"));
        ls.add(new Student("4", "Ha Minh Nghia", "Spring-20", ".net"));             
        
        Manager m = new Manager();
        while (true) {
            m.menu();
            int choice = validation.checkInputIntLimit(1, 5);
            switch (choice) {
                case 1:
                    m.createStudent(Main.count);
                    break;
                case 2:
                    m.findAndSort();
                    break;
                case 3:
                    m.updateOrDelete(count);
                    break;
                case 4:
                    m.report();
                    break;
                case 5:
                    return;
            }

        }
    }

}
