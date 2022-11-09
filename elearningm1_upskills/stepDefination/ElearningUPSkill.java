package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class ElearningUPSkill {
	
	WebDriver driver;
	String UserName;
	String FirstName;
	String LastName;
	@Given("elearning Portal is launched")
	public void elearning_Portal_is_launched() {
		System.setProperty("webdriver.chrome.driver", "C:\\work\\browser_driver\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();

		driver.get("http://elearningm1.upskills.in/");
	}

		
	@When("Title of the elearning Portal is matched")
	public void title_of_the_elearning_Portal_is_matched() {
		System.out.println(driver.getTitle());
	}
	
	@Then("Click on Sign up")
	public void click_on_Sign_up() {
		
		driver.findElement(By.xpath("//a[normalize-space()='Sign up!']")).click();
		
	}

	@Then("Fill up mandatory fields")
	public void fill_up_mandatory_fields() {
		 UserName = "Name"+Math.random();
		 FirstName = "FirstNameExample1";
		 LastName = "LastNameExample1";
		System.out.println("Username : "+UserName);
	   driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys(FirstName);
	   driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);
	   driver.findElement(By.xpath("//input[@name='email']")).sendKeys("emailExample1@gmail.com");
	   driver.findElement(By.xpath("//input[@id='username']")).sendKeys(UserName);
	   driver.findElement(By.xpath("//input[@id='pass1']")).sendKeys("passwordExample1");
	   driver.findElement(By.xpath("//input[@id='pass2']")).sendKeys("passwordExample1");
	    	   
	}

	@Then("Click on register button")
	public void click_on_register_button() {
		driver.findElement(By.xpath("//button[@name='submit']")).click();
	}

	@Then("Verify next button is visible")
	public void verify_next_button_is_visible() {
				
		System.out.println(driver.findElement(By.xpath("//button[@name='next']")).isDisplayed());		
		
	}

	@Then("Click on next button")
	public void click_on_next_button() {
		driver.findElement(By.xpath("//button[@name='next']")).click();
	}

	@Then("Click on name dropdown")
	public void click_on_name_dropdown() {
		
		String nameDropDownXpath = "//a[contains(text(),'"+FirstName+" "+LastName+"')]";
		driver.findElement(By.xpath(nameDropDownXpath)).click();
		
	}

	@Then("Click on Profile")
	public void click_on_Profile() {
		String profileXpath = "//a[contains(text(),'Profile')]";
		driver.findElement(By.xpath(profileXpath)).click();
	}

	@Then("Click on messages")
	public void click_on_messages() {
		driver.findElement(By.xpath("//a[normalize-space()='Messages']")).click();
		
	}

	@Then("Click on Compose message")
	public void click_on_Compose_message() {
		driver.findElement(By.xpath("//img[@title='Compose message']//..")).click();
	}

	@Then("Fill up the fields send to subject, message")
	public void fill_up_the_fields_send_to_subject_message() {
		WebElement iframe = driver.findElement(By.xpath("//iframe[@title='Rich Text Editor, content']"));
		driver.findElement(By.xpath("//input[@placeholder='Please select an option']")).click();
		driver.findElement(By.xpath("//input[@placeholder='Please select an option']")).sendKeys("mail2nmaity@gmail.com");
		driver.findElement(By.xpath("//input[@name='title']")).sendKeys("Subject : test email");
		driver.switchTo().frame(iframe);
		driver.findElement(By.xpath("/html/body/p")).sendKeys("Body : test email");
		driver.switchTo().defaultContent();
			
	}

	@Then("Click on send message")
	public void click_on_send_message() {
		driver.findElement(By.xpath("//button[contains(text(),' Send message')]")).click();
		System.out.println(driver.findElement(By.xpath("//div[@class='alert alert-danger']")).getText());
		
	}


	
	
}
