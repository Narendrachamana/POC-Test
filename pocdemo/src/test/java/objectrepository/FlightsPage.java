package objectrepository;

import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import accelerators.Actiondriver;
import accelerators.Base;

public class FlightsPage extends Base {

	public FlightsPage() {
		PageFactory.initElements(driver, this);
	}

	private static final String frombox = "//label[@for='fromCity']";
	private static final String fromTextbox = "//input[@placeholder='From']";
	private static final String fromSelectDropDown = "(//div[@class='makeFlex hrtlCenter'])[2]";
	private static final String tobox = "//label[@for='toCity']";
	private static final String toTextbox = "//input[@placeholder='To']";
	private static final String toSelectDropDown = "(//div[@class='makeFlex hrtlCenter'])[2]";
	private static final String travellerClass = "//*[@data-cy='flightTraveller']";
	private static final String search = "//a[text()='Search']";
	private static final String bookNow = "//button[text()='Book Now']";
	private static final String applybtn = "//button[@data-cy='travellerApplyBtn']";
	private static final String roundTrip = "(//span[@class='tabsCircle appendRight5'])[2]";
	private static final String dateDropDown = "//span[@class='lbl_input latoBold appendBottom10']";
	private static final String months = "(//div[@class='DayPicker-Caption']/div)";
	private static final String dates = "//div[@class='DayPicker-Body']/div[@class='DayPicker-Week']/div";
	private static final String nextMonthBtn = "//span[@aria-label='Next Month']";
	private static final String travellersDropDown = "//span[@class='lbl_input latoBold appendBottom5']";
	private static final String departflightsList = "(//div[@class='paneView'])[1]//div[contains(@class,'listingCard')]//span[contains(@class,'boldFont blackText')]";

	private static final String returnflightsList = "(//div[@class='paneView'])[2]//div[contains(@class,'listingCard')]//span[contains(@class,'boldFont blackText')]";

	@FindBy(how = How.XPATH, using = frombox)
	private WebElement wbfrombox;

	@FindBy(how = How.XPATH, using = fromTextbox)
	private WebElement wbfromTextbox;

	@FindBy(how = How.XPATH, using = fromSelectDropDown)
	private WebElement wbfromSelectDropDown;

	@FindBy(how = How.XPATH, using = tobox)
	private WebElement wbtobox;

	@FindBy(how = How.XPATH, using = toTextbox)
	private WebElement wbtoTextbox;

	@FindBy(how = How.XPATH, using = toSelectDropDown)
	private WebElement wbtoSelectDropDown;

	@FindBy(how = How.XPATH, using = travellerClass)
	private WebElement wbtraveller;

	@FindBy(how = How.XPATH, using = search)
	private WebElement searchbtn;

	@FindBy(how = How.XPATH, using = bookNow)
	private WebElement booknowbtn;

	@FindBy(how = How.XPATH, using = applybtn)
	private WebElement applybtns;

	@FindBy(how = How.XPATH, using = roundTrip)
	private WebElement roundtripbtn;

	@FindBy(how = How.XPATH, using = dateDropDown)
	private WebElement datedropdownbtn;

	@FindBys(@FindBy(how = How.XPATH, using = months))
	private List<WebElement> monthselect;

	@FindBys(@FindBy(how = How.XPATH, using = dates))
	private List<WebElement> dateselect;

	@FindBy(how = How.XPATH, using = nextMonthBtn)
	private WebElement nextmonth;

	@FindBy(how = How.XPATH, using = travellersDropDown)
	private WebElement traveldropdown;

	@FindBys(@FindBy(how = How.XPATH, using = departflightsList))
	private List<WebElement> departFilgtsList;

	@FindBys(@FindBy(how = How.XPATH, using = returnflightsList))
	private List<WebElement> retirnFilgtsList;

	public void clickOnRountTrip() throws Throwable {
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(roundtripbtn);
	}

	public void enterFromCity(String fromCity) throws Throwable {
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(wbfrombox);
		Thread.sleep(3000);
		Actiondriver.enterText(wbfromTextbox, fromCity);
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(wbfromSelectDropDown);
	}

