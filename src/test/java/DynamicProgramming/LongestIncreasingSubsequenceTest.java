package DynamicProgramming;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class LongestIncreasingSubsequenceTest {
	
	//DataProvider for the control flow test method LIS
	@DataProvider
	public static Object[][] dataProviderLIS() {
		int[] ar1 = {};
		int[] ar2 = {5};
		int[] ar3 = {3,2,1};
		int[] ar4 = {1,2,3};
		int[] ar5 = {1,2,1,4,1};
		
		return new Object[][] {
			{ar1,0},
			{ar2,1},
			{ar3,1},
			{ar4,3},
			{ar5,3},
		};
	}
	
	//Unit test for the control flow test method LIS
	@Test
	@UseDataProvider("dataProviderLIS")
	public void LISTest(int[] array, int expected) {
		
		Assert.assertEquals(expected, LongestIncreasingSubsequence.LIS(array));
		
	}
	
	//DataProvider for the data flow test method upperBound
	@DataProvider
	public static Object[][] dataProviderUpperBound() {
		int[] ar = {3,10,20,0,0};
		
		
		return new Object[][] {
			{ar,2,2,21,2},
			{ar,-1,3,11,2},
			{ar,-1,3,21,3},
		};
	}
	
	//Unit test for the data flow test method upperBound
	@Test
	@UseDataProvider("dataProviderUpperBound")
	public void upperBoundTest(int[] ar, int l, int r, int key, int expected) {
		
		Assert.assertEquals(expected, LongestIncreasingSubsequence.upperBound(ar,l,r,key));
		
	}

}
