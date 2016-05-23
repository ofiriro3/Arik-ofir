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
		double [] array = new double [10];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = Math.random();
		}
		
		double[] array2 = array.clone();
		RadixSort sort = new RadixSort();
		sort.sort(array);
		Arrays.sort(array2);
		
		for (int i = 0; i < array.length; i++) {
			
			assertTrue(array2[i] == array[i]);
		}
	}
	@Test
	public void MergeSortTest()
	{
		double [] array = new double [10];
		
		for (int i = 0; i < array.length; i++) {
			array[i] = Math.random();
		}
		
		double[] array2 = array.clone();
		MergeSort sort = new MergeSort();
		sort.sort(array);
		Arrays.sort(array2);
		
		for (int i = 0; i < array.length; i++) {
			
			assertTrue(array[i] == array2[i]);
		}
	}
	
	
	
	
}