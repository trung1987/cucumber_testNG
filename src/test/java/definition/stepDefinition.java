package definition;

import static org.testng.Assert.assertEquals;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.CapabilityType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

import cucumber.api.PendingException;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.github.bonigarcia.wdm.ChromeDriverManager;

public class stepDefinition {
	WebDriver driver;
	@Given("^Open Browser$")
	public void open_Browser() {
	    // Write code here that turns the phrase above into concrete actions
		ChromeDriverManager.getInstance().setup();
		// SSL Certificate Error Handling in Chrome
		DesiredCapabilities handlSSLErr = DesiredCapabilities.chrome();
		handlSSLErr.setCapability(CapabilityType.ACCEPT_SSL_CERTS, true);
		driver = new ChromeDriver(handlSSLErr);
	}

	@Then("^Wait PageLoad completely$")
	public void wait_PageLoad_completely() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").toString()
						.equals("complete");
			}
		};
		try {
			Thread.sleep(2500);
			WebDriverWait wait = new WebDriverWait(driver, 30);
			wait.until(expectation);
		} catch (Throwable error) {
			throw new Exception("Timeout waiting for Page Load Request to complete.");
		}
	}

	@Then("^Verify PageTitle$")
	public void verify_PageTitle() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		assertEquals(driver.getTitle().toString(),"Magento Stack Exchange");
	}

	@Given("^Enter URL$")
	public void enter_URL() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.get("https://magento.stackexchange.com/");
	}

	@Then("^Click Login Button$")
	public void click_Login_Button() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.xpath("//a[contains(text(),'Log In')]")).click();
	}

	@Then("^Verify Login Page are displayed$")
	public void verify_Login_Page_are_displayed() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		String str="Log In - Magento Stack Exchange";
		assertEquals(driver.getTitle().toString(),str);
	}

	@Then("^I fill in \"([^\"]*)\" with \"([^\"]*)\"$")
	public void i_fill_in_with(String arg1, String arg2) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id(arg1)).sendKeys(arg2);
	}

	@Then("^I click on the \"([^\"]*)\" button$")
	public void i_click_on_the_button(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.findElement(By.id(arg1)).click();
	}

	@Then("^I should see \"([^\"]*)\" message$")
	public void i_should_see_message(String arg1) throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
	}

	@Then("^Close browser$")
	public void close_browser() throws Throwable {
	    // Write code here that turns the phrase above into concrete actions
		driver.quit();
	}

}
