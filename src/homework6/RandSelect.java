package homework6;

class RandSelect implements Selector {

	@Override
	public double select(double[] ar, int i) {
		return randSelect(ar, 0, ar.length - 1, i);
	}

    private double randSelect(double[] ar, int p, int r, int i){
        if (p == r)
            return ar[p];
        int q = randPartition(ar, p ,r);
        int k = q - p + 1;
        if (i == k)
            return ar[q];
        if (i < k)
            return randSelect(ar, p, q-1, i);
        else
            return randSelect(ar, q+1, r, i-k);
    }

    private int randPartition(double[] ar, int p, int r) {
        double x = ar[p];
        swapRand(ar, p, r);
        int i = p - 1;

        for (int j = p; j <= r-1; j++) {
            if (ar[j] <= x) {
                i++;
                swapRand(ar, i, j);
            }
        }
        swapRand(ar, i+1, r);
        return i+1;
    }

    private void swapRand(double[] ar, int i, int j) {
        double tmp = ar[i];
        ar[i] = ar[j];
        ar[j] = tmp;
    }
}
