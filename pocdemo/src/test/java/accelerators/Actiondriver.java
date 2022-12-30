package accelerators;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.support.Color;


public class Actiondriver extends Base {

	public static void waituntilElement(WebElement element) {
		Wait<WebDriver> wait = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.visibilityOf(element));

	}

	public static void enterText(WebElement element, String text) {
		try {
			waituntilElement(element);
			element.clear();
			element.sendKeys(text);
		} catch (StaleElementReferenceException e) {
			element.clear();
			element.sendKeys(text);
		}
	}

	public static void clearText(WebElement element) {
		waituntilElement(element);
		element.clear();
	}

	public static boolean gf_JsClick(WebElement objLocator) throws Throwable {
		boolean blnFlag = false;
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", objLocator);
			blnFlag = true;
			return blnFlag;
		} catch (Exception e) {

			return blnFlag;
		} finally {
			Exception e;
		}
	}

	public static Date futureDateByDays(String days) {
		Date currentDate = new Date();
		
		Calendar c = Calendar.getInstance();
		c.setTime(currentDate);
		int i = Integer.parseInt(days);
		c.add(Calendar.DATE, i);
		
		return c.getTime();

	}

	public static void clickElement(WebElement element) {
		try {
			waituntilElement(element);
			element.click();
		} catch (StaleElementReferenceException e) {
			waitUntilElementIsClickable(element);
			element.click();
		}
	}

	public static void waitUntilElementIsClickable(WebElement element) {
		Wait<WebDriver> wait = new WebDriverWait(driver, 60).ignoring(StaleElementReferenceException.class);
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	public static String rgbatohex(WebElement element) {
		String s = element.getCssValue("color");
	      // convert rgba to hex
	      String c = Color.fromString(s).asHex();
	    //  System.out.println("Color is :" + s);
	      System.out.println("Hex code for color:" + c);
	      return c;
	}
	
}