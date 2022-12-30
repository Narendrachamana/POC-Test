package testscripts;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import accelerators.Base;
import objectrepository.VisaPage;
import utilities.ExcelReader;
import utilities.Property;

public class MakeMyTripVisaTest extends Base {
	VisaPage visaPage;
	public static Property configProps = new Property(
			System.getProperty("user.dir") + File.separator + "config.properties");

	@Test(dataProvider = "flightData")
	public void verifyVisaPage(String data[]) throws Throwable {
		visaPage = new VisaPage();
		driver.get(configProps.getProperty("visaURL"));
		Thread.sleep(3000);
		visaPage.enterDestinationCity("Singapore");
		visaPage.clickOnDateDropDowns();
		visaPage.clickOnDepartureandReturnBox("45", "52");
		visaPage.clickOnTravellerBox();
		visaPage.clickOnPlusButton();
		visaPage.clickOnApply();
		visaPage.clickOnSearchButton();
		visaPage.clickOnProceedButton();

	}

	@DataProvider(name = "flightData")
	public Object[][] getItemData() throws Exception {
		String path = System.getProperty("user.dir") + File.separator + "Testdata" + File.separator
				+ "Demo_TestData.xlsx";
		return ExcelReader.getDataFromSpreadSheet(path, "FlightReservation_TestData");
	}

}