	public void enterToCity(String toCity) throws Throwable {
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(wbtobox);
		Actiondriver.enterText(wbtoTextbox, toCity);
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(wbtoSelectDropDown);
	}

	public void clickOnDateDropDown() throws Throwable {
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(datedropdownbtn);
	}

	public void clickOnDepartureandReturnDate(String DepartureDays, String ReturnDays) throws Throwable {
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
			String month = monthselect.get(1).getText();

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
				Thread.sleep(5000);
			} else {
				Thread.sleep(5000);
				WebElement nextBtn = driver.findElement(By.xpath("//span[@aria-label='Next Month']"));
				Actiondriver.gf_JsClick(nextBtn);
			}

		}

	}

	public void clickOnTraveller() throws Throwable {
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(traveldropdown);
	}

	public void clickOnAdults(String adultscount) throws Throwable {
		WebElement adultstext = driver.findElement(By.xpath(
				"//ul[@class='guestCounter font12 darkText gbCounter']//li[@data-cy='adults-" + adultscount + "']"));
		Actiondriver.gf_JsClick(adultstext);
	}

	public void clickOnInfants(String infantcount) throws Throwable {
		WebElement infanttxt = driver.findElement(By.xpath(
				"//ul[@class='guestCounter font12 darkText gbCounter']//li[@data-cy='infants-" + infantcount + "']"));
		Actiondriver.gf_JsClick(infanttxt);
	}

	public void clickOnApply() throws Throwable {
		Actiondriver.gf_JsClick(applybtns);
	}

	public void clickOnSearchButton() throws Throwable {
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(searchbtn);
		Thread.sleep(5000);
	}

	public void selectAirlineFilters(String deprtFilghtName, String returnFightName) throws Throwable {

		String airlineFilter1 = "//span[@class='filterName' and @title='" + deprtFilghtName + "']";
		String airlineFilter2 = "//span[@class='filterName' and @title='" + returnFightName + "']";
		WebElement airline1 = driver.findElement(By.xpath(airlineFilter1));
		Actiondriver.gf_JsClick(airline1);
		Thread.sleep(3000);
		WebElement airline2 = driver.findElement(By.xpath(airlineFilter2));
		Actiondriver.gf_JsClick(airline2);
		Thread.sleep(3000);
	}

	public void selectDepartureFilght(String flightName) throws Throwable {
		String airlineFilter1 = "//span[@class='filterName' and @title='" + flightName + "']";
		WebElement airline1 = driver.findElement(By.xpath(airlineFilter1));
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", airline1);
		for (int k = 0; k < departFilgtsList.size(); k++) {

			System.out.println("depart flights is: " + departFilgtsList.get(k).getText());

			if (flightName.contains(departFilgtsList.get(k).getText())) {
				Thread.sleep(5000);
				WebElement radiobutton = driver.findElement(By.xpath(
						"(//div[@class='paneView'])[1]//div[contains(@class,'listingCard')]//span[contains(text(),'"
								+ flightName + "')]"));

				Actiondriver.gf_JsClick(radiobutton);
				break;
			}

		}
	}

	public void selectreturnFilght(String flightName) throws Throwable {
		Thread.sleep(7000);
		String airlineFilter1 = "//span[@class='filterName' and @title='" + flightName + "']";
		WebElement airline1 = driver.findElement(By.xpath(airlineFilter1));
		System.out.println("return flights size is: " + retirnFilgtsList.size());
		((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", airline1);
		for (int k = retirnFilgtsList.size() - 1; k > 0; k--) {
			System.out.println("return flights is: " + retirnFilgtsList.get(k).getText());

			if (flightName.contains(retirnFilgtsList.get(k).getText())) {
				Thread.sleep(5000);
				WebElement radiobutton = driver.findElement(By.xpath(
						"(//div[@class='paneView'])[2]//div[contains(@class,'listingCard')]//span[contains(text(),'"
								+ flightName + "')]"));

				Actiondriver.gf_JsClick(radiobutton);
				break;
			}

		}
	}

	public void clickonBookNow() throws Throwable {
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(booknowbtn);
	}

}
