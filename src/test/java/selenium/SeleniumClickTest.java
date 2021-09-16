package selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;

public class SeleniumClickTest {

private RemoteWebDriver driver;
	
	@BeforeEach
	void setup () {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
	}
	
	@Test
	void clickTest() {
		this.driver.get("https://demoqa.com/checkbox");
		
		WebElement expandAll = this.driver.findElementByCssSelector("#tree-node > div > button.rct-option.rct-option-expand-all");
		expandAll.click();
		WebElement selectDesktop = this.driver.findElementByCssSelector("#tree-node > ol > li > ol > li:nth-child(1) > span > label > span.rct-checkbox > svg");
		selectDesktop.click();
		WebElement result = this.driver.findElementByCssSelector("#result");
		assertEquals("You have selected :\r\n"
				+ "desktop\r\n"
				+ "notes\r\n"
				+ "commands", result.getText());
	}
	
	@AfterEach
	void tearDown() {
		this.driver.close();
	}
}