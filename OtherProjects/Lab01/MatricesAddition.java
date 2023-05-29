package Others.Lab01;

import java.util.Scanner;

public class MatricesAddition {
    public static void addTwoMatrices(int[][] a, int[][] b) {       
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                a[i][j] += b[i][j];
            }
        }
        
        for (int i = 0; i < a.length; i++) {
            for (int j = 0; j < a[0].length; j++) {
                System.out.print(a[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Number of rows: ");
        int m = sc.nextInt();
        sc.nextLine();
        System.out.println("Number of column: ");
        int n = sc.nextInt();
        sc.nextLine();

        int[][] a = new int[m][n];
        int[][] b = new int[m][n];
        
        System.out.println("Type the first matrix's rows respectively:");
        for (int i = 0; i < m; i++) {
            String[] row = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                a[i][j] = Integer.parseInt(row[j]);
            }
        }

        System.out.println("Type the second matrix's rows respectively:");
        for (int i = 0; i < m; i++) {
            String[] row = sc.nextLine().split(" ");
            for (int j = 0; j < n; j++) {
                b[i][j] = Integer.parseInt(row[j]);
            }
        }

        addTwoMatrices(a, b);
        sc.close();
    }
}