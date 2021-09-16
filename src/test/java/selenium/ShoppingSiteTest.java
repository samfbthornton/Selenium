package selenium;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.AfterEach;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ShoppingSiteTest {
	
private RemoteWebDriver driver;

private WebDriverWait wait;

	@BeforeEach
	void setup () {
		this.driver = new ChromeDriver();
		this.driver.manage().window().maximize();
		this.wait = new WebDriverWait(driver, 5);
	}
	
	@Test
	void buyItemTest() {
		this.driver.get("http://automationpractice.com/index.php");
		
		WebElement search = this.driver.findElementByCssSelector("#search_query_top");
		search.sendKeys("printed summer dress");
		WebElement submit = this.driver.findElementByCssSelector("#searchbox > button");
		submit.click();
		//this.driver.executeScript("window.scrollBy(0, 350)", "");
		WebElement product = this.driver.findElementByCssSelector("#center_column > ul > li.ajax_block_product.col-xs-12.col-sm-6.col-md-4.first-in-line.last-line.first-item-of-tablet-line.first-item-of-mobile-line.last-mobile-line > div > div.right-block > h5 > a");
		assertEquals("Printed Summer Dress", product.getText());
		product.click();
		WebElement addToCart = this.driver.findElementByCssSelector("#add_to_cart");
		addToCart.click();
		WebElement itemInCart = this.driver.findElementByCssSelector("#layer_cart_product_title");
		this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#layer_cart_product_title")));
		this.wait.until(ExpectedConditions.textToBePresentInElement(itemInCart, "Printed Summer Dress"));
		assertEquals("Printed Summer Dress", itemInCart.getText());
		WebElement proceedToCheckout = this.driver.findElementByCssSelector("#layer_cart > div.clearfix > div.layer_cart_cart.col-xs-12.col-md-6 > div.button-container > a");
		proceedToCheckout.click();
		WebElement proceedAgain = this.driver.findElementByCssSelector("#center_column > p.cart_navigation.clearfix > a.button.btn.btn-default.standard-checkout.button-medium");
		proceedAgain.click();
		WebElement emailAdd = this.driver.findElementByCssSelector("#email");
		emailAdd.sendKeys("sthornton@qa.com");
//		WebElement createAcc = this.driver.findElementByCssSelector("#SubmitCreate");
//		createAcc.click();
//		this.wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("#id_gender1")));
//		WebElement gender = this.driver.findElementByCssSelector("#id_gender1");
//		gender.click();
//		WebElement firstName = this.driver.findElementByCssSelector("#customer_firstname");
//		firstName.sendKeys("Sam");
//		WebElement lastName = this.driver.findElementByCssSelector("#customer_lastname");
//		lastName.sendKeys("Thornton");
//		WebElement password = this.driver.findElementByCssSelector("#passwd");
//		password.sendKeys("Password");
//		WebElement dobDate = this.driver.findElementByCssSelector("#uniform-days");
//		dobDate.click();
		WebElement password = this.driver.findElementByCssSelector("#passwd");
		password.sendKeys("Password");
		WebElement signIn = this.driver.findElementByCssSelector("#SubmitLogin");
		signIn.click();
		this.driver.executeScript("window.scrollBy(0, 350)", "");
		WebElement processAdd = this.driver.findElementByCssSelector("#center_column > form > p > button");
		processAdd.click();
		WebElement terms = this.driver.findElementByCssSelector("#cgv");
		terms.click();
		WebElement processDel = this.driver.findElementByCssSelector("#form > p > button");
		processDel.click();
		WebElement bankWire = this.driver.findElementByCssSelector("#HOOK_PAYMENT > div:nth-child(1) > div > p > a");
		bankWire.click();
		WebElement confirm = this.driver.findElementByCssSelector("#cart_navigation > button");
		confirm.click();
		WebElement price = this.driver.findElementByCssSelector("#center_column > div > span");
		assertEquals("$30.98", price.getText());
	}

//	@AfterEach
//	void tearDown() {
//		this.driver.close();
//	}
}