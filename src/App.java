import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class App {

    public static int[] generateRandomArray(int size) {
        Random ran = new Random();

        int[] arr = new int[size];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = ran.nextInt(101);
        }
        return arr;
    }

    public static void swap(int[] arr, int i, int j) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;

    }

    public static void bubbleSort(int[] arr, int n) {
        if (arr == null || arr.length <= 1 || n == 0) {
            return;
        }
        for (int i = 0; i < n; i++) {
            if (arr[i] > arr[i + 1]) {
                swap(arr, i, i + 1);
            }
        }
        bubbleSort(arr, n - 1);
    }

    public static void bubbleSort(int[] arr) {
        bubbleSort(arr, arr.length - 1);
    }

    public static void bubbleSort2(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return;
        }
        boolean isSorted;
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = 0; j < arr.length - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    swap(arr, j, j + 1);
                }
            }

        }
    }

    public static boolean isSorted(int[] arr) {
        if (arr == null || arr.length <= 1) {
            return true;
        }
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] > arr[i + 1]) {
                return false;
            }
        }
        return true;
    }

    public static void writeToFile(int[] arr, String fileName) throws IOException {
        BufferedWriter writer = new BufferedWriter(new FileWriter(fileName));
        for (int i = 0; i < arr.length; i++) {
            writer.write(arr[i] + "\n");
        }
        writer.close();
    }

    public static int[] readFromFile(String fileName) throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(fileName));
        String line = reader.readLine();
        int i = 0;
        while (line != null) {
            // System.out.println(line);
            line = reader.readLine();
            i++;
        }
        reader.close();
        int[] arr = new int[i];
        reader = new BufferedReader(new FileReader(fileName));
        for (int j = 0; j < arr.length; j++) {
            arr[j] = Integer.parseInt(reader.readLine());
        }
        reader.close();
        return arr;
    }

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter the size of the array");
        int size = scanner.nextInt();
        scanner.nextLine();

        int[] arr = generateRandomArray(size);

        System.out.println("Enter the file name");
        String fileName = scanner.nextLine();

        writeToFile(arr, fileName);
        System.out.println("Array before sorting");
        int[] a = readFromFile(fileName);
        System.out.println(Arrays.toString(a));
        
        bubbleSort(a, arr.length - 1);
        System.out.println("Array after sorting");
        System.out.println(Arrays.toString(a));
        System.out.println("Is the array sorted? " + isSorted(a));
        writeToFile(a, "sortedFile.txt");
    }
}
