package Conversions;

import org.junit.Assert;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;

import com.tngtech.java.junit.dataprovider.DataProvider;
import com.tngtech.java.junit.dataprovider.DataProviderRunner;
import com.tngtech.java.junit.dataprovider.UseDataProvider;

@RunWith(DataProviderRunner.class)
public class OctalToDecimalTest {
	
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	//DataProvider for the black box test which will not cause exceptions
	@DataProvider
	public static Object[][] dataProviderOctalToDecimalNoException() {
		
		return new Object[][] {
			{"-77",-63},
			{"-76",-62},
			{"-7",-7},
			{"-6",-6},
			{"-1",-1},
			{"-0",0},
			{"1",1},
			{"6",6},
			{"7",7},
			{"76",62},
			{"77",63},
		};
	}
	
	//Unit test for the black box test which will not cause exceptions
	@Test
	@UseDataProvider("dataProviderOctalToDecimalNoException")
	public void OctalToDecimalNoExceptionTest(String octal, int expected) {
		
		Assert.assertEquals(expected, OctalToDecimal.convertOctalToDecimal(octal));
		
	}
	
	//DataProvider for the black box test which will cause exceptions number format exception
	@DataProvider
	public static Object[][] dataProviderOctalToDecimalWithException() {
		
		return new Object[][] {
			{"-7A"},
			{"-78"},
			{"-A"},
			{"-8"},
			{"8"},
			{"A"},
			{"78"},
			{"7A"},
		};
	}
	
	//Unit test for the black box test which will cause exceptions number format exception
	@Test
	@UseDataProvider("dataProviderOctalToDecimalWithException")
	public void OctalToDecimalWithExceptionTest(String octal) {
		thrown.expect(NumberFormatException.class);
		OctalToDecimal.convertOctalToDecimal(octal);
		
	}

}
