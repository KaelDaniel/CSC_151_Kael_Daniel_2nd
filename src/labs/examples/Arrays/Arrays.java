package labs.examples.Arrays;

import java.util.Scanner;

public class Arrays {

    public static void main(String[] args) {
        int[] numbers1 = FirstArray();
        int[] numbers2 = SecondArray();
        boolean equalLength = numbers1.length == numbers2.length;
        if (!equalLength) {
            System.out.println("Array values are not equal in length.");
        } else {
            System.out.println("Array values are equal in length.");
        }
        if (equalLength) {
            for (int i = 0; i < numbers1.length; i++) {
                if (numbers1[i] != numbers2[i]) {
                    System.out.println("Array values are not equal.");
                    return;
                }
            }
        System.out.println("Array values are equal.");
        }
}

    public static int[] FirstArray() {
        Scanner scanner = new Scanner(System.in);

        int x = scanner.nextInt();

        int[] numbers = new int[x];

        for (int i = 0; i < numbers.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers[i] = scanner.nextInt();
        }
        return numbers;
    }

    public static int[] SecondArray() {
        Scanner scanner = new Scanner(System.in);

        int y = scanner.nextInt();

        int[] numbers2 = new int[y];

        for (int i = 0; i < numbers2.length; i++) {
            System.out.print("Enter number " + (i + 1) + ": ");
            numbers2[i] = scanner.nextInt();
        }
        return numbers2;
    }
}