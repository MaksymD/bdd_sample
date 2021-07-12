package at.ac.tuwien.inso.swtesten.sample1;

import at.ac.tuwien.inso.swtesten.util.SeleniumWebDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

public class WikipediaSeleniumHelper {
	private WebDriver driver;
	private String baseUrl;

	public void setUp() {
		driver = SeleniumWebDriver.getDriver();
		baseUrl = "http://www.wikipedia.org/";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}

	public void setBrowserLanguage(String locale) {
		SeleniumWebDriver.setDefaultLocale(locale);
	}

	public void selectLanguage() {
		driver.get(baseUrl);
		driver.findElement(By.xpath("//strong[text() = 'English']")).click();
	}

	public void search(String searchText) {
		driver.findElement(By.id("searchInput")).clear();
		driver.findElement(By.id("searchInput")).sendKeys(searchText);
		driver.findElement(By.id("searchButton")).click();
		//driver.findElement(By.cssSelector("div#mw-content-text.mw-content-ltr p"));
	}

	public void assertSearchResultByText(String searchText) {
		WebElement results = driver.findElement(By.xpath("//*[@id='firstHeading']"));
		assertTrue(results.getText().contains(searchText));
	}

	public void assertArticleNotExists(String heading) {
		WebElement element = driver.findElement(By.className("mw-search-createlink"));
		assertEquals("The page \"" + heading + "\" does not exist. You can ask for it to be created.", element.getText());

		WebElement element2 = driver.findElement(By.className("mw-search-nonefound"));
		assertEquals("There were no results matching the query.", element2.getText());
	}

	public void shutDown() {
		SeleniumWebDriver.closeDriver();
	}

	public byte[] takeScreenshot() {
		return ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	}
}
