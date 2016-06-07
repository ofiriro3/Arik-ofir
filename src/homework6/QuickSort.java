package homework6;

class QuickSort implements Sorter{

	@Override
	public void sort(double[] ar) {
		quickSort(ar, 0, ar.length - 1);
	}

	private void quickSort(double[] ar, int p, int r){
		if (p < r){
			int q = partition(ar, p, r);
			quickSort(ar, p, q - 1);
			quickSort(ar, q + 1, r);
		}
	}
	private int partition(double[] ar, int p, int r){
		double x = ar[p];
		int i = p - 1;
		int j = r + 1;

		while (true){
			do {
				i++;
			} while(ar[i] < x);

			do {
				j--;
			} while(ar[j] > x);
			if(i < j)
				swap(ar, i, j);
			else
				return j + 1;
		}

	}
	private void swap(double[] ar, int i, int j) {
		double tmp = ar[j];
		ar[j] = ar[i];
		ar[i] = tmp;
		
	}

}
