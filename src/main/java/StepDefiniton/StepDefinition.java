package StepDefiniton;




import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.AfterStep;
import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;




public class StepDefinition {
	
	
	@Before
	public void SetUp()
	{
		System.setProperty("webdriver.chrome.driver","C:\\Users\\Admin\\Desktop\\Sachin\\ChromeDriver\\chromedriver.exe");
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(10,TimeUnit.SECONDS);
		
		driver.get("https://magazine.trivago.com/");
	}
		
	
	@After
	public void teardown()
	{
		driver.quit();
	}
	@AfterStep
	public void takesScreenshot(Scenario scenario)
	{
		
		final byte[] screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.BYTES);
	      scenario.embed(screenshot, "image/png"); //  embed it in html report.
		
	}
	

	
	WebDriver driver;
	
	
	/*-----------------------Navigation -------------------------*/
	

	@Given("^user is on home page$")
	public void user_is_on_magazine_page1() throws Throwable {
	    
		String title = driver.getTitle();
		Assert.assertEquals("trivago Magazine", title); //Validate user is on homepage
	
	
	}
	
		
	@Then("^user clicks on menu button$")
	public void user_clicks_menu() throws InterruptedException
	{
		
		driver.findElement(By.xpath("//div[@class='nav-icon']")).click(); //Click on Menu Button
		Thread.sleep(2000);
		
	}

	@Then("^user clicks on destination$")
	public void user_clicks_destination() throws InterruptedException
	{
		driver.findElement(By.xpath("//div[@class='menu-title' and text()='Destinations']")).click();
		//Expand Destination 
	}
	
	@Then("^user selects destination$")
	public void user_selects_destinations()
	{
		
		driver.findElement(By.xpath("//div[@class='destination-menu' and text()='Northwest']")).click();
		
		//Selects Destination
	}
	
	@Then("^user is on desired destination$")
	public void user_on_desired_location()
	{
		Boolean dest = driver.findElement(By.xpath("//h1[@class='hero-main-title dest-2-main-title' and text()='Northwest']")).isDisplayed();
		Assert.assertEquals(dest, true);
		System.out.println("User is on Navigated Destination");
		
		//Verify user is on Desired Destination
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='destination-name' and text()='Washington']"))).build().perform();
	
		
	}
	
	
	/*----------------------------Contact form  ---------------------------*/
	
	
	
	@Then("^user goes to footer page$")
	
	public void user_is_on_footer()
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[@class='trivago-magazine-footer']"))).build().perform();
		
		//Moves to footer
	}
	
	@Then("^user clicks on contact link$")
	public void user_clicks_contact()
	{
		
		
		Actions action = new Actions(driver);
		
		action.moveToElement(driver.findElement(By.xpath("//a[text()='Contact']"))).click().perform();
		//clicks on Contact link
		}
	
	@Then("^new window appears$")
	public void new_window()
	{
		String parent=driver.getWindowHandle();
		Set<String> wind = driver.getWindowHandles();
		System.out.println(wind);
		Iterator<String> it = wind.iterator();
		
		
		if(it.hasNext())
		{
			System.out.println(it.next());
			driver.switchTo().window(it.next());
			//goto New window
		
		}
		
	}
	
	@Then("^user enters message$")
	public void user_enters_message()
	{
		driver.findElement(By.xpath("//textarea[@class='contact-msg']")).sendKeys("Sample for Case Study");
		
	}
	
	@Then("^user enters full name$")
	public void user_enters_full_name()
	{
		driver.findElement(By.xpath("//input[@class='contact-input' and @id='contact-email']/parent::div[@class='col col-xs-12 col-sm-12 col-md-6']/preceding-sibling::div[@class='col col-xs-12 col-sm-12 col-md-6']/input[@class='contact-input']")).sendKeys("Tom");
		
	}
	
	@Then("^user enters email$")
	public void user_enters_email()
	{
		driver.findElement(By.xpath("//input[@class='contact-input' and @id='contact-email']")).sendKeys("Tom1@gmail.com");
		
	}
	
	@Then("^user clicks on send button$")
	public void user_submits_form() throws InterruptedException
	{
		
		if(driver.findElement(By.xpath("//input[@id='confirm']")).isDisplayed())
		{
			driver.findElement(By.xpath("//input[@id='confirm']")).click();
		}
		Thread.sleep(2000);
		driver.findElement(By.xpath("//button[@class='contact-submit']")).click();
	}
	
	@Then("^message is displayed$")
	public void message_displayed() throws InterruptedException
	{
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//p[@class='feedback' and text()='Message Sent Successfully!']"))).build().perform();
		Thread.sleep(5000);
		String msg = driver.findElement(By.xpath("//p[@class='feedback' and text()='Message Sent Successfully!']")).getText();
		Assert.assertEquals("Message Sent Successfully!", msg);
		
		
	}
	
	
	
	/*----------------------------------LINKS-----------------------------------*/
	
	//There were many links on homepage, Out of which I have validated 5 links. 
	
	
	@Then("user is on read more section")
	public void read_more_section()
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='h1 welcome-title' and text()='COVID-19']"))).build().perform();
	}
	
	@Then("user clicks on first link read more")
	public void user_clicks_on_first_link_read_more() {
	    
		driver.findElement(By.xpath("//div[@class='hero-button' and text()='Read More']")).click();
	}

	@Then("user is on desired unique places page")
	public void user_is_on_desired_unique_places_page() throws InterruptedException {
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//h1[@class='post-title' and text()='8 Unique Places in California That You Need to Visit']"))).build().perform();
		
		String title = driver.getTitle();
		Assert.assertEquals("8 Unique Places in California That You Need to Visit", title);
		Thread.sleep(3000);
	}

	@Then("user is back to homepage")
	public void user_is_back_to_homepage() throws InterruptedException {
	    
		driver.navigate().back();
		Thread.sleep(2000);
	}
	
	@Then("user goes to postlockdown trip section")
	public void postlockdown_trip_section() throws InterruptedException
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[@class='theme-card-name' and text()='Romantic Getaways']"))).build().perform();
		Thread.sleep(2000);
	}

	@Then("user clicks on second link romantic getaways")
	public void user_clicks_on_second_link_romantic_getaways() {
		
		
		driver.findElement(By.xpath("//span[@class='theme-card-name' and text()='Romantic Getaways']")).click();
	
	}

	@Then("user is on desired getaways page")
	public void user_is_on_desired_getaways_page() throws InterruptedException {
		
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//p[@class='description-text']"))).build().perform();
		
		String title = driver.getTitle();
		Assert.assertEquals("Our Favorite Romantic Getaways To Inspire Your Next Trip", title);
		Thread.sleep(2000);
	}

	
	
	@Then("user goes to best vacation section")
	public void user_on_best_vacation_section()
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//h3[@class='post-title' and text()='6 of the Best Vacation Rentals in Big Bear, CA']"))).build().perform();
	}
	@Then("user clicks on third link best vacations")
	public void user_clicks_on_third_link_best_vacations() {
		
		driver.findElement(By.xpath("//h3[@class='post-title' and text()='6 of the Best Vacation Rentals in Big Bear, CA']")).click();
	    
	}

	@Then("user is on desired vacations page")
	public void user_is_on_desired_vacations_page() {
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//h1[@class='post-title' and text()='6 of the Best Vacation Rentals in Big Bear, CA']"))).build().perform();
		
		String title = driver.getTitle();
		Assert.assertEquals("6 of the Best Vacation Rentals in Big Bear, CA", title);
	   
	}

	
	@Then("user goes to future trip section")
	public void iser_is_on_future_trip_section()
	{
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//span[@class='destination-card-name' and text()='Midwest']"))).build().perform();
	}
	
	@Then("user clicks on fourth link future trip")
	public void user_clicks_on_fourth_link_future_trip() {
	    
		driver.findElement(By.xpath("//span[@class='destination-card-name' and text()='Midwest']")).click();
	}

	@Then("user is on desired trip page")
	public void user_is_on_desired_trip_page() {
	    
		Actions action = new Actions(driver);
		action.moveToElement(driver.findElement(By.xpath("//div[@class='destination-name' and text()='Minnesota']"))).build().perform();
		
		String title = driver.getTitle();
		Assert.assertEquals("Midwest", title);
	}

	@Then("user clicks on fifth link about")
	public void user_clicks_on_fifth_link_about() {
	    
		driver.findElement(By.xpath("//a[text()='About' and @class='footer-link']")).click();
	}

	@Then("user is on desired about page")
	public void user_is_on_desired_about_page() {
		Set<String> wind = driver.getWindowHandles();
		System.out.println(wind);
		Iterator<String> it = wind.iterator();
		
		driver.switchTo().window(it.next());
		
		driver.switchTo().window(it.next());
		String title = driver.getTitle();
		
		if(title == "trivago Magazine")
		{
			System.out.println("Next page");
		}
		else
		{
			System.out.println("Samepage");
		}
			
	}


	
	
}

	
	
	
	


