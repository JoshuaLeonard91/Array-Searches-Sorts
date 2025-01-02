/*
 * Author: Joshua Leonard
 * Course: COP3530
 * Project #: 1
 * Title: Array Searches and Sorts
 * Due Date: 9/16/2022
 *
 * This program demonstrates the use of:
 * 1: binary and sequential searches.
 * 2: bubble sort, insertion sort and selection sort.
 * 3: demonstrates calculating kendall's tau and printing out the matrix.
 * 
 */
package project1;
import java.io.IOException;
import java.util.Scanner;
/**
 * <b>COP 3530: Project 1 – Array Searches and Sorts </b> 
 * <p>
 * This is the main class file that handles the display menu, reading in the user input for the file
 * creating the arrays, and printing both kendalls tau matrix and both formatted strings with country data.
 * @author Joshua Leonard
 * @version 9/8/2022
 */
public class Project1 {
	
	public static Country[] country;
	public static Country[] r1;
	public static Country[] r2;
	private static FileHandler fileHandler = new FileHandler();
	private static String fileName;
	private static boolean searchFlag = true;
	private static SortMethods sort = new SortMethods();
	private static SearchMethods search = new SearchMethods();
	private static Kendall kendall = new Kendall();
	/**
	 * <b>!Entry Point!</b>
	 * <p>
	 * This is the main function.
	 * <p>
	 * It prints out the the Project #, Who the instructor is, who the student is, students N#:,
	 * and the name of the project.
	 * <p>
	 * The program will loop until a correct file name is given, it will create a new array of country objects with its
	 * size set equal to the number of lines counted in the file.
	 * <p>
	 * If the file was successfully read it will clone the new array to r1 and r2 for later use, print out the number of 
	 * records read and call the display menu. After the display menu option 7 is used this class will set the flag to true and
	 * end the program.
	 * @param args
	 */
	public static void main(String[] args) {
		Scanner file = new Scanner(System.in);
		System.out.println("COP3530 Project 1\nInstructor: Professor Liu\nStudent: Joshua Leonard\nN#: N01476308\nArray Searches and Sorts\n");
		
		
		boolean flag = false;
		while(!flag) {
			try {
				System.out.println("Enter the file name:");
				fileName = file.nextLine();
				country = new Country[fileHandler.setSize(fileName)];
				fileHandler.readCountry(fileName);
				r1 = country.clone();
				r2 = country.clone();
				System.out.println();
				System.out.println("There were "+country.length+" records read.");
				System.out.println();
				displayMenu();
				flag = true;
		}catch (IOException e) {
			System.out.println("File not found: " + e.getMessage());
			}
		}//end while loop
		file.close();
	}//end main
	/**
	 * This methods is the display menu, it will loop until the user selects 7 to quit the program. Each input
	 * will call on another method or methods to get the correct data.
	 * <p>
	 * 1: prints out all the countries reports<br>
	 * 2: sorts by name<br>
	 * 3: sorts by case fatality rate<br>
	 * 4: sorts by GDP per capita<br>
	 * 5: search for a country the user input<br>
	 * 6: print the kendall's tau matrix<br>
	 * 7: quits program<br>
	 */
	public static void displayMenu()
    {
		//variable declarations
        Scanner scnr = new Scanner(System.in);
        boolean flag = true;
        boolean inputFlag = false;
       
        //Loop user options until user types "7" sets the flag
        // to false will call a new displayMenu.
        do {
            //user options print statements
            System.out.println("Please make a selection: ");
            System.out.println("1) Print a countries report");
            System.out.println("2) Sort by Name");
            System.out.println("3) Sort by Case Fatality Rate");
            System.out.println("4) Sort by GDP per capita");
            System.out.println("5) Find and print a given country ");
            System.out.println("6) Print Kendall's tau matrix");
            System.out.println("7) Quit Program");
            //prints out what the user selected
            String input = "";
            while(!inputFlag) {
            	input = scnr.nextLine();
            	if(input.matches("1|2|3|4|5|6|7")){
            		inputFlag = true;
            	}else {
            		System.out.println("Invalid Choice! Please enter 1-7:");
            	}//end if/else
            }//end while
            inputFlag = false;
            switch (input) {
            	
                case "1" : printData(country);
                    break;
                case "2" : sort.insertionSort(country);
                System.out.println("Countries sorted by Name.\n");
                searchFlag=false;
                    break;
                case "3" : sort.selectionSort(country);
                System.out.println("Countries sorted by Case Fatality Rate.\n");
                searchFlag=true;
                    break;
                case "4" : sort.bubbleSort(country);
                System.out.println("Countries sorted by GDP per capita.\n");
                searchFlag=true;
                    break;
                case "5" : 
                	System.out.println("Enter country name:");
                	String key = scnr.nextLine();
                	search.searchKey(searchFlag,country,key);
                	break;
                case "6" : kendall();
                    break;
                case "7" : System.out.println("Programing Exiting");
                    flag = false;
            }
        }while(flag);//end do-while
        scnr.close();
    }//end displayMenu
	/**
	 * This methods prints out the header followed by dash line to indicate seperation.
	 * <p>
	 * The second half of this method will print out each country in the array in the specified format.
	 * <p>
	 * NAME CAPTIAL GDPPC CASERATE DEATHRATE POPDENS
	 * <p>
	 * @param country array of country objects
	 */
	public static void printData(Country[] country) {
		System.out.println("\n");
		String name = "Name";
		String capital = "Capital";
		String gdppc = "GDPPC";
		String cfr = "CFR";
		String cr = "CaseRate";
		String dr = "DeathRate";
		String den = "PopDensity";
		System.out.printf("%-39s %s %11s %11s %13s %13s %13s\n",name,capital,gdppc,cfr,cr,dr,den);
		System.out.println
		("--------------------------------------------------------------------------------------------------------------------");
		for(int i = 0; i < country.length;i++) {
			System.out.println(country[i].getData());
		}//end for loop
		System.out.println("\n");	
	}//end printData
	/**
	 * This method creates the formatted matrix and takes in passed values for each box.
	 * @param num1 top left corner
	 * @param num2 top right corner
	 * @param num3 bottom left corner
	 * @param num4 bottom right corner
	 */
	public static void kendOuput(double num1,double num2,double num3,double num4) {
		String l = "|";
		String cr = "COVID Case Rate";
		String dr = "COVID Death Rate";
		String g = "GDPPC";
		String p = "PopDensity";
		String x1 = String.format("%.4f", num1);
		String x2 = String.format("%.4f", num2);
		String x3 = String.format("%.4f", num3);
		String x4 = String.format("%.4f", num4);
		System.out.println("\n\n-------------------------------------------");
		System.out.printf("%s%18s%8s%4s%11s%1s\n", l,l,g,l,p,l);
		System.out.println("-------------------------------------------");
		System.out.printf("%s%16s%2s%8s%4s%9s%3s\n", l,cr,l,x1,l,x2,l);
		System.out.printf("%s%17s%1s%8s%4s%9s%3s\n", l,dr,l,x3,l,x4,l);
		System.out.println("-------------------------------------------\n\n");
	}//end kendOutput
	/**
	 * This method is called from the display menu selection.
	 * <p>
	 * This method calls on kenSort 6 times to sort the arrays according to whats needed for the kendall's tau matrix.
	 * <p>
	 * Strings with field 1 and field 2 both require r1 array to be sorted by case rate, r2 has to be sorted twice by GDPPC followed by POPDENS.
	 * <p>
	 * Strings with field 3 and 4 both require r1 array to be sorted by death rate, r2 has to be sorted twice by GDPPC followed by POPDENS
	 * <p>
	 * calls kendOutput at the end of the method passing the values of x1,x2,x3, and x4.
	 */
	public static void kendall() {
		
		//sort by case rate
		sort.kenSort(r1,"CASERATE");
		//field 1
		sort.kenSort(r2,"GDPPC");
		double x1 = kendall.stats(r1, r2, "fieldOne");
		//field 2
		sort.kenSort(r2,"POPDENS");
		double x2 = kendall.stats(r1, r2, "fieldTwo");
		//sort by death rate
		sort.kenSort(r1,"DEATHRATE");
		//field 3
		sort.kenSort(r2,"GDPPC");
		double x3 = kendall.stats(r1, r2, "fieldThree");
		//field 4
		sort.kenSort(r2,"POPDENS");
		double x4 = kendall.stats(r1, r2, "fieldFour");
		kendOuput(x1, x2, x3, x4);
		
	}//end kendall
}

