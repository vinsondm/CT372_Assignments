import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();

        students.add(new Student(3, "Jack", "123 A St"));
        students.add(new Student(1, "Ivy", "456 B St"));
        students.add(new Student(5, "Hank", "789 C St"));
        students.add(new Student(2, "Greg", "101 D St"));
        students.add(new Student(4, "Frank", "202 E St"));
        students.add(new Student(8, "Elle", "303 F St"));
        students.add(new Student(6, "Deborah", "404 G St"));
        students.add(new Student(7, "Chuck", "505 H St"));
        students.add(new Student(10, "Bob", "606 I St"));
        students.add(new Student(9, "Alice", "707 J St"));

        System.out.println("Original List:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sorting by name
        SelectionSort.selectionSort(students, new NameComparator());

        System.out.println("\nSorted by Name:");
        for (Student student : students) {
            System.out.println(student);
        }

        // Sorting by rollno
        SelectionSort.selectionSort(students, new RollNoComparator());

        System.out.println("\nSorted by Roll No:");
        for (Student student : students) {
            System.out.println(student);
        }
    }
}