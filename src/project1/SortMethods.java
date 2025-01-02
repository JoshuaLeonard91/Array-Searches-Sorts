package project1;

import java.util.List;

/**
 * <b>COP 3530: Project 1 – Array Searches and Sorts </b>  
 * <p>
 * This class contains 4 different sorting methods, three are used for the
 * display menu and one is used for the kendall's tau matrix for display menu 6.
 * <p>
 * <b>Sort methods class</b><br>
 * insertionSort: Sorts countries by names.<br>
 * selectionSort: Sorts countries by CFR.<br>
 * bubbleSort: Sorts countries by GDPPC.<br>
 * kenSort: Sorts countries depending on what type of
 * sorting is being required.
 * @author Joshua Leonard
 * @version 9/15/2022
 */

public class SortMethods {
	/**
	 * This method will sort a country with insertion sort, it will split the array into
	 * a sorted section and unsorted section, the values from the section that is not sorted are taken
	 * and inserted into the appropriate sorted section of the array.
	 * @param country takes in array of countries.
	 */
	public void insertionSort(Country[] country) {
		int inner;
		int outer;
		for(outer = 1;outer<country.length;outer++) {
			Country temp = country[outer];
		    inner = outer - 1;
			while(inner>=0 && temp.getName().compareTo(country[inner].getName())<=0) {
				country[inner+1] = country[inner];
				inner--;
			}//end while
			country[inner+1] = temp;
		}
	}//end insertionSort
	/**
	 * This method will sort an array with selection sort, it will scan all elements in the array
	 * to find the smallest item, in this case case fatality rate, and will swap the smallest element and place it
	 * in the appropriate sorted position. Will repeat this process until there are no more elements to sort.
	 * @param country takes in array of countries.
	 */
	public void selectionSort(Country[] country) {
		int outer = 0;
		while(outer<country.length-1) {
			int lowest = outer;
			int inner = outer + 1;
			while(inner<country.length) {
				if(country[inner].getCFR() < country[lowest].getCFR()) {
					lowest = inner;
				}//end if
				inner++;
			}//end second while
			if(lowest != outer) {
				Country temp = country[lowest];
				country[lowest] = country[outer];
				country[outer] = temp;
			}//end if
			outer++;
		}//end first while
	}//end selectionSort
	/**
	 * This method will sort countries by GDP per capita and will print out 
	 * that this method was used for sorting. This will start at the end of the
	 * array and compare each element going toward the start of an array, if the second to last 
	 * element is bigger it will swap the two and move to the next comparison.
	 * @param country takes in array of countries.
	 */
	public void bubbleSort(Country[] country) {
		for(int outer = 0; outer<country.length-1; outer++) {
			for(int inner = country.length-1; inner > outer ; inner--) {
				if(country[inner].getGDPPC() < country[inner-1].getGDPPC()) {
					Country temp = country[inner];
					country[inner] = country[inner-1];
					country[inner-1] = temp;
				}//end if
			}//end second for loop
		}//end first for loop
	}//end bubbleSort
	/**
	 * This method will sort a array of countries depending on the field string that is passed through.<br>
	 * Required field types are either CASERATE, DEATHRATE,GDPPC OR POPDENS.<br>
	 * @param toSort array of countries to sort
	 * @param field takes in 4 different types of strings
	 */
	public void kenSort(Country[] toSort,String field) {
		int outer = 0;
		while(outer<toSort.length-1) {
			int lowest = outer;
			int inner = outer + 1;
			while(inner<toSort.length) {
				
				if(field.equals("CASERATE") && toSort[inner].getCaseRate()<toSort[lowest].getCaseRate()) {
					lowest = inner;
				}
				if(field.equals("DEATHRATE") && toSort[inner].getDeathRate()<toSort[lowest].getDeathRate()) {
					lowest = inner;
				}
				if(field.equals("GDPPC") && toSort[inner].getGDPPC()<toSort[lowest].getGDPPC()) {
					lowest = inner;
				}
				if(field.equals("POPDENS") && toSort[inner].getPopDens()<toSort[lowest].getPopDens()) {
					lowest = inner;
				}//end 
				
				inner++;
			}//end second while loop
			if(lowest != outer) {
				Country temp = toSort[lowest];
				toSort[lowest] = toSort[outer];
				toSort[outer] = temp;
			}//end if
			outer++;
		}//end first while loop
	}//end kenSort
}
