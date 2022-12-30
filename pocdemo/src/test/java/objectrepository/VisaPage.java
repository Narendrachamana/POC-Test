package objectrepository;

import accelerators.Base;

import java.awt.Color;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import accelerators.Actiondriver;
import accelerators.Base;

public class VisaPage extends Base {

	public VisaPage() {
		PageFactory.initElements(driver, this);
	}

	private static final String destinationbox = "//label[@for='fromCountryCode']";
	private static final String destinationTextbox = "//input[contains(@class,'react-autosuggest__input react-autosuggest__input--open')]";
	private static final String destinationSelectDropDown = "//li[@id='react-autowhatever-1-section-0-item-0']";
	private static final String departureBox = "//div[@class='vsw_inputBox dates  ']";
	private static final String returnBox = "(//span[@class='lbl_input latoBold appendBottom10'])[2]";
	private static final String travellersBox = "//label[@for='travellers']";// (//span[@class='lbl_input latoBold
																				// appendBottom10'])[3]
	private static final String travellerstext = "//span[@class='latoBold font22 darkGreyText']";
	private static final String plusButton = "//span[@class='btnPlus']";
	private static final String minusButton = "//span[@class='btnMinus ']";
	private static final String applyButton = "//button[@class='primaryBtn btnApply pushRight']";
	private static final String searchButton = "//button[@id='search_button']";
	private static final String proceedButton = "//a[text()='PROCEED']";
	private static final String months = "(//div[@class='DayPicker-Caption']/div)";
	private static final String dateDropDown = "(//span[@class='lbl_input latoBold appendBottom10'])[1]";
	String travellersvalue;
	
	
	@FindBy(how = How.XPATH, using = destinationbox)
	private WebElement wbdestinationbox;

	@FindBy(how = How.XPATH, using = destinationTextbox)
	private WebElement wbdestinationTextbox;

	@FindBy(how = How.XPATH, using = destinationSelectDropDown)
	private WebElement wbdestinationSelectDropDown;

	@FindBy(how = How.XPATH, using = departureBox)
	private WebElement wbdeparturebox;

	@FindBy(how = How.XPATH, using = returnBox)
	private WebElement wbreturnbox;

	@FindBy(how = How.XPATH, using = travellersBox)
	private WebElement wbtravellerbox;

	@FindBy(how = How.XPATH, using = travellerstext)
	private WebElement wbtravellerText;

	@FindBy(how = How.XPATH, using = plusButton)
	private WebElement plusbtn;

	@FindBy(how = How.XPATH, using = minusButton)
	private WebElement minusbtn;

	@FindBy(how = How.XPATH, using = applyButton)
	private WebElement applybtn;

	@FindBy(how = How.XPATH, using = searchButton)
	private WebElement searchbtn;

	@FindBy(how = How.XPATH, using = proceedButton)
	private WebElement proceedbtn;

	@FindBys(@FindBy(how = How.XPATH, using = months))
	private List<WebElement> monthselect;

	@FindBys(@FindBy(how = How.XPATH, using = dateDropDown))
	private WebElement datesdropdown;

	public void enterDestinationCity(String destinationCity) throws Throwable {
		Actiondriver.gf_JsClick(wbdestinationbox);
		Thread.sleep(3000);
		Actiondriver.enterText(wbdestinationTextbox, destinationCity);
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(wbdestinationSelectDropDown);
	}

	public void clickOnDateDropDowns() throws Throwable {
		Actiondriver.gf_JsClick(datesdropdown);
	}

	public void clickOnDepartureandReturnBox(String DepartureDays, String ReturnDays) throws Throwable {
		String str = Actiondriver.futureDateByDays(DepartureDays).toString();
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
		String date = formatter.format(Actiondriver.futureDateByDays(DepartureDays));

		String splitter[] = date.split("-");
		String month_year = splitter[1];
		String day = splitter[0];
		String year = splitter[2];

		String departureDate = str.substring(0, 10) + " " + year;

		String str1 = Actiondriver.futureDateByDays(ReturnDays).toString();
		String returndate = str1.substring(0, 10) + " " + year;

		String flag = "False";

		for (int i = 0; i <= monthselect.size(); i++) {
			String month = monthselect.get(0).getText();

			if (month_year.concat(year).contains(month)) {

				WebElement departureDate1 = driver.findElement(By.xpath(
						"//div[@class='DayPicker-Body']//div[@class='DayPicker-Week']//div[contains(@class,'DayPicker-Day') and @aria-label ='"
								+ departureDate + "']"));

				Actiondriver.gf_JsClick(departureDate1);

				WebElement returnDate = driver.findElement(By.xpath(
						"//div[@class='DayPicker-Body']//div[@class='DayPicker-Week']//div[contains(@class,'DayPicker-Day') and @aria-label ='"
								+ returndate + "']"));
				Actiondriver.gf_JsClick(returnDate);
				flag = "True";
				Thread.sleep(4000);
			} else {
				Thread.sleep(4000);
				WebElement nextBtn = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
				Actiondriver.gf_JsClick(nextBtn);
			}

		}

	}

	public void clickOnTravellerBox() throws Throwable {
		Actiondriver.gf_JsClick(wbtravellerbox);
	}

	public void clickOnPlusButton() throws Throwable {
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(plusbtn);
		travellersvalue = wbtravellerText.getText();
	}

	public void clickOnMinusButton() throws Throwable {
		Actiondriver.gf_JsClick(minusbtn);
	}

	public void clickOnApply() throws Throwable {
		Actiondriver.gf_JsClick(applybtn);
	}

	public void clickOnSearchButton() throws Throwable {
		Actiondriver.gf_JsClick(searchbtn);
	}

	public void clickOnProceedButton() throws Throwable {
		Thread.sleep(4000);
		WebElement travlervalueFromdetailsPage = driver.findElement(By.xpath("//input[@id='traveller']"));
		String expectedValue = travlervalueFromdetailsPage.getAttribute("value");

		// traveller value assertion
		Assert.assertEquals(expectedValue.substring(1), travellersvalue);

		Thread.sleep(5000);
		Actiondriver.gf_JsClick(proceedbtn);
		Alert alert = driver.switchTo().alert();
		Assert.assertEquals("Please enter valid values", alert.getText());
		//System.out.println("color code is : "+alert.hashCode());
		alert.accept();
		
		WebElement textcolor =driver.findElement(By.xpath("(//p[@class='text-red prepend_top3'])[1]"));
		
		String s=Actiondriver.rgbatohex(textcolor);
		if("#eb2026".equals(Actiondriver.rgbatohex(textcolor)))
				{
			System.out.println("color is matched with Red");
				}
		else {
			System.out.println("color is not matched");
		}
         
			
		
	}

}
