package homework6;

public class RadixSort implements Sorter {

	/**
	 * Since out numbers have only 10 digits perform radix sort over thier 10
	 * digits 
	 */
	@Override
	public void sort(double[] ar) {

		for (int i = 0; i < ar.length; i++) {
			
			RadixSort(ar , 10-i);
		}
		
	}

	private void RadixSort(double[] ar, int digitToSort) {
		
		// Create new array for the counting sort of the specific digit
		int [] CountingSortCells = new int [10];
		int [] digitsOfAr = new int [ar.length];
		
		for (int i = 0; i < ar.length; i++) {
			
			int digit = findingDigit(ar[i], digitToSort);
			CountingSortCells[digit]++;
			digitsOfAr[i] = digit;
		}
		
		for (int i = 1; i < CountingSortCells.length; i++) {
			
			CountingSortCells[i]+=CountingSortCells[i-1];
		}
		double [] newAr = new double [ar.length];
		for (int i = ar.length-1 ; i >= 0; i--) {
			
			int digitOfThisNum = digitsOfAr[i];
			int newCell = CountingSortCells[digitOfThisNum];
			newAr[newCell-1] = ar[i];
			CountingSortCells[digitOfThisNum]--;
			
		}
		
		ar = newAr;
		
		
	}

	private int findingDigit(double num, int digitToSort) {
		
		for (int j = 0; j < digitToSort; j++) {
			
			num = num *10 ;
			
		}
		
		return ((int)num) %10;
}}