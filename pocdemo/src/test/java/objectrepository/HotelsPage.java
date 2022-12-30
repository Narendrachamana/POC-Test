package objectrepository;

import java.text.SimpleDateFormat;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

import accelerators.Actiondriver;
import accelerators.Base;

public class HotelsPage extends Base {

	public HotelsPage() {
		PageFactory.initElements(driver, this);
	}

	private static final String hotels = "//a[@href='https://www.makemytrip.com/hotels/']";
	private static final String city = "//label[@for='city']";
	private static final String cityTextBox = "//input[contains(@class,'react-autosuggest__input react-autosuggest__input--open')]";
	private static final String citySelectDropdown = "//li[@id='react-autowhatever-1-section-0-item-0']";
	private static final String checkinDropdown = "(//span[@class='lbl_input latoBold appendBottom5'])[1]";
	private static final String checkoutDropdown = "(//span[@class='lbl_input latoBold appendBottom5'])[2]";
	private static final String roomsandguestDropdown = "(//span[@class='lbl_input latoBold appendBottom5'])[3]";
	private static final String pricepernightDropdown = "(//span[@class='lbl_input latoBold appendBottom5'])[4]";
	private static final String months = "(//div[@class='DayPicker-Caption']/div)";
	private static final String dates = "(//div[@class='DayPicker-Caption']/div)";
	private static final String nextmonthButton = "//span[@aria-label='Next Month']";
	private static final String roomsdropdown = "(//div[@class='gstSlct'])[1]";
	private static final String roomsCount = "//ul[@class='gstSlct__list']//li";
	private static final String adults = "(//div[@class='gstSlct'])[2]";
	private static final String adultsCount = "//ul[@class='gstSlct__list']//li";
	private static final String childrens = "(//div[@class='gstSlct'])[3]";
	private static final String childrensCount = "//ul[@class='gstSlct__list']//li";
	private static final String ageOfChild = "(//div[@class='gstSlct'])[4]";
	private static final String ageOfChildCount = "//ul[@class='gstSlct__list']//li";
	private static final String applyButton = "//div[@class='primaryBtn btnApplyNew pushRight capText']";
	private static final String searchButton = "//button[@id='hsw_search_button']";
	private static final String minPriceFilter = "//input[@placeholder='Min']";
	private static final String maxPriceFilter = "//input[@placeholder='Max']";
	private static final String nextButton = "//button[@aria-label='Select Range button']";
	private static final String hotelcheckbox = "(//span[@data-testid='checkboxFilter'])[14]";
	private static final String breaskFast = "(//span[@data-testid='checkboxFilter'])[3]";
	private static final String roomselection = "//div[@class='makeFlex flexOne padding20 relative lftCol']";

	// input[@class='rangeInput ']

	@FindBy(how = How.XPATH, using = hotels)
	private WebElement wbhotels;

	@FindBy(how = How.XPATH, using = city)
	private WebElement wbcity;

	@FindBy(how = How.XPATH, using = citySelectDropdown)
	private WebElement cityselectDropdown;

	@FindBy(how = How.XPATH, using = cityTextBox)
	private WebElement citytextBox;

	@FindBy(how = How.XPATH, using = checkinDropdown)
	private WebElement checkindropdown;

	@FindBy(how = How.XPATH, using = checkoutDropdown)
	private WebElement checkoutdropdown;

	@FindBy(how = How.XPATH, using = roomsandguestDropdown)
	private WebElement wbfrroomsandguestdropdownombox;

	@FindBy(how = How.XPATH, using = pricepernightDropdown)
	private WebElement pricepernightdropdown;

	@FindBy(how = How.XPATH, using = months)
	private WebElement wbmonths;

	@FindBy(how = How.XPATH, using = dates)
	private WebElement wbdates;

	@FindBy(how = How.XPATH, using = nextmonthButton)
	private WebElement nextmonthbutton;

	@FindBy(how = How.XPATH, using = roomsdropdown)
	private WebElement wbroomsdropdown;

	@FindBys(@FindBy(how = How.XPATH, using = roomsCount))
	private List<WebElement> wbroomsCount;

	@FindBy(how = How.XPATH, using = adults)
	private WebElement wbadults;

	@FindBys(@FindBy(how = How.XPATH, using = adultsCount))
	private List<WebElement> wbadultsCount;

	@FindBy(how = How.XPATH, using = childrens)
	private WebElement wbchildrens;

	@FindBys(@FindBy(how = How.XPATH, using = childrensCount))
	private List<WebElement> wbchildrensCount;

	@FindBy(how = How.XPATH, using = ageOfChild)
	private WebElement ageOfchild;

	@FindBys(@FindBy(how = How.XPATH, using = ageOfChildCount))
	private List<WebElement> wbageofchildCount;

	@FindBy(how = How.XPATH, using = applyButton)
	private WebElement applybutton;

	@FindBy(how = How.XPATH, using = searchButton)
	private WebElement searchbutton;

	@FindBys(@FindBy(how = How.XPATH, using = months))
	private List<WebElement> monthselect;

	@FindBy(how = How.XPATH, using = dates)
	private WebElement datesdropdown;

	@FindBy(how = How.XPATH, using = minPriceFilter)
	private WebElement minPrice;

