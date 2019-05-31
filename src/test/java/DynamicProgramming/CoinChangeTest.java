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
public class CoinChangeTest {

	@Rule
    public ExpectedException thrown = ExpectedException.none();
	
	//DataProvider for the control flow test method minimumCoins
	@DataProvider
	public static Object[][] dataProviderCoinChangeFunction() {
		return new Object[][] {
			{3, new int[] {2,5,6}, 0},
			{10000, new int[] {1000, 2000, 3000, 4000}, 3},
			{1, new int[] {}, 0 },
			{1000, new int[] {1, 1, 1, 1, 1, 0, 0, 0, 0 ,0}, 1000},
			{2147483646, new int[] {2147483645, 2147483646, 2147483647}, 1}
		};
	}		
	
	//Unit test for the control flow test method minimumCoins
	@Test
	@UseDataProvider("dataProviderCoinChangeFunction")
	public void coinChangeTest(int amount, int[] coins, int expected) {
		
		Assert.assertEquals(expected, CoinChange.minimumCoins(coins, amount));
	}
	
	//DataProvider for the black box test which will cause exceptions on input formats
	@DataProvider
	public static Object[][] dataProviderCoinChangelWithException() {

		return new Object[][] {
			{0, new int[] {-1,0,1}}
		};
	}

	//Unit test for the black box test which will cause exceptions number format exception
	@Test
	@UseDataProvider("dataProviderCoinChangelWithException")
	public void coinChangeTestWithExceptionTest(int amount, int[] coins) {
		thrown.expect(IllegalArgumentException.class);
		CoinChange.minimumCoins(coins, amount);

	}
}
