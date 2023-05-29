package OtherProjects.Lab01;

import java.util.Scanner;

public class ArrayManipulation {
    public static void bubbleSort(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i - 1] > arr[i]) {
                int tmp = arr[i];
                arr[i] = arr[i - 1];
                arr[i - 1] = tmp;
                i = 0;
            }
        }

        for (int i = 0; i < arr.length; i++)
            System.out.print(arr[i] + " ");

        System.out.println();
    }

    public static int calculateSum(int[] arr) {
        int sum = 0;

        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }

        return sum;
    }

    public static double calculateAvg(int[] arr) {
        double avg = calculateSum(arr);
        return avg / arr.length;   
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Type the length of the array: ");
        int l = sc.nextInt();
        sc.nextLine();
        
        int[] arr = new int[l];

        System.out.println("Type the array: ");
        String[] sarr = sc.nextLine().split(" ");

        for (int i = 0; i < l; i++) {
            arr[i] = Integer.parseInt(sarr[i]);
        }
        
        System.out.print("The sorted array is ");
        bubbleSort(arr);
        System.out.println("The sum of the elements in the array is " + calculateSum(arr));
        System.out.println("The average value of the elements in the array is " + calculateAvg(arr));
        sc.close();
    }
}
