package Others;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

import DynamicProgramming.LevenshteinDistance;

@RunWith(DataProviderRunner.class)
public class EulersFunctionTest {

	//DataProvider for the control flow test method EulersFunction
	@DataProvider
	public static Object[][] dataProviderEulersFunction() {
		return new Object[][] {
			{1,1},
			{2,1},
			{5,4},
			{4,2},
			{20,8}
		};
	}
	
	//Unit test for the control flow test method EulersFunction
	@Test
	@UseDataProvider("dataProviderEulersFunction")
	public void eulerTest(int n, int expected) {
		
		Assert.assertEquals(expected, EulersFunction.getEuler(n));
	}
}
