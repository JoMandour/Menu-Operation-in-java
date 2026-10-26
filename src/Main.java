import java.util.Scanner;

public class Main {
    Scanner sc = new Scanner(System.in);
    ArrayOperations ops = new ArrayOperations(5);

    int readInt(String prompt) {
        IO.print(prompt);
        while (!sc.hasNextInt()) {
            IO.println("Invalid input. Enter an integer.");
            sc.next();
            IO.print(prompt);
        }
        return sc.nextInt();
    }

    void main() {
        int choice;
        do {
            IO.println("\n-----Array Operations Menu-----");
            IO.println("1- Append Item");
            IO.println("2- Traverse Items");
            IO.println("3- Access Item by index");
            IO.println("4- Search specific Item");
            IO.println("5- Insert Item at specific position");
            IO.println("6- Delete last Item");
            IO.println("7- Delete item at specific index");
            IO.println("8- Enlarge array");
            IO.println("9- Check if array is full");
            IO.println("0- Exit");

            choice = readInt("Choose an option: ");

            switch (choice) {
                case 1: ops.append(readInt("Enter a value: ")); break;
                case 2: IO.println("traverse called"); break;
                case 3: IO.println("access called"); break;
                case 4: IO.println("search called"); break;
                case 5: IO.println("insert called"); break;
                case 6: IO.println("delete last called"); break;
                case 7: IO.println("delete at index called"); break;
                case 8: IO.println("enlarge called"); break;
                case 9: IO.println(ops.isFull() ? "Full" : "Not full"); break;
                case 0: IO.println("Bye"); break;
                default: IO.println("Invalid option");
            }
        } while (choice != 0);
    }

    public class ArrayOperations {
    private int[] arr;
    private int size = 0;

    public ArrayOperations(int capacity) {
        arr = new int[capacity];
    }

    public boolean isFull() {
        return size == arr.length;
    }

    public void append(int value) {
        if (isFull()) {
            IO.println("Array is full.");
            return;
        }
        arr[size] = value;
        size++;
    }
  }
}