	@FindBy(how = How.XPATH, using = maxPriceFilter)
	private WebElement maxPrice;

	@FindBy(how = How.XPATH, using = nextButton)
	private WebElement wbnextButton;

	@FindBy(how = How.XPATH, using = breaskFast)
	private WebElement breakfast;

	@FindBy(how = How.XPATH, using = hotelcheckbox)
	private WebElement wbhotelcheckbox;

	@FindBys(@FindBy(how = How.XPATH, using = roomselection))
	private List<WebElement> wbroomselection;

	public void enterCity(String city1) throws Throwable {
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(wbcity);
		Thread.sleep(3000);
		Actiondriver.enterText(citytextBox, city1);
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(cityselectDropdown);
	}

	public void clickOncheckinandcheckoutDropdown(String CheckinDays, String CheckoutDays) throws Throwable {
		String str = Actiondriver.futureDateByDays(CheckinDays).toString();
		System.out.println("test date "+ str);
		SimpleDateFormat formatter = new SimpleDateFormat("dd-MMMM-yyyy");
		String date = formatter.format(Actiondriver.futureDateByDays(CheckinDays));

		String splitter[] = date.split("-");
		String month_year = splitter[1];
		String day = splitter[0];
		String year = splitter[2];

		String checkinDate = str.substring(0, 10) + " " + year;

		String str1 = Actiondriver.futureDateByDays(CheckoutDays).toString();
		String checkoutdate = str1.substring(0, 10) + " " + year;

		String flag = "False";

		for (int i = 0; i <= monthselect.size(); i++) {
			String month = monthselect.get(0).getText();

			if (month_year.concat(year).contains(month)) {

				WebElement checkinDate1 = driver.findElement(By.xpath(
						"//div[@class='DayPicker-Body']//div[@class='DayPicker-Week']//div[contains(@class,'DayPicker-Day') and @aria-label ='"
								+ checkinDate + "']"));

				Actiondriver.gf_JsClick(checkinDate1);

				WebElement returnDate = driver.findElement(By.xpath(
						"//div[@class='DayPicker-Body']//div[@class='DayPicker-Week']//div[contains(@class,'DayPicker-Day') and @aria-label ='"
								+ checkoutdate + "']"));
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

	public void clickOnDateDropDowns() throws Throwable {
		Actiondriver.gf_JsClick(datesdropdown);

	}

	public void clickOnRoomsAndGuest() throws Throwable {
		Actiondriver.gf_JsClick(wbfrroomsandguestdropdownombox);
	}

	public void clickonRooms(String count) throws Throwable {
		Actiondriver.gf_JsClick(wbroomsdropdown);
		for (int i = 0; i <= wbroomsCount.size(); i++) {
			if (count.equals(wbroomsCount.get(i).getText())) {
				Thread.sleep(2000);
				System.out.println("rooms count : " + wbroomsCount.get(i).getText());
				Actiondriver.gf_JsClick(wbroomsCount.get(i));
				break;
			}

		}
	}

	public void clickOnAdults(String adultscount) throws Throwable {
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(wbadults);
		for (int i = 0; i <= wbadultsCount.size(); i++) {
			if (adultscount.equals(wbadultsCount.get(i).getText())) {
				Thread.sleep(2000);
				System.out.println("adults count : " + wbadultsCount.get(i).getText());
				Actiondriver.gf_JsClick(wbadultsCount.get(i));
				break;
			}
		}
	}

	public void clickOnChildrens(String childrencount) throws Throwable {
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(wbchildrens);
		for (int i = 0; i <= wbchildrensCount.size(); i++) {
			if (childrencount.equals(wbchildrensCount.get(i).getText())) {
				Thread.sleep(2000);
				System.out.println("childern count : " + wbchildrensCount.get(i).getText());
				Actiondriver.gf_JsClick(wbchildrensCount.get(i));
				break;
			}
		}
	}

	public void clickOnAge(String agecount) throws Throwable {
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(ageOfchild);
		System.out.println("age  size : " + wbageofchildCount.size());
		for (int i = 0; i <= wbageofchildCount.size(); i++) {
			if (agecount.equals(wbageofchildCount.get(i).getText())) {
				Thread.sleep(2000);
				System.out.println("age of child count : " + wbageofchildCount.get(i).getText());
				Actiondriver.gf_JsClick(wbageofchildCount.get(i));
				break;
			}
		}
	}

	public void clickonPriceperNightDropdown() throws Throwable {
		Actiondriver.gf_JsClick(pricepernightdropdown);
	}

	public void clickOnApply() throws Throwable {
		Actiondriver.gf_JsClick(applybutton);
	}

	public void clickOnSearchButton() throws Throwable {
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(searchbutton);
		Thread.sleep(5000);
	}

	public void clickonfilter(String min, String max) throws Throwable {
		Actiondriver.enterText(minPrice, min);
		Actiondriver.enterText(maxPrice, max);
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(wbnextButton);
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(wbhotelcheckbox);
		Thread.sleep(3000);
		Actiondriver.gf_JsClick(breakfast);

		driver.navigate().refresh();
		Thread.sleep(10000);
		Actiondriver.gf_JsClick(wbroomselection.get(1));
	}

}
