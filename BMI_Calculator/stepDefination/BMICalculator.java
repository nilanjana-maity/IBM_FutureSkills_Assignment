package stepDefination;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class BMICalculator {

	WebDriver driver;
	
	@Given("BMI Calculator is launched")
	public void bmi_Calculator_is_launched() {
		System.setProperty("webdriver.chrome.driver", "C:\\work\\browser_driver\\chromedriver_win32\\chromedriver.exe");
		 driver = new ChromeDriver();

		driver.get("https://www.calculator.net/calorie-calculator.html");
	}

	@When("Title of the page is matched")
	public void title_of_the_page_is_matched() {
		System.out.println(driver.getTitle());
	}

	@Then("Enter Age {string}")
	public void enter_Age(String string) {
	    WebElement ageElement = driver.findElement(By.id("cage"));
	    ageElement.clear();
	    ageElement.sendKeys(string);
	    
	}

	@Then("Enter Height {string}")
	public void enter_Height(String string) {
		 WebElement heightElement = driver.findElement(By.id("cheightmeter"));
		 heightElement.clear();
		 heightElement.sendKeys(string);
	}

	@Then("Enter Weight {string}")
	public void enter_Weight(String string) {
		WebElement weightElement = driver.findElement(By.id("ckg"));
		weightElement.clear();
		weightElement.sendKeys(string);
	}

	@Then("Tap on Calculate BMI")
	public void tap_on_Calculate_BMI() {
		WebElement CalculateElement = driver.findElement(By.xpath("(//input[@value='Calculate'])[1]"));
		CalculateElement.click();
	}

	@Then("Capture & Print the Result")
	public void capture_and_print_the_Result() {
		
		try {
			String Maintain_weight = driver.findElement(By.xpath("//div[contains(text(),'Maintain weight')]/../../td[2]/div/b")).getText();
			System.out.println("Maintain weight : " + Maintain_weight + " "+"Calories/day");
			}
			catch(Exception e) {
				System.out.println("Error");
			}
		
		/*String Maintain_weight = driver.findElement(By.xpath("//div[contains(text(),'Maintain weight')]/../../td[2]/div/b")).getText();
		String Mild_weight_loss = driver.findElement(By.xpath("//div[contains(text(),'Mild weight loss')]/../../td[2]/div/b")).getText();
		String Weight_loss = driver.findElement(By.xpath("//div[contains(text(),'Weight loss')]/../../td[2]/div/b")).getText();
		String Extreme_weight_loss = driver.findElement(By.xpath("//div[contains(text(),'Extreme weight loss')]/../../td[2]/div/b")).getText();
		*/
		/*System.out.println("Maintain weight : " + Maintain_weight + " "+"Calories/day");
		System.out.println("Mild weight loss : " + Mild_weight_loss + "Calories/day");
		System.out.println("Weight loss : " + Weight_loss + "Calories/day");
		System.out.println("Extreme weight loss : " + Extreme_weight_loss + "Calories/day");
		//h1[contains(text(),'Calorie Calculator')]/../div[3]
		*/
	}


	@Then("Close the browser")
	public void close_the_browser() {
	    driver.close();
	}
	
}
