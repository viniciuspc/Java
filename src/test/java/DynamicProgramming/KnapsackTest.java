package DynamicProgramming;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class KnapsackTest {
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	//DataProvider for the data flow test method knapsack
	@DataProvider
	public static Object[][] dataProviderKnapsack() {
		int[] wt1 = {};
		int[] wt2 = {10,20,30};
		int[] wt3 = {10,10,30};
		int[] wt4 = {10,20,30};
		
		int[] val1 = {};
		int[] val2 = {7,9,11};
		int[] val3 = {7,9,11};
		int[] val4 = {7,9,11};
		
		return new Object[][] {
			{50,wt1,val1,0,0},
			{10,wt2,val2,3,7},
			{10,wt3,val3,3,9},
			{20,wt4,val4,3,9},
		};
	}
	
	//Unit test for the data flow test method knapsack
	@Test
	@UseDataProvider("dataProviderKnapsack")
	public void knapsackTest(int W, int wt[], int val[], int n,int expected) {
		
		Assert.assertEquals(expected, Knapsack.knapSack(W, wt, val, n));
		
	}
	
	//Unit test for the data flow test method knapsack - case that throws exception.
	@Test
	public void knapsackTestException() {
		
		int W = -1; 
		int wt[] = {10,20,30};
		int val[] = {7,9,11};
		int n = 3;
		
		thrown.expect(ArrayIndexOutOfBoundsException.class);
		
		Knapsack.knapSack(W, wt, val, n);
		
	}
	

}
