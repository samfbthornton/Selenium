package selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumDemoTest {

	
	private RemoteWebDriver driver;
	
	@BeforeEach
	void setup () {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}
	
	@Test
	void demoTest() {
		this.driver.get("https://demoqa.com/text-box");
		
		WebElement inputName = this.driver.findElementByCssSelector("#userName");
		inputName.sendKeys("Sam");
		WebElement inputEmail = this.driver.findElementByCssSelector("#userEmail");
		inputEmail.sendKeys("sthornton@qa.com");
		WebElement inputCurAdd= this.driver.findElementByCssSelector("#currentAddress");
		inputCurAdd.sendKeys("Here");
		WebElement inputPerAdd = this.driver.findElementByCssSelector("#permanentAddress");
		inputPerAdd.sendKeys("Not here");
		WebElement closeAd = this.driver.findElementByCssSelector("#close-fixedban");
		closeAd.click();
		this.driver.executeScript("window.scrollBy(0, 350)", "");
		WebElement submit = this.driver.findElementByCssSelector("#submit");
		submit.click();
		WebElement name = this.driver.findElementByCssSelector("#name");
		assertEquals("Name:Sam", name.getText());
		WebElement email = this.driver.findElementByCssSelector("#email");
		assertEquals("Email:sthornton@qa.com", email.getText());
		WebElement curAdd = this.driver.findElementByCssSelector("#output #currentAddress");
		assertEquals("Current Address :Here", curAdd.getText());
		WebElement perAdd = this.driver.findElementByCssSelector("#output #permanentAddress");
		assertEquals("Permananet Address :Not here", perAdd.getText());
	}
	
	@AfterEach
	void tearDown() {
		this.driver.close();
	}
	
}