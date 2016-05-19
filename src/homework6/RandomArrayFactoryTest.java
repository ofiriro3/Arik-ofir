package homework6;

import static org.junit.Assert.*;

import java.awt.List;
import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;

import org.junit.Test;

public class RandomArrayFactoryTest {

	@Test
	public void RandomArrayTest() {

		RandomArrayFactory array = new RandomArrayFactory();

		double[] a = array.getRandomArray(10);
		double digits = RandomArrayFactory.MAXDIGIT;

	}
	@Test
	public void RadixSortTest()
	{
		double [] array = { 0.523456889 ,0.323456888 ,0.1234567897 ,
							0.123456789 ,0.922456784 ,0.1238567863};
		
		double[] array2 = array.clone();
		RadixSort sort = new RadixSort();
		sort.sort(array);
		Arrays.sort(array2);
		
		for (int i = 0; i < array.length; i++) {
			
			System.out.print(array[i]+" ");
			if(i%3 ==0 && i>0)
				System.out.println();
		}
	}
	@Test
	public void FindDigit()
	{
		
		int i= RadixSort.this.findingDigit(0.123456789, 10);
				}
	
	
	
}