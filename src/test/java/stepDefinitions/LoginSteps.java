package stepDefinitions;

import java.time.Duration;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class LoginSteps {

	//Pre-condition  - Given
	//Actions  - When
	//Validations  - Then
	public WebDriver driver;
	@Given("the user is on OrangeHrm Login Page")
	public void the_user_is_on_orange_hrm_login_page() throws InterruptedException {
	  //implement the method with selenium java test script
		
		driver=new ChromeDriver();
		driver.manage().timeouts().pageLoadTimeout(Duration.ofSeconds(10));
		driver.manage().deleteAllCookies();
		driver.manage().window().maximize();
		driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
		Thread.sleep(4000);
	}

	@When("the user enters valid credentials \\(username:{string} , password:{string});")
	public void the_user_enters_valid_credentials_username_password(String usn, String psw) throws InterruptedException {
	 // Enter username
		driver.findElement(By.xpath("//input[@placeholder='Username']")).sendKeys(usn);
		Thread.sleep(2000);
	//Enter password	
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(psw);
	}

	@When("the user clicks on login Button") //you can also write @And
	public void the_user_clicks_on_login_button() {
		driver.findElement(By.xpath("//button[@type='submit']")).click();
	}

	@Then("the User should redirected to the HomePage")
	public void the_user_should_redirected_to_the_home_page() throws InterruptedException {
	    String currentUrl = driver.getCurrentUrl();
	    System.out.println(currentUrl);
		Thread.sleep(4000);
	}

	@Then("the user should see a Dashboard") //you can also write @And
	public void the_user_should_see_a_Dashboard() {
		String text = driver.findElement(By.xpath("//h6[text()='Dashboard']")).getText();
		System.out.println(text);
	    boolean verifyHomepage = driver.findElement(By.xpath("//h6[text()='Dashboard']")).isDisplayed();
	    Assert.assertEquals(verifyHomepage,true);
	    driver.quit();
	}
}
