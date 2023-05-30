package OtherProjects.hust.soict.dsai.lab01;

import java.util.Scanner;

public class NumberOfDays {
	public static int getNumberOfDays(String month, int year){		
		int m = 0;
		int day = 0;
		
		switch(month.toLowerCase()) {
			case "january":
			case "jan":
			case "jan.":
			case "1":
				m = 1;
				break;
			case "february":
			case "feb":
			case "feb.":
			case "2":
				m = 2;
				break;
			case "march":
			case "mar":
			case "mar.":
			case "3":
				m = 3;
				break;
			case "april":
			case "apr":
			case "apr.":
			case "4":
			    m = 4;
			    break;
			case "may":
			case "5":
			    m = 5;
			    break;
			case "june":
			case "jun":
			case "jun.":
			case "6":
			    m = 6;
			    break;
			case "july":
			case "jul":
			case "jul.":
			case "7":
			    m = 7;
			    break;
			case "august":
			case "aug":
			case "aug.":
			case "8":
			    m = 8;
			    break;
			case "september":
			case "sep":
			case "sep.":
			case "9":
			    m = 9;
			    break;
			case "october":
			case "oct":
			case "oct.":
			case "10":
			    m = 10;
			    break;
			case "november":
			case "nov":
			case "nov.":
			case "11":
			    m = 11;
			    break;
			case "december":
			case "dec":
			case "dec.":
			case "12":
			    m = 12;
			    break;
			default:
			    break;
		    }
		
		if ((m == 2) && checkLeap(year)) {
			day = 29;
		} else if (m == 2) {
			day = 28;
		} else if (m == 4
				|| m == 6
				|| m == 9
				|| m == 11) {
			day = 30;
		} else if (m != 0) {
			day = 31;
		}
		
		return day;
	}
	
	public static boolean checkLeap(int year) {
		return ((year % 4 == 0) && (year % 100 != 0))
				|| (year % 400 == 0);			
	}
	
	public static void main(String args[]) {
		Scanner keyboard = new Scanner(System.in);
		String month = keyboard.nextLine();
		int year = keyboard.nextInt();
		
		System.out.print(getNumberOfDays(month, year));
		keyboard.close();
	}
}
