package OtherProjects.Lab01;

import java.util.Scanner;

public class Stars {
	public static void printStars(int n) {	
		int i, j;

		for(i = 1; i <= n; i++) {
			for(j = 1; j <= n - i; j++) {				
				System.out.print(" ");
			}
			for(j = 0; j < 2 * i - 1; j++) {				
				System.out.print("*");
			}
			System.out.println();
		}			
	}	
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		int n = keyboard.nextInt();
		
		printStars(n);
		keyboard.close();
	}
}

