package testscripts;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import accelerators.Base;
import objectrepository.FlightsPage;
import objectrepository.LoginPage;
import objectrepository.VisaPage;
import utilities.ExcelReader;
import utilities.Property;

public class MakemytripFlightsTest extends Base {
	LoginPage loginPage;
	FlightsPage flightsPage;
	public static Property configProps = new Property(
			System.getProperty("user.dir") + File.separator + "config.properties");

	@Test(dataProvider = "flightData")
	public void verifyLogIn(String data[]) throws Throwable {
		/*
		 * loginPage=new LoginPage(); loginPage.clickonloginbtn();
		 * loginPage.dologin("9019003418","12345678@"); loginPage.clickonlogin();
		 */

		flightsPage = new FlightsPage();
		driver.get(configProps.getProperty("flightsURL"));
		flightsPage.clickOnRountTrip();
		flightsPage.enterFromCity(data[0]);
		flightsPage.enterToCity(data[1]);
		flightsPage.clickOnDateDropDown();
		flightsPage.clickOnDepartureandReturnDate(data[2], data[3]);
		flightsPage.clickOnTraveller();
		flightsPage.clickOnAdults(data[4]);
		flightsPage.clickOnInfants(data[5]);
		flightsPage.clickOnApply();
		flightsPage.clickOnSearchButton();
		flightsPage.selectAirlineFilters(data[6], data[7]);
		flightsPage.selectDepartureFilght(data[6]);
		flightsPage.selectreturnFilght(data[7]);
		flightsPage.clickonBookNow();

	}

	@DataProvider(name = "flightData")
	public Object[][] getItemData() throws Exception {
		String path = System.getProperty("user.dir") + File.separator + "Testdata" + File.separator
				+ "Demo_TestData.xlsx";
		return ExcelReader.getDataFromSpreadSheet(path, "FlightReservation_TestData");
	}

}
