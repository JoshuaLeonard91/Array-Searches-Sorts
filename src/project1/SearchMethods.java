package project1;

/**
 * <b>COP 3530: Project 1 – Array Searches and Sorts </b>  
 * <p>
 * The search method class has three different methods, one method is always called from
 * the project class file depending if it was called or not. If the method is called it will
 * call either binSearch of SeqSearch depending on the search flag passed to the searchKey method. 
 * <p>
 * <b>Simple searching methods</b><br>
 * binSearch: Binary Search<br>
 * seqSearch: Sequential search<br>
 * searchKey: Calls either binSearch or seqSearch<br>
 * depending on whether the search flag is true or false
 * @author Joshua Leonard
 * @version 9/8/2022
 */

public class SearchMethods {
	
	 
	/**
	 * Search flag is passed through to this method<br>
	 * If search flag is true, it will call on the seqSearch method and search the array.<br>
	 * If search flag is false, it will called on the binSearch method and search the array<br>
	 * key = user input<br>
	 * @param searchFlag true or false, this is set in project 1 class and passed here
	 * @param country array of country objects
	 */
	public void searchKey(boolean searchFlag,Country[] country,String key) {
		if(searchFlag == false) {
			System.out.println(binSearch(country,key));
			}else{
				System.out.println(seqSearch(country,key));
			}
	}//end searchKey
	/**
	 * Simple Binary search method, takes in an array and a key. If the searchflag
	 * from searchKey is false this method will be called.
	 * @param country array of country objects
	 * @param key user input from searchKey Method
	 * @return1 If not found, return string not found
	 * @return2 If found, return country search data
	 */
	public String binSearch(Country[] country,String key) {
		
		int i = 0;
		int j = country.length-1;
		int mid;
		
		while(i <= j) {
			mid = (i + j) / 2;
			if(country[mid].getName().compareTo(key) < 0) {
				i = mid + 1;
			}else if(country[mid].getName().compareTo(key) > 0) {
				j = mid - 1;
			}else {
				System.out.println("Binary search is used.\n");
				return country[mid].getSearchData();
			}
		}
		System.out.println("Binary search is used.\n");
		return "Error country "+key+" not found.\n";
	}//end binSearch
	/**
	 * Simple Sequential search method, takes in an array and a key. If the search flag from
	 * searchKey method is true this method will be called.
	 * @param country array of country objects
	 * @param key user input from searchKey Method
	 * @return1 If not found, return string not found
	 * @return2 If found, return country search data
	 */
	public String seqSearch(Country[] country,String key) {
		int j = 0;
		while(j<country.length) {
			if(country[j].getName().equals(key)) {
				break;
			}
			j++;
		}
		System.out.println("Sequential search is used.\n");
		if(j == country.length) {
			return "Error: country "+key+" not found.\n";
		}
		else {
			return country[j].getSearchData();
		}
	}//end seqSearch
}//end sortMethods class
