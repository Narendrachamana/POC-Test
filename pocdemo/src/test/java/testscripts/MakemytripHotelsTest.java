package testscripts;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import accelerators.Base;
import objectrepository.FlightsPage;
import objectrepository.HotelsPage;
import objectrepository.VisaPage;
import utilities.ExcelReader;

public class MakemytripHotelsTest extends Base {
	HotelsPage hotelsPage;

	@Test(dataProvider = "hotelsData")
	public void verifyHotelsPage(String data[]) throws Throwable {
		hotelsPage = new HotelsPage();
		Thread.sleep(3000);

		hotelsPage = new HotelsPage();
		driver.get(configProps.getProperty("hotelsURL"));
		hotelsPage.enterCity(data[0]);
		hotelsPage.clickOnDateDropDowns();
		hotelsPage.clickOncheckinandcheckoutDropdown("0", "1");
		hotelsPage.clickOnRoomsAndGuest();
		hotelsPage.clickonRooms("01");
		hotelsPage.clickOnAdults(data[3]);
		hotelsPage.clickOnChildrens(data[4]);
		hotelsPage.clickOnAge(data[5]);
		hotelsPage.clickOnApply();
		//hotelsPage.clickonPriceperNightDropdown();
		hotelsPage.clickOnSearchButton();
		hotelsPage.clickonfilter("2000","3999");
	}

	@DataProvider(name = "hotelsData")
	public Object[][] getItemData() throws Exception {
		String path = System.getProperty("user.dir") + File.separator + "Testdata" + File.separator
				+ "Demo_TestData.xlsx";
		return ExcelReader.getDataFromSpreadSheet(path, "HotelReservation_TestData");
	}

}
