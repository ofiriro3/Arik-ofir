package homework6;

public class RandomArrayFactory {

	final static double MAXDIGIT = Math.pow(10, 10);
	
	/**
	 * Construct an array sized "size" of random double numbers between [0,1)
	 * Numbers are set to have only 10 digits after the point
	 * @param size
	 * @return
	 */
	public double[] getRandomArray(int size) {		
		
		double [] array = new double [size];
		
		for (int i = 0; i < array.length; i++) {
			
			array[i] = (double)((Math.round(Math.random()*MAXDIGIT))/MAXDIGIT);
		}
		
		return array;
		
	}

	

}
