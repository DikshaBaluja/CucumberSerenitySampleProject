package moduleTesting.utilities;

import java.time.Duration;
import java.util.HashMap;
import java.util.Random;
import java.util.function.Function;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import net.serenitybdd.core.pages.PageObject;

public class WebActions extends PageObject
{
	public static HashMap<String, String> elementLocators = new HashMap<String, String>();

	static
	{
		
		elementLocators.put("SearchBox","//input[@name='search']");
		elementLocators.put("SearchButton","//input[@type='submit']");
		
	}
	
	
	public WebActions(WebDriver driver)
	{
		super(driver);
	}

	public String getAlertText(){

		Alert alert = getDriver().switchTo().alert();

		String alertText = alert.getText();

		return alertText;

	}

	public void acceptAlert()
	{
		Alert alert = getDriver().switchTo().alert();

		alert.accept();
	}
	
	
	public void switchToWindow(int windowNumber)
	{
	   String [] windowHandles = getDriver().getWindowHandles().toArray(new String [getDriver().getWindowHandles().size()]);
	   getDriver().switchTo().window(windowHandles[windowNumber]);
	   
	}
	
	public void _setValue(String locator,String value)
	{
		if(value.isEmpty()==false)
		{
			getDriver().findElement(By.xpath(locator)).sendKeys(value);
		}
	}

	public void _clearValue(String locator)
	{

		getDriver().findElement(By.xpath(locator)).clear();

	}
	
	public String getText(String locator)
	{
		String text = getDriver().findElement(By.xpath(locator)).getText();
		return text;
	}
	
	
	

	public void waitForPageLoad()
	{
		new WebDriverWait(getDriver(), 60).until(
			      webDriver -> ((JavascriptExecutor) webDriver).executeScript("return document.readyState").equals("complete"));
	}

	public void _sendTabKey(String locator)
	{

		getDriver().findElement(By.xpath(locator)).sendKeys(Keys.TAB);

	}

	public void refreshBrowser()
	{
		Actions actions = new Actions(getDriver());
		actions.keyDown(Keys.CONTROL).sendKeys(Keys.F5).perform();
	}

	public void _moveToElementClick(String locator)
	{
		Actions action = new Actions(getDriver());
		WebElement element = getDriver().findElement(By.xpath(locator));
		action.moveToElement(element).click().build().perform();
	}

	public void _javascriptClick(String locator)
	{
		WebElement element = getDriver().findElement(By.xpath(locator));
		JavascriptExecutor executor = (JavascriptExecutor)getDriver();
		executor.executeScript("arguments[0].click();", element);    
	}

	public void _click(String locator)
	{
		getDriver().findElement(By.xpath(locator)).click();;
	}

	public void _focus(String locator)
	{
		WebElement element = getDriver().findElement(By.xpath(locator));
		JavascriptExecutor executor = (JavascriptExecutor)getDriver();
		executor.executeScript("arguments[0].focus();", element);    
	}

	public void selectDropdown(String locator,String value)
	{
		Select select = new Select(getDriver().findElement(By.xpath(locator)));
		if(value.isEmpty()==false)
		{
			select.selectByVisibleText(value);
		}
	}

	public void _checkElementDisplay(String locator,boolean display)
	{
		if(display==false)
		{
			if(getDriver().findElements(By.xpath(locator)).size()==0)
			{
				Assert.assertTrue(true,"element not displayed");
			}
			else
			{
				Assert.assertFalse(false,"element  displayed");
			}
		}
		else if(display==true)
		{
			FluentWait(locator);
			if(getDriver().findElement(By.xpath(locator)).isDisplayed()==true)
			{
				Assert.assertTrue(true,"element displayed");
			}
			else
			{
				Assert.assertFalse(false,"element not displayed");
			}

		}

	}

	public void _waitForClickable(String locator)
	{
		new WebDriverWait(getDriver(),60).until(ExpectedConditions.elementToBeClickable(By.xpath(locator)));

	}

	public void FluentWait(String locator)
	{
		Wait<WebDriver> wait = new FluentWait<WebDriver>(getDriver())
				.withTimeout(Duration.ofSeconds(60))
				.pollingEvery(Duration.ofMillis(5))
				.ignoring(NoSuchElementException.class);

		WebElement foo = wait.until(new Function<WebDriver, WebElement>() {
			public WebElement apply(WebDriver driver) {
				return driver.findElement(By.xpath(locator));
			}
		});

	}


    
    public int generateRandomNumber()
    {
		int m = (int) Math.pow(10, 5 - 1);
	    m= m + new Random().nextInt(9 * m);
	    return m;
    	
    }
    
	
	public void quitBrowser()
	{
		getDriver().quit();
	}

}