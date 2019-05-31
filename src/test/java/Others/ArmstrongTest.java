package Others;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class ArmstrongTest {

	//DataProvider for the control flow test method checkIfANumberIsAmstrongOrNot
	@DataProvider
	public static Object[][] dataProviderArmstrongFunction() {
		return new Object[][] {
			{0, true},
			{1, true},
			{-1, false},
			{2, false}
		};
	}
	
	//Unit test for the control flow test method checkIfANumberIsAmstrongOrNot
	@Test
	@UseDataProvider("dataProviderArmstrongFunction")
	public void isArmstrongTest(int number, boolean expected) {
		
		Assert.assertEquals(expected, Armstrong.checkIfANumberIsAmstrongOrNot(number));
	}
}
