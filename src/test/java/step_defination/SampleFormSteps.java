package step_defination;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

public class SampleFormSteps {
	
	WebDriver driver;
	
	@Given("User opens the browser and navigate to the v training form website")
	public void user_opens_the_browser_and_navigate_to_the_v_training_form_website() {
	    WebDriverManager.chromedriver().setup();
	    driver = new ChromeDriver();
	    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS); //Implicit Wait Statement for Junit
	    driver.get("https://v1.training-support.net/selenium/simple-form");
	    driver.manage().window().maximize();
	}

	@When("User Enters Firstname, Lastname, Email")
	public void user_enters_firstname_lastname_email() throws InterruptedException {
	    driver.findElement(By.id("firstName")).sendKeys("Abdul");
	    driver.findElement(By.id("lastName")).sendKeys("Moiez");
	    driver.findElement(By.id("email")).sendKeys("abc@gmail.com");
	    Thread.sleep(1000);
	}

	@When("Contact Number, Message")
	public void contact_number_message() throws InterruptedException {
		driver.findElement(By.id("number")).sendKeys("9908001848");
		driver.findElement(By.xpath("//div[@class='field']/textarea")).sendKeys("Hello!");
		Thread.sleep(1000);
	}

	@When("Users clicks on Submit")
	public void users_clicks_on_submit() throws InterruptedException {
		driver.findElement(By.xpath("//input[@value='submit']")).click();
		Thread.sleep(1000);
	}

	@Then("A Confirmation popup is Displayed")
	public void a_confirmation_popup_is_displayed() throws InterruptedException {
	    System.out.println("Thank you for registering");
	    Alert al = driver.switchTo().alert();
	    al.accept(); //To close the popup window, we are using Alert class
	    Thread.sleep(2000);
	    driver.close();
	}

}
