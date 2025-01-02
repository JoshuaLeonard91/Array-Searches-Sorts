package project1;
/**
 * <b>COP 3530: Project 1 – Array Searches and Sorts </b>  
 * <p>
 * Kendall class is to calculate kendall's tau for the matrix, there are two methods.
 * <p>
 * The checkCD and stats methods work together and checks whether 
 * the pairs of elements agree or disagree with each other for 
 * every other pair of element.
 * <p>
 * Example: Pairs at index 0 will compare with pairs at index 1,2,3,4.... and so on through the length of the array.
 * <p>
 * Then it will compare Pairs at index 1 with pairs at index 2,3,4.... and so on
 * until all elements have been paired and checked with each other.
 * @author Joshua Leonard
 * @version 9/7/2022
 *
 */
public class Kendall {
	
	/**
	 * (x1,y1) = pair 1<br>
	 * (x2,y2) = pair 2<br>
	 * if both elements in pair 2, x2 and y2 is greater than
	 * the elements in pair 1, x1 and y1 return true
	 * else return false.
	 * @param x1 covid case rate OR covid deaths rate sorted by from smallest to largest
	 * @param y1 covid case OR covid deaths sorted by GDPPC or POPDENS from smallest to largest
	 * @param x2 covid case rate OR covid deaths rate sorted by from smallest to largest
	 * @param y2 covid case OR covid deaths sorted by GDPPC or POPDENS from smallest to largest
	 * @return true or false
	 */
	public boolean checkCD(double x1,double y1,double x2,double y2) {
		return (x2 > x1 && y2 > y1);
	}//end checkCD
	/**
	 * Takes in two arrays and a string returns kendall's tau's value, two if statements, one checks the case rate and the other
	 * checks death rates, depending on what is passed in for the field string. It will call on checkCD to check whether the case rates, 
	 * agree or disagree with each other. More detailed explanation in checkCD method.
	 * @param r1 test case 1
	 * @param r2 test case 2
	 * @param field indicates the position on the kendall's matrix that is being calulcated.
	 * @return tau's value
	 */
	public double stats(Country[] r1,Country[] r2,String field) {
		//con = concordant (agree) dis = discordnant (disagrees)
		double con = 0;
		double dis = 0;
		// for upper left and upper right field in matrix
		if(field.equals("fieldOne") || field.equals("fieldTwo")) {
			for(int i = 0; i < r1.length;i++) {
				for(int j = i+1;j < r1.length;j++) {
					if(checkCD(r1[i].getCaseRate(),r2[i].getCaseRate(),r1[j].getCaseRate(),r2[j].getCaseRate()) == true) {
						con++;
					}else {
						dis++;
					}
				}
			}
		}//end if
		// for bottom left and bottom right field in matrix
		if(field.equals("fieldThree") || field.equals("fieldFour")) {
			for(int i = 0; i < r1.length;i++) {
				for(int j = i+1;j<r1.length;j++) {
					if(checkCD(r1[i].getDeathRate(),r2[i].getDeathRate(),r1[j].getDeathRate(),r2[j].getDeathRate()) == true) {
						con++;
					}else {
						dis++;
					}
				}
			}
		}//end if
		return (con-dis)/(con+dis);
	}//end stats
}//end kendall class
