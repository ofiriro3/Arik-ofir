package homework6;

import static org.junit.Assert.*;

import org.junit.Test;

public class RandomArrayFactoryTest {

	@Test
	public void test() {

		RandomArrayFactory array = new RandomArrayFactory();

		double[] a = array.getRandomArray(10);
		double digits = RandomArrayFactory.MAXDIGIT;

		for (int i = 0; i < a.length; i++) {
			
			System.out.println(a[i]);
		}
	}
}
