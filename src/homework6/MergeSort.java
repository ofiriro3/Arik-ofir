package homework6;

import java.util.Arrays;

public class MergeSort implements Sorter{

	@Override
	public void sort(double[] ar) {
		
		System.arraycopy(mergeSort(ar), 0, ar, 0, ar.length);
	}

	private double [] mergeSort(double[] ar) {
		
		if ( ar.length == 1)
		{
			return ar;
		}
	
			int mid = ar.length /2;
			double [] array1 = new double [mid];
			double [] array2 = new double [ar.length-mid];
			System.arraycopy(ar, 0, array1, 0, mid);
			System.arraycopy(ar, mid, array2, 0, array2.length);
			double [] array5 = mergeSort(array2);
			double [] array4 = mergeSort(array1);
			double [] array3 = merge(array4,array5);
			
		
		return array3;
	}

	private double [] merge(double[] array1, double[] array2) {
		
		double array3 [] = new double [array1.length+array2.length];
		int j = 0;
		int k = 0;
		for (int i = 0; i < array2.length +array1.length; i++) {
			
			if (j == array1.length)
			{
				System.arraycopy(array2, k, array3, i, array3.length-i);
				break;
			}
			else if(k == array2.length)
			{
				System.arraycopy(array1, j, array3, i, array3.length-i);
				break;

			}
			else
			{
				if(array1[j] < array2[k])
				{
					array3[i] = array1[j];
					j++;
				}
				else
				{
					array3[i] = array2[k];
					k++;
				}
			}
			
				
			
		}
		
		return array3;
	}

}
