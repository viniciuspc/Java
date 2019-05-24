package Others;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class GCDTest {
	
	//DataProvider for the control flow test method GCD
	@DataProvider
	public static Object[][] dataProviderGCD() {
		
		return new Object[][] {
			{0,5,5},
			{5,0,5},
			{4,2,2},
			{3,6,3},
		};
	}
	
	//Unit test for the control flow test method LIS
	@Test
	@UseDataProvider("dataProviderGCD")
	public void gcdTest(int num1, int num2, int expected) {
		
		Assert.assertEquals(expected, GCD.gcd(num1, num2));
		
	}

}
