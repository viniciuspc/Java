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
public class RomanToIntegerTest {
	@Rule
    public ExpectedException thrown= ExpectedException.none();
	
	//DataProvider for the black box test which will not cause exceptions
	@DataProvider
	public static Object[][] dataProviderRomanToIntegerNoException() {

		return new Object[][] {
			{"I",1},
			{"II",2},
			{"IV",4},
			{"V",5},
			{"VI",6},
			{"VII",7},
			{"IX",9},
			{"X",10},
			{"XI",11},
			{"XII",12},
			{"IL",49},
			{"L",50},
			{"LI",51},
			{"LII",52},
			{"IC",99},
			{"C",100},
			{"CI",101},
			{"CII",102},
			{"ID",499},
			{"D",500},
			{"DI",501},
			{"DII",502},
			{"IM",999},
			{"M",1000},
			{"MI",1001},
			{"MII",1002},
		};
	}

	//Unit test for the black box test which will not cause exceptions
	@Test
	@UseDataProvider("dataProviderRomanToIntegerNoException")
	public void romanToIntNoExceptionTest(String A, int expected) {

		Assert.assertEquals(expected, RomanToInteger.romanToInt(A));

	}

	//DataProvider for the black box test which will cause exceptions number format exception
	@DataProvider
	public static Object[][] dataProviderRomanToIntegerlWithException() {

		return new Object[][] {
			{"0"},
			{"H"},
			{"J"},
			{"U"},
			{"W"},
			{"K"},
			{"B"},
			{"E"},
			{"N"},
		};
	}

	//Unit test for the black box test which will cause exceptions number format exception
	@Test
	@UseDataProvider("dataProviderRomanToIntegerlWithException")
	public void romanToIntWithExceptionTest(String A) {
		thrown.expect(NullPointerException.class);
		RomanToInteger.romanToInt(A);

	}
}
