package homework6;

public class InsertionSort implements Sorter {

	@Override
	public void sort(double[] ar) {

			insertionRec(ar,ar[1],1,1);
	}		
		private static void insertionRec(double [] ar , double Val , int index , int temp)
		{
			if ( temp-1 < 0 || ar[temp-1] < Val)
			{
				ar[temp] = Val;
				if (index+1 > ar.length-1)
				{
					return;
				}
				insertionRec(ar, ar[index+1], index+1,index+1);
				return;
			}
			ar[temp] = ar[temp-1];
			insertionRec(ar, Val, index, temp-1);
		}
				
	}


