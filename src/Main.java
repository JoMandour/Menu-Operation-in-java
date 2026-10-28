import java.util.Arrays;
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
            IO.println("5- Insert item at specific position");
            IO.println("6- Delete last item");;
            IO.println("7- Delete item at specific index");
            IO.println("8- Enlarge array");
            IO.println("9- Check if array is full");
            IO.println("0- Exit");

            choice = readInt("Choose an option: ");

            switch (choice) {
                case 1: ops.append(readInt("Enter a value: ")); break;
                case 2: ops.traverse(); break;
                case 3: ops.get(readInt("Enter index:")); break;
                case 4: ops.search(readInt("Search for a number :"));; break;
                case 5: {
                  int index = readInt("Enter index: ");
                  int value = readInt("Enter value: ");
                  ops.insertAt(index, value);
                  break;
                }
                case 6: ops.deleteLast(); break;
                case 7: ops.deleteAt(readInt("Enter index: ")); break;
                case 8: ops.enlarge(); break;
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

public void traverse() {
    if (size == 0) {
        IO.println("Array is empty.");
        return;
    }
    for (int i = 0; i < size; i++) {
        IO.println("[" + i + "] = " + arr[i]);
    }
}   
public void get (int index){
        if (index <0 || index>= size) {
            IO.println("Invalid index");
            return;
        }
        IO.println("["+index+"]=" + arr[index]);
}
public void search (int value){
        for (int i =0 ; i <size ; i++){
            if (value == arr[i]){
                IO.println("Elemnt found at index : " + i);
                return;
            }
        }
        IO.println("Element not found.");
}
public void deleteLast() {
    if (size == 0) {
        IO.println("Array is empty.");
        return;
    }
    size--;
    IO.println("Last item deleted.");
}


public void enlarge() {
    arr = Arrays.copyOf(arr, arr.length * 2);
    IO.println("Array enlarged. New capacity: " + arr.length);
}

public void insertAt(int index, int value) {
      if (isFull()) {
        IO.println("Array is full");
        return;
      }
      if (index < 0 || index > size) {
        IO.println("Invalid index");
        return;
      }
       for (int i = size; i > index; i--) {
        arr[i] = arr[i - 1];
      }
      arr[index] = value;
      size++;
}
public void deleteAt(int index) {
    if (size == 0) {
        IO.println("Array is empty.");
        return;
    }
    if (index < 0 || index >= size) {
        IO.println("Invalid index.");
        return;
    }
    for (int i = index; i < size - 1; i++) { // مش لاقطها اوي ,شبه هبدتها عكست العمليىة بتاع الي فوقها 
        arr[i] = arr[i + 1];
    }
    size--;
    IO.println("Item deleted.");
}
    }
       }
   









//public void deleteLast(){
       // for (int i=0 ; i<size ; i++) {
          // arr = Arrays.copyOf(arr, arr.length - 1);
         //  return;
        //}
    //}